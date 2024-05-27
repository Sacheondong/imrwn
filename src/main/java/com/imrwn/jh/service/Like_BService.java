package com.imrwn.jh.service;

import com.imrwn.jh.dto.Like_B;

public interface Like_BService {

	int getCount(Integer bno) throws Exception;

	Like_B getSelect(Integer bno, String id) throws Exception;

	int getInsert(Like_B l) throws Exception;

	int getDelete(String id, Integer bno) throws Exception;


}