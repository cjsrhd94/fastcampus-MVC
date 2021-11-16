package com.fastcampus.biz.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// 2. DAO(Data Access Object) 클래스 : 실질적인 DB 연동을 담당하는 클래스
//@Repository
public class BoardDAOMyBatis implements BoardDAO {
	
	@Autowired
	// sqlSessionTemplate가 MyBatis의 컨테이너다.
	private SqlSessionTemplate mybatis;
	

	// BOARD 관련 CRUD(Create(INSERT), Read(SELECT), Update, Delete) 메소드 구현  
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 insertBoard() 기능 처리");
		// SQL의 아이디(Namespace.id이름), Parameter Object
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 getBoard() 기능 처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 getBoardList() 기능 처리");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}


}















