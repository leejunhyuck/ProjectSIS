package org.sis.mapper;

import org.sis.user.model.MemberVO;

public interface UserMapper {

	
	public MemberVO login(MemberVO member);
	
	public int join(MemberVO member);
	
	public MemberVO mypage(String mmid);
	
	public int infoUpdate(MemberVO member);
	
}
