package com.dleague.memberTeam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamMandateServlet
 */
@WebServlet("/member/memberTeamMandate")
public class MemberTeamMandateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamMandateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leader = request.getParameter("leader");
		String choose = request.getParameter("choose");

		int result = new MemberTeamService().MemberTeamMandate(leader, choose);
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = "성공적으로 위임하였습니다!";
			loc = "/member/logout";
		} else {
			msg = "오류!! 관리자에게 문의하시오!!";
			String Referer = request.getHeader("Referer"); //어디서 시도했는지
			String Origin  = request.getHeader("Origin");
			String url = request.getRequestURL().toString(); //url패턴까지
			String uri = request.getRequestURI(); //localhost빼고
			if(Origin == null) {
				Origin = url.replace(uri, "");
			}
			loc = Referer.replace(Origin+request.getContextPath(), "");
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
