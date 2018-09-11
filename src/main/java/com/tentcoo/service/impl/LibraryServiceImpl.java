package com.tentcoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tentcoo.library.component.BookDetailComponent;
import com.tentcoo.library.component.CateSearchComponent;
import com.tentcoo.library.component.SimpleSearchComponent;
import com.tentcoo.library.pojo.BookDetail;
import com.tentcoo.library.pojo.BookLink;
import com.tentcoo.library.pojo.SimpleQueryPage;
import com.tentcoo.pojo.LinkResult;
import com.tentcoo.pojo.QueryList;
import com.tentcoo.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private Logger logger = Logger.getLogger(LibraryServiceImpl.class);
	
	@Resource
	SimpleSearchComponent simpleSearchComponent;
	
	@Resource
	BookDetailComponent bookDetailComponent;
	
	@Resource
	CateSearchComponent cateSearchComponent;
	
	public QueryList queryByWord(String word, int page) {
		int max = 12;
		int start = (page - 1 ) * max  + 1; 
		QueryList res = new QueryList();
		try {
			SimpleQueryPage datas =  simpleSearchComponent.query(word, start, max);
			res.setHasNext(datas.isHasNextPage());
			List<LinkResult> linkResults = new ArrayList<LinkResult>();
			for(BookLink book : datas.getBooks()) {
				LinkResult link = new LinkResult();
				if(book.isCategory()) {
					String spm = "tentcoo_"+book.getLink()+"$$tentcoo_end";
					byte[] encodeBase64 = Base64.encodeBase64(spm.getBytes("UTF-8"));
					link.setUrl("category.html?spm="+new String(encodeBase64));
				}else {
					String spm = "tentcoo_"+book.getLink()+"$$tentcoo_end";
					byte[] encodeBase64 = Base64.encodeBase64(spm.getBytes("UTF-8"));
					link.setUrl("detail.html?spm="+new String(encodeBase64));
				}
				link.setBookName(book.getBookName());
				linkResults.add(link);
			}
			res.setData(linkResults);
			res.setCurrentPage(page);
		} catch (Exception e) {
			logger.error("Exception:",e);
		}
		return res;
	}

	public BookDetail getBookDetail(String url) {
		try {
			return bookDetailComponent.getBookDetail(url);
		} catch (Exception e) {
			logger.error("Catch exception",e);
			return null;
		}
	}

	public QueryList queryCategory(String url) {
		QueryList res = new QueryList();
		try {
		 SimpleQueryPage datas =   cateSearchComponent.query(url);
			res.setHasNext(datas.isHasNextPage());
			List<LinkResult> linkResults = new ArrayList<LinkResult>();
			for(BookLink book : datas.getBooks()) {
				LinkResult link = new LinkResult();
				String spm = "tentcoo_"+book.getLink()+"$$tentcoo_end";
				byte[] encodeBase64 = Base64.encodeBase64(spm.getBytes("UTF-8"));
				link.setUrl("detail.html?spm="+new String(encodeBase64));
				link.setBookName(book.getBookName());
				linkResults.add(link);
			}
			res.setData(linkResults);
			res.setCurrentPage(1);
		} catch (Exception e) {
			logger.error("Catch exception",e);
		}
		return res;
	}

}
