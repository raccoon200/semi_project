package com.dleague.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.member.model.vo.Member;
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Team;
import com.dleague.search.model.vo.TeamMember;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class TeamDeleteServlet
 */
@WebServlet("/search/teamDelete")
public class TeamDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String teamName = request.getParameter("teamName");
		//System.out.println("teamName="+teamName);
		
		//3.비지니스로직 처리
		/*List<TeamMember> list = new searchService().teamMemberSearch(teamName);
		List<Member> memberList = new searchService().userMemberSearch(teamName);*/
		int result = new searchService().teamDelete(teamName);	//team테이블 status 'N' 변경
		//4.view단 처리위임.
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "팀이 해체되었습니다!";
			loc = "/search/teamSearch";
		}
		else {
			msg = "팀 해체 실패! 관리자에게 문의하세요!";
			loc = "/search/searchView?teamName="+teamName;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
