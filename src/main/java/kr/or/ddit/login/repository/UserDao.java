package kr.or.ddit.login.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.login.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public UserVo selectUser(String userid) {

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
	
		sqlSession.close();
		
		return user;
	}

	
}
