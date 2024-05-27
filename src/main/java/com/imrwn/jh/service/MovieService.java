package com.imrwn.jh.service;

import java.util.List;

import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dto.Movie;

public interface MovieService {


	int getSaveDB(Movie m) throws Exception;

	Movie getSelectMovie(String title, String directors) throws Exception;

	Movie getSelectMno(Integer mno) throws Exception;

	List<Movie> getSelectRandom(String actors, String genre, float score) throws Exception;

	List<Movie> getSelectSearch(MovSearchCondition sc) throws Exception;

	int getSelectSearchCnt(MovSearchCondition sc) throws Exception;

	List<Movie> getSelectLikeList(MovSearchCondition sc) throws Exception;

	int getSelectLikeCnt(MovSearchCondition sc) throws Exception;

}