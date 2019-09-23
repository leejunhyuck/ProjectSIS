package org.sis.user.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.sis.user.model.MemberVO;
import org.sis.user.oauth.KakaoApi;
import org.sis.user.oauth.NaverLoginBO;
import org.sis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;

import lombok.Setter;
import lombok.extern.java.Log;



@Controller
@RequestMapping("user/*")
@Log
public class UserController {

	@Setter(onMethod_=@Autowired )
	private UserService service;
	
	@Setter(onMethod_=@Autowired )
	private KakaoApi kakao;

	@Setter(onMethod_=@Autowired )
	private NaverLoginBO naverLoginBO;
	
	private String apiResult = null;
	
	//@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public void login(Model model, HttpSession session) {
		
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		log.info("네이버:" + naverAuthUrl);
		// 네이버
		model.addAttribute("url", naverAuthUrl);
		
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("member") MemberVO member, Model model,HttpSession session) {
		
		log.info("MEMBER: " + member);
		
		MemberVO resultVO = new MemberVO();
		
		resultVO = service.loginCheck(member);
          
		session.setAttribute("mname", resultVO.getMname());
		
		session.setAttribute("mmid", resultVO.getMmid());
		
        
		
		return "redirect:/";
            
       
		
	}
	
	
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public void callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		log.info("callback....");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"shinn0608@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		// response의 nickname값 파싱
		String nickname = (String) response_obj.get("nickname");
		log.info(nickname);
		// 4.파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId", nickname); // 세션 생성
		model.addAttribute("result", apiResult);
		
	}
	
	@PostMapping(value="/duplicateCheck",produces="application/json; charset=UTF-8")
	@ResponseBody
	public int duplicateCheck(@RequestParam("userid") String userid) {
		
		log.info("check..");
		
		int dupCnt = 0;
		
		try {
			dupCnt = service.getDupCheckCnt(userid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dupCnt;
		
		
		

	}
	
	
	@GetMapping("/join")
	public void join(){
		
		log.info("join");
		
	}
	
	@PostMapping("/join")
	  public String joinPost(@ModelAttribute("member") MemberVO member) {

		
		
	    log.info("MEMBER: " + member);

	    
	    try {
			service.register(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	 
	    
	    return "/user/joinResult";
	  }
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		
		return "redirect:/";
		
		
	}
	
	@GetMapping("/mypage")
	public void mypage(HttpSession session,Model model) {

		log.info("mypage...");
		
	
		
		model.addAttribute("user", service.userInfo((String)session.getAttribute("mmid")));
		
		
	}
	
	@GetMapping("/recent")
	public void recent(HttpSession session,Model model,@CookieValue(value="productItems", required=false ) Cookie genderCookie) {			

		log.info("recent...");
		
		if(genderCookie != null) {
			String a =genderCookie.getValue();
			log.info(a);
			
			String[] words = a.split("%2C");
		

			for (String string : words) {
			
			log.info(string);
			}
			
		}
		
		
		
		
	
		
		
	}
	
	@PostMapping("/socket")
	public void socket1() {

		log.info("socket");
		
		 try{


             // 1. 서버의 IP와 서버의 동작 포트 값(10001)을 인자로 넣어 socket 생성

             Socket sock = new Socket("192.168.41.64", 9000);

             String msg = "123";
            

             // 2. 생성된 Socket으로부터 InputStream과 OutputStream을 구함

             OutputStream out = sock.getOutputStream();
             
             out.write(msg.getBytes());
             
             out.flush();
             
             
             
             InputStream in = sock.getInputStream();
             
             byte[] arr = new byte[1024];

             int count = in.read(arr);
             
             System.out.println(new String(arr));
             
             System.out.println(count);
                          
             in.close();

             out.close();
             
             sock.close();

      }catch(Exception e){

             System.out.println(e);
             e.printStackTrace();

      }

}
		
	
	
	
	@GetMapping("/socket")
	public void socket() {

		log.info("socket page");
		
		
	
		
	
		
		
	}
	
	
	@PostMapping("/infoModify")
	public String infoModify(@ModelAttribute("member") MemberVO member,RedirectAttributes rttr) {

		log.info("infoModify...");
		
		log.info(""+member);
		
		
		String result = service.userModify(member) == true ? "success":"fail";
		
		rttr.addFlashAttribute("result",result);
		
		
		return "redirect:/user/mypage";
		
	}

	@RequestMapping(value = "/oauth")
	public String login(@RequestParam("code") String code, HttpSession session) {
		log.info("로그인 할때 임시 코드값");
		log.info(code);
		log.info("로그인 후 결과값");

		JsonNode node = kakao.getAccessToken(code);
		log.info(""+node);

		String token = node.get("access_token").toString();

		session.setAttribute("token", token);

		return "/user/joinResult";
	}
	
	
}
