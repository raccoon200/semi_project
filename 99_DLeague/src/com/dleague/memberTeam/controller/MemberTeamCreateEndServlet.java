package com.dleague.memberTeam.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberTeamCreateEndServlet
 */
@WebServlet("/member/memberTeamCreateEnd")
public class MemberTeamCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamCreateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String teamName = request.getParameter("teamName");
		String t_register_writer = request.getParameter("t_register_writer");
		String regionCode = request.getParameter("regionCode");
		String introduce = request.getParameter("introduce");
		String register_msg = request.getParameter("register_msg");
		
		Team team = new Team();
		
		
		package com.dleague.memberTeam.model.vo;
		private String teamName;
		private String regionCode;
		private String capTain;
		private String teamLogo;
		private String introduce;
		private Date foundingDate;
		private String status;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
