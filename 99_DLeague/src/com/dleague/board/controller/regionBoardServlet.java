package com.dleague.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.service.BoardService;

/**
 * Servlet implementation class regionBoardServlet
 */
@WebServlet("/board/regionBoard")
public class regionBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regionBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RegionBoard> regionBoard =  new BoardService().selectAll();
		
		if(regionBoard!=null && !regionBoard.isEmpty()) {
			request.setAttribute("param", "board");
			request.getRequestDispatcher("/WEB-INF/views/board/regionBoard.jsp").forward(request,response);
		}else {
			//error
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
