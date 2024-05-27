package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dto.Board;

public interface BoardDao {

	List<Board> searchSelectPage(SearchCondition sc) throws Exception;

	int searchResultCnt(SearchCondition sc) throws Exception;

	int count() throws Exception;

	List<Board> selectAll() throws Exception;

	Board select(Integer bno) throws Exception;

	int deleteAll() throws Exception;

	int delete(Integer bno, String writer) throws Exception;

	int insert(Board b) throws Exception;

	int update(Board b) throws Exception;

	int updateViewCnt(Integer bno) throws Exception;

	int updateCommentCnt(Integer bno, Integer commentCnt) throws Exception;

	int updateLikeCnt(Integer bno, Integer likeCnt) throws Exception;

	List<Board> selectInfoId(String writer) throws Exception;

	List<Board> selectComment() throws Exception;

	List<Board> selectLike() throws Exception;

}