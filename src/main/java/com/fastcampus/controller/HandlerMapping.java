package com.fastcampus.controller;

import com.fastcampus.controller.board.*;
import com.fastcampus.controller.user.LoginController;
import com.fastcampus.controller.user.LogoutController;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

    private Map<String, Controller> mappers;

    public HandlerMapping() {
        mappers = new HashMap<String, Controller>();
        mappers.put("/login.do", new LoginController());
        mappers.put("/logout.do", new LogoutController());
        mappers.put("/insertBoard.do", new InsertBoardController());
        mappers.put("/updateBoard.do", new UpdateBoardController());
        mappers.put("/deleteBoard.do", new DeleteBoardController());
        mappers.put("/getBoard.do", new GetBoardController());
        mappers.put("/getBoardList.do", new GetBoardListController());
    }

    public Controller getController(String path) {
        return mappers.get(path);
    }
}
