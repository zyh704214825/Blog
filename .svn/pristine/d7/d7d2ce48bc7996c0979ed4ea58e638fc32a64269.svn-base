package com.ambow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ambow.javabean.Comment;

public interface CommentMapper {
	int insertComment(Comment comm);
	int updateComment(Comment comm);
	int deleteComment(int comm_id);
	void deleteCommentByBlogId(int blog_id);
	Comment findCommentById(int comm_id);
	List<Comment> findCommentByBlogId(int comm_blog);
	List<Comment> findCommentByPage(@Param("comm")Comment comm);
	int findCommentByCnt(@Param("comm")Comment comm);
	List<Comment> findAllComment();
}
