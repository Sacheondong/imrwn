package com.imrwn.jh.service;

import java.util.List;

import com.imrwn.jh.dto.Comment_B;

public interface Comment_BService {

	int getCount(Integer bno) throws Exception;

	int getRemoveAll(Integer bno) throws Exception;

	List<Comment_B> getSelectInfoId(String id) throws Exception;

	List<Comment_B> getList(Integer bno) throws Exception;

	int getWrite(Comment_B b) throws Exception;

	int getModify(Comment_B b) throws Exception;

	int getRemove(Integer cno, Integer bno, String commenter) throws Exception;

}