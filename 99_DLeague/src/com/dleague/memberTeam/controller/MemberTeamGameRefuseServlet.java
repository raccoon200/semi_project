package com.dleague.memberTeam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamGameRefuseServlet
 */
@WebServlet("/member/memberTeamGameRefuse")
public class MemberTeamGameRefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamGameRefuseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		String choose = request.getParameter("choose");
		int result = new MemberTeamService().memberTeamGameRefuse(teamName, choose);
		String Referer = request.getHeader("Referer"); //어디서 시도했는지
		String Origin  = request.getHeader("Origin");
		String url = request.getRequestURL().toString(); //url패턴까지
		String uri = request.getRequestURI(); //localhost빼고
		
		if(Origin == null) {
			Origin = url.replace(uri, "");
		}
		
		String loc = Referer.replace(Origin+request.getContextPath(), "");
		String msg = "";
		if(result>0) msg = "성공적으로 거절했습니다!";
		else msg = "오류!! 관리자에게 문의하시오!!";
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
