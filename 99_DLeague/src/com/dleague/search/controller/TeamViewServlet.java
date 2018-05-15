package com.dleague.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.member.model.vo.Member;
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Activity;
import com.dleague.search.model.vo.Team;
import com.dleague.search.model.vo.TeamMember;


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
		
		/*HttpSession session = request.getSession(false);*/
		/*Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");*/
		
		//2. 업무로직 요청
		List<Team> list = new searchService().teamSearch(teamName);
		
		List<TeamMember> memberList = new searchService().teamMemberSearch(teamName);
		
		List<Activity> activityList = new searchService().activityListSearch(teamName);
		/*System.out.println("activityList="+activityList);*/
		//3. view단 처리위임
		request.setAttribute("list", list);					//팀리스트
		request.setAttribute("memberList", memberList);		//팀멤버 리스트
		request.setAttribute("activityList", activityList);	//활동내역 리스트
		/*request.setAttribute("memberLoggedIn", memberLoggedIn);	*/
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
