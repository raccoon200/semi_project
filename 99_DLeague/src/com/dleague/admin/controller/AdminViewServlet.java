package com.dleague.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.admin.model.service.adminService;
import com.dleague.member.model.vo.Member;

/**
 * Servlet implementation class AdminViewServlet
 */
@WebServlet("/admin/adminView")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<Member> list = null;/*new adminService().MemberList();*/
		String userId = request.getParameter("userId");

		Member m = null;
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/admin/adminUserView.jsp";
		
		
		if(session != null) {
			m = (Member)session.getAttribute("memberLoggedIn");
		}
		if(m!=null && "admin".equals(m.getUserId())) {
			//1. 파라미터 변수에 담기
			list = new adminService().userView(userId);
			
			/*System.out.println("list@AdminMemberListServlet="+list);*/
		}else {
			msg = "관리자 로그인이 필요한 서비스입니다.\\n\\n로그인을 해주세요.";
			view = "/WEB-INF/views/common/msg.jsp";
		}
		
		request.setAttribute("list", list);					//회원리스트
		request.setAttribute("param", "adminPage");			//네비게이터 변수
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
