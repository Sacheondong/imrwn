
package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dto.Movie;
import com.imrwn.jh.jackson.Directors;

public interface MovieDao {

	int insert(Movie m) throws Exception;

	int updatemovieLikeCnt(Integer mno, int movieLikeCnt) throws Exception;

	int updatemovieReviewCnt(Integer mno, int movieReviewCnt) throws Exception;

	Movie selectTitleDire(String title, String directors) throws Exception;

	Movie selectMno(Integer mno) throws Exception;

	List<Movie> selectRandom(String actors, String genre, float score);

	List<Movie> selectSearch(MovSearchCondition sc) throws Exception;

	int selectSearchCnt(MovSearchCondition sc) throws Exception;

	List<Movie> selectLikeList(MovSearchCondition sc) throws Exception;

	int selectLikeCnt(MovSearchCondition sc) throws Exception;

}
