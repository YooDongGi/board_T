package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardDelete")
public class BoardDelete extends HttpServlet{
	
	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_no = Integer.parseInt(req.getParameter("p_no"));
		int b_no = Integer.parseInt(req.getParameter("b_no"));
		
		int cnt = 0;
		try {
			cnt = boardService.postDelete(p_no);
		} catch (Exception e) {
			cnt = 0;
		}
		
		if(cnt != 0) {
			resp.sendRedirect(req.getContextPath()+"/boardList?boardno="+b_no);
		} else {
			resp.sendRedirect(req.getContextPath()+"/boardView?p_no="+p_no);
		}
		
		
		
	}
}
