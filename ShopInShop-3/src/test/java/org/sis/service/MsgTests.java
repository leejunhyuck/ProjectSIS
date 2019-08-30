package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.mapper.MessageMapper;
import org.sis.mapper.TimeMapper;
import org.sis.user.model.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MsgTests {

	@Autowired
	MessageMapper mapper;
	
	@Autowired
	TimeMapper tmapper;
	
	@Test
	public void insertTests() {
		for (int i = 2; i < 50; i++) {
			
	
		MessageVO vo = new MessageVO();
		vo.setMmid("mmid3");
		vo.setContent("content"+i);
		vo.setTitle("title1"+i);
		vo.setWhom("user123");
		mapper.insert(vo);
		}
	}
	@Test
	public void timetest() {
		tmapper.getTime();
	}
	
	@Test
	public void listtest() {
		mapper.msgList();
		log.info(""+mapper.msgList());
		
		
	}
}
