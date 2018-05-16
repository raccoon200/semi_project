package com.dleague.search.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.search.model.searchService.searchService;

/**
 * Servlet implementation class TeamUserKickServlet
 */
@WebServlet("/search/userKick")
public class TeamUserKickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamUserKickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int result=0;
		String checkbox = request.getParameter("checkbox");
		String teamName = request.getParameter("teamName");
//		System.out.println("checkbox="+checkbox);
		String userIdKick[] = checkbox.split(",");
		for(String kick : userIdKick) {
//			System.out.println(kick);
			if(!("undefined".equals(kick))) {
				result = new searchService().teamUserKick(kick);
			}
		}
		//4.view단 처리위임.
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "팀원이 강퇴되었습니다!";
			loc = "/search/searchView?teamName="+teamName;
		}
		else {
			msg = "팀원 강퇴 실패! 관리자에게 문의하세요!";
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
