package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.BoardDaoI;
import kr.or.ddit.common.model.PageVo;

public class BoardService implements BoardServiceI {

	BoardDaoI boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	@Override
	public int boardAdd(String b_nm) {
		return boardDao.boardAdd(b_nm);
	}

	@Override
	public List<BoardVo> selectBoard() {
		return boardDao.selectBoard();
	}

	@Override
	public List<PostVo> selectPost(int b_no) {
		return boardDao.selectPost(b_no);
	}
	@Override
	public List<PostVo> selectPagingPost(PageVo vo) {
		return boardDao.selectPagingPost(vo);
	}

	@Override
	public int boardUpdate(BoardVo vo) {
		return boardDao.boardUpdate(vo);
	}

	@Override
	public PostVo boardView(int p_no) {
		return boardDao.boardView(p_no);
	}

	@Override
	public int selectPostCnt(int p_no) {
		return boardDao.selectPostCnt(p_no);
	}

	@Override
	public int postUpdate(PostVo vo) {
		return boardDao.postUpdate(vo);
	}

	@Override
	public int postDelete(int p_no) {
		return boardDao.postDelete(p_no);
	}

	@Override
	public int postRegist(PostVo vo) {
		return boardDao.postRegist(vo);
	}

	@Override
	public int selectSeq() {
		return boardDao.selectSeq();
	}

	@Override
	public List<CommentVo> selectComment(int p_no) {
		return boardDao.selectComment(p_no);
	}

	@Override
	public int commentRegist(CommentVo vo) {
		return boardDao.commentRegist(vo);
	}

	@Override
	public int commentDelete(int c_no) {
		return boardDao.commentDelete(c_no);
	}

	
}
