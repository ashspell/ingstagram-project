package com.ashspell.ingstagram.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ashspell.ingstagram.user.model.Ingstagram;

@Repository
public interface PostIngstagramDAO {
	
	public Ingstagram postUser(
			@Param("imagePath") String imagePath,
			@Param("title") String title,
			@Param("content") String content);
		
		
	
}
