package com.multishop.member.service;

import com.multishop.main.service.Service;
import com.multishop.member.dao.MemberDAO;
import com.multishop.member.vo.MemberVO;

public class MemberWriteService implements Service {
	public Integer service(Object obj) throws Exception {

		return new MemberDAO().write((MemberVO)obj);
	}

}
