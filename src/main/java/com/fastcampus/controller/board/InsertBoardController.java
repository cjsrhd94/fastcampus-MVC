package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertBoardController {

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 등록 기능 처리");
        boardDAO.insertBoard(vo);
        // 로직 처리 후, 이동할 화면을 문자열로 리턴하면 자동으로 forwarding된다.
        return "getBoardList.do";
    }
}
