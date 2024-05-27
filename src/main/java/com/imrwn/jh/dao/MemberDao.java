package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.dto.Member;

public interface MemberDao {

	List<Member> selectAll() throws Exception;

	Member selectId(String id) throws Exception;

	int insertMem(Member m) throws Exception;

	int updateMem(Member m) throws Exception;

	int deleteId(String id) throws Exception;

	int deleteAll() throws Exception;

	int updateMovieCnt(String id, int movieCnt) throws Exception;

	int updateMovielikeCnt(String id, int movielikeCnt) throws Exception;

	int updateNick(Member m) throws Exception;

	int updateMovieScoreCnt(String id, int movieScoreCnt) throws Exception;

}