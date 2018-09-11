package com.tentcoo.library.pojo;

import java.util.List;

public class SimpleQueryPage {

	private int currentStart;
	private boolean hasNextPage;
	private boolean hasPrevPage;
	private List<BookLink> books;

	public int getCurrentStart() {
		return currentStart;
	}

	public void setCurrentStart(int currentStart) {
		this.currentStart = currentStart;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public List<BookLink> getBooks() {
		return books;
	}

	public void setBooks(List<BookLink> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "SimpleQueryPage [currentStart=" + currentStart + ", hasNextPage=" + hasNextPage + ", hasPrevPage="
				+ hasPrevPage + ", books=" + books + "]";
	}
	
}