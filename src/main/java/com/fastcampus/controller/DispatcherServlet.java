package com.fastcampus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastcampus.biz.board.BoardDAO;
import com.fastcampus.biz.board.BoardDAOJdbc;
import com.fastcampus.biz.board.BoardVO;
import com.fastcampus.biz.user.UserDAO;
import com.fastcampus.biz.user.UserVO;

@WebServlet(urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {
	
	public DispatcherServlet() {
		System.out.println("===> DispatcherServlet ����");
	}
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����ڰ� ��û�� path ������ �����Ѵ�. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("��û PATH : " + path);
		
		// 2. ��û path�� �ش��ϴ� �������� �б�ó���Ѵ�. 
		HttpSession session = request.getSession();
		
		if(path.equals("/login.do")) {
			System.out.println("�α��� ��� ó��");
			
			// 1. ����� �Է����� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. ���� ȭ�� ����
			if(user != null) {				
				// �α��� ���� �� ����(���尴ü)�� ����� ������ �����Ѵ�.
				session.setAttribute("user", user);				
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.html");
			}
			
		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ��� ó��");
			
			session.invalidate();

			response.sendRedirect("login.html");
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ��� ó��");
			
			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAOJdbc();
			boardDAO.insertBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ��� ó��");
			
			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAOJdbc();
			boardDAO.updateBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ��� ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAOJdbc();
			boardDAO.deleteBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ��� ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAOJdbc();
			BoardVO board = boardDAO.getBoard(vo);
			
			// 3. �˻� ����� JSP ���Ͽ��� ����� �� �ֵ��� session�̳� request�� ����Ѵ�. 
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");			
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ��� ó��");
			
			// 0. ����(���� ��ü) üũ
			UserVO user = (UserVO) session.getAttribute("user");
			if(user == null) {
				response.sendRedirect("login.html");
			} else {
				// 1. ����� �Է����� ����
				String searchCondition = request.getParameter("searchCondition");
				String searchKeyword = request.getParameter("searchKeyword");
				
				// Null Check
				if(searchCondition == null) searchCondition = "TITLE";
				if(searchKeyword == null) searchKeyword = "";
	
				// 2. DB ���� ó��
				BoardVO vo = new BoardVO();
//				vo.setSearchCondition(searchCondition);
//				vo.setSearchKeyword(searchKeyword);
				
				BoardDAO boardDAO = new BoardDAOJdbc();
				List<BoardVO> boardList = boardDAO.getBoardList(vo);
				
				// 3. �˻� ����� JSP ���Ͽ��� ����� �� �ֵ��� session�̳� request�� ����Ѵ�. 
				session.setAttribute("boardList", boardList);
				response.sendRedirect("getBoardList.jsp");
			}
			
		} else {
			System.out.println("path�� �ش��ϴ� ������ �����ϴ�.");
		}
	}
}




















