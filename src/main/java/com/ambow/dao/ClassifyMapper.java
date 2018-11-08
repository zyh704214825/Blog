package com.ambow.dao;

import java.util.List;
import com.ambow.javabean.Classify;

public interface ClassifyMapper {
    public List<Classify> getAllClassify();
    public Classify getOneClassify(int cls_id);
    public List<Classify> clsList(Classify cls);
    public int getPageCnt(Classify cls);
    public void updateClassify(Classify cls);
    public int addClassify(Classify cls);
    public void deleteClassify(Classify cls);
}
