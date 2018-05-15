package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.Complain;

/**
 * Servlet implementation class ComplainBoardFormEndServlet
 */
@WebServlet("/board/complainBoardFormEnd")
public class ComplainBoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String complain_title = request.getParameter("complain_title");
		String complain_writer = request.getParameter("complain_writer");
		String complain_type = request.getParameter("complain_type");
		String c_complain = request.getParameter("c_complain");
		String complain_content = request.getParameter("complain_content");
		
		Complain complain = new Complain();
		complain.setComplain_title(complain_title);
		complain.setComplain_type(complain_type);
		complain.setComplain_writer(complain_writer);
		if("c_userid".equals(complain_type))
			complain.setC_userId(c_complain);
		else
			complain.setC_teamname(c_complain);
		complain.setComplain_content(complain_content);
		int result = new BoardService().insertComplain(complain);
		if(result>0) {
			result = new BoardService().selectRecentComplainNo();
		}
		String view = "";
		if(result>0) {
			view="/WEB-INF/views/board/complainBoardView.jsp?no="+result;
			request.setAttribute("complainBoard", complain);
		}else {
			request.setAttribute("msg", "신고글을 작성하지 못했습니다");
			request.setAttribute("loc", "/WEB-INF/views/board/complainBoardList.jsp");
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
