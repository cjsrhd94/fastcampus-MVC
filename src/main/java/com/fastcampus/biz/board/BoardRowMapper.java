package com.fastcampus.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	// JdbcTemplate는 검색 결과를 RowMapper 객체의 mapRow() 메소드를 통해
	// 특정 자바객체(VO)에 매핑해준다.
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// ResultSet의 각 ROW를 어떤 자바 객체에 어떻게 매핑할 것인지를 기술한다.
		System.out.println("rowNum : " + rowNum);
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));				
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}
