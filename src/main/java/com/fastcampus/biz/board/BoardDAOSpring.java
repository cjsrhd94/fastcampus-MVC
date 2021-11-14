package com.fastcampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ���� : �������� DB ������ ����ϴ� Ŭ����
//@Repository
public class BoardDAOSpring implements BoardDAO {
	
	@Autowired
	private JdbcTemplate spring;
	
	// BOARD ���� SQL ��ɾ��
	private final String BOARD_INSERT     = "insert into board(seq, title, writer, content) " + 
                                            "values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE     = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt = cnt + 1 where seq = ?";
	private final String BOARD_DELETE     = "delete board where seq = ?";
	private final String BOARD_GET        = "select * from board where seq = ?";
	private final String BOARD_LIST       = "select * from board order by seq desc";
	
	// BOARD ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����  
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� insertBoard() ��� ó��");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� updateBoard() ��� ó��");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� deleteBoard() ��� ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
//	// �� �� ��ȸ
//	public Map<String, Object> getBoard(BoardVO vo) {
//		System.out.println("===> SPRING ������� getBoard() ��� ó��");
//		Object[] params = {vo.getSeq()};
//		return spring.queryForMap(BOARD_GET, params);
//	}
//	
//	// �� ��� �˻�
//	public List<Map<String, Object>> getBoardList(BoardVO vo) {
//		System.out.println("===> SPRING ������� getBoardList() ��� ó��");
//		// ����� ��ȸ�� ���� query() �޼ҵ带 ����Ѵ�. 
//		// ù ��° ���ڴ� SQL(SELECT), �� ��° ���ڴ� �˻��� ResultSet�� ������ RowMapper ��ü
//		return spring.queryForList(BOARD_LIST);
//	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoard() ��� ó��");
		Object[] params = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoardList() ��� ó��");
		// ����� ��ȸ�� ���� query() �޼ҵ带 ����Ѵ�. 
		// ù ��° ���ڴ� SQL(SELECT), �� ��° ���ڴ� �˻��� ResultSet�� ������ RowMapper ��ü
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}


}















