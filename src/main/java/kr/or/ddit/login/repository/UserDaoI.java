package kr.or.ddit.login.repository;

import kr.or.ddit.login.model.UserVo;

public interface UserDaoI {

	
	// 회원 정보 조회
	UserVo selectUser(String userid);
}
