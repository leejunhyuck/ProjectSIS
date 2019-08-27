package org.sis.user.service;

import org.sis.mapper.LoginMapper;
import org.sis.user.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.java.Log;

@Service
public class LoginService {

	@Setter(onMethod_=@Autowired )
	private LoginMapper mapper;
	
	@Setter(onMethod_=@Autowired )
	private MemberService memberserice;
	

	public void register(MemberVO member) {
		
		
		mapper.join(member);		
		
		//memberserice.insertMembership(member);
		
	}
	
	public MemberVO logincheck(MemberVO member){
		
		return mapper.login(member);
		
		
	}
	
	
}
