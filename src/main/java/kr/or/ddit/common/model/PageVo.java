package kr.or.ddit.common.model;

public class PageVo {
	private int page;
	private int pageSize;
	private int b_no;
	
	public PageVo() {}
	
	public PageVo(int page, int pageSize, int b_no) {
		this.page = page;
		this.pageSize = pageSize;
		this.b_no = b_no;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	
	
}
