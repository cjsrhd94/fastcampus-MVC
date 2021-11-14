package com.fastcampus.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 구동한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml"); 
		
		// 2. 테스트 객체를 Lookup한다. 
		BoardService boardService = (BoardService) container.getBean("boardService");
		// if(boardService != null) System.out.println("Lookup한 객체 : " + boardService.toString());
		 
		// 3. 객체를 테스트한다. 
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("Spring IoC 테스트");
		vo.setWriter("테스터");
		vo.setContent("Spring IoC 테스트중입니다.");
//		boardService.insertBoard(vo);
		
//		vo.setSeq(3);
//		Map<String, Object> board = boardService.getBoard(vo);
//		System.out.println("상세 조회 결과 : " + board.toString());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// 4. 컨테이너를 종료한다. 
		container.close();
	}
}
