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

import com.tentcoo.library.pojo.BookDetail;
import com.tentcoo.library.pojo.BorrowDetail;

@Component
public class BookDetailComponent {

	public BookDetail getBookDetail(String query) throws Exception {
		URL url = new URL(query);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BookDetail detail = new BookDetail();
		connection.setRequestMethod("GET");
		connection.setUseCaches(Boolean.FALSE);
		connection.addRequestProperty("Connection", "close");
		connection.setConnectTimeout(8000);
		connection.setReadTimeout(8000);
		Document doc = Jsoup.parse(connection.getInputStream(), "gb2312", "http://query.libmill.com/");
		Elements tables = doc.getElementsByTag("table");
		if (tables.size() >= 3) {
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
			detail.setAuthor(author);
			detail.setIsbn(isbn);
			detail.setLibNumber(libNumber);
			detail.setPublisher(publisher);
			detail.setTitle(title);
		}

		Element borrowDetail = tables.get(3);
		List<BorrowDetail> borrowDetailList = new ArrayList<BorrowDetail>();
		if (borrowDetail != null) {
			Elements trs = borrowDetail.getElementsByTag("tr");
			if (trs.size() > 1) {
				for (int i = 1; i < trs.size(); i++) {
					Elements tds = trs.get(i).getElementsByTag("td");
					if (tds.size() > 6) {
						String code = "";
						String place = "";
						String returnTime = "";
						String status = "";
						String reader = "";
						if (tds.get(1) != null) {
							code = tds.get(1).text();
						}
						if (tds.get(2) != null) {
							returnTime = tds.get(3).text();
						}
						if (tds.get(2) != null) {
							reader = tds.get(2).text();
						}
						if (tds.get(4) != null) {
							place = tds.get(4).text();
						}
						if (tds.get(6) != null) {
							status = tds.get(6).text();
						}
						BorrowDetail detailBean = new BorrowDetail();
						detailBean.setCode(code);
						detailBean.setPlace(place);
						if(returnTime.isEmpty()) {
							detailBean.setReturnTime("-");
						}else if(returnTime.length() == 6) {
							detailBean.setReturnTime("20"+returnTime.substring(0, 2)+"-"+returnTime.substring(2, 4)+"-"+returnTime.substring(4, 6));
						}else if(returnTime.length() == 8) {
							detailBean.setReturnTime(returnTime.substring(0, 4)+"-"+returnTime.substring(4, 6)+"-"+returnTime.substring(6, 8));
						}else {
							detailBean.setReturnTime(returnTime);
						}
						detailBean.setReader(reader);
						detailBean.setReader(null);
						detailBean.setStatus(status);
						borrowDetailList.add(detailBean);
					}
				}
			}
		}
		detail.setBorrows(borrowDetailList);
		return detail;
	}

}
