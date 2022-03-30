package com.ashspell.ingstagram.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashspell.ingstagram.post.bo.PostIngstagramBO;
import com.ashspell.ingstagram.post.model.PostIngstagram;

@Controller
@RequestMapping("/ingstagram")
public class PostIngstagramController {
	
	@Autowired
	private PostIngstagramBO postingstagramBO;
	
	
	
	
	@GetMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
		List<PostIngstagram> postList = postingstagramBO.getPostList(userId);
		
		model.addAttribute("postList", postList);
		
		return "ingstagram/list";
	}
	
	
	@GetMapping("/sign_out")
	
	public String signout(HttpServletRequest request) {
			
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userID");
		session.removeAttribute("userLoginID");
		session.removeAttribute("userName");
		
		return "redirect:/user/signin_view";
		
		
		}
	}
	
	
	

 