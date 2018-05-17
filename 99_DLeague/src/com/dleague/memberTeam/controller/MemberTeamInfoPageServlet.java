package com.dleague.memberTeam.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.memberTeam.model.vo.Activity;
import com.dleague.memberTeam.model.vo.MemberRegister;
import com.dleague.memberTeam.model.vo.Team;
import com.dleague.memberTeam.model.vo.TeamMember;


/**
 * Servlet implementation class memberTeamInfoPageServlet
 */
@WebServlet("/member/memberTeamInfoPage")
public class MemberTeamInfoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamInfoPageServlet() {
        super();
        // TODO Auto-generated constructor stubssㄴ
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 변수에 담기
		String userId = request.getParameter("userId");
		String teamName = request.getParameter("teamName");
		//2. 업무로직 요청
		List<Team> list = new MemberTeamService().teamSearch(teamName);
		
		List<TeamMember> memberList = new MemberTeamService().teamMemberSearch(teamName);
		
		List<Activity> activityList = new MemberTeamService().activityListSearch(teamName);
		
		List<MemberRegister> memberRegisterList = new MemberTeamService().memberRegisterList(userId);
		
		/*System.out.println("activityList="+activityList);*/
		//3. view단 처리위임
		request.setAttribute("list", list);					//팀리스트
		request.setAttribute("memberList", memberList);		//팀멤버 리스트
		request.setAttribute("activityList", activityList);	//활동내역 리스트
		request.setAttribute("param", "memberTeamInfo");
		request.setAttribute("memberRegisterList", memberRegisterList);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/member/memberTeamInfo.jsp");
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
