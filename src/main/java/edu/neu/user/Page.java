package edu.neu.user;

import java.util.List;

public class Page<E> {
	//result set
	private List<E> list;
	private int totalRecords;
	private int pageSize;
	// page No.
	private int pageNo;
	
	public int getTotalPages(){
		return (totalRecords+pageSize-1)/pageSize;
	}
	
	//count the first record of current page
	public int countOffset(int currentPage,int pageSize){
		int offset = pageSize * (currentPage - 1);
		return offset;
	}
	
	public int getTopPageNo(){
		return 1;
	}
	
	public int getPreviousPageNo(){
		if(pageNo<=1){
			return 1;
		}
		return pageNo-1;
	}
	
	public int getBottomPageNo(){
		return getTotalPages();
	}
	
	public int getNextPageNo(){
		if(pageNo>=getBottomPageNo()){
			return getBottomPageNo();
		}
		return pageNo+1;
	}
	
	public List<E> getList(){
		return list;
	}
	
	public void setList(List<E> list){
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
