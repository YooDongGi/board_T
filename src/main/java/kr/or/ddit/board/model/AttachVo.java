package kr.or.ddit.board.model;

public class AttachVo {
	private int a_no;
	private String a_nm;
	private String a_route;
	private int p_no;
	
	public AttachVo() {}
	
	public AttachVo(int a_no, String a_nm, String a_route, int p_no) {
		this.a_no = a_no;
		this.a_nm = a_nm;
		this.a_route = a_route;
		this.p_no = p_no;
	}
	
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_nm() {
		return a_nm;
	}
	public void setA_nm(String a_nm) {
		this.a_nm = a_nm;
	}
	public String getA_route() {
		return a_route;
	}
	public void setA_route(String a_route) {
		this.a_route = a_route;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	@Override
	public String toString() {
		return "AttachVo [a_no=" + a_no + ", a_nm=" + a_nm + ", a_route=" + a_route + ", p_no=" + p_no + "]";
	}
	
	
}
