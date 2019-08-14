package org.sis.board.controller;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ReplyVO;
import org.sis.board.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;


@RestController
@RequestMapping("/replies/*")
@AllArgsConstructor
@Log
@CrossOrigin
public class ReplyController {

	private ReplyService service;
	
	
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno")Integer rno){
		
		log.info("rno : "+rno);
		
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	@GetMapping("/{bno}/{page}")
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable(name="bno") Integer bno,
			@PathVariable(name="page") Integer page
		){
		int totalReply = service.countReply(bno);
		Criteria cri = new Criteria();
		cri.setBno(bno);
		cri.setPage(page);
		
		return new ResponseEntity<>(service.getList(cri),HttpStatus.OK);
		
	}
	@GetMapping("/list/{bno}")
	public ResponseEntity<List<ReplyVO>> getListbyBno(@PathVariable(name="bno") Integer bno){		
		log.info("getList by Bno: "+bno);
		
		return new ResponseEntity<>(service.getSimpleList(bno),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value = "/new", consumes = "application/json" ,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("register new reply");
		service.register(vo);
		
		return new ResponseEntity<>("success",HttpStatus.OK);
		
		
	}
	
	@PutMapping(value = "/modify" , consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> update(@RequestBody ReplyVO vo) {
		log.info("수정:" + vo);
		log.info("update reply");
		service.modify(vo);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/remove/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno){
		log.info("delete reply rno: "+rno);
		service.remove(rno);
		
		
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	
	
	
}
