package com.tentcoo.library.pojo;

public class BookLink {

	private String link;
	private boolean isCategory;
	private String bookName;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isCategory() {
		return isCategory;
	}

	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookLink [link=" + link + ", isCategory=" + isCategory + ", bookName=" + bookName + "]";
	}
	
}