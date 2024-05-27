package com.imrwn.jh.service;

import com.imrwn.jh.dto.Like_M;

public interface Like_MService {

	int getCount(Integer mno) throws Exception;

	Like_M getSelect(Integer mno, String id) throws Exception;

	int getWriteGood(Like_M l) throws Exception;

	int getWriteScore(Like_M l) throws Exception;

	int getModifyGood(int good, Integer mno, String id) throws Exception;

	int getModifyScore(float score, Integer mno, String id) throws Exception;

	Like_M getSelectAvg(Integer mno) throws Exception;

}