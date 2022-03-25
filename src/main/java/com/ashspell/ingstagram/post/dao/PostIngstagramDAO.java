package com.ashspell.ingstagram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.ashspell.ingstagram.post.model.PostIngstagram;

@Repository
public interface PostIngstagramDAO {
	
	public PostIngstagram postUser(
			@Param("imagePath") String imagePath,
			@Param("title") String title,
			@Param("content") String content
			);
		
	public List<PostIngstagram> selectPostList(@Param("id") int id);
		
	public PostIngstagram selectPost(@Param("id") int id);

	
	
}
