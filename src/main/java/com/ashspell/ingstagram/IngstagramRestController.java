package com.ashspell.ingstagram;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashspell.ingstagram.bo.IngstagramBO;

@RestController
@RequestMapping("/ingstagram")
public class IngstagramRestController {

	
	@Autowired
	private IngstagramBO ingstagramBO;
	
	@PostMapping("/sign_up")
	
	public Map<String, String> signup (
			
			@RequestParam("loginid") String loginid,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("name") String name) {
		
		int count = ingstagramBO.addUser(loginid, password, email, name);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	
	
}
