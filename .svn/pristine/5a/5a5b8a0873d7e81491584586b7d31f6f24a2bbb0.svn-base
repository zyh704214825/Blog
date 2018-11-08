package com.ambow.service;

import java.util.List;

import com.ambow.javabean.Blogarticles;
import com.ambow.javabean.Classify;


public interface BlogarticlesService {
	public List<Blogarticles> getAllBlogarticles(String keyword);
	public Blogarticles getFireBlogarticle();
	public List<Blogarticles> getBlogByType(int typeId);
	public List<Blogarticles> getBlogByComm();
	public Blogarticles getBlogDetail(int blog_id);
	public int addBlog(Blogarticles blog);
	public List<Blogarticles> blogList(Blogarticles blog);
	public int getPageCnt(Blogarticles blog);
	public void deleteBlog(Blogarticles blog);
	public void deleteBlogByCls(Classify cls);
	public void updateComm(Blogarticles blog);
}
