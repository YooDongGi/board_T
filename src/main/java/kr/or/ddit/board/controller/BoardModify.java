package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardModify")
public class BoardModify extends HttpServlet{
	
	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p_no = Integer.parseInt(req.getParameter("p_no"));
		
		PostVo post = boardService.boardView(p_no);
		List<BoardVo> boardL = boardService.selectBoard();
		
		req.setAttribute("boardL", boardL);
		req.setAttribute("post", post);
		
		req.getRequestDispatcher("/board/boardModify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int p_no = Integer.parseInt(req.getParameter("p_no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		PostVo post = new PostVo();
		post.setP_no(p_no);
		post.setTitle(title);
		post.setContent(content);
		
		int cnt = 0;
		try {
			cnt = boardService.postUpdate(post);
		} catch (Exception e) {
			cnt = 0;
		}
		
		if(cnt != 0) {
			resp.sendRedirect(req.getContextPath()+ "/boardView?p_no="+p_no);
		} else {
			doGet(req, resp);
		}
		
		
		
	}
}
