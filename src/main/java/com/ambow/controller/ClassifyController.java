package com.ambow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambow.javabean.Classify;
import com.ambow.service.BlogarticlesService;
import com.ambow.service.ClassifyService;

//@RestController
@Controller
public class ClassifyController {
	@Autowired
	private ClassifyService classifyService;
	@Autowired
	private BlogarticlesService blogarticlesService;
	//删除分类
	@RequestMapping("deleteClassify")
	public String deleteClassify(Classify cls){
		blogarticlesService.deleteBlogByCls(cls);
		classifyService.deleteClassify(cls);
		return "redirect:typeList";
	}
	
	//新增分类入口
	@RequestMapping("addBy")
	public String addBy(){
		return "demo/addClassify";
	}
	
	//新增分类
	@RequestMapping("/addClassify")
	public String addClassify(Classify cls){
		classifyService.addClassify(cls);
		return "redirect:typeList";
	}
	
	//修改分类信息
	@RequestMapping("/updateClassify")
	public String updateClassify(Classify cls){
		System.out.println("updateClassify"+cls.toString());
		classifyService.updateClassify(cls);
		return "redirect:typeList";
	}
	
	//遍历所有分类
	@RequestMapping("/getAllClassify")
	@ResponseBody
	public List<Classify> getAllClassify(){
		List<Classify> classifyList = classifyService.getAllClassify();
		return classifyList;
	}
	
	//根据id获取一个分类的详细信息
	@RequestMapping("/getOneClassify")
	public String getOneClassify(int cls_id,Model model){
		Classify cls = classifyService.getOneClassify(cls_id);
		model.addAttribute("cls", cls);
		return "demo/classifyDetail";
	}
	
	//后台分类分页
	@RequestMapping("/typeListPage")
	@ResponseBody
	public List<Classify> typeListPage(Classify cls,Model model){
		getPageCnt(cls);
		List<Classify> clsList = classifyService.clsList(cls);
		for(Classify c:clsList){
			c.setPageCnt(cls.getPageCnt());
			c.setPageNow(cls.getPageNow());
			c.setSearchCon(cls.getSearchCon());
		}
		model.addAttribute("pageNow",cls.getPageNow());
		model.addAttribute("pageCnt",cls.getPageCnt());
		model.addAttribute("searchCon",cls.getSearchCon());
		model.addAttribute("clsList",clsList);
		return clsList;
	}
	
	//后台遍历分类
	@RequestMapping("/typeList")
	public String blogList(Classify cls,Model model){
		cls = getPageCnt(cls);
		List<Classify> clsList = classifyService.clsList(cls);
		for(Classify c:clsList){
			c.setPageCnt(cls.getPageCnt());
			c.setPageNow(cls.getPageNow());
			c.setSearchCon(cls.getSearchCon());
		}
		model.addAttribute("pageNow",cls.getPageNow());
		model.addAttribute("pageCnt",cls.getPageCnt());
		model.addAttribute("searchCon",cls.getSearchCon());
		model.addAttribute("clsList",clsList);
		return "demo/clssifyList";
	}
	
	//获取符合查询条件的记录条数
	public Classify getPageCnt(Classify cls){
		int pageCnt = classifyService.getPageCnt(cls); 
		if (pageCnt % cls.getPageSize() == 0)
			pageCnt = pageCnt / cls.getPageSize();
		else
			pageCnt = pageCnt / cls.getPageSize() + 1;
		cls.setPageCnt(pageCnt);
		cls.setBeginRec((cls.getPageNow()-1)*(cls.getPageSize()));
		return cls;
	}
	
	
}
