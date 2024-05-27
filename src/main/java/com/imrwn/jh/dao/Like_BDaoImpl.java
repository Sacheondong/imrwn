package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.Like_B;

@Repository
public class Like_BDaoImpl implements Like_BDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.like_b.";
	
	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(namespace + "count", bno);
	}
	@Override
	public Like_B select(Integer bno, String id) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("id", id);
		
		return session.selectOne(namespace + "select", map);
	}
	@Override
	public int insert(Like_B l) throws Exception {
		return session.insert(namespace + "insert", l);
	}
	@Override
	public int delete(Integer bno, String id) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("id", id);
		
		return session.delete(namespace + "delete", map);
	}
}
