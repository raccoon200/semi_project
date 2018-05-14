package com.dleague.memberTeam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamOut
 */
@WebServlet("/member/memberTeamOut")
public class MemberTeamOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("servlet@"+userId);
		int result = new MemberTeamService().memberTeamOut(userId);
		String msg = "";
		String loc = "/member/logout";
		
		if(result>0) msg = "성공적으로 탈퇴했습니다! 재로그인시 반영됩니다.";
		else msg = "탈퇴오류! 관리자에게 문의하시오!";
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
