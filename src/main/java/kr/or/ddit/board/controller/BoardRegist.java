package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardRegist")
public class BoardRegist extends HttpServlet{
	
	private BoardServiceI boardService = new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(BoardRegist.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<BoardVo> boardL = boardService.selectBoard();
		
		req.setAttribute("boardL", boardL);
		
		req.getRequestDispatcher("/board/boardRegist.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int b_no = Integer.parseInt(req.getParameter("b_no"));
		String userid = req.getParameter("userid");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Date p_date = new Date();
		PostVo vo = new PostVo(userid, b_no, title, content, p_date);
		logger.debug("{}", vo);
		int cnt = 0;
		try {
			cnt = boardService.postRegist(vo);
		} catch (Exception e) {
			cnt = 0;
		}
		
		if(cnt == 1) {
			int seq = boardService.selectSeq();
			resp.sendRedirect("/boardView?p_no="+seq);
		} else {
			doGet(req, resp);
		}
		
	}
}
