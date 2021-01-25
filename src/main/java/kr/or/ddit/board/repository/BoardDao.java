package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.login.model.UserVo;

public class BoardDao implements BoardDaoI{

	@Override
	public List<BoardVo> selectAllBoard() {

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectAllBoard");
	
		sqlSession.close();
		
		return boardList;
	}

	@Override
	public int boardAdd(String b_nm) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int cnt = sqlSession.insert("board.boardAdd", b_nm);
		
		if(cnt == 1) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public List<BoardVo> selectBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardVo> boardL = sqlSession.selectList("board.selectBoard");
		
		sqlSession.close();
		
		return boardL;
	}

	@Override
	public List<PostVo> selectPost(int b_no) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<PostVo> postList = sqlSession.selectList("board.selectPost", b_no);
		
		sqlSession.close();
		
		return postList;
	}

	@Override
	public int boardUpdate(BoardVo vo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int cnt = sqlSession.update("board.boardUpdate", vo);
				
		if(cnt == 1) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
				
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public PostVo boardView(int p_no) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		PostVo post = sqlSession.selectOne("board.boardView", p_no);
		
		sqlSession.close();
		
		return post;
	}

	
}
