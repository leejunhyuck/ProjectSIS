package org.sis.board.controller;


import org.sis.board.model.ComLikeVO;
import org.sis.mapper.ComLikeMapper;
import org.sis.mapper.ComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;


@RestController
@RequestMapping("/like_com/*")
@Log
@CrossOrigin
public class ComLikeController {
	
	@Autowired
	private ComLikeMapper mapper;
	@Autowired
	private ComMapper comMapper;
	
	
	@PostMapping(value = "/new", consumes = "application/json" ,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ComLikeVO vo){
		log.info("like community: " + vo);
		
		if(mapper.check(vo) != null ) {
			return new ResponseEntity<>("Like",HttpStatus.NOT_FOUND);
		}else{
			mapper.insert(vo);
			comMapper.updateLikeCnt(vo.getBno());
		}
		
		return new ResponseEntity<>("Like",HttpStatus.OK);
		
		
	}
	
	
	
}
