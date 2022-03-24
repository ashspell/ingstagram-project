package com.ashspell.ingstagram.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashspell.ingstagram.post.bo.PostIngstagramBO;

@RestController
@RequestMapping("/post")
public class PostIngstagramRestController {
		
	@Autowired
	private PostIngstagramBO postingstagramBO;
	
	
	
}
