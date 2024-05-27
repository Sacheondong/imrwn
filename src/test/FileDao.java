package com.imrwn.jh.dao;

import java.util.List;

import com.imrwn.jh.dto.File;

public interface FileDao {

	int count() throws Exception;

	List<File> selectAll() throws Exception;

	File select(int fno) throws Exception;

	int deleteAll() throws Exception;

	int delete(int fno, String writer);

	int insert(File f) throws Exception;

	int update(File f) throws Exception;

}