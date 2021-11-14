package com.fastcampus.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml"); 
		
		// 2. �׽�Ʈ ��ü�� Lookup�Ѵ�. 
		BoardService boardService = (BoardService) container.getBean("boardService");
		// if(boardService != null) System.out.println("Lookup�� ��ü : " + boardService.toString());
		 
		// 3. ��ü�� �׽�Ʈ�Ѵ�. 
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("Spring IoC �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("Spring IoC �׽�Ʈ���Դϴ�.");
//		boardService.insertBoard(vo);
		
//		vo.setSeq(3);
//		Map<String, Object> board = boardService.getBoard(vo);
//		System.out.println("�� ��ȸ ��� : " + board.toString());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// 4. �����̳ʸ� �����Ѵ�. 
		container.close();
	}
}
