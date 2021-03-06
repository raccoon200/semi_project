package com.dleague.game.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.game.model.exception.GameException;
import com.dleague.game.model.service.GameService;
import com.dleague.game.model.vo.Game;
import com.dleague.member.model.vo.Member;

/**
 * Servlet implementation class GameListServlet
 */
@WebServlet("/game/myGameList")
public class GameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		Member m = null;
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/game/myGameList.jsp";
		List<Game> list = null;
		if(session != null) {
			m = (Member)session.getAttribute("memberLoggedIn");
		}
		if(m == null) {
			msg = "로그인이 필요한 서비스 입니다.\\n\\n로그인을 해주새요.";
			view = "/WEB-INF/views/common/msg.jsp";
		}else if(m.getTeamname() == null){
			msg = "팀이 필요한 서비스입니다.\\n\\n팀을 생성하거나 팀가입을 해주세요.";
			view = "/WEB-INF/views/common/msg.jsp";
		}else {
			try {
				list = new GameService().selectListByTeamName(m.getTeamname());
			} catch (GameException e) {
				e.printStackTrace();
				throw new ServletException();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("param", "myGameList");
		request.setAttribute("list", list);
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
