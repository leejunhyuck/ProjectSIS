package org.sis.mapper;

import org.sis.user.model.Member;

public interface LoginMapper {

	
	public int getLoginCnt(Member member);
	
	public int join(Member member);
}
