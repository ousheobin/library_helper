package com.tentcoo.library.component;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tentcoo.library.pojo.BookLink;
import com.tentcoo.library.pojo.SimpleQueryPage;

@Component
public class SimpleSearchComponent {

	private String libQueryUrl = "http://query.libmill.com/*/[all]/search?format=hitcount&"
			+ "recordset=titlenumber&start=${start}&max=${max}&debug=off&searchstyle=normal&"
			+ "word=${word}&link=and&match=any&from=[title]" + "&db=${chineseBookLibrary}" + "&db2=English+Books";

	private String chineseBookLibrary = "中文图书";

	public SimpleQueryPage query(String word, int start, int max) throws Exception {
		String query = libQueryUrl.replace("${chineseBookLibrary}", URLEncoder.encode(chineseBookLibrary, "utf-8"))
				.replace("${word}", URLEncoder.encode(word, "utf-8")).replace("${start}", Integer.toString(start))
				.replace("${max}", Integer.toString(max));
		URL url = new URL(query);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setUseCaches(Boolean.FALSE);
		connection.addRequestProperty("Connection", "close");
		connection.setConnectTimeout(8000);
		connection.setReadTimeout(8000);
		Document doc = Jsoup.parse(connection.getInputStream(), "gb2312", "http://query.libmill.com/");
		SimpleQueryPage result = new SimpleQueryPage();
		Elements headerNav = doc.getElementsByTag("table").get(0).getElementsByTag("a");
		if (headerNav != null && !headerNav.isEmpty()) {
			for (Element element : headerNav) {
				if (element.text().equals("下一页")) {
					result.setHasNextPage(true);
				} else if (element.text().equals("上一页")) {
					result.setHasPrevPage(true);
				}
			}
			if (doc.getElementsByTag("table").size() > 3) {
				Elements trElements = doc.getElementsByTag("table").get(2).getElementsByTag("tr");
				List<BookLink> data = new ArrayList<BookLink>();
				for (int i = 1; i < trElements.size(); i++) {
					Element trow = trElements.get(i);
					Elements tdElements = trow.getElementsByTag("td");
					if (tdElements.size() == 4) {
						String bookName = tdElements.get(2).text();
						String bookUrl = tdElements.get(2).getElementsByTag("a").get(0).attr("href");
						BookLink book = new BookLink();
						if (bookUrl.contains("format=browse")) {
							book.setCategory(true);
						}else {
							book.setCategory(false);
						}
						book.setBookName(bookName);
						book.setLink(bookUrl);
						data.add(book);
					}
				}
				result.setBooks(data);
			}
		}
		return result;
	}

}
