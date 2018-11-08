package com.ambow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.dao.CommentMapper;
import com.ambow.javabean.Comment;
@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;
	@Override
	public int insertComment(Comment comm) {
		return commentMapper.insertComment(comm);
	}

	@Override
	public int updateComment(Comment comm) {
		return commentMapper.updateComment(comm);
	}

	@Override
	public int deleteComment(int comm_id) {
		return commentMapper.deleteComment(comm_id);
	}

	@Override
	public Comment findCommentById(int comm_id) {
		return commentMapper.findCommentById(comm_id);
	}

	@Override
	public List<Comment> findAllComment() {
		return commentMapper.findAllComment();
	}

	@Override
	public List<Comment> findCommentByBlogId(int comm_blog) {
		return commentMapper.findCommentByBlogId(comm_blog);
	}

	@Override
	public void deleteCommentByBlogId(int blog_id) {
		commentMapper.deleteCommentByBlogId(blog_id);
	}

	@Override
	public List<Comment> findCommentByPage(Comment comm) {
		comm.setPageNow((comm.pageNow-1)*comm.pageSize);
		return commentMapper.findCommentByPage(comm);
	}

	@Override
	public int findCommentByCnt(Comment comm) {
		comm.setPageNow((comm.getPageNow()-1)*comm.getPageSize());
		int cnt=commentMapper.findCommentByCnt(comm);
		if(cnt%comm.pageSize==0){
			return cnt / comm.pageSize;
		}else{
			return cnt / comm.pageSize+1;
		}
	}
	
}
