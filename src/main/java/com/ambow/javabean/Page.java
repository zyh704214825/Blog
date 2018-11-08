package com.ambow.javabean;

public class Page {
	public Integer pageNow = 1;
	public Integer pageSize = 5;
	public String searchCon = "";
	public Integer pageCnt=1;
	public Integer beginRec=0;
	public Integer getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(Integer pageCnt) {
		this.pageCnt = pageCnt;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSearchCon() {
		return searchCon;
	}
	public void setSearchCon(String searchCon) {
		this.searchCon = searchCon;
	}
	public Integer getBeginRec() {
		return beginRec;
	}
	public void setBeginRec(Integer beginRec) {
		this.beginRec = beginRec;
	}
	public Page() {
		super();
	}

}
