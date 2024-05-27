package com.imrwn.jh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imrwn.jh.dto.File;

@Repository
public class FileDaoImpl implements FileDao {
	@Autowired
	SqlSession session;
	
	String namespace = "com.imrwn.file.";
	
	@Override
	public int count() throws Exception {
		return session.selectOne(namespace + "count");
	}
	
	@Override
	public List<File> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}
	
	@Override
	public File select(int fno) throws Exception {
		return session.selectOne(namespace + "select", fno);
	}
	
	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}
	
	@Override
	public int delete(int fno, String writer) {
		Map map = new HashMap();
		map.put("fno", fno);
		map.put("writer", writer);
		
		return session.delete(namespace + "delete", map);
	}
	
	@Override
	public int insert(File f) throws Exception {
		return session.insert(namespace + "insert", f);
	}
	
	@Override
	public int update(File f) throws Exception {
		return session.update(namespace + "update", f);
	}
	
}
