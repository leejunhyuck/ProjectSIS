package org.sis.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.sis.mapper.ReplyMapper;
import org.sis.user.model.MemberVO;
import org.sis.user.oauth.KakaoApi;
import org.sis.user.oauth.NaverLoginBO;
import org.sis.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;



@Controller
@RequestMapping("store/*")
@Log
public class StroreController {

	
	
	@GetMapping("/google")
	public void google() {
		
		log.info("list");
		
		
	}
	
	

	
}
