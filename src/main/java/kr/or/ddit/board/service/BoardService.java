package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.BoardDaoI;

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
	public int boardUpdate(BoardVo vo) {
		return boardDao.boardUpdate(vo);
	}

	@Override
	public PostVo boardView(int p_no) {
		return boardDao.boardView(p_no);
	}
	
}
