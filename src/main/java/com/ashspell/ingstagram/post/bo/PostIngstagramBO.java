package com.ashspell.ingstagram.post.bo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.ingstagram.common.FileManagerService;
import com.ashspell.ingstagram.post.dao.PostIngstagramDAO;
import com.ashspell.ingstagram.post.model.PostIngstagram;


@Service
public class PostIngstagramBO {
	
	@Autowired
	private PostIngstagramDAO postingstagramDAO;
	
	public int addPost(int id, String content, String userName, MultipartFile file) {
	
		String imagePath = FileManagerService.saveFile(id, file);
		
		return postingstagramDAO.postUser(id, imagePath, userName, content);
		
	}
		
		public List<PostIngstagram> getPostList() {
			
			List<PostIngstagram> postList = postingstagramDAO.selectPostList();
			
			return postList;
		}
		
		
		
}
