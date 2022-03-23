package com.ashspell.ingstagram.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.ingstagram.dao.PostIngstagramDAO;

@Service
public class PostIngstagramBO {
	
	@Autowired
	private PostIngstagramDAO postingstagramDAO;
	
	
	
}
