package com.imrwn.jh.service;

import java.util.List;

import com.imrwn.jh.dto.Member;

public interface MemberService {

	List<Member> getSelectAll() throws Exception;

	Member getSelectId(String id) throws Exception;

	int getInsertMem(Member m) throws Exception;

	int getUpdateMem(Member m) throws Exception;

	int getDeleteId(String id) throws Exception;

	int getDeleteAll() throws Exception;

}