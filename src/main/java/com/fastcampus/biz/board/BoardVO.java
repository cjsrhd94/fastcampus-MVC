package com.fastcampus.biz.board;

import java.util.Date;

import lombok.Data;

// 1. VO(Value Object) Ŭ����
@Data
public class BoardVO {
	// BOARD ���̺��� �÷��� ������ ������� ����
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;

	private String searchCondition;
	private String searchKeyword;
}











