package com.dleague.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Team;


/**
 * Servlet implementation class TeamViewServlet
 */
@WebServlet("/search/searchView")
public class TeamViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 변수에 담기
		String teamName = request.getParameter("teamName");
		//2. 업무로직 요청
		List<Team> list = new searchService().teamSearch(teamName);
		
		//3. view단 처리위임
		request.setAttribute("list", list);	//팀토탈수	
		request.setAttribute("param", "teamSearch");
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/search/teamSearchView.jsp");
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
