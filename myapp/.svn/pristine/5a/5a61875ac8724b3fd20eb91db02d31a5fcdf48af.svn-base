package com.minnano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minnano.dao.MemberDao;
import com.minnano.model.MemberBean;

@Service
public class MemberServieImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberBean> list() {
		System.out.println("i'm in memberservice.list()");
		return memberDao.list();
	}

	@Override
	public boolean login(String id, String passwd) {
		// TODO Auto-generated method stub
		boolean ret = false;
		System.out.println("mae");
		MemberBean memberbean = memberDao.login(id);
		System.out.println(memberbean.toString());
		if(memberbean.getmPasswd().equals(passwd)){
			ret = true;
		}
		return ret;
	}

	@Override
	public void joinMember(MemberBean memberbean) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		System.out.println("service_memberbean"+memberbean.toString());
		memberDao.insertMember(memberbean);
		
	}
}
