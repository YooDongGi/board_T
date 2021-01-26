package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.login.model.UserVo;

public class BoardDao implements BoardDaoI{
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
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
	public List<PostVo> selectPagingPost(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<PostVo> postList = sqlSession.selectList("board.selectPagingPost", vo);
		
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

	@Override
	public int selectPostCnt(int p_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.selectOne("board.selectPostCnt", p_no);
		sqlSession.close();
		return cnt;
	}

	@Override
	public int postUpdate(PostVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.update("board.postUpdate", vo);
		
		if(cnt == 1) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int postDelete(int p_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.update("board.postDelete", p_no);
		if(cnt == 1) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int postRegist(PostVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		logger.debug("{}",vo);
		int cnt = sqlSession.insert("board.postRegist", vo);
		logger.debug("후 :{}",vo);
		if(cnt != 0) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int selectSeq() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.selectOne("board.selectSeq");
		sqlSession.close();
		return cnt;
	}

	@Override
	public List<CommentVo> selectComment(int p_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<CommentVo> commentList = sqlSession.selectList("board.selectComment", p_no);
		sqlSession.close();
		return commentList;
	}

	@Override
	public int commentRegist(CommentVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.insert("board.commentRegist", vo);
		if(cnt != 0) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int commentDelete(int c_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.update("board.commentDelete", c_no);
		if(cnt != 0) {
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}


	
}
