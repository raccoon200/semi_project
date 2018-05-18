package com.dleague.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.game.model.exception.GameException;
import com.dleague.game.model.service.GameService;
import com.dleague.member.model.vo.Member;

/**
 * Servlet implementation class GameRegisterServlet
 */
@WebServlet("/game/gameRegister")
public class GameRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		String view = "/WEB-INF/views/game/gameRegister.jsp";
		String msg = "";
		String loc ="/";
		Member m = null;
		if(session != null) {
			m = (Member)session.getAttribute("memberLoggedIn");
		}
		if(m != null) {			
			int cnt=0;
			try {
				cnt = new GameService().getGameCountByTeamName(m.getTeamname());
			} catch (GameException e) {
				e.printStackTrace();
				throw new ServletException();
			}
//			System.out.println(cnt);
			if(cnt > 0) {
				view = "/WEB-INF/views/common/msg.jsp";
				msg = "등록된 경기가 있거나, 처리되지 않은 경기가 있습니다. 확인해주세요.";
			}else {
				view = "/WEB-INF/views/game/gameRegister.jsp";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("param", "gameRegister");
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
