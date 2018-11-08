package com.ambow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.dao.ClassifyMapper;
import com.ambow.javabean.Blogarticles;
import com.ambow.javabean.Classify;

@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService{
	@Autowired
	private ClassifyMapper classifyMapper;

	@Override
	public List<Classify> getAllClassify() {
		List<Classify> classifyList = (List<Classify>) classifyMapper.getAllClassify();
		return classifyList;
	}

	@Override
	public Classify getOneClassify(int cls_id) {
		return classifyMapper.getOneClassify(cls_id);
	}

	@Override
	public List<Classify> clsList(Classify cls) {
		return classifyMapper.clsList(cls);
	}
	@Override
	public int getPageCnt(Classify cls) {
		return classifyMapper.getPageCnt(cls);
	}

	@Override
	public void updateClassify(Classify cls) {
		classifyMapper.updateClassify(cls);;
	}

	@Override
	public int addClassify(Classify cls) {
		return classifyMapper.addClassify(cls);
	}

	@Override
	public void deleteClassify(Classify cls) {
		classifyMapper.deleteClassify(cls);
	}
}
