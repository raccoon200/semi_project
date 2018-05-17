package com.dleague.game.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.game.model.exception.GameException;
import com.dleague.game.model.service.GameService;
import com.dleague.game.model.vo.Game;
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Activity;
import com.dleague.search.model.vo.Team;
import com.dleague.search.model.vo.TeamMember;

/**
 * Servlet implementation class GameViewServlet
 */
@WebServlet("/game/gameView")
public class GameViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String status = request.getParameter("status");
		String home = "";
		String away = "";
		Object o = null;
		List<TeamMember> hMemberList = null;
		List<TeamMember> aMemberList = null;
		
		List<Activity> hActivityList = null;
		List<Activity> aActivityList = null;
		
		Team tHome = null;
		Team tAway = null;

		try {
			if("Y".equals(status)) {			
				Activity a = new GameService().selectOneWithResult(no);
				home = a.getHome();
				away = a.getAway();
				o = a;			
			}else {
				Game g = new GameService().selectOneGame(no);
				home = g.getHome();
				away = g.getAway();
				o = g;
			}
			tHome = new GameService().selectTeamByTeamName(home);
			tAway = new GameService().selectTeamByTeamName(away);
			System.out.println(tHome);
			System.out.println(tAway);
			
			hMemberList = new searchService().teamMemberSearch(home);
			aMemberList = new searchService().teamMemberSearch(away);
			
			hActivityList = new searchService().activityListSearch(home);
			aActivityList = new searchService().activityListSearch(away);
		}catch (GameException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		String view = "/WEB-INF/views/game/myGameView.jsp";
		
		request.setAttribute("obj", o);
		request.setAttribute("tHome", tHome);
		request.setAttribute("tAway", tAway);
		request.setAttribute("hMemberList", hMemberList);
		request.setAttribute("aMemberList", aMemberList);
		request.setAttribute("hActivityList", hActivityList);
		request.setAttribute("aActivityList", aActivityList);
		request.setAttribute("param", "myGameList");
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
