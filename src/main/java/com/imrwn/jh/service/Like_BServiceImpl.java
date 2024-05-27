package com.imrwn.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.dao.BoardDao;
import com.imrwn.jh.dao.Like_BDao;
import com.imrwn.jh.dto.Like_B;

@Service
public class Like_BServiceImpl implements Like_BService {

	private Like_BDao like_bDao;
	private BoardDao boardDao;
	
	@Autowired
	public Like_BServiceImpl(Like_BDao like_bDao, BoardDao boardDao) {
		super();
		this.like_bDao = like_bDao;
		this.boardDao = boardDao;
	}
	
	@Override
	public int getCount(Integer bno) throws Exception {
		return like_bDao.count(bno);
	}
	@Override
	public Like_B getSelect(Integer bno, String id) throws Exception {
		return like_bDao.select(bno, id);
	}
	@Override
	public int getInsert(Like_B l) throws Exception {
		int res = like_bDao.insert(l);
		if( res == 1 ) {
			boardDao.updateLikeCnt(l.getBno(), 1);
		}
		return res;
	}
	@Override
	public int getDelete(String id, Integer bno) throws Exception {
		int res = like_bDao.delete(bno, id);
		if(res == 1) {
			boardDao.updateLikeCnt(bno, -1);
		}
		return res;
	}
}
