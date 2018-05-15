package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.Complain;

/**
 * Servlet implementation class ComplainBoardViewServlet
 */
@WebServlet("/board/complainBoardView")
public class ComplainBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		Complain complainBoard = new BoardService().selectComplainBoardOne(no);
		String view ="";
		if(complainBoard!=null) {
			request.setAttribute("param", "complain");
			request.setAttribute("complainBoard", complainBoard);
			view = "/WEB-INF/views/board/complainBoardView.jsp";
		}else {
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("loc", "/WEB-INF/views/board/complainBoardList.jsp");
			request.setAttribute("msg", "게시글을 불러오지 못했습니다");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
