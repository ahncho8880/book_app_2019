package com.minnano.service;

import java.util.List;

import com.minnano.model.MemberBean;

public interface MemberService {
	public List<MemberBean> list();
	public boolean login(String id, String passwd);
	public void joinMember(MemberBean memberbean);
}
