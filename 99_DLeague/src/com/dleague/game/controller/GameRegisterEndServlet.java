package com.dleague.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameRegisterEndServlet
 */
@WebServlet("/game/gameRegisterEnd")
public class GameRegisterEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRegisterEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String dateTime = request.getParameter("date");
		String gamePlace = request.getParameter("gamePlace");
		String point_x = request.getParameter("point_x");
		String point_y = request.getParameter("point_y");
		String game_content = request.getParameter("game_content");
		
		System.out.println("dateTime = " + dateTime);
		System.out.println("gamePlace = " + gamePlace);
		System.out.println("point_x = " + point_x);
		System.out.println("point_y = " + point_y);
		System.out.println("game_content = " + game_content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
