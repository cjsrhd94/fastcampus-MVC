package com.fastcampus.biz.board;

import java.util.List;

// 3. Service 인터페이스
public interface BoardService {

	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

//	// 글 상세 조회
//	Map<String, Object> getBoard(BoardVO vo);
//
//	// 글 목록 검색
//	List<Map<String, Object>> getBoardList(BoardVO vo);
	
	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 검색
	List<BoardVO> getBoardList(BoardVO vo);

}












