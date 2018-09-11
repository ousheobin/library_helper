package com.tentcoo.dao;

import java.util.List;

import com.tentcoo.entity.RecordEntity;
import com.tentcoo.pojo.RankDto;

public interface RecordDao {
	
	public void addRecord(RecordEntity record);
	
	public List<RankDto> getRankList();

}
