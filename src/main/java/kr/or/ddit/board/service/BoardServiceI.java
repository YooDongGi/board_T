package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;

public interface BoardServiceI {

	// 모든 게시판 목록을 조회 
	List<BoardVo> selectAllBoard();
	
	// 활성화된 게시판 목록 조회
	List<BoardVo> selectBoard();
	
	// 게시판 등록
	int boardAdd(String b_nm);
	
	// 게시판에 맞는 게시글 조회
	List<PostVo> selectPost(int b_no);
	
	// 게시판 상태 변경
	int boardUpdate(BoardVo vo);
	
	// 게시글 조회
	PostVo boardView(int p_no);
}
