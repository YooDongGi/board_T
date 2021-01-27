package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/fileDelete")
public class FileDelete extends HttpServlet{

	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a_no = Integer.parseInt(req.getParameter("a_no"));
		
		int cnt = 0;
		try {
			cnt = boardService.attachDelete(a_no);
		} catch (Exception e) {
			cnt = 0;
		}
		
	}
}
