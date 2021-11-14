package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.biz.user.UserVO;
import com.fastcampus.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 기능 처리");

        // 0. 세션(내장 객체) 체크
        HttpSession session = request.getSession();

        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            return "login.html";
        } else {
            // 1. 사용자 입력정보 추출
            String searchCondition = request.getParameter("searchCondition");
            String searchKeyword = request.getParameter("searchKeyword");

            // Null Check
            if (searchCondition == null) searchCondition = "TITLE";
            if (searchKeyword == null) searchKeyword = "";

            // 2. DB 연동 처리
            BoardVO vo = new BoardVO();
            vo.setSearchCondition(searchCondition);
            vo.setSearchKeyword(searchKeyword);

            BoardDAO boardDAO = new BoardDAOJdbc();
            List<BoardVO> boardList = boardDAO.getBoardList(vo);

            // 3. 검색 결과를 JSP 파일에서 사용할 수 있도록 session이나 request에 등록한다.
            session.setAttribute("boardList", boardList);
            session.setAttribute("search", vo);
            return "getBoardList.jsp";
        }
    }
}