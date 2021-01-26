package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class BoardServiceTest {

	private BoardServiceI service;
	
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		service = new BoardService();

		/***When***/
		List<BoardVo> boardList = service.selectAllBoard();

		/***Then***/
		assertEquals(3, boardList.size());
		
	}

}
