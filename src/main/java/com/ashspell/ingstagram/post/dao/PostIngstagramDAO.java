package com.ashspell.ingstagram.post.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.ashspell.ingstagram.post.model.PostIngstagram;

@Repository
public interface PostIngstagramDAO {
	
	public int postUser(
			@Param("id") int id,
			@Param("imagePath") String imagePath,
			@Param("userName") String userName,
			@Param("content") String content
			);
		
	public List<PostIngstagram> selectPostList();
		


	
	
}
