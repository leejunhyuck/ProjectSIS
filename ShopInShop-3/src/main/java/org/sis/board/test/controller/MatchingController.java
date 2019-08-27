package org.sis.board.test.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.sis.board.test.model.MatchingAttachVO;
import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.MatchingVO;
import org.sis.board.test.model.PageMaker;
import org.sis.board.test.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/matching/*")
@Log
@AllArgsConstructor
@CrossOrigin
public class MatchingController {

	private MatchingService service;

	@GetMapping("/list")
	public void listPage(@ModelAttribute("cri") Criteria cri ,Model model) {
		log.info("list Page.......................");
		int totalCount = service.getListCount(cri);
		
		
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pm", new PageMaker(cri, totalCount));
	}
	
	@GetMapping("/register")
	public void registerPage() {
		log.info("Get Resiger Page................");
	}
	
	@PostMapping("/register")
	public String postRegiste(@ModelAttribute MatchingVO vo,RedirectAttributes rttr) {
		log.info("Register vo: "+vo);
		
		service.register(vo);
		rttr.addFlashAttribute("reuslt","success");
		
		return "redirect:/matching/list";
	}
	
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("bno: "+cri.getBno());
		
		
		
		model.addAttribute("vo", service.get(cri.getBno()));
		
		
	}
	
	@PostMapping("/modify")
	public String modify(MatchingVO vo,@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("수정: "+vo);
		service.modify(vo);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/matching/list"+cri.getLink();
	}
	
	@PostMapping("/remove")
	public String remove(@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("del bno: "+cri.getBno());
		
		List<MatchingAttachVO> attachList = service.getAttachList(cri.getBno());
		
		if(service.remove(cri.getBno()) == 1) {
			
			deleteFiles(attachList);
		}
		
		
		rttr.addFlashAttribute("result", "success");
		cri.setPage(1);
		
		return "redirect:/matching/list"+cri.getLink();
		
	}
	
	
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<MatchingAttachVO>> getAttachList(Integer bno){
		log.info("getAttach: "+bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	
	private void deleteFiles(List<MatchingAttachVO> attachList) {
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		log.info("delete attach files ...." + attachList);
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get("C:\\upload\\matching\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName());
				Files.deleteIfExists(file);
				
				//Path thumbNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_"+attach.getUuid()+"_"+attach.getFileName());
				//Files.deleteIfExists(thumbNail);
			}catch(Exception e){
				log.info("delete file error"+ e.getMessage());
			}// end catch .. 
		}); // end for each
	}
	
	
	


}
