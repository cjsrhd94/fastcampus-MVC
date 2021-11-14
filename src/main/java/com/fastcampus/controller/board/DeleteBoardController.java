package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 삭제 기능 처리");

        // 1. 사용자 입력정보 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAOJdbc();
        boardDAO.deleteBoard(vo);

        // 3. 화면 네비게이션
        ModelAndView mav = new ModelAndView();
        mav.setViewName("getBoardList.do");
        return mav;
    }
}
