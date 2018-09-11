package com.tentcoo.service;

import com.tentcoo.library.pojo.BookDetail;
import com.tentcoo.library.pojo.SimpleQueryPage;
import com.tentcoo.pojo.QueryList;

public interface LibraryService {
	
	public QueryList queryByWord(String word,int page);
	
	public QueryList queryCategory(String url);
	
	public BookDetail getBookDetail(String url);

}