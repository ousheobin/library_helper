package com.tentcoo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tentcoo.dao.UserDao;
import com.tentcoo.entity.UserEntity;
import com.tentcoo.utils.UUIDGenerator;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
	UUIDGenerator uuidGenerator;

	public void addUser(UserEntity user) {
		user.setId(uuidGenerator.generateUUID());
		sqlSessionTemplate.insert("UserDao.addUser",user);
	}

	public UserEntity queryUserByUserid(String userId) {
		return sqlSessionTemplate.selectOne("UserDao.queryUserByKingdeeid",userId);
	}

	public List<UserEntity> getAllUserList() {
		return sqlSessionTemplate.selectList("UserDao.selectAllUsers");
	}

}
