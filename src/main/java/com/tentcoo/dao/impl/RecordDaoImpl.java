package com.tentcoo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tentcoo.dao.RecordDao;
import com.tentcoo.entity.RecordEntity;
import com.tentcoo.pojo.RankDto;
import com.tentcoo.utils.UUIDGenerator;

@Repository
public class RecordDaoImpl implements RecordDao {
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
	UUIDGenerator uuidGenerator;

	public void addRecord(RecordEntity record) {
		record.setId(uuidGenerator.generateUUID());
		sqlSessionTemplate.insert("RecordDao.addRecord",record);
	}

	public List<RankDto> getRankList() {
		return sqlSessionTemplate.selectList("RecordDao.selectCountList");
	}

}
