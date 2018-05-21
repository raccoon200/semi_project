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
import com.dleague.memberTeam.model.vo.Team;
import com.dleague.memberTeam.model.vo.TeamMember;

/**
 * Servlet implementation class MemberTeamManagementPageServlet
 */
@WebServlet("/member/memberTeamManagementPage")
public class MemberTeamManagementPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamManagementPageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 변수에 담기
		String teamName = request.getParameter("teamName");
		//System.out.println("팀이름"+teamName);
		String msg = "";
		String loc = "/";
		
		if(teamName.equals("null")) {
			//System.out.println("안녕!");
			msg = "팀이 없습니다! 가입 또는 생성해주세요!";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		} 
		String userId = request.getParameter("userId");
		
		//2. 업무로직 요청
		List<Team> list = new MemberTeamService().teamSearch(teamName);
		
		List<TeamMember> memberList = new MemberTeamService().teamMemberSearch(teamName);
		
		List<Activity> activityList = new MemberTeamService().activityListSearch(teamName);
		/*System.out.println("activityList="+activityList);*/
		
		//접속한 아이디가 팀장인지 검사.
		
		String capTain="";
		for(Team t : list){
			capTain = t.getCapTain();
		}
		//System.out.println("팀장은 누구!"+capTain);
		//System.out.println("팀원은 누구!"+userId);
		
		if(!capTain.equals(userId)) {
			msg = "권한이 없습니다!(팀원)";
			loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		} 
		else {
		request.setAttribute("list", list);					//팀리스트
		request.setAttribute("memberList", memberList);		//팀멤버 리스트
		request.setAttribute("activityList", activityList);	//활동내역 리스트
		request.setAttribute("param", "memberTeamManagement");
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/member/memberTeamManagement.jsp");
		reqDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
