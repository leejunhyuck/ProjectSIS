package org.sis.user.service;

import org.sis.mapper.UserMapper;
import org.sis.user.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.java.Log;

@Service
public class UserService {

	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;

	public void register(MemberVO member) {

		mapper.join(member);

	}

	public MemberVO loginCheck(MemberVO member) {

		return mapper.login(member);

	}
	public MemberVO userInfo(String mmid) {

		return mapper.mypage(mmid);

	}
	
	public boolean userModify(MemberVO member) {
		
		
		
		
		return mapper.infoUpdate(member)==1?true:false; 
		
	}
	
	public int getDupCheckCnt(String userid) {
		
		
		return mapper.getDupCheckCnt(userid);
	}
	
	

}
