package com.dleague.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.region.model.service.RegionService;
import com.dleague.region.model.vo.Region;

/**
 * Servlet implementation class RegionBoardUpdateServlet
 */
@WebServlet("/board/regionBoardUpdate")
public class RegionBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		RegionBoard board = new BoardService().selectRegionBoardOne(no);
		List<Region> regionList = new RegionService().selectRegionList();
		request.setAttribute("board", board);
		request.setAttribute("param", "regionBoard");
		request.setAttribute("regionList", regionList);
		request.getRequestDispatcher("/WEB-INF/views/board/regionBoardUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
