package kr.or.ddit.board.model;

import java.util.Date;

public class PostVo {
	private int p_no;
	private String userid;
	private int b_no;
	private String title;
	private String content;
	private Date p_date;
	private int p_act;
	private int parent_no;
	private int gno;
	private int views;
	
	public PostVo() {}
	
	public PostVo(int p_no, String userid, int b_no, String title, String content,
				Date p_date, int p_act, int parent_no, int gno, int views) {
		this.p_no = p_no;
		this.userid = userid;
		this.b_no = b_no;
		this.title = title;
		this.content = content;
		this.p_date = p_date;
		this.p_act = p_act;
		this.parent_no = parent_no;
		this.gno = gno;
		this.views = views;
	}
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public int getP_act() {
		return p_act;
	}
	public void setP_act(int p_act) {
		this.p_act = p_act;
	}
	public int getParent_no() {
		return parent_no;
	}
	public void setParent_no(int parent_no) {
		this.parent_no = parent_no;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "PostVo [p_no=" + p_no + ", userid=" + userid + ", b_no=" + b_no + ", title=" + title + ", content="
				+ content + ", p_date=" + p_date + ", p_act=" + p_act + ", parent_no=" + parent_no + ", gno=" + gno
				+ ", views=" + views + "]";
	}
	
	
}
