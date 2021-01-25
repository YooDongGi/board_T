package kr.or.ddit.login.service;

import kr.or.ddit.login.model.UserVo;
import kr.or.ddit.login.repository.UserDao;
import kr.or.ddit.login.repository.UserDaoI;

public class UserService implements UserServiceI{

	UserDaoI userDao = new UserDao();
	
	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

}
