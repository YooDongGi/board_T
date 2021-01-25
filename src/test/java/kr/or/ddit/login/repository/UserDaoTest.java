package kr.or.ddit.login.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.login.model.UserVo;

public class UserDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private UserDaoI dao;
	
	@Test
	public void selectUserTest() {
		/***Given***/
		dao = new UserDao();
		String userid = "ehdrl";

		/***When***/
		UserVo user = dao.selectUser(userid);
		
		/***Then***/
		assertEquals("유동기", user.getUsernm());
		
	}

}
