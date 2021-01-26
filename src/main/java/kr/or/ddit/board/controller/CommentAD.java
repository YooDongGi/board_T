package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/commentAD")
public class CommentAD extends HttpServlet{

	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p_no = Integer.parseInt(req.getParameter("p_no"));
		int c_no = Integer.parseInt(req.getParameter("c_no"));
		
		int cnt = 0;
		try {
			cnt = boardService.commentDelete(c_no);
		} catch (Exception e) {
			cnt = 0;
		}
		resp.sendRedirect(req.getContextPath()+ "/boardView?p_no="+p_no);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		int p_no = Integer.parseInt(req.getParameter("p_no"));
		String c_con = req.getParameter("c_con");
		Date c_date = new Date();
		
		CommentVo comment = new CommentVo(userid, p_no, c_con, c_date);
		
		int cnt = 0;
		try {
			cnt = boardService.commentRegist(comment);
		} catch (Exception e) {
			cnt = 0;
		}
		
		resp.sendRedirect(req.getContextPath()+ "/boardView?p_no="+p_no); 
		
		
		
	}
}
