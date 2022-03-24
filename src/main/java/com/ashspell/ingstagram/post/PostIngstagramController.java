package com.ashspell.ingstagram.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingstagram")
public class PostIngstagramController {
	
	@GetMapping("/upload")
	public String upload() {
		return "ingstagram/upload";
	}
	
	@GetMapping("/list")
	public String list() {
		return "ingstagram/list";
	}
	
	@GetMapping("/sign_out")
	
	public String signout(HttpServletRequest request) {
			
			//로그아웃
			// 세션에 저장한 사용자 정보 지우기
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userID");
		session.removeAttribute("userLoginID");
		session.removeAttribute("userName");
		
		return "redirect:/user/signin_view";
		
		}
	}
	
	
	

 