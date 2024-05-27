package com.imrwn.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.dao.Like_MDao;
import com.imrwn.jh.dao.MemberDao;
import com.imrwn.jh.dao.MovieDao;
import com.imrwn.jh.dto.Like_M;

@Service
public class Like_MServiceImpl implements Like_MService {

	private Like_MDao like_mDao;
	private MovieDao movieDao;
	private MemberDao memberDao;

	@Autowired
	public Like_MServiceImpl(Like_MDao like_mDao, MovieDao movieDao, MemberDao memberDao) {
		super();
		this.like_mDao = like_mDao;
		this.movieDao = movieDao;
		this.memberDao = memberDao;
	}

	@Override
	public int getCount(Integer mno) throws Exception {
		return like_mDao.count(mno);
	}

	@Override
	public Like_M getSelect(Integer mno, String id) throws Exception {

		return like_mDao.select(mno, id);
	}

	@Override
	public int getWriteGood(Like_M l) throws Exception {
		int res = like_mDao.insertGood(l);

		return res;
	}

	@Override
	public int getWriteScore(Like_M l) throws Exception {
		int res = like_mDao.insertScore(l);
		return res;
	}

	@Override
	public int getModifyGood(int good, Integer mno, String id) throws Exception {
		int res = like_mDao.updateGood(good, mno, id);
		if (res == 1) {
			memberDao.updateMovielikeCnt(id, -good);
			movieDao.updatemovieLikeCnt(mno, -good);
		}
		return res;
	}

	@Override
	public int getModifyScore(float score, Integer mno, String id) throws Exception {
		int res = like_mDao.updateScore(score, mno, id);

		return res;
	}
	@Override
	public Like_M getSelectAvg(Integer mno) throws Exception {
		return like_mDao.selectAvg(mno);
	}

}
