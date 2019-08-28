package org.sis.user.controller;

import javax.servlet.http.HttpSession;

import org.sis.user.model.CriteriaMsg;
import org.sis.user.model.MemberVO;
import org.sis.user.model.MessageVO;
import org.sis.user.model.PageMakerMsg;
import org.sis.user.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Component
@Controller
@Log
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/msg/*")
public class MessageController {
	
	private MessageService service;
	

	
	@GetMapping("/list")
	public void listPage(@ModelAttribute("cri") CriteriaMsg cri,@ModelAttribute("vo") MessageVO vo ,Model model,HttpSession session) {		
		int totalCount = service.getListCount(cri);
		
		session.getAttribute("mmid");
		
		MemberVO member = new MemberVO();
		
		member.setMmid((String)session.getAttribute("mmid"));
		
		model.addAttribute("list", service.getList(member,cri));
		model.addAttribute("pm", new PageMakerMsg(cri, totalCount));
	}
	
	@GetMapping("/read")
	public void read(@ModelAttribute("cri") CriteriaMsg cri,Integer msgnum, Model model) {
//		log.info("msgnum: "+cri.getMsgnum());
		service.updateRead(msgnum);
		model.addAttribute("vo", service.get(msgnum));
		
		
		
	}
	

	

	@PostMapping("/register")
	public String register(MessageVO vo,RedirectAttributes rttr) {
		service.register(vo);
		rttr.addFlashAttribute("result","success");
		return "redirect:/msg/list";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("vo") MessageVO vo ,Model model) {

	
		return "/msg/register";
	}	
	
	@GetMapping("/remove")
	public String remove(@ModelAttribute("cri") CriteriaMsg cri, RedirectAttributes rttr) {
		log.info("del msgnum: "+cri.getMsgnum());
		
		service.remove(cri.getMsgnum());
		
		rttr.addFlashAttribute("result", "success");
		cri.setPage(1);
		
		return "redirect:/msg/list"+cri.getLink();
		
	}
	  
	
	
}
