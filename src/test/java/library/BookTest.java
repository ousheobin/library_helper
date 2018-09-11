package library;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookTest {

	private static String context = "dGVudGNvb18vKi8lNWJhbGwlNWQvc2VhcmNoP2R"
			+ "iMj1FbmdsaXNoJTIwQm9va3MmZm9ybWF0PWhpdGNvdW50JmZyb209JT"
			+ "VidGl0bGUlNWQmbGluaz1hbmQmd29yZD1TUkUmbWF4PTEyJnN0YXJ0PT"
			+ "EmbWF0Y2g9YW55JmRiPSVkNiVkMCVjZSVjNCVjZCViYyVjYSVlOSZzZWFyY"
			+ "2hzdHlsZT1ub3JtYWwmZGVidWc9b2ZmJnJlY29yZHNldD10aXRsZW51bWJl"
			+ "ciZfZHVwPW9mZiZ3b3JkPVNSRSZtYXRjaD1leGFjdCZyZWNvcmRzZXQ9bW"
			+ "FyY3JlY29yZCZmb3JtYXQ9ZGV0YWlsJnN0YXJ0PTEkJHRlbnRjb29fZW5k";

	public static void main(String[] args) throws IOException {
		byte[] baseByte = Base64.decodeBase64(context);
		String query = new String(baseByte, "utf-8");
		if (query.startsWith("tentcoo_") && query.endsWith("$$tentcoo_end")) {
			query = "http://query.libmill.com" + query.replace("tentcoo_", "").replace("$$tentcoo_end", "");
			URL url = new URL(query);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setUseCaches(Boolean.FALSE);
			connection.addRequestProperty("Connection", "close");
			connection.setConnectTimeout(8000);
			connection.setReadTimeout(8000);
			Document doc = Jsoup.parse(connection.getInputStream(), "gb2312", "http://query.libmill.com/");
			Elements tables = doc.getElementsByTag("table");
			if (tables != null && tables.size() >= 3) {
				Element detailTable = tables.get(2);
				Elements trs = detailTable.getElementsByTag("tr");
				String title = "";
				String libNumber = "";
				String author = "";
				String publisher = "";
				String isbn = "";
				
				if (trs.get(2) != null) {
					Element td = trs.get(2).getElementsByTag("td").get(1);
					if (td != null) {
						title = td.text();
					}
				}
				if (trs.get(3) != null) {
					Element td = trs.get(3).getElementsByTag("td").get(1);
					if (td != null) {
						libNumber = td.text();
					}
				}
				if (trs.get(4) != null) {
					Element td = trs.get(4).getElementsByTag("td").get(1);
					if (td != null) {
						author = td.text();
					}
				}
				if (trs.get(5) != null) {
					Element td = trs.get(5).getElementsByTag("td").get(1);
					if (td != null) {
						publisher = td.text();
					}
				}
				if (trs.get(9) != null) {
					Element td = trs.get(9).getElementsByTag("td").get(1);
					if (td != null) {
						isbn = td.text().split("\\s+")[0];
					}
				}
			}
			
			Element borrowDetail = tables.get(3);
			if(borrowDetail != null) {
				System.out.println(borrowDetail);
				Elements trs = borrowDetail.getElementsByTag("tr");
				if(trs.size() > 1){
					for(int i = 1 ; i < trs.size() ; i ++) {
						Elements tds = trs.get(i).getElementsByTag("td");
						if(tds.size() > 6) {
							String code = "";
							String place = "";
							String returnTime ="";
							String status = "";
							if (tds.get(1) != null) {
								code = tds.get(1).text();
							}
							if (tds.get(3) != null) {
								returnTime = tds.get(3).text();
							}
							if(tds.get(4)!=null) {
								returnTime = tds.get(4).text();
							}
							if(tds.get(6)!=null) {
								status = tds.get(6).text();
							}
						}
					}
				}
			}
		}
	}

}
