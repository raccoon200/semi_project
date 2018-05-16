package com.dleague.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.Complain;
import com.dleague.member.model.service.MemberService;
import com.dleague.member.model.vo.Member;
import com.dleague.memberTeam.model.service.MemberTeamService;
import com.dleague.memberTeam.model.vo.Team;


/**
 * Servlet implementation class ComplainBoardFormEndServlet
 */
@WebServlet("/board/complainBoardFormEnd")
public class ComplainBoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String complain_title = request.getParameter("complain_title");
		String complain_writer = request.getParameter("complain_writer");
		String complain_type = request.getParameter("complain_type");
		String c_complain = request.getParameter("c_complain");
		String complain_content = request.getParameter("complain_content");
		
		
		Complain complain = new Complain();
		complain.setComplain_title(complain_title);
		complain.setComplain_type(complain_type);
		complain.setComplain_writer(complain_writer);
		if("c_userid".equals(complain_type))
			complain.setC_userId(c_complain);
		else
			complain.setC_teamname(c_complain);
		complain.setComplain_content(complain_content);
		
		//용의팀, 용의자가 있는지 체크
		int check = -1;
		if("c_userid".equals(complain_type)) {
			Member m = new MemberService().selectOne(c_complain);
			if(m!=null) {
				check = 1;
			}
		}else {
			List<Team> t = new MemberTeamService().teamSearch(c_complain);
			if(t!=null && !t.isEmpty()) {
				check=1;
			}
		}
		if(check==-1) {
			request.setAttribute("msg", "신고대상이 존재하지 않는 회원/팀입니다");
			request.setAttribute("loc", "/board/complainBoard");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		}
		
		
		int result = new BoardService().insertComplain(complain);
		if(result>0) {
			result = new BoardService().selectRecentComplainNo();
		}
		String view = "";
		if(result>0) {
			view="/board/complainBoardView?no="+result;
			request.setAttribute("complainBoard", complain);
			request.setAttribute("param", "complain");
		}else {
			request.setAttribute("msg", "신고글을 작성하지 못했습니다");
			request.setAttribute("loc", "/WEB-INF/views/board/complainBoardList.jsp");
			view="/WEB-INF/views/common/msg.jsp";
		}
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
