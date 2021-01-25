package kr.or.ddit.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.login.model.UserVo;
import kr.or.ddit.login.service.UserService;
import kr.or.ddit.login.service.UserServiceI;


@WebServlet("/loginController")
public class Login extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		UserVo user = userService.selectUser(userid);
		
		if(user != null && pass.equals(user.getPass())) {
			
			HttpSession session = req.getSession();
			session.setAttribute("S_USER", user);
			
			resp.sendRedirect(req.getContextPath()+ "/main");
			
		} else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
	}
}
