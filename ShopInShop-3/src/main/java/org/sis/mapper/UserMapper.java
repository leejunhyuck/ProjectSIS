package org.sis.mapper;

import java.util.List;

import org.sis.board.model.ShopVO;
import org.sis.user.model.MemberVO;

public interface UserMapper {

	
	public MemberVO login(MemberVO member);
	
	public int join(MemberVO member);
	
	public MemberVO mypage(String mmid);
	
	public int infoUpdate(MemberVO member);
	
	public int getDupCheckCnt(String userid);
	
	
	
}
