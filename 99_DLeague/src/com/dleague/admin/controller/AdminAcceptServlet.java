package com.dleague.admin.controller;

import java.io.IOException;
import java.util.Hashtable;
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
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Team;

/**
 * Servlet implementation class AdminAcceptServlet
 */
@WebServlet("/admin/adminAccept")
public class AdminAcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<TeamRegister> list = null;
		
		Member m = null;
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/admin/adminAccept.jsp";
		int totalMember=0;
		int cPage=0; 
		String pageBar ="";
		
		int totalPage=0;
		
		if(session != null) {
			m = (Member)session.getAttribute("memberLoggedIn");
		}
		if(m!=null && "admin".equals(m.getUserId())) {
			//1. 파라미터 변수에 담기
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch (NumberFormatException e) {
				//cPage파리미터가 값이 없거나, 부정입력된 경우대비
				cPage=1;
			}
			/*System.out.println("cPage="+cPage);*/
			
			//1.비지니스 로직 처리
			int numPerPage = 10;
			//전체 게시물 수 
			totalMember = new adminService().acceptTeamCount();	//팀토탈카운트

			// (공식1) totalPage
			totalPage = (int)(Math.ceil(totalMember/(double)numPerPage));
			
			//2.2 페이징된 회원리스트 가져오기
			list = new adminService().acceptTeamList(cPage, numPerPage);
			
			//2.3 페이징바 만들기
			int pageBarSize = 5;
			//공식3 시작페이지 구하기
			int pageNo = (cPage-1)/pageBarSize*pageBarSize+1;
			//종료페이지 no
			int pageEnd = pageNo+pageBarSize-1;
			//[이전]
			if(pageNo == 1) {
				
			} else {
				pageBar += "<a href= '"+request.getContextPath()+"/admin/adminAccept?cPage="+(pageNo-1)+"'><span class='page gradient'>이전</span></a>";
			}
			//[pageNo]
			while(pageNo <= pageEnd && pageNo <= totalPage){
				if(pageNo==cPage) {
					pageBar += "<span class='page active'>"+pageNo+"</span>";				
				}else {
					pageBar+="<a href='"+request.getContextPath()+"/admin/adminAccept?cPage="+pageNo+"'><span class='page gradient'>"+pageNo+"</span></a>";	
				}
				pageNo++;
			}
			//[다음]
			if(pageNo > totalPage) {
				
			}else {
				pageBar += "<a href= '"+request.getContextPath()+"/admin/adminAccept?cPage="+(pageNo)+"'><span class='page gradient'>다음</span></a>";
			}
//			System.out.println("list@AdminMemberListServlet="+list);
//			System.out.println("totalMember@AdminMemberListServlet="+totalMember);
		}else {
			msg = "관리자 로그인이 필요한 서비스입니다.\\n\\n로그인을 해주세요.";
			view = "/WEB-INF/views/common/msg.jsp";
		}
		
		request.setAttribute("list", list);					//신청팀리스트
		request.setAttribute("pageBar", pageBar);			//페이지바
		request.setAttribute("cPage", cPage);				//페이지바
		request.setAttribute("param", "adminAccept");		//네비게이터 변수
		request.setAttribute("totalMember", totalMember);	//신청팀총수
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
