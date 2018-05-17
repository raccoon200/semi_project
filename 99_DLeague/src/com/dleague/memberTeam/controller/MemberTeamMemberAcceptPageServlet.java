package com.dleague.memberTeam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.memberTeam.model.vo.MemberRegister;

/**
 * Servlet implementation class MemberTeamMemberAcceptPageServlet
 */
@WebServlet("/member/memberTeamMemberAcceptPage")
public class MemberTeamMemberAcceptPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamMemberAcceptPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		List<MemberRegister> memberRegisterList = new MemberTeamService().memberTeamMemberAcceptPage(teamName);
		request.setAttribute("memberRegisterList", memberRegisterList);
		request.setAttribute("param", "memberTeamMemberAcceptPage");
		request.getRequestDispatcher("/WEB-INF/views/member/MemberTeamMemberAcceptPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
