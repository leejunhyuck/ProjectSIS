package org.sis.board.controller;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ListVO;
import org.sis.board.model.PageMaker;
import org.sis.board.model.ShopVO;
import org.sis.board.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@PostMapping(value="/google",consumes = "application/json")
	@ResponseBody
	public ListVO google2(@RequestBody ListVO vo) {
		
		
		log.info(""+vo);
		
		
		return vo;
		
		
	}
	

	@PostMapping(value="/list",consumes = "application/json")
	@ResponseBody
	public List<ListVO> goo(@RequestBody ListVO vo) {
		
		
		log.info(""+vo);
		
		
//		vo.setDepositmin("5000");
//		vo.setDepositmax("8000");
//		vo.setRentmin("300");
//		vo.setRentmax("600");
//		vo.setSurfacemin("10");
//		vo.setSurfacemax("20");
//		vo.setNelat(37.51248610);
//		vo.setSwlat(37.5124868);
//		vo.setNelng(127.0285218);
//		vo.setSwlng(127.0285216);
//		vo.setFloor("1");
//		vo.setPark(false);
//		vo.setElev(true);
//		vo.setToilet(true);
		
		log.info(""+service.getConList(vo));
		
		
		
		return service.getConList(vo);
		
		
	}
	
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri ,Model model) {
		log.info("list Page.......................");
		int totalCount = service.getListCount(cri);
		log.info(""+totalCount);
		
		
		
		model.addAttribute("pm", new PageMaker(cri, totalCount));
		model.addAttribute("list", service.getList(cri));
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