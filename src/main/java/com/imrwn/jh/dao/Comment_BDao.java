package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.dto.Comment_B;

public interface Comment_BDao {

	int deleteAll(Integer bno) throws Exception;

	int count(Integer bno) throws Exception;

	int delete(Integer cno, String commenter) throws Exception;

	int insert(Comment_B b) throws Exception;

	List<Comment_B> selectAll(Integer bno) throws Exception;

	int update(Comment_B b) throws Exception;

	List<Comment_B> selectInfoId(String id) throws Exception;

}