package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.AttachVo;
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

	@Override
	public int replyRegist(PostVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		logger.debug("vo : {}", vo);
		int cnt = sqlSession.insert("board.replyRegist", vo);
		logger.debug("cnt : {}", cnt);
		if(cnt != 0) {
			logger.debug("commit ");
			sqlSession.commit();
		} else {	// 비정상적으로 동작했을 경우 rollback을 한다
			logger.debug("rollback ");
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public String boardName(int b_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String b_nm = sqlSession.selectOne("board.boardName", b_no);
		sqlSession.close();
		return b_nm;
	}

	@Override
	public int attachAdd(AttachVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.insert("board.attachAdd", vo);
		if(cnt != 0) {
			sqlSession.commit();
		} else {	
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public List<AttachVo> attachList(int p_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<AttachVo> attachList = sqlSession.selectList("board.attachList", p_no);
		sqlSession.close();
		return attachList;
	}

	@Override
	public AttachVo selectAttach(int a_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AttachVo attach = sqlSession.selectOne("board.selectAttach", a_no);
		sqlSession.close();
		return attach;
	}

	@Override
	public int attachDelete(int a_no) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.delete("board.attachDelete", a_no);
		if(cnt != 0) {
			sqlSession.commit();
		} else {	
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	
}
