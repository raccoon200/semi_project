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
import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.memberTeam.model.vo.TeamRegister;
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Team;
import com.dleague.search.model.vo.TeamMember;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class TeamUpdateServletEnd
 */
@WebServlet("/search/TeamUpdateServletEnd")
public class TeamUpdateServletEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamUpdateServletEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "팀정보수정오류[form:enctype]");
			request.setAttribute("loc", "/search/teamSearch");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				  .forward(request, response);
			return;
		}
		
		//1.b saveDirectory
		String saveDirectory = getServletContext().getRealPath("/images/team");
		
		
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
		
		
		Team team = new Team();
		team.setTeamName(teamName);
		team.setCapTain(t_register_writer);
		team.setRegionCode(regionCode);
		team.setIntroduce(introduce);
//		team.setRegister_msg(register_msg);
		team.setTeamLogo(teamLogo);
		
		//3.비지니스로직 처리
		List<TeamMember> list = new searchService().teamMemberSearch(teamName);
		List<Member> memberList = new searchService().userMemberSearch(teamName);
		int result = new searchService().teamUpdate(team);
		
		//팀업데이트가 성공하면
		String userId="";
		String memberTeamName="";
		String grade="";
		if(result>0) {
			for(TeamMember tm : list) {
				userId= tm.getUserId();
				memberTeamName = tm.getTeamName();
				grade = tm.getGrade();

				if("팀장".equals(grade)) {
					int result3 = new searchService().teamMemberUpdate2(userId);
				}
				if(t_register_writer.equals(userId)) {
					int result2 = new searchService().teamMemberUpdate(userId);
				}
			}
			String memberUserId="";
			String memberGrade="";
			for(Member m : memberList) {
				memberUserId=m.getUserId();
				memberGrade=m.getGrade();

				if("팀장".equals(memberGrade)) {
					int result4 = new searchService().userUpdate(memberUserId);
				}
				if(t_register_writer.equals(memberUserId)) {
					int result5 = new searchService().userUpdate2(memberUserId);
				}
			}
			
		}
		
		//4.view단 처리위임.
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "팀  정보 수정 성공!";
			loc = "/member/memberTeamInfoPage?teamName="+memberTeamName+"&userId="+userId;
		}
		else {
			msg = "팀 정보 수정 실패!";
			loc = "/member/memberTeamInfoPage?teamName="+memberTeamName+"&userId="+userId;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("param", "memberTeamInfo");
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
