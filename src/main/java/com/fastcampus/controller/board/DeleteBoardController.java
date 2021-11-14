package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteBoardController {
     @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 삭제 기능 처리");
        boardDAO.deleteBoard(vo);
        return "getBoardList.do";
    }
}
