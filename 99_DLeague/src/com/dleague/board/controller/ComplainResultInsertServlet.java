package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;

/**
 * Servlet implementation class ComplainResultInsertServlet
 */
@WebServlet("/board/complainResultInsert")
public class ComplainResultInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainResultInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String complain_result = request.getParameter("result");
		int no = Integer.parseInt(request.getParameter("no"));
		
		int result = new BoardService().complainResultInsert(no, complain_result);
		String view="";
		if(result>0) {
			view="/board/complainBoardView?no="+result;
			request.setAttribute("param", "complain");
		}else {
			request.setAttribute("msg", "신고글을 처리하지 못했습니다");
			request.setAttribute("loc", "/board/complainBoardView?no="+result);
			view="/WEB-INF/views/common/msg.jsp";
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
