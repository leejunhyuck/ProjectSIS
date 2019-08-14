package org.sis.board.controller;

import org.sis.board.model.BoardVO;
import org.sis.board.model.Criteria;
import org.sis.board.model.PageMaker;
import org.sis.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/board/*")
@Log
@AllArgsConstructor
@CrossOrigin
public class BoardController {

	private BoardService service;

	@GetMapping("/list")
	public void listPage(@ModelAttribute("cri") Criteria cri ,Model model) {		
		int totalCount = service.getListCount(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pm", new PageMaker(cri, totalCount));
	}
	
	@GetMapping("/register")
	public void registerPage() {
		log.info("Get Resiger Page................");
	}
	@PostMapping("/register")
	public String postRegiste(@ModelAttribute BoardVO vo,RedirectAttributes rttr) {
		log.info("Register vo: "+vo);
		
		service.register(vo);
		rttr.addFlashAttribute("reuslt","success");
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("bno: "+cri.getBno());
		
		model.addAttribute("vo", service.get(cri.getBno()));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo,@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("수정: "+vo);
		service.modify(vo);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/board/list"+cri.getLink();
	}
	
	@PostMapping("/remove")
	public String remove(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("del bno: "+cri.getBno());
		service.remove(cri.getBno());
		
		rttr.addFlashAttribute("result", "success");
		cri.setPage(1);
		
		return "redirect:/board/list"+cri.getLink();
	}
	
	
	

	@RequestMapping("/login")
	public void login() {

		log.info("" + "hello");

	}

}
