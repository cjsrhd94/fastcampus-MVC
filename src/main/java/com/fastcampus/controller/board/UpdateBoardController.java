package com.fastcampus.controller.board;

import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateBoardController {

    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAOJdbc boardDAO) {
        System.out.println("글 수정 기능 처리");
        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }
}
