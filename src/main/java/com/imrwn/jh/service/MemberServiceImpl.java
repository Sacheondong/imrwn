package com.imrwn.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imrwn.jh.dao.MemberDao;
import com.imrwn.jh.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public List<Member> getSelectAll() throws Exception {
		return memberDao.selectAll();
	}
	@Override
	public Member getSelectId(String id) throws Exception {
		return memberDao.selectId(id);
	}
	@Override
	public int getInsertMem(Member m) throws Exception {
		return memberDao.insertMem(m);
	}
	@Override
	public int getUpdateMem(Member m) throws Exception {
		if(m.getPwd() != null && m.getPwd() != "" && m.getPwd() != "null") {
			return memberDao.updateMem(m);
		}else {
			return memberDao.updateNick(m);
		}

	}
	@Override
	public int getDeleteId(String id) throws Exception {
		return memberDao.deleteId(id);
	}
	@Override
	public int getDeleteAll() throws Exception {
		return memberDao.deleteAll();
	}
}
