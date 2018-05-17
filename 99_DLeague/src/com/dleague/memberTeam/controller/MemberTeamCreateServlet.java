package com.dleague.memberTeam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.region.model.service.RegionService;
import com.dleague.region.model.vo.Region;

/**
 * Servlet implementation class MemberTeamCreateServlet
 */
@WebServlet("/member/memberTeamCreate")
public class MemberTeamCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");*/
		String userId = request.getParameter("userId");
		System.out.println(userId);
		int cnt = new MemberTeamService().cntTeamCreate(userId);
		/*System.out.println(cnt);*/
		if(cnt>0) {
			String msg = "이미 팀 생성 중입니다!";
			String Referer = request.getHeader("Referer"); //어디서 시도했는지
			String Origin  = request.getHeader("Origin");
			String url = request.getRequestURL().toString(); //url패턴까지
			String uri = request.getRequestURI(); //localhost빼고
			if(Origin == null) {
				Origin = url.replace(uri, "");
			}
			String loc = Referer.replace(Origin+request.getContextPath(), "");
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		List<Region> regionList = new RegionService().selectRegionList();
		request.setAttribute("param", "memberTeamCreate");
		request.setAttribute("regionList", regionList);
		request.getRequestDispatcher("/WEB-INF/views/member/memberTeamCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
