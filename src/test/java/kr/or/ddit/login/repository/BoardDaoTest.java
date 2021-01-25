package kr.or.ddit.login.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.BoardDaoI;

public class BoardDaoTest {

	private BoardDaoI dao;
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		dao = new BoardDao();

		/***When***/
		List<BoardVo> boardList = dao.selectAllBoard();

		/***Then***/
		assertEquals(3, boardList.size());
	}
	
	@Test
	public void boardViewTest() {
		/***Given***/
		dao = new BoardDao();
		int p_no = 1;

		/***When***/
		PostVo post = dao.boardView(p_no);

		/***Then***/
		assertEquals("제목", post.getTitle());
	}

}
