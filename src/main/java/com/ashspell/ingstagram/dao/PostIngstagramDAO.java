package com.ashspell.ingstagram.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ashspell.ingstagram.model.Ingstagram;

@Repository
public interface PostIngstagramDAO {
	
	public Ingstagram postUser(
			@Param("imagePath") String imagePath,
			@Param("title") String title,
			@Param("content") String content) {
		
		
	}
}
