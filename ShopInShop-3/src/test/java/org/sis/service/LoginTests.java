package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.mapper.LoginMapper;
import org.sis.user.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class LoginTests {

	@Autowired
	LoginMapper mapper;
	
	@Test
	public void insert() {
		
		MemberVO member = new MemberVO();
		
		member.setMpw("hello");
		member.setMmid("id");
		member.setMname("Nick");
		
		mapper.join(member);
		
	}
	
	
	@Test
	public void check() {
		
		MemberVO member = new MemberVO();
		
		member.setMpw("hello");
		member.setMmid("id");
		
		
		log.info(""+mapper.login(member));
		
	}
	
}
