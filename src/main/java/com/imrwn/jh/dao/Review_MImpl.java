package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.Review_M;

@Repository
public class Review_MImpl implements Review_MDao {

	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.review_m.";
	
	@Override
	public int deleteAll(Integer mno) throws Exception {
		return session.delete(namespace + "deleteAll", mno);
	}
	@Override
	public int count(Integer mno) throws Exception {
		return session.selectOne(namespace + "count", mno);
	}
	@Override
	public int delete(Integer rno, String reviewer) throws Exception {
		Map map = new HashMap();
		map.put("rno", rno);
		map.put("reviewer", reviewer);
		
		return session.delete(namespace + "delete", map);
	}
	@Override
	public int insert(Review_M r) throws Exception {
		return session.insert(namespace + "insert", r);
	}
	@Override
	public List<Review_M> selectAll(Integer mno) throws Exception {
		return session.selectList(namespace + "selectAll", mno);
	}
	@Override
	public int update(Review_M r) throws Exception {
		return session.update(namespace + "update", r);
	}
	@Override
	public List<Review_M> selectInfoRev(String reviewer) throws Exception {
		return session.selectList(namespace + "selectInfoRev", reviewer);
	}
	@Override
	public Review_M selectId(String reviewer, Integer mno) throws Exception {
		Map map = new HashMap();
		map.put("reviewer", reviewer);
		map.put("mno", mno);
		return session.selectOne(namespace + "selectId", map);
	}
	@Override
	public List<Review_M> selectInfoId(String reviewer) throws Exception {
		return session.selectList(namespace + "selectInfoId", reviewer);
	}
}
