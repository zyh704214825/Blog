package com.ambow.service;

import java.util.List;

import com.ambow.javabean.Comment;

public interface CommentService {
	public int insertComment(Comment comm);
	public int updateComment(Comment comm);
	public int deleteComment(int comm_id);
	public void deleteCommentByBlogId(int blog_id);
	public Comment findCommentById(int comm_id);
	public List<Comment> findCommentByBlogId(int comm_blog);
	public List<Comment> findCommentByPage(Comment comm);
	public int findCommentByCnt(Comment comm);
	public List<Comment> findAllComment();
}
