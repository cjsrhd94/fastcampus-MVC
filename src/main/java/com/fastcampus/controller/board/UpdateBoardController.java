package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 수정 기능 처리");

        // 1. 사용자 입력정보 추출
        String title = request.getParameter("title");
        String seq = request.getParameter("seq");
        String content = request.getParameter("content");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setSeq(Integer.parseInt(seq));
        vo.setContent(content);

        BoardDAO boardDAO = new BoardDAOJdbc();
        boardDAO.updateBoard(vo);

        // 3. 화면 네비게이션
        return "getBoardList.do";
    }
}
