package kr.or.ddit.login.service;

import kr.or.ddit.login.model.UserVo;

public interface UserServiceI {

	// 회원 정보 조회
	UserVo selectUser(String userid);
}
