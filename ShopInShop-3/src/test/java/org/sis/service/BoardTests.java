package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.board.model.BoardVO;
import org.sis.board.model.ReplyVO;
import org.sis.mapper.BoardMapper;
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
	
	
	
	
	
	
	@Test
	public void selecttests() {
		
		ReplyVO vo = mapper.select(4);
	
		
		log.info(""+vo);
		
	}
	
}
