package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.util.FileUtil;
@MultipartConfig
@WebServlet("/replyRegist")
public class ReplyRegist extends HttpServlet{
	
	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 부모글 게시글 번호 ( pa_no )
		
		List<BoardVo> boardL = boardService.selectBoard();
		
		req.setAttribute("boardL", boardL);
		
		req.getRequestDispatcher("/board/replyRegist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 부모글 게시글 번호
		int pa_no = Integer.parseInt(req.getParameter("pa_no"));
		
		PostVo pa_post = boardService.boardView(pa_no); 
		
		// 새로운글에 등록될 정보
		String userid = req.getParameter("userid");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Date p_date = new Date();
		PostVo vo = new PostVo(userid, pa_post.getB_no() , title, content, p_date);
		vo.setParent_no(pa_post.getP_no());
		vo.setGno(pa_post.getGno());
		
		int cnt = 0;
		int a_cnt = 0;
		try {
			cnt = boardService.replyRegist(vo);
		} catch (Exception e) {
			e.printStackTrace();
			cnt = 0;
		}
		Part file = req.getPart("file");
		if(file.getSize() > 0) {
			String a_nm = "";
			String a_route = "";
			int seq = boardService.selectSeq();
			a_nm = FileUtil.getFileName(file.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(a_nm);
			a_route = UUID.randomUUID().toString() + fileExtension;
			
			file.write("d:\\fileupload\\"+a_route);
			
			AttachVo attach = new AttachVo();
			attach.setA_nm(a_nm);
			attach.setA_route(a_route);
			attach.setP_no(seq);
			a_cnt = boardService.attachAdd(attach);
		}
		if(cnt == 1) {
			int seq = boardService.selectSeq();
			resp.sendRedirect("/boardView?p_no="+seq);
		} else {
			doGet(req, resp);
		}
	}
}
