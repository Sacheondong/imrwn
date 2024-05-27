package com.imrwn.jh.service;

import java.util.List;

import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dto.Board;

public interface BoardService {

	List<Board> getSearchResultPage(SearchCondition sc) throws Exception;

	int getSearchResultCnt(SearchCondition sc) throws Exception;

	int getCount() throws Exception;

	List<Board> getList() throws Exception;

	Board getBoard(Integer bno) throws Exception;

	Board getRead(Integer bno) throws Exception;

	int getRemoveAll() throws Exception;

	int getRemove(Integer bno, String writer) throws Exception;

	int getWrite(Board b) throws Exception;

	int getModify(Board b) throws Exception;

	List<Board> getSelectInfoId(String writer) throws Exception;

	List<Board> getSelectComment() throws Exception;

	List<Board> getSelectLike() throws Exception;

}