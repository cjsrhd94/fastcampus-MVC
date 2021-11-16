package com.fastcampus.biz.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// 2. DAO(Data Access Object) Ŭ���� : �������� DB ������ ����ϴ� Ŭ����
//@Repository
public class BoardDAOMyBatis implements BoardDAO {
	
	@Autowired
	// sqlSessionTemplate�� MyBatis�� �����̳ʴ�.
	private SqlSessionTemplate mybatis;
	

	// BOARD ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����  
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� insertBoard() ��� ó��");
		// SQL�� ���̵�(Namespace.id�̸�), Parameter Object
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� deleteBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� getBoard() ��� ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}


}















