package org.sis.user.service;

import org.sis.mapper.BoardMapper;
import org.sis.mapper.LoginMapper;
import org.sis.user.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class LoginService {

	@Setter(onMethod_=@Autowired )
	private LoginMapper mapper;
	

	public void register(MemberVO member){
		
		mapper.join(member);
		
		
	}
	
	public String logincheck(MemberVO member){
		
		return mapper.login(member).getName();
		
		
	}
	
	
}
