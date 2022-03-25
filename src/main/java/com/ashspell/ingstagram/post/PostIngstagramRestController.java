package com.ashspell.ingstagram.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashspell.ingstagram.post.bo.PostIngstagramBO;

@RestController
@RequestMapping("/post")
public class PostIngstagramRestController {
		
	@Autowired
	private PostIngstagramBO postingstagramBO;
	
	
	@PostMapping("/upload")
	
	public Map<String, String> upload (
			
			@RequestParam("id") int id,
			@RequestParam("comment") String comment) {
			
			return
		}
	
	}

