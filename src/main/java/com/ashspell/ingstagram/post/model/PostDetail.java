package com.ashspell.ingstagram.post.model;

import java.util.List;

import com.ashspell.ingstagram.post.comment.model.Comment;

public class PostDetail {
	
	private PostIngstagram post;
	private int likeCount;
	private List<Comment> commentList;
	private boolean isLike;
	
	public PostIngstagram getPost() {
		return post;
	}
	public void setPost(PostIngstagram post) {
		this.post = post;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	
	
}
