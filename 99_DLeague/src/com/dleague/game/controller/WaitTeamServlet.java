package com.dleague.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.game.model.exception.GameException;
import com.dleague.game.model.service.GameService;

/**
 * Servlet implementation class WaitTeamServlet
 */
@WebServlet("/game/waitTeam")
public class WaitTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		int gameNo = Integer.parseInt(request.getParameter("gameNo"));
		
		//System.out.println("teamName@WaitTeamServlet = "+teamName);
		//System.out.println("gameNo@WaitTeamServlet = "+gameNo);
		
		int result=0;
		try {
			result = new GameService().waitTeam(teamName, gameNo);
		} catch (GameException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		String msg = "";
		String loc = "";
		String view = "/WEB-INF/views/common/msg.jsp";
		String referer = request.getHeader("Referer");
		String origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		//크롬 외 다른 브라우저 용
		if(origin == null) {
			origin = url.replace(uri, "");
		}
		
		loc = referer.replace(origin+request.getContextPath(),"");
		
		if(result > 0) {
			msg = "경기가 신청되었습니다.";
		}else if(result == -1){
			msg = "오류! 관리자에게 문의하세요.";
		}else {
			msg = "이미 신청되어있습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
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
