package com.ashspell.ingstagram.post.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.ashspell.ingstagram.post.model.PostIngstagram;

@Repository
public interface PostIngstagramDAO {
	
	public int postUser(
			@Param("id") int id,
			@Param("filePath") String filePath,
			@Param("userName") String userName,
			@Param("content") String content
			);
		
	public List<PostIngstagram> selectPostList();
		
	public int deletePost(
			@Param("postId") int postId);
	
	public PostIngstagram selectPost(@Param("postId") int postId);

	
	
}
