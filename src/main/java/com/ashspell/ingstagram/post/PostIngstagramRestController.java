package com.ashspell.ingstagram.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.ingstagram.post.bo.PostIngstagramBO;
import com.ashspell.ingstagram.post.model.PostIngstagram;

@RestController
@RequestMapping("/ingstagram/post")
public class PostIngstagramRestController {
		
	@Autowired
	private PostIngstagramBO postingstagramBO;
	
	
	@PostMapping("/upload")
	
	public Map<String, String> upload (
			
		
			@RequestParam("file") MultipartFile file,
			@RequestParam("content") String content,
			HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			int id = (Integer)session.getAttribute("id");
			String userName = (String)session.getAttribute("userName");
			
			Map<String, String> result = new HashMap<>();
			
			int count = postingstagramBO.addPost(id, content, userName, file);
			
			if(count == 1) {
				result.put("result", "success");
			} else {
				result.put("result", "fail");
			}
					return result;
		}
	
	}

