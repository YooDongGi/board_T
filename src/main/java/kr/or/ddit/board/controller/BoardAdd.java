package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardAdd")
public class BoardAdd extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardAdd.class);
	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String b_nm = req.getParameter("boardnm");
		
		int cnt = 0; 
		try {
			cnt = boardService.boardAdd(b_nm);
		} catch (Exception e) {
			cnt = 0;
		}
		
		logger.debug("cnt {} ", cnt);
		
		if(cnt == 1) {
			resp.sendRedirect(req.getContextPath()+ "/main");
		} else {
			resp.sendRedirect(req.getContextPath() + "/manage");
		}
		
	}
}
