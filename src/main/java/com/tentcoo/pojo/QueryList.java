package com.tentcoo.pojo;

import java.util.List;

public class QueryList {

	private int currentPage;
	private boolean hasNext = false;
	private List<LinkResult> data;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<LinkResult> getData() {
		return data;
	}

	public void setData(List<LinkResult> data) {
		this.data = data;
	}

}
