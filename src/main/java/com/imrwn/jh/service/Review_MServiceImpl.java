
package com.imrwn.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.dao.MemberDao;
import com.imrwn.jh.dao.MovieDao;
import com.imrwn.jh.dao.Review_MDao;
import com.imrwn.jh.dto.Review_M;

@Service
public class Review_MServiceImpl implements Review_MService {

	private Review_MDao review_mDao;
	private MovieDao movieDao;
	private MemberDao memberDao;

	@Autowired
	public Review_MServiceImpl(Review_MDao review_mDao, MovieDao movieDao, MemberDao memberDao) {
		super();
		this.review_mDao = review_mDao;
		this.movieDao = movieDao;
		this.memberDao = memberDao;
	}

	@Override
	public int getRemoveAll(Integer mno) throws Exception {
		return review_mDao.deleteAll(mno);
	}

	@Override
	public int getCount(Integer mno) throws Exception {
		return review_mDao.count(mno);
	}

	@Override
	public int getRemove(Integer rno, String reviewer, Integer mno) throws Exception {
		int res = review_mDao.delete(rno, reviewer);
		if (res == 1) {
			memberDao.updateMovieCnt(reviewer, -1);
			movieDao.updatemovieReviewCnt(mno, -1);
		}
		return res;
	}

	@Override
	public int getWrite(Review_M r) throws Exception {
		int res = review_mDao.insert(r);
		if (res == 1) {
			memberDao.updateMovieCnt(r.getreviewer(), 1);
			movieDao.updatemovieReviewCnt(r.getMno(), 1);
		}
		return res;
	}

	@Override
	public List<Review_M> getSelectAll(Integer mno) throws Exception {
		return review_mDao.selectAll(mno);
	}

	@Override
	public int getModify(Review_M r) throws Exception {
		return review_mDao.update(r);
	}

	@Override
	public List<Review_M> getSelectInfoRev(String reviewer) throws Exception {
		return review_mDao.selectInfoRev(reviewer);
	}
	@Override
	public Review_M getSelectId(String reviewer, Integer mno) throws Exception {
		return review_mDao.selectId(reviewer, mno);
	}
	@Override
	public List<Review_M> getSelectInfoId(String reviewer) throws Exception {
		return review_mDao.selectInfoId(reviewer);
	}
}
