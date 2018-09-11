package com.tentcoo.dao;

import java.util.List;

import com.tentcoo.entity.BookListEntity;

public interface BookListDao {
	
	public void addBookList(BookListEntity bookList);
	
	public void updateBookList(BookListEntity bookList);
	
	public List<BookListEntity> selectByUserId(String userId);
	
	public List<BookListEntity> selectNotReturnByUserId(String userId);

}
