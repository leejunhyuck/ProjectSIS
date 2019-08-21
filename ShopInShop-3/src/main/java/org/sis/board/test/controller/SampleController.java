package org.sis.board.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log
public class SampleController {

	
	@GetMapping("/view")
	public void view() {

		log.info("page .... ");
	}
}
