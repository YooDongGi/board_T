package kr.or.ddit.login.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.login.model.UserVo;

public class UserServiceTest {

	private UserServiceI service;
	
	@Test
	public void selectUserTest() {
		/***Given***/
		service = new UserService();
		
		String userid = "ehdrl";

		/***When***/
		UserVo user = service.selectUser(userid);
		
		/***Then***/
		assertEquals("유동기", user.getUsernm());
	}

}
