package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.common.model.PageVo;

public interface BoardServiceI {

	// 모든 게시판 목록을 조회 
	List<BoardVo> selectAllBoard();
	
	// 활성화된 게시판 목록 조회
	List<BoardVo> selectBoard();
	
	// 게시판 등록
	int boardAdd(String b_nm);
	
	// 게시판에 맞는 게시글 조회
	List<PostVo> selectPost(int b_no);
	// 게시판에 맞는 게시글 페이징처리 후 조회
	List<PostVo> selectPagingPost(PageVo vo);
	
	// 게시판 상태 변경
	int boardUpdate(BoardVo vo);
	
	// 게시글 조회
	PostVo boardView(int p_no);
	
	// 게시글 수 조회
	int selectPostCnt(int p_no);
	
	// 게시글 수정
	int postUpdate(PostVo vo);
	
	// 게시글 삭제
	int postDelete(int p_no);
	
	// 게시글 등록
	int postRegist(PostVo vo);
	
	// 현재 시퀀스 확인
	int selectSeq();
	
	// 게시글의 댓글 목록 조회
	List<CommentVo> selectComment(int p_no);
	
	// 댓글 등록
	int commentRegist(CommentVo vo);
	
	// 댓글 삭제
	int commentDelete(int c_no);
	
	// 답글 등록
	int replyRegist(PostVo vo);
	
	// 게시판 이름 조회
	String boardName(int b_no);
}
