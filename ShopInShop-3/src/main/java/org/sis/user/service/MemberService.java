package org.sis.user.service;

import org.sis.mapper.LoginMapper;
import org.sis.user.model.LoginUtil;
import org.sis.user.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class MemberService {

	@Autowired
	private LoginMapper mapper;

	public void insertMembership(MemberVO memberVO) throws Exception {
	                
	        String encode_password = LoginUtil.encryptPassword(memberVO.getMmid(), memberVO.getMpw());
	        memberVO.setMmid(memberVO.getMmid());
	        memberVO.setMpw(encode_password);
	        mapper.join(memberVO);
	
	
}
}