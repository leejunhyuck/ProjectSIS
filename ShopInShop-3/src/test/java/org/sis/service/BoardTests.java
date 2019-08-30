package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.board.model.ComVO;
import org.sis.board.test.model.ReplyVO;
import org.sis.mapper.ComMapper;
import org.sis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class BoardTests {

	@Autowired
	ReplyMapper mapper;
	
	@Autowired
	private ComMapper comMapper;
	
	@Test
	public void insert100Test() {
		
		ComVO vo = new ComVO();
		for(int i = 1; i<100; i++) {
			vo.setMmid("user123");
			vo.setTitle("insert100 Test Title"+i);
			vo.setContent("insert100 Test content"+i);
			comMapper.insert(vo);
		}
	}
	
	
	
	
	
	
	@Test
	public void selecttests() {
		
		ReplyVO vo = mapper.select(4);
	
		
		log.info(""+vo);
		
	}
	
}
