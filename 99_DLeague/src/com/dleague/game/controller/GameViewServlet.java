package com.dleague.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.game.model.service.GameService;
import com.dleague.game.model.vo.Game;

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

		Object o = null;
		if("Y".equals(status)) {			
			o = new GameService().selectOneWithResult(no);
		}else {
			o = new GameService().selectOneGame(no);
		}
		String msg = "";
		String loc = "";
		String view = "/WEB-INF/views/game/myGameView.jsp";
		if(o == null) {
			msg = "잘못된 경로입니다.";
			loc = "/game/myGameList";
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		request.setAttribute("obj", o);
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
