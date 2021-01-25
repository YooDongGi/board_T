package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/manage")
public class BoardManage extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardManage.class);
	private BoardServiceI boardService = new BoardService(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<BoardVo> boardList = boardService.selectAllBoard();
		List<BoardVo> boardL = boardService.selectBoard();
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardL", boardL);
		
		req.getRequestDispatcher("/board/boardmanage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String b_nm = req.getParameter("b_nm");
		String act = req.getParameter("act");
		
		int b_act = Integer.parseInt(act);
		
		BoardVo vo = new BoardVo();
		vo.setB_nm(b_nm);
		vo.setB_act(b_act);
		
		int cnt = 0;
		
		try {
			cnt = boardService.boardUpdate(vo);
		} catch (Exception e) {
			cnt = 0;
		}
		
		doGet(req,resp);
	}
}
