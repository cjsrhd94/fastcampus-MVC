package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.biz.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class GetBoardListController{

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, BoardDAOJdbc boardDAO, HttpSession session, ModelAndView mav) {
        System.out.println("글 목록 검색 기능 처리");
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            mav.setViewName("login.html");
        } else {
            // Null Check
            if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
            if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");

            session.setAttribute("boardList", boardDAO.getBoardList(vo));
            session.setAttribute("search", vo);

            mav.setViewName("getBoardList.jsp");
        }
        return mav;
    }
}