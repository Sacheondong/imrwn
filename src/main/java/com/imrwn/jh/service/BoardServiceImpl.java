package com.imrwn.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dao.BoardDao;
import com.imrwn.jh.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public List<Board> getSearchResultPage(SearchCondition sc) throws Exception {
		return boardDao.searchSelectPage(sc);
	}

	@Override
	public int getSearchResultCnt(SearchCondition sc) throws Exception {
		return boardDao.searchResultCnt(sc);
	}

	@Override
	public int getCount() throws Exception {
		return boardDao.count();
	}

	@Override
	public List<Board> getList() throws Exception {
		return boardDao.selectAll();
	}

	@Override
	public Board getBoard(Integer bno) throws Exception {
		return boardDao.select(bno);
	}

	@Override
	public Board getRead(Integer bno) throws Exception {
		boardDao.updateViewCnt(bno);
		Board b = boardDao.select(bno);
		return b;
	}

	@Override
	public int getRemoveAll() throws Exception {
		return boardDao.deleteAll();
	}

	@Override
	public int getRemove(Integer bno, String writer) throws Exception {
		return boardDao.delete(bno, writer);
	}

	@Override
	public int getWrite(Board b) throws Exception {
		return boardDao.insert(b);
	}

	@Override
	public int getModify(Board b) throws Exception {
		return boardDao.update(b);
	}
	@Override
	public List<Board> getSelectInfoId(String writer) throws Exception {
		return boardDao.selectInfoId(writer);
	}
	@Override
	public List<Board> getSelectComment() throws Exception {
		return boardDao.selectComment();
	}
	@Override
	public List<Board> getSelectLike() throws Exception {
		return boardDao.selectLike();
	}
	
}
