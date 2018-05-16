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
 * Servlet implementation class ComplainBoardUpdateServlet
 */
@WebServlet("/board/complainBoardUpdate")
public class ComplainBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Complain complain = new BoardService().selectComplainBoardOne(no);	
		String view = "";
		
		if(complain!=null) {
			request.setAttribute("complainBoard", complain);
			request.setAttribute("param", "complain");
			view = "/WEB-INF/views/board/complainBoardUpdate.jsp";
		}else {
			request.setAttribute("loc", "/board/complainBoardView?no="+no);
			request.setAttribute("msg", "신고글을 수정하지 못했습니다");
			view = "/WEB-INF/views/common/msg.jsp";
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
