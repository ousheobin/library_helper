package com.tentcoo.entity;

import org.apache.ibatis.type.Alias;

@Alias(value = "UserEntity")
public class UserEntity {

	private String id;
	private String kingdeeId;
	private String userNumber;
	private String memberName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKingdeeId() {
		return kingdeeId;
	}

	public void setKingdeeId(String kingdeeId) {
		this.kingdeeId = kingdeeId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
