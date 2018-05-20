package com.dleague.memberTeam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dleague.memberTeam.model.service.MemberTeamService;

/**
 * Servlet implementation class MemberTeamActivityServlet
 */
@WebServlet("/member/memberTeamActivity")
public class MemberTeamActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		String gameNo = request.getParameter("gameNo");
		String score = request.getParameter("home") + " : " + request.getParameter("away");
		int result = new MemberTeamService().memberTeamAcitivty(gameNo, score);
		String msg = "";
		if(result>0) msg = "성공적으로 기록하였습니다!";
		else msg = "오류!! 관리자에게 문의하시오!!";
		String script = "self.close(); opener.window.location.reload();";
		//팝업창을 닫기위한 코드 추가
		String loc = "/member/memberTeamActivityPage?teamName="+teamName;
		request.setAttribute("script",script);
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
