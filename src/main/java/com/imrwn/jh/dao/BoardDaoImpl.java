package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.board.";
	
	@Override
	public List<Board> searchSelectPage(SearchCondition sc) throws Exception {
		return session.selectList(namespace + "searchSelectPage", sc);
	}
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
		return session.selectOne(namespace + "searchResultCnt", sc);
	}
	@Override
	public int count() throws Exception {
		return session.selectOne(namespace + "count");
	}
	@Override
	public List<Board> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}
	@Override
	public Board select(Integer bno) throws Exception {
		return session.selectOne(namespace + "select", bno);
	}
	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}
	@Override
	public int delete(Integer bno, String writer ) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("writer", writer);
		return session.delete(namespace + "delete", map);
	}
	@Override
	public int insert(Board b) throws Exception {
		return session.insert(namespace + "insert", b);
	}
	@Override
	public int update(Board b) throws Exception {
		return session.update(namespace + "update", b);
	}
	@Override
	public int updateViewCnt(Integer bno) throws Exception {
		return session.update(namespace + "updateViewCnt", bno);
	}
	@Override
	public int updateCommentCnt(Integer bno, Integer commentCnt) throws Exception {
		Map map = new HashMap();
		map.put("commentCnt", commentCnt);
		map.put("bno", bno);
		
		return session.update(namespace + "updateCommentCnt", map);
	}
	@Override
	public int updateLikeCnt(Integer bno, Integer likeCnt) throws Exception {
		Map map = new HashMap();
		map.put("likeCnt", likeCnt);
		map.put("bno", bno);
		
		return session.update(namespace + "updateLikeCnt", map);
	}
	@Override
	public List<Board> selectInfoId(String writer) throws Exception {
		return session.selectList(namespace + "selectInfoId", writer);
	}	
	@Override
	public List<Board> selectComment() throws Exception {
		return session.selectList(namespace + "selectComment");
	}
	@Override
	public List<Board> selectLike() throws Exception {
		return session.selectList(namespace + "selectLike");
	}
}
