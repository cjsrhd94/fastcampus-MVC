package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.biz.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 등록 기능 처리");
        boardDAO.insertBoard(vo);
        // 로직 처리 후, 이동할 화면을 문자열로 리턴하면 자동으로 forwarding된다.
        return "getBoardList.do";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 수정 기능 처리");
        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 삭제 기능 처리");
        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAOJdbc boardDAO, HttpSession session, ModelAndView mav) {
        System.out.println("글 상세 조회 기능 처리");
        session.setAttribute("board", boardDAO.getBoard(vo));
        mav.setViewName("getBoard.jsp");
        return mav;
    }

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
