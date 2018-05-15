package com.dleague.memberTeam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.memberTeam.model.vo.TeamRegister;
import com.dleague.search.model.vo.Team;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberTeamCreateEndServlet
 */
@WebServlet("/member/memberTeamCreateEnd")
public class MemberTeamCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTeamCreateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "팀생성오류[form:enctype]");
			request.setAttribute("loc", "/board/boardList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				  .forward(request, response);
			return;
		}
		
		//1.b saveDirectory
		String saveDirectory = getServletContext().getRealPath("/upload/member");
		
		
		//1.c maxPostSize
		int maxPostSize = 1024*1024*10;
	
		//1.d MultipartRequest객체생성 ==> 파일rename정책 커스터마이징
		MultipartRequest multiReq = new MultipartRequest(request, 
												   saveDirectory, 
												   maxPostSize, 
												   "UTF-8", 
												   new com.dleague.common.MyFileRenamePolicy());

		//2.파라미터 가져오기
		//request객체가 아닌 MultipartRequest객체에서 가져옴.
		String teamName = multiReq.getParameter("teamName");
		String t_register_writer = multiReq.getParameter("t_register_writer");
		String regionCode = multiReq.getParameter("regionCode");
		String introduce = multiReq.getParameter("introduce");
		String register_msg = multiReq.getParameter("register_msg");
		String teamLogo = multiReq.getFilesystemName("up_file");
		
		
		TeamRegister team = new TeamRegister();
		team.setTeamName(teamName);
		team.setT_register_writer(t_register_writer);
		team.setRegionCode(regionCode);
		team.setIntroduce(introduce);
		team.setRegister_msg(register_msg);
		team.setTeamLogo(teamLogo);;
		
		//3.비지니스로직 처리
	
		int result = new MemberTeamService().insertTeamRegist(team);
		
		//4.view단 처리위임.
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/board/boardList";
		if(result>0) {
			msg = "팀  등록 신청 성공!";
			loc = "/";
		}
		else {
			msg = "팀 등록 신청 실패!";
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
