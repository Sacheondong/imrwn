package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.dto.Review_M;

public interface Review_MDao {

	int deleteAll(Integer mno) throws Exception;

	int count(Integer mno) throws Exception;

	int delete(Integer rno, String reviewer) throws Exception;

	int insert(Review_M r) throws Exception;

	List<Review_M> selectAll(Integer mno) throws Exception;

	int update(Review_M r) throws Exception;

	List<Review_M> selectInfoRev(String reviewer) throws Exception;

	Review_M selectId(String reviewer, Integer mno) throws Exception;

	List<Review_M> selectInfoId(String reviewer) throws Exception;

}