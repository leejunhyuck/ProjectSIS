package org.sis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sis.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TimeTests {

	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void test() {
		log.info(mapper.getTime());
	}
	
	
	
}
