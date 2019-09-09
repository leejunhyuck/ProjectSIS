package org.sis.board.controller;

import org.sis.board.model.Criteria;
import org.sis.board.model.PageMaker;
import org.sis.board.model.ShopVO;
import org.sis.board.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/shop/*")
@Log
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@GetMapping("/google")
	public void google() {
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri ,Model model) {
		log.info("list Page.......................");
		int totalCount = service.getListCount(cri);
		log.info(""+totalCount);
		
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pm", new PageMaker(cri, totalCount));
	}
	
	@GetMapping("/list_test")
	public void list_test() {
	}
	
	@GetMapping("/read")
	public void read() {
		
		
		
		
	}
	
	@GetMapping("/analysis")
	public void analysis() {
	}
	
	@GetMapping("/recent")
	public void recent() {
	}
	
	@GetMapping("/mylist")
	public void mylist() {
	}
	
	@GetMapping("/register")
	public void registerGet() {
	}
	
	@PostMapping("/register")
	public void registerPost(@ModelAttribute ShopVO vo) {
		log.info("register...");
		service.register(vo);
	}
	
	@PutMapping("/modify")
	public void modify() {
	}
	
	@DeleteMapping("remove")
	public void remove() {
	}
}