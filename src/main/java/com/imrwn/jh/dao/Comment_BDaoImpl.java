package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.Comment_B;

@Repository
public class Comment_BDaoImpl implements Comment_BDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.comment_b.";
	
	@Override
	public int deleteAll(Integer bno) throws Exception {
		return session.delete(namespace + "deleteAll", bno);	
	}
	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(namespace + "count", bno);
	}
	@Override
	public int delete(Integer cno, String commenter) throws Exception {
		Map map = new HashMap();
		map.put("cno", cno);
		map.put("commenter", commenter);
		
		return session.delete(namespace + "delete", map);
	}
	@Override
	public int insert(Comment_B b) throws Exception {
		return session.insert(namespace + "insert", b);
	}
	@Override
	public List<Comment_B> selectAll(Integer bno) throws Exception {
		return session.selectList(namespace + "selectAll", bno);
	}
	@Override
	public int update(Comment_B b) throws Exception {
		return session.update(namespace + "update", b);
	}
	@Override
	public List<Comment_B> selectInfoId(String id) throws Exception {
		return session.selectList(namespace + "selectInfoId", id);
	}
	
}
