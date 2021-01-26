package kr.or.ddit.board.model;

import java.util.Date;

public class CommentVo {
	private int c_no;
	private String userid;
	private int p_no;
	private String c_con;
	private Date c_date;
	private int c_act;
	
	public CommentVo() {}
	
	public CommentVo(int c_no, String userid, int p_no, String c_con, Date c_date, int c_act) {
		this.c_no = c_no;
		this.userid = userid;
		this.p_no = p_no;
		this.c_con = c_con;
		this.c_date = c_date;
		this.c_act = c_act;
	}

	public CommentVo(String userid, int p_no, String c_con, Date c_date) {
		this.userid = userid;
		this.p_no = p_no;
		this.c_con = c_con;
		this.c_date = c_date;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getC_con() {
		return c_con;
	}
	public void setC_con(String c_con) {
		this.c_con = c_con;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public int getC_act() {
		return c_act;
	}
	public void setC_act(int c_act) {
		this.c_act = c_act;
	}
	@Override
	public String toString() {
		return "CommentVo [c_no=" + c_no + ", userid=" + userid + ", p_no=" + p_no + ", c_con=" + c_con + ", c_date="
				+ c_date + ", c_act=" + c_act + "]";
	}
	
	
	
}
