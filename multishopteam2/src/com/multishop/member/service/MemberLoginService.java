package com.multishop.member.service;

import com.multishop.main.service.Service;
import com.multishop.member.dao.MemberDAO;
import com.multishop.member.vo.MemberVO;

public class MemberLoginService implements Service {

	@Override
	public MemberVO service(Object obj) throws Exception {

		return new MemberDAO().login((MemberVO)obj);
	} // end of service

} // end of MemberLoginService
