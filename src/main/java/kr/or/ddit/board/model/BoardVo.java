package kr.or.ddit.board.model;

public class BoardVo {
	private int b_no;
	private String b_nm;
	private int b_act;
	
	public BoardVo() {}
	
	public BoardVo(int b_no, String b_nm, int b_act) {
		this.b_no = b_no;
		this.b_nm = b_nm;
		this.b_act = b_act;
	}
	
	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_nm() {
		return b_nm;
	}
	public void setB_nm(String b_nm) {
		this.b_nm = b_nm;
	}
	public int getB_act() {
		return b_act;
	}
	public void setB_act(int b_act) {
		this.b_act = b_act;
	}

	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", b_nm=" + b_nm + ", b_act=" + b_act + "]";
	}

	
	
}
