package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.board.model.BoardVO;
import org.sis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class ReplyTests {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void tests() {
		
		
		BoardVO vo = mapper.select(4);
		
		log.info(""+vo);
		
	}
	
	
	@Test
	public void updatetests() {
		
		BoardVO vo = mapper.select(4);
		vo.setTitle("AAAA");
		mapper.update(vo);
		
		
		log.info(""+vo);
		
	}
	
	
}
