package kr.or.ddit.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {

	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int a_no = Integer.parseInt(req.getParameter("a_no"));
		AttachVo attVo = boardService.selectAttach(a_no);
		
		String path = "d:\\fileupload\\" + attVo.getA_route();
		String filename = attVo.getA_nm();
		
		resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		
		while(fis.read(buff) != -1) {
			sos.write(buff);
		}
		
		fis.close();
		sos.close();
	}
}

