package com.tentcoo.service;

import java.util.List;

import com.tentcoo.entity.BookListEntity;
import com.tentcoo.entity.RecordEntity;
import com.tentcoo.pojo.RankDto;

public interface BookService {
	
	public void addBookList(BookListEntity bookList);
	
	public void updateBookList(BookListEntity bookList);
	
	public List<BookListEntity> selectByUserId(String userId);
	
	public void addRecord(RecordEntity record);
	
	public List<RankDto> getRankList();

}
