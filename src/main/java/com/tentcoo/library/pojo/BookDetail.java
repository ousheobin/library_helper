package com.tentcoo.library.pojo;

import java.util.List;

public class BookDetail {

	private String title = "";
	private String libNumber = "";
	private String author = "";
	private String publisher = "";
	private String isbn = "";

	private List<BorrowDetail> borrows;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLibNumber() {
		return libNumber;
	}

	public void setLibNumber(String libNumber) {
		this.libNumber = libNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<BorrowDetail> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<BorrowDetail> borrows) {
		this.borrows = borrows;
	}

}
