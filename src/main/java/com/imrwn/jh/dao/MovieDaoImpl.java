
package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dto.Movie;
import com.imrwn.jh.jackson.Directors;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	SqlSession session;

	String namespace = "com.imrwn.movie.";

	@Override
	public Movie selectTitleDire(String title, String directors) throws Exception {
		Map map = new HashMap();
		map.put("title", title);
		map.put("directors", directors);

		return session.selectOne(namespace + "selectTitleDire", map);
	}

	@Override
	public int insert(Movie m) throws Exception {
		return session.insert(namespace + "insert", m);
	}

	@Override
	public int updatemovieLikeCnt(Integer mno, int movieLikeCnt) throws Exception {
		Map map = new HashMap();
		map.put("mno", mno);
		map.put("movieLikeCnt", movieLikeCnt);

		return session.update(namespace + "updatemovieLikeCnt", map);
	}

	@Override
	public int updatemovieReviewCnt(Integer mno, int movieReviewCnt) throws Exception {
		Map map = new HashMap();
		map.put("mno", mno);
		map.put("movieReviewCnt", movieReviewCnt);

		return session.update(namespace + "updatemovieReviewCnt", map);
	}
	@Override
	public List<Movie> selectSearch(MovSearchCondition sc) throws Exception {
		return session.selectList(namespace + "selectSearch", sc);
	}
	@Override
	public int selectSearchCnt(MovSearchCondition sc) throws Exception {
		return session.selectOne(namespace + "selectSearchCnt", sc);
	}
	@Override
	public Movie selectMno(Integer mno) throws Exception {
		return session.selectOne(namespace + "selectMno", mno);
	}
	@Override
	public List<Movie> selectRandom(String actors, String genre, float score) {
		Map map = new HashMap();
		map.put("actors", actors);
		map.put("genre", genre);
		map.put("score", score);
		return session.selectList(namespace + "selectRandom", map);
	}
	@Override
	public List<Movie> selectLikeList(MovSearchCondition sc) throws Exception {
		return session.selectList(namespace + "selectLikeList", sc);
	}
	@Override
	public int selectLikeCnt(MovSearchCondition sc) throws Exception {
		return session.selectOne(namespace + "selectLikeCnt", sc);
	}
}
