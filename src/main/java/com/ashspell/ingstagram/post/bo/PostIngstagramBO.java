package com.ashspell.ingstagram.post.bo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.ingstagram.common.FileManagerService;
import com.ashspell.ingstagram.post.dao.PostIngstagramDAO;
import com.ashspell.ingstagram.user.model.Ingstagram;

@Service
public class PostIngstagramBO {
	
	@Autowired
	private PostIngstagramDAO postingstagramDAO;
	
	public Ingstagram  addPost(int id, String title, String content, MultipartFile file) {
	
		String imagePath = FileManagerService.saveFile(id, file);
		
		return postingstagramDAO.postUser(imagePath, title, content);
		
		
		
		
			
				
	}
}
