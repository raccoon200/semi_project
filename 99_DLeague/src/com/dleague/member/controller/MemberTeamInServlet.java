package com.dleague.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.member.model.service.MemberService;
import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamInServlet
 */
@WebServlet("/member/memberTeamIn")
public class MemberTeamInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String teamName = request.getParameter("teamName");
		String msg = request.getParameter("msg");
		MemberService memberService = new MemberService();
		int result = 0;
		int cnt = memberService.memberTeamInCount(userId, teamName);
		if(!(cnt>0)) result = memberService.memberTeamIn(userId, teamName, msg);
		String Referer = request.getHeader("Referer"); //어디서 시도했는지
		String Origin  = request.getHeader("Origin");
		String url = request.getRequestURL().toString(); //url패턴까지
		String uri = request.getRequestURI(); //localhost빼고
		if(Origin == null) {
			Origin = url.replace(uri, "");
		}
		String loc = Referer.replace(Origin+request.getContextPath(), "");
		if(result>0) {
			msg = "성공적으로 신청되었습니다!";
		} else if(cnt>0) {
			msg = "이미 신청한 팀입니다! 내 팀 정보-가입 신청한 팀 내역에서 삭제해주세요!";
		} else {
			msg = "오류!! 관리자에게 문의하시오!";
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
