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
import kr.or.ddit.common.model.PageVo;

@WebServlet("/boardList")
public class BoardList extends HttpServlet{

	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int b_no = Integer.parseInt(req.getParameter("boardno"));
		String pageParam = req.getParameter("page");
		
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pageSize = 10;
		
		PageVo vo = new PageVo(page, pageSize, b_no);
		List<PostVo> postList = boardService.selectPagingPost(vo);
		List<BoardVo> boardL = boardService.selectBoard();
		int cnt = boardService.selectPostCnt(b_no);
		
		int pagination = (int)Math.ceil((double)cnt/pageSize);
		
		req.setAttribute("boardL", boardL);
		req.setAttribute("postList", postList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("page", vo);
		
		req.getRequestDispatcher("/board/boardList.jsp").forward(req, resp);
		
	}
}

