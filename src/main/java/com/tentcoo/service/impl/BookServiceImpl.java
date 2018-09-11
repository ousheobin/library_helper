package com.tentcoo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tentcoo.dao.BookListDao;
import com.tentcoo.dao.RecordDao;
import com.tentcoo.entity.BookListEntity;
import com.tentcoo.entity.RecordEntity;
import com.tentcoo.pojo.RankDto;
import com.tentcoo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	BookListDao bookListDao;
	
	@Resource
	RecordDao recordDao;

	public void addBookList(BookListEntity bookList) {
		bookListDao.addBookList(bookList);
	}

	public void updateBookList(BookListEntity bookList) {
		bookListDao.updateBookList(bookList);
	}

	public List<BookListEntity> selectByUserId(String userId) {
		return bookListDao.selectByUserId(userId);
	}

	public void addRecord(RecordEntity record) {
		record.setSearchTime(new Date());
		recordDao.addRecord(record);
	}

	public List<RankDto> getRankList() {
		return recordDao.getRankList();
	}

}
