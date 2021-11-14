package com.fastcampus.biz.board;

import java.util.List;

// 3. Service �������̽�
public interface BoardService {

	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

//	// �� �� ��ȸ
//	Map<String, Object> getBoard(BoardVO vo);
//
//	// �� ��� �˻�
//	List<Map<String, Object>> getBoardList(BoardVO vo);
	
	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);

	// �� ��� �˻�
	List<BoardVO> getBoardList(BoardVO vo);

}












