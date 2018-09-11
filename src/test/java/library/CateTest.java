package library;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CateTest {

	private static String libQueryUrl = "http://query.libmill.com/*/%5ball%5d/search"
			+ "?submit=%20%bc%ec%cb%f7%20&format=hitcount&from=%5btitle%5d"
			+ "&link=and&word=oracle&max=12&start=1&match=any&db=%d6%d0"
			+ "%ce%c4%cd%bc%ca%e9&searchstyle=normal&debug=off&recordset="
			+ "titlenumber&_dup=off&word=Oracle%2011g%ca%fd%be%dd%bf%e2%"
			+ "bb%f9%b4%a1%bd%cc%b3%cc&match=exact&recordset=marcrecord&" + "format=browse&start=1";

	public static void main(String args[]) throws Exception {
		URL url = new URL(libQueryUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setUseCaches(Boolean.FALSE);
		connection.addRequestProperty("Connection", "close");
		connection.setConnectTimeout(8000);
		connection.setReadTimeout(8000);
		Document doc = Jsoup.parse(connection.getInputStream(), "gb2312", "http://query.libmill.com/");
		Elements centerElement = doc.getElementsByTag("center");
		if (centerElement != null) {
			if (centerElement.get(0).getElementsByTag("table").size() > 0 ) {
				Elements trElements = centerElement.get(0).getElementsByTag("tr");
				for (int i = 3; i < trElements.size() - 1; i++) {
					Element trow = trElements.get(i);
					Elements tdElements = trow.getElementsByTag("td");
					if (tdElements.size() == 4) {
						String bookName = tdElements.get(2).text();
						String bookUrl = tdElements.get(2).getElementsByTag("a").get(0).attr("href");
						System.out.println(bookName + "--->" + bookUrl);
					}
				}
			}
		}
	}

}
