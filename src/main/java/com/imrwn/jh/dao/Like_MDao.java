package com.imrwn.jh.dao;

import com.imrwn.jh.dto.Like_M;

public interface Like_MDao {

	int count(Integer mno) throws Exception;

	Like_M select(Integer mno, String id) throws Exception;

	int insertGood(Like_M l) throws Exception;

	int insertScore(Like_M l) throws Exception;

	int updateGood(int good, Integer mno, String id) throws Exception;
	
	int updateScore(float score, Integer mno, String id) throws Exception;

	Like_M selectAvg(Integer mno) throws Exception;

}