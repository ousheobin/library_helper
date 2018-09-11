package com.tentcoo.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value="BookListEntity")
public class BookListEntity {

	private String id;
	private String bookName;
	private String bookNumber;
	private Date markTime;
	private int isDelete;
	private Date deleteTime;
	private UserEntity user;
	private int isBack;
	private String bookSource;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public Date getMarkTime() {
		return markTime;
	}

	public void setMarkTime(Date markTime) {
		this.markTime = markTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getIsBack() {
		return isBack;
	}

	public void setIsBack(int isBack) {
		this.isBack = isBack;
	}

	public String getBookSource() {
		return bookSource;
	}

	public void setBookSource(String bookSource) {
		this.bookSource = bookSource;
	}

}
