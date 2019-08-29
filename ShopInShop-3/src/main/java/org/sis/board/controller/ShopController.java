package org.sis.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/shop/*")
@Log
public class ShopController {
	
	@GetMapping("/google")
	public void google() {
	}
	
	@GetMapping("/list")
	public void list() {
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
	public void registerPost() {
	}
	
	@PutMapping("/modify")
	public void modify() {
	}
	
	@DeleteMapping("remove")
	public void remove() {
	}
}