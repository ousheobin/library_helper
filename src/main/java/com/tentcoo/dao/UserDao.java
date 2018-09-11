package com.tentcoo.dao;

import java.util.List;

import com.tentcoo.entity.UserEntity;

public interface UserDao {
	
	public void addUser(UserEntity user);
	
	public UserEntity queryUserByUserid(String userId);
	
	public List<UserEntity> getAllUserList();

}
