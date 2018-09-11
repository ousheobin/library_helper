package com.tentcoo.library.component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.tentcoo.library.pojo.BookLink;
import com.tentcoo.library.pojo.SimpleQueryPage;

@Component
public class CateSearchComponent {

	public SimpleQueryPage query(String queryUrl) throws Exception {
		URL url = new URL(queryUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setUseCaches(Boolean.FALSE);
		connection.addRequestProperty("Connection", "close");
		connection.setConnectTimeout(8000);
		connection.setReadTimeout(8000);
		Document doc = Jsoup.parse(connection.getInputStream(), "gb2312", "http://query.libmill.com/");
		Elements centerElement = doc.getElementsByTag("center");
		SimpleQueryPage result = new SimpleQueryPage();
		if (centerElement != null) {
			if (centerElement.get(0).getElementsByTag("table").size() > 0 ) {
				List<BookLink> data = new ArrayList<BookLink>();
				Elements trElements = centerElement.get(0).getElementsByTag("tr");
				for (int i = 3; i < trElements.size() - 1; i++) {
					Element trow = trElements.get(i);
					Elements tdElements = trow.getElementsByTag("td");
					if (tdElements.size() == 4) {
						String bookName = tdElements.get(2).text();
						String bookUrl = tdElements.get(2).getElementsByTag("a").get(0).attr("href");
						BookLink book = new BookLink();
						book.setCategory(false);
						book.setBookName(bookName);
						book.setLink(bookUrl);
						data.add(book);
					}
				}
				result.setBooks(data);
			}
		}
		result.setCurrentStart(0);
		result.setHasNextPage(false);
		result.setHasNextPage(false);
		return result;
	}

}
