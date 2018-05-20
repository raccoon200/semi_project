package com.dleague.memberTeam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.search.model.searchService.searchService;

/**
 * Servlet implementation class MemberTeamDeleteServlet
 */
@WebServlet("/member/memberTeamDelete")
public class MemberTeamDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		MemberTeamService memberTeamService = new MemberTeamService(); 
		int cnt = memberTeamService.cntTeamMember(teamName);
		String msg = "";
		String loc = "";
		String Referer = request.getHeader("Referer"); //어디서 시도했는지
		String Origin  = request.getHeader("Origin");
		String url = request.getRequestURL().toString(); //url패턴까지
		String uri = request.getRequestURI(); //localhost빼고
		
		if(Origin == null) {
			Origin = url.replace(uri, "");
			loc = Referer.replace(Origin+request.getContextPath(), "");
		}
		
		if(cnt>0) {
			msg = "팀장 혼자 있을 때 가능합니다!";
		} else {
			int result = new searchService().teamDelete(teamName);
			if(result>0) { 
				msg = "성공적으로 팀 삭제되었습니다. 로그아웃 후 확인가능합니다.";
				loc = "/member/logout"; 
			}
			else {
				msg = "오류!! 관리자에게 문의하시오!!";
				loc = Referer.replace(Origin+request.getContextPath(), "");
			}
		}
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
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
