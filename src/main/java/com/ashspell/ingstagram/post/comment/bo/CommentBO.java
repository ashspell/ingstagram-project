package com.ashspell.ingstagram.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.ingstagram.post.comment.dao.CommentDAO;
import com.ashspell.ingstagram.post.comment.model.Comment;

@Service
public class CommentBO {
	
	
	@Autowired
	private CommentDAO commentDAO;
	
	public int addComment(int postId, int userId, String userName, String content) {
		
		return commentDAO.insertComment(postId, userId, userName, content);
	}

	public List<Comment> getCommentList(int postId) {
		
		return commentDAO.selectCommentList(postId);
	}
	
	public int deleteCommentByPostId(int postId) {
		return commentDAO.deleteCommentByPostId(postId);
	}
}
