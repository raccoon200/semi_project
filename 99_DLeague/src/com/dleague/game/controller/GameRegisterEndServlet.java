package com.dleague.game.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.game.model.vo.Game;

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
		
		String teamName = request.getParameter("teamName");
		String dateTime = request.getParameter("date");
		String gamePlace = request.getParameter("gamePlace");
		String point_x = request.getParameter("point_x");
		String point_y = request.getParameter("point_y");
		String game_content = request.getParameter("game_content");
		String addrDetail = request.getParameter("addrDetail");
		
		System.out.println("dateTime = " + dateTime);
		System.out.println("gamePlace = " + gamePlace);
		System.out.println("point_x = " + point_x);
		System.out.println("point_y = " + point_y);
		System.out.println("game_content = " + game_content);
		System.out.println("addrDetail = " + addrDetail);
		
		String[] sepDateTime = dateTime.split(" - ");

		System.out.println("sepDateTime = " + sepDateTime[0]+","+sepDateTime[1]);

		Game g = new Game();
		g.setHome(teamName);
		g.setGameDateString(sepDateTime[0]);
		g.setStartTime(sepDateTime[1]);
		g.setGameContent(game_content);
		g.setPlace(gamePlace+"#"+addrDetail+"#"+point_x+"#"+point_y);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}