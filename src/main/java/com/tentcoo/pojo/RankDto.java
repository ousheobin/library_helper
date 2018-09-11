package com.tentcoo.pojo;

import org.apache.ibatis.type.Alias;

@Alias(value="RankDto")
public class RankDto {

	private String keyWord;
	private String times;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

}
