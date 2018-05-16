package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.Complain;

/**
 * Servlet implementation class ComplainBoardUpdateEndServlet
 */
@WebServlet("/board/complainBoardUpdateEnd")
public class ComplainBoardUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("complain_title");
		Complain complain = new Complain();
		//int result = new BoardDAO().complainBoardUpdate(complain);
		int result = 0;
		String view = "";
		
		if(result>0) {
			view = "/board/complainBoardView?no="+no;
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
