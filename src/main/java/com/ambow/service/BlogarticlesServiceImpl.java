package com.ambow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.dao.BlogarticlesMapper;
import com.ambow.javabean.Blogarticles;
import com.ambow.javabean.Classify;

@Service("blogarticlesService")
public class BlogarticlesServiceImpl implements BlogarticlesService{
	@Autowired
	private BlogarticlesMapper blogarticlesMapper;

	@Override
	public List<Blogarticles> getAllBlogarticles(String keyword) {
		return blogarticlesMapper.getAllBlogarticles(keyword);
	}

	@Override
	public Blogarticles getFireBlogarticle() {
		return blogarticlesMapper.getFireBlogarticle();
	}

	@Override
	public List<Blogarticles> getBlogByType(int typeId) {
		return blogarticlesMapper.getBlogByType(typeId);
	}

	@Override
	public List<Blogarticles> getBlogByComm() {
		return blogarticlesMapper.getBlogByComm();
	}

	@Override
	public Blogarticles getBlogDetail(int blog_id) {
		return blogarticlesMapper.getBlogDetail(blog_id);
	}

	@Override
	public int addBlog(Blogarticles blog) {
		return blogarticlesMapper.addBlog(blog);
	}

	@Override
	public List<Blogarticles> blogList(Blogarticles blog) {
		return blogarticlesMapper.blogList(blog);
	}
	
	@Override
	public int getPageCnt(Blogarticles blog) {
		return blogarticlesMapper.getPageCnt(blog);
	}

	@Override
	public void deleteBlog(Blogarticles blog) {
		blogarticlesMapper.deleteBlog(blog);
	}

	@Override
	public void deleteBlogByCls(Classify cls) {
		blogarticlesMapper.deleteBlogByCls(cls);
	}

	@Override
	public void updateComm(Blogarticles blog) {
		blogarticlesMapper.updateComm(blog);
	}
}
