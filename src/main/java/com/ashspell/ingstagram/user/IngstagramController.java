package com.ashspell.ingstagram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingstagram")
public class IngstagramController {
	
	
	@GetMapping("/signin_view")
	public String signinview() {
		return "ingstagram/signin";
	}
	
	@GetMapping("/signup_view")
	public String signupview() {
		return "ingstagram/signup";
	}
	
	@GetMapping("/upload_view")
	public String uploadview() {
		return "ingstagram/upload";
	}
	
}
