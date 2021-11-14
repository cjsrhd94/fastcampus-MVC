package com.fastcampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스 : 실질적인 DB 연동을 담당하는 클래스
//@Repository
public class BoardDAOSpring implements BoardDAO {
	
	@Autowired
	private JdbcTemplate spring;
	
	// BOARD 관련 SQL 명령어들
	private final String BOARD_INSERT     = "insert into board(seq, title, writer, content) " + 
                                            "values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE     = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt = cnt + 1 where seq = ?";
	private final String BOARD_DELETE     = "delete board where seq = ?";
	private final String BOARD_GET        = "select * from board where seq = ?";
	private final String BOARD_LIST       = "select * from board order by seq desc";
	
	// BOARD 관련 CRUD(Create(INSERT), Read(SELECT), Update, Delete) 메소드 구현  
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 insertBoard() 기능 처리");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 updateBoard() 기능 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 deleteBoard() 기능 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
//	// 글 상세 조회
//	public Map<String, Object> getBoard(BoardVO vo) {
//		System.out.println("===> SPRING 기반으로 getBoard() 기능 처리");
//		Object[] params = {vo.getSeq()};
//		return spring.queryForMap(BOARD_GET, params);
//	}
//	
//	// 글 목록 검색
//	public List<Map<String, Object>> getBoardList(BoardVO vo) {
//		System.out.println("===> SPRING 기반으로 getBoardList() 기능 처리");
//		// 목록을 조회할 때는 query() 메소드를 사용한다. 
//		// 첫 번째 인자는 SQL(SELECT), 두 번째 인자는 검색한 ResultSet을 매핑할 RowMapper 객체
//		return spring.queryForList(BOARD_LIST);
//	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoard() 기능 처리");
		Object[] params = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoardList() 기능 처리");
		// 목록을 조회할 때는 query() 메소드를 사용한다. 
		// 첫 번째 인자는 SQL(SELECT), 두 번째 인자는 검색한 ResultSet을 매핑할 RowMapper 객체
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}


}















