package com.dleague.memberTeam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.game.model.vo.Game;
import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamActivityPageServlet
 */
@WebServlet("/member/memberTeamActivityPage")
public class MemberTeamActivityPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamActivityPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		List<Game> memberTeamActivity = new MemberTeamService().memberTeamActivityPage(teamName);
		request.setAttribute("memberTeamActivity", memberTeamActivity);
		request.setAttribute("param", "memberTeamActivityPage");
		request.getRequestDispatcher("/WEB-INF/views/member/memberTeamActivityPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
