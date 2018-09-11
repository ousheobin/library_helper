package com.tentcoo.service;

import com.tentcoo.entity.UserEntity;

public interface UserService {

	public void addUser(UserEntity user);
	
	public UserEntity queryUserByUserid(String userId);
}
