package com.imrwn.jh.dao;

import com.imrwn.jh.dto.Like_B;

public interface Like_BDao {

	int count(Integer bno) throws Exception;

	Like_B select(Integer bno, String id) throws Exception;

	int insert(Like_B l) throws Exception;

	int delete(Integer lno, String id) throws Exception;

}