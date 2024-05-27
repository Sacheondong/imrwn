package com.imrwn.jh.service;

import java.util.List;

import com.imrwn.jh.dto.Review_M;

public interface Review_MService {

	int getRemoveAll(Integer mno) throws Exception;

	int getCount(Integer mno) throws Exception;

	int getRemove(Integer rno, String reviewer, Integer mno) throws Exception;

	int getWrite(Review_M r) throws Exception;

	List<Review_M> getSelectAll(Integer mno) throws Exception;

	int getModify(Review_M r) throws Exception;

	List<Review_M> getSelectInfoRev(String reviewer) throws Exception;

	Review_M getSelectId(String reviewer, Integer mno) throws Exception;

	List<Review_M> getSelectInfoId(String reviewer) throws Exception;

}