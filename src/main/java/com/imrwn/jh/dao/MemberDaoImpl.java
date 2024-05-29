package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession session;

	String namespace = "com.imrwn.member.";

	@Override
	public List<Member> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}

	@Override
	public Member selectId(String id) throws Exception {
		return session.selectOne(namespace + "selectId", id);
	}

	@Override
	public int insertMem(Member m) throws Exception {
		return session.insert(namespace + "insertMem", m);
	}

	@Override
	public int updateMem(Member m) throws Exception {
		return session.update(namespace + "updateMem", m);
	}
	
	@Override
	public int updateNick(Member m) throws Exception {
		return session.update(namespace + "updateNick", m);
	}

	@Override
	public int deleteId(String id) throws Exception {
		return session.delete(namespace + "deleteId", id);
	}

	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}

	@Override
	public int updateMovieCnt(String id, int movieCnt) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("movieCnt", movieCnt);

		return session.update(namespace + "updateMovieCnt", map);
	}

	@Override
	public int updateMovielikeCnt(String id, int movielikeCnt) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("movielikeCnt", movielikeCnt);

		return session.update(namespace + "updateMovielikeCnt", map);
	}
	@Override
	public int updateMovieScoreCnt(String id, int movieScoreCnt) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("movieScoreCnt", movieScoreCnt);
		
		return session.update(namespace + "updateMovieScoreCnt", map);
	}
}
