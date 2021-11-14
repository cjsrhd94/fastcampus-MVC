package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 기능 처리");

        // 1. 사용자 입력정보 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAOJdbc();
        BoardVO board = boardDAO.getBoard(vo);

        // 3. 검색 결과를 JSP 파일에서 사용할 수 있도록 session이나 request에 등록한다.
        HttpSession session = request.getSession();
        session.setAttribute("board", board);
        return "getBoard.jsp";
    }
}
