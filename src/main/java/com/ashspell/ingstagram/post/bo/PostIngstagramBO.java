package com.ashspell.ingstagram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.ingstagram.common.FileManagerService;
import com.ashspell.ingstagram.post.dao.PostIngstagramDAO;
import com.ashspell.ingstagram.post.model.PostIngstagram;
import com.ashspell.ingstagram.user.model.Ingstagram;

@Service
public class PostIngstagramBO {
	
	@Autowired
	private PostIngstagramDAO postingstagramDAO;
	
	public PostIngstagram  addPost(int id, String title, String content, MultipartFile file) {
	
		String imagePath = FileManagerService.saveFile(id, file);
		
		return postingstagramDAO.postUser(imagePath, title, content);
		
	
		
		public List <PostIngstagram> getPostList() {
			
			List<PostIngstagram> postList = postingstagramDAO.selectPostList();
			
			// 포스트 마다 댓글 좋아요 가져오기
			
			// 그 정보를 하나의 새로운 데이터 클래스(DTO)를 만들어서 구성
			
			// 새로운 클래스(DTO)를 리스트 형태로 구성
			
			return 
		}
			
				
	}
}
