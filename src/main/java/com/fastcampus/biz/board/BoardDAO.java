package com.fastcampus.biz.board;

import java.util.List;

public interface BoardDAO {

	// BOARD ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����  
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);

	// �� ��� �˻�
	List<BoardVO> getBoardList(BoardVO vo);

}