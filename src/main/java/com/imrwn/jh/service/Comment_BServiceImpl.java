package com.imrwn.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.dao.BoardDao;
import com.imrwn.jh.dao.Comment_BDao;
import com.imrwn.jh.dto.Comment_B;

@Service
public class Comment_BServiceImpl implements Comment_BService {

	private BoardDao boardDao;
	private Comment_BDao comment_bDao;

	@Autowired
	public Comment_BServiceImpl(BoardDao boardDao, Comment_BDao comment_bDao) {
		super();
		this.boardDao = boardDao;
		this.comment_bDao = comment_bDao;
	}

	@Override
	public int getCount(Integer bno) throws Exception {
		return comment_bDao.count(bno);
	}

	@Override
	public int getRemoveAll(Integer bno) throws Exception {
		return comment_bDao.deleteAll(bno);
	}

	@Override
	public int getRemove(Integer cno, Integer bno, String commenter) throws Exception {
		int res = comment_bDao.delete(cno, commenter);
		if (res == 1) {
			boardDao.updateCommentCnt(bno, -1);
		}
		return res;
	}

	@Override
	public int getWrite(Comment_B b) throws Exception {
		int res = comment_bDao.insert(b);
		if (res == 1) {
			boardDao.updateCommentCnt(b.getBno(), 1);
		}
		return res;
	}

	@Override
	public List<Comment_B> getList(Integer bno) throws Exception {
		return comment_bDao.selectAll(bno);
	}

	@Override
	public int getModify(Comment_B b) throws Exception {
		return comment_bDao.update(b);
	}

	@Override
	public List<Comment_B> getSelectInfoId(String id) throws Exception {
		return comment_bDao.selectInfoId(id);
	}

}
