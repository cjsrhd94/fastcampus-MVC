package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardService;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/insertBoardView.do")
    public String insertBoardView(BoardVO vo) {
        return "insertBoard";
    }

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) {
        System.out.println("글 등록 기능 처리");
        boardService.insertBoard(vo);
        // 로직 처리 후, 이동할 화면을 문자열로 리턴하면 자동으로 forwarding된다.
        return "forward:getBoardList.do";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo) {
        System.out.println("글 수정 기능 처리");
        boardService.updateBoard(vo);
        return "forward:getBoardList.do";
    }

    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        System.out.println("글 삭제 기능 처리");
        boardService.deleteBoard(vo);
        return "forward:getBoardList.do";
    }

    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, HttpSession session, ModelAndView mav) {
        System.out.println("글 상세 조회 기능 처리");
        session.setAttribute("board", boardService.getBoard(vo));
        mav.setViewName("getBoard");
        return mav;
    }

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, HttpSession session, ModelAndView mav) {
        System.out.println("글 목록 검색 기능 처리");
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            mav.setViewName("login");
        } else {
            // Null Check
            if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
            if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
            // 절대 검색 결과는 세션에 등록하지 않는다. 한 번 쓰고 삭제되는 request 객체에 저장해야 한다.
            // 검색 결과를 ModelAndView에 저장하면 자동으로 request에 등록된다.
            mav.addObject("boardList", boardService.getBoardList(vo));   // Model 저장
            mav.addObject("search", vo);

            mav.setViewName("getBoardList");                                         // View 저장
        }
        return mav;
    }
}
