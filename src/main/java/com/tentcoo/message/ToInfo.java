package com.tentcoo.message;

import java.util.ArrayList;
import java.util.List;

public class ToInfo {

	private String no;
	private List<String> user;
	
	public ToInfo(){
		user = new ArrayList<String>();
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<String> getUser() {
		return user;
	}
	public void setUser(List<String> user) {
		this.user = user;
	}

	

}
