package org.sis.mapper;

import org.sis.user.model.MemberVO;

public interface LoginMapper {

	
	public int getLoginCnt(MemberVO member);
	
	public int join(MemberVO member);
}
