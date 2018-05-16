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
import com.dleague.memberTeam.model.vo.TeamRegister;

/**
 * Servlet implementation class AdminAcceptViewEndServlet
 */
@WebServlet("/admin/adminAcceptViewEnd")
public class AdminAcceptViewEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAcceptViewEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int result = 0;
		String YorN = request.getParameter("YorN");
		int t_reg_no = Integer.parseInt(request.getParameter("t_reg_no"));
		
		Member m = null;
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/admin/adminAccept.jsp";
		
		if(session != null) {
			m = (Member)session.getAttribute("memberLoggedIn");
		}
		if(m!=null && "admin".equals(m.getUserId())) {
			//1. 파라미터 변수에 담기
			if("Y".equals(YorN)) {
				result = new adminService().acceptTeamSuccess(YorN,t_reg_no);
				if(result>0) {
					msg = "팀생성 수락에 성공했습니다!\\n\\n팀을 생성합니다.";
				}else {
					msg = "팀생성 수락이 실패했습니다!\\n\\n관리자에게 문의하세요.";
					view = "/WEB-INF/views/common/msg.jsp";
				}
			}else if("N".equals(YorN)) {
				result = new adminService().acceptTeamSuccess(YorN,t_reg_no);
				if(result>0) {
					msg = "팀생성이 거절 되었습니다!";
				}else {
					msg = "팀생성 거절이 실패했습니다!\\n\\n관리자에게 문의하세요.";
					view = "/WEB-INF/views/common/msg.jsp";
				}
			}
			/*System.out.println("list@AdminMemberListServlet="+list);*/
		}else {
			msg = "관리자 로그인이 필요한 서비스입니다.\\n\\n로그인을 해주세요.";
			view = "/WEB-INF/views/common/msg.jsp";
		}

		request.setAttribute("param", "adminAccept");			//네비게이터 변수
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
