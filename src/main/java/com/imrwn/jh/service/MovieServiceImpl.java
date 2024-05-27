
package com.imrwn.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dao.MovieDao;
import com.imrwn.jh.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	@Override
	public Movie getSelectMovie(String title, String directors) throws Exception {
		return movieDao.selectTitleDire(title, directors);
	}

	@Override
	public int getSaveDB(Movie m) throws Exception {
		return movieDao.insert(m);
	}
	@Override
	public List<Movie> getSelectSearch(MovSearchCondition sc) throws Exception {
		return movieDao.selectSearch(sc);
	}
	@Override
	public int getSelectSearchCnt(MovSearchCondition sc) throws Exception {
		return movieDao.selectSearchCnt(sc);
	}
	@Override
	public Movie getSelectMno(Integer mno) throws Exception {
		return movieDao.selectMno(mno);
	}
	@Override
	public List<Movie> getSelectRandom(String actors, String genre, float score) throws Exception {
		return movieDao.selectRandom(actors, genre, score);
	}
	@Override
	public List<Movie> getSelectLikeList(MovSearchCondition sc) throws Exception {
		return movieDao.selectLikeList(sc);
	}
	@Override
	public int getSelectLikeCnt(MovSearchCondition sc) throws Exception {
		return movieDao.selectLikeCnt(sc);
	}
}
