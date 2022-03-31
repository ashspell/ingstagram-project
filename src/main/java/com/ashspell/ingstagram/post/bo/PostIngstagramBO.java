package com.ashspell.ingstagram.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.ingstagram.common.FileManagerService;
import com.ashspell.ingstagram.post.comment.bo.CommentBO;
import com.ashspell.ingstagram.post.comment.model.Comment;
import com.ashspell.ingstagram.post.dao.PostIngstagramDAO;
import com.ashspell.ingstagram.post.like.bo.LikeBO;
import com.ashspell.ingstagram.post.model.PostDetail;
import com.ashspell.ingstagram.post.model.PostIngstagram;


@Service
public class PostIngstagramBO {
	
	@Autowired
	private PostIngstagramDAO postingstagramDAO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private CommentBO commentBO;
	
	public int addPost(int id, String content, String userName, MultipartFile file) {
	
		String imagePath = FileManagerService.saveFile(id, file);
		
		return postingstagramDAO.postUser(id, imagePath, userName, content);
		
	}
		
	
	
		
		public List<PostDetail> getPostList(int userId) {
			List<PostIngstagram> postList = postingstagramDAO.selectPostList();
			
			List<PostDetail> postDetailList = new ArrayList<>();
			
			// 포스트마다 댓글 좋아요 가져오기
			for(PostIngstagram post : postList) {
				// 좋아요 개수 얻어오기 postId
				int likeCount = likeBO.getLikeCount(post.getId());
				
				//댓글 리스트 가져오기
				List<Comment> commentList = commentBO.getCommentList(post.getId());
				
				//로그인한 사용자가 좋아요를 눌렀는지 여부
				boolean isLike = likeBO.isLike(post.getId(), userId);
				
				PostDetail postDetail = new PostDetail();
				
				
				postDetail.setPost(post);
				postDetail.setLikeCount(likeCount);
				postDetail.setCommentList(commentList);
				postDetail.setLike(isLike);
				
				postDetailList.add(postDetail);
				
			}
			
			return postDetailList;
		}
		
		public int deletePost(int postId, int userId) {
			
			Post post = this.getPosts(userId);
		}
		
		
}
