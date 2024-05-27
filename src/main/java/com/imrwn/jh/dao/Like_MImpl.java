package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.Like_M;

@Repository
public class Like_MImpl implements Like_MDao {

	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.like_m.";
	
	@Override
	public int count(Integer mno) throws Exception {
		return session.selectOne(namespace + "count", mno);
	}
	@Override
	public Like_M select(Integer mno, String id) throws Exception {
		Map map = new HashMap();
		map.put("mno", mno);
		map.put("id", id);
		
		return session.selectOne(namespace + "select", map);
	}
	@Override
	public int insertGood(Like_M l) throws Exception {
		return session.insert(namespace + "insertGood", l);
	}
	@Override
	public int insertScore(Like_M l) throws Exception {
		return session.insert(namespace + "insertScore", l);
	}
	@Override
	public int updateGood(int good, Integer mno, String id) throws Exception {
		Map map = new HashMap();
		map.put("good", good);
		map.put("mno", mno);
		map.put("id", id);

		return session.update(namespace + "updateGood", map);
	}
	@Override
	public int updateScore(float score, Integer mno, String id) throws Exception {
		Map map = new HashMap();
		map.put("score", score);
		map.put("mno", mno);
		map.put("id", id);
		
		return session.update(namespace + "updateScore", map);
	}
	@Override
	public Like_M selectAvg(Integer mno) throws Exception {
		return session.selectOne(namespace + "selectAvg", mno);
	}
	
}
