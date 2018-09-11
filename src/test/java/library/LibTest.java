package library;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LibTest {
	
	private static String libQueryUrl = "http://query.libmill.com/*/[all]/search?format=hitcount&"
			+ "recordset=titlenumber&start=253&max=12&debug=off&searchstyle=normal&"
			+ "word=${word}&link=and&match=any&from=[title]"
			+ "&db=${chineseBookLibrary}"
			+ "&db2=English+Books";
	
	public static void main(String args[]) throws Exception {
		String word = "项目管理";
		String chineseBookLibrary = "中文图书";
		String query = libQueryUrl.replace("${chineseBookLibrary}", URLEncoder.encode(chineseBookLibrary, "utf-8")).replace("${word}", URLEncoder.encode(word, "utf-8"));
		URL url = new URL(query);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setUseCaches(Boolean.FALSE);
		connection.addRequestProperty("Connection", "close");
		connection.setConnectTimeout(8000);  
		connection.setReadTimeout(8000);    
		Document doc = Jsoup.parse(connection.getInputStream(), "gb2312","http://query.libmill.com/");
		Elements headerNav = doc.getElementsByTag("table").get(0).getElementsByTag("a");
		if(headerNav!=null && !headerNav.isEmpty()) {
			for(Element element : headerNav) {
				if(element.text().equals("下一页")) {
					String pageUrl = element.attr("href");
					String[] params = pageUrl.split("&");
					int max = 12;
					int start = 0;
					for(String parameter : params) {
						if(parameter.contains("max=")){
							max = Integer.valueOf(parameter.split("=")[1]);
						}else if(parameter.contains("start=")) {
							start = Integer.valueOf(parameter.split("=")[1]);
						}
					}
					System.out.println("下一页：word:"+word+" start:"+start+" max:"+max);
				}else if(element.text().equals("上一页")) {
					String pageUrl = element.attr("href");
					String[] params = pageUrl.split("&");
					int max = 12;
					int start = 0;
					for(String parameter : params) {
						if(parameter.contains("max=")){
							max = Integer.valueOf(parameter.split("=")[1]);
						}else if(parameter.contains("start=")) {
							start = Integer.valueOf(parameter.split("=")[1]);
						}
					}
					System.out.println("上一页：word:"+word+" start:"+start+" max:"+max);
				}
			}
		}
		if(doc.getElementsByTag("table").size() > 3) {
			Elements trElements = doc.getElementsByTag("table").get(2).getElementsByTag("tr");
			for(int i = 1 ; i < trElements.size() ; i ++ ) {
				Element trow = trElements.get(i);
				Elements tdElements = trow.getElementsByTag("td");
				if(tdElements.size()==4) {
					String bookName = tdElements.get(2).text();
					String bookUrl = tdElements.get(2).getElementsByTag("a").get(0).attr("href");
					if(bookUrl.contains("format=browse")) {
						System.out.println("-->Category");
					}
					System.out.println(bookName+"--->"+bookUrl);
				}
			}
		}
	}
	
}
