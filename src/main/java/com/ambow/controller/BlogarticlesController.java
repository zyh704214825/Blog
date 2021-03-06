package com.ambow.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambow.javabean.Blogarticles;
import com.ambow.javabean.Users;
import com.ambow.service.BlogarticlesService;
import com.ambow.service.CommentService;

@Controller
public class BlogarticlesController {
	@Autowired
	private BlogarticlesService blogarticlesService;
	@Autowired
	private CommentService commentService;
	
	//前台查询所有博客 首页
	@RequestMapping("/getAllBlogarticles")
	@ResponseBody
	public List<Blogarticles> getAllBlogarticles(String keyword){
		//System.out.println("111111"+keyword);
		//System.out.println("getAllBlogarticles....");
		List<Blogarticles> blogList = blogarticlesService.getAllBlogarticles(keyword);
		for(int i=0;i<blogList.size();i++){
			if(blogList.get(i).getBlog_remark().length()>92){
				String ss = blogList.get(i).getBlog_remark();
				blogList.get(i).setBlog_remark(ss.substring(0, 92)+"...");
			}
			//System.out.println(blogList.get(i).toString());
		}
		return blogList;	
	}
	
	//前台推荐博客
	@RequestMapping("/getFireBlogarticle")
	@ResponseBody
	public Blogarticles getFireBlogarticle(){
		Blogarticles blogarticles = blogarticlesService.getFireBlogarticle();
			if(blogarticles.getBlog_remark().length()>132){
				String ss = blogarticles.getBlog_remark();
				blogarticles.setBlog_remark(ss.substring(0, 132)+"...");
			}
		return blogarticles;
	}
	
	//前台根据类型查看博客
	@RequestMapping("/getBlogByType")
	@ResponseBody
	public List<Blogarticles> getBlogByType(int typeId) {
		//System.out.println(typeId);
		List<Blogarticles> blogListByType = blogarticlesService.getBlogByType(typeId);
		for(int i=0;i<blogListByType.size();i++){
			if(blogListByType.get(i).getBlog_remark().length()>92){
				String ss = blogListByType.get(i).getBlog_remark();
				blogListByType.get(i).setBlog_remark(ss.substring(0, 92)+"...");
			}
		}
		return blogListByType;
	}
	
	//前台首根据评论热度遍历博客
	@RequestMapping("/getBlogByComm")
	@ResponseBody
	public List<Blogarticles> getBlogByComm() {
		List<Blogarticles> blogListByComm = blogarticlesService.getBlogByComm();
		for(int i=0;i<blogListByComm.size();i++){
			if(blogListByComm.get(i).getBlog_remark().length()>92){
				String ss = blogListByComm.get(i).getBlog_remark();
				blogListByComm.get(i).setBlog_remark(ss.substring(0, 92)+"...");
			}
		}
		return blogListByComm;
	}

	//前台根据id查看博文详情
	@RequestMapping("/getBlogDetail")
	public String getBlogDetail(int blog_id,Model model){
		Blogarticles blog = blogarticlesService.getBlogDetail(blog_id);
		model.addAttribute("blog", blog);
		return "show";
		
	}
	
	//后台根据id查看博文详情
	@RequestMapping("/getBlogDetailByAdmin")
	public String getBlogDetailByAdmin(int blog_id,Model model){
		Blogarticles blog = blogarticlesService.getBlogDetail(blog_id);
		model.addAttribute("blog", blog);
		return "demo/blogDetail";
		
	}
	
	//前台根据类型查看博客,当前博客除外
	@RequestMapping("/getBlogByTypeBesideThis")
	@ResponseBody
	public List<Blogarticles> getBlogByTypeBesideThis(int typeId,int blogId) {
		System.out.println(typeId+blogId);
		List<Blogarticles> blogListByTypeBT = blogarticlesService.getBlogByType(typeId);
		for(int i=0;i<blogListByTypeBT.size();i++){
			if(blogListByTypeBT.get(i).getBlog_id()==blogId||i>=10){
				blogListByTypeBT.remove(i);
			}
		}
		return blogListByTypeBT;
	}
	
	//写博文入口
	@RequestMapping("/writeBlog")
	public String writeBlog(HttpServletRequest req,Model model){
		Users user = (Users) req.getSession().getAttribute("loginUsers");
		if(user==null){
			//model.addAttribute("loginMsg", "登录后才能写文章！");
			return "login-1";
		}else{
			model.addAttribute("user", user);
			System.out.println(user.toString());
			return "writeBlog";
		}
	}
	
	//提交博文
	@RequestMapping("/submitBlog")
	public String submitBlog(@ModelAttribute Blogarticles blog,HttpServletRequest req){
		System.out.println(blog.toString());
		Users user = (Users) req.getSession().getAttribute("loginUsers");
		blog.setBlog_users(user);
		blog.setBlog_date(new Date());
		blog.setComm_count(0);
		blogarticlesService.addBlog(blog);
		return "index";
	}
	
	//后台博文分页
	@RequestMapping("/blogListPage")
	@ResponseBody
	public List<Blogarticles> blogListPage(Blogarticles blog,Model model){
		getPageCnt(blog);
		//System.out.println(blog.getPageNow()+"  "+blog.getPageCnt()+"   "+blog.getPageSize()+"  "+blog.getBeginRec());
		//System.out.println(blog.getSearchCon());
		List<Blogarticles> blogList = blogarticlesService.blogList(blog);
		for(Blogarticles b:blogList){
			b.setPageCnt(blog.getPageCnt());
			b.setPageNow(blog.getPageNow());
			b.setSearchCon(blog.getSearchCon());
		}
		model.addAttribute("pageNow",blog.getPageNow());
		model.addAttribute("pageCnt",blog.getPageCnt());
		model.addAttribute("searchCon",blog.getSearchCon());
		model.addAttribute("blogList",blogList);
		return blogList;
	}
	
	//后台遍历博文
	@RequestMapping("/blogList")
	public String blogList(Blogarticles blog,Model model){
		blog = getPageCnt(blog);
		//System.out.println("asdfa"+blog.getSearchCon());
		List<Blogarticles> blogList = blogarticlesService.blogList(blog);
		for(Blogarticles b:blogList){
			b.setPageCnt(blog.getPageCnt());
			b.setPageNow(blog.getPageNow());
			b.setSearchCon(blog.getSearchCon());
		}
		model.addAttribute("pageNow",blog.getPageNow());
		model.addAttribute("pageCnt",blog.getPageCnt());
		model.addAttribute("searchCon",blog.getSearchCon());
		model.addAttribute("blogList",blogList);
		return "demo/blogList";
	}
	
	//根据文章id删除文章
	@RequestMapping("/deleteBlog")
	public String deleteBlog(Blogarticles blog){
		commentService.deleteCommentByBlogId(blog.getBlog_id());
		blogarticlesService.deleteBlog(blog);
		return "redirect:blogList";
	}
	
	//获取符合查询条件的记录条数
	public Blogarticles getPageCnt(Blogarticles blog){
		int pageCnt = blogarticlesService.getPageCnt(blog); 
		//System.out.println(pageCnt);
		if (pageCnt % blog.getPageSize() == 0)
			pageCnt = pageCnt / blog.getPageSize();
		else
			pageCnt = pageCnt / blog.getPageSize() + 1;
		blog.setPageCnt(pageCnt);
		blog.setBeginRec((blog.getPageNow()-1)*(blog.getPageSize()));
		return blog;
	}
	
	//提交form表单用数据
	@ModelAttribute("blog")
	public Blogarticles getBlog(Blogarticles blog){
		return blog;
	}
	
	
}
