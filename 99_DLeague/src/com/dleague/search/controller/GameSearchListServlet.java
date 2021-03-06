package com.dleague.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.game.model.service.GameService;
import com.dleague.game.model.vo.Game;
import com.dleague.member.model.vo.Member;
import com.dleague.search.model.searchService.searchService;
import com.dleague.search.model.vo.Team;

/**
 * Servlet implementation class GameSearchListServlet
 */
@WebServlet("/search/gameSearchList")
public class GameSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameSearchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		
		String gameDate = request.getParameter("gameDate");

		/*List<Game> list = new searchService().gameSearchList();//게임 및 로고 리스트*/
		
		//1. 파라미터 변수에 담기
		int cPage; 
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			//cPage파리미터가 값이 없거나, 부정입력된 경우대비
			cPage=1;
		}
		/*System.out.println("cPage="+cPage);*/
		
		//1.비지니스 로직 처리
		int numPerPage = 5;
		//전체 게시물 수 
		int totalGame = new searchService().selectGameCount();	//팀토탈카운트
		// (공식1) totalPage
		int totalPage = (int)(Math.ceil(totalGame/(double)numPerPage));
		
		List<Game> list = null;
		if(gameDate==null) {
			//2.2 페이징된 회원리스트 가져오기
			list = new searchService().selectGameList(cPage, numPerPage);
		}else {
			//2.3 날짜 게임검색 리스트 가져오기
			list = new searchService().selectGameList(cPage, numPerPage,gameDate);
		}
		//2.3 페이징바 만들기
		String pageBar ="";
		int pageBarSize = 5;
		//공식3 시작페이지 구하기
		int pageNo = (cPage-1)/pageBarSize*pageBarSize+1;
		//종료페이지 no
		int pageEnd = pageNo+pageBarSize-1;
		//[이전]
		if(pageNo == 1) {
			
		} else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/gameSearchList?cPage="+(pageNo-1)+"'><span class='page gradient'>이전</span></a>";
		}
		//[pageNo]
		while(pageNo <= pageEnd && pageNo <= totalPage){
			if(pageNo==cPage) {
				pageBar += "<span class='page active'>"+pageNo+"</span>";				
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/search/gameSearchList?cPage="+pageNo+"'><span class='page gradient'>"+pageNo+"</span></a>";	
			}
			pageNo++;
		}
		//[다음]
		if(pageNo > totalPage) {
			
		}else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/gameSearchList?cPage="+(pageNo)+"'><span class='page gradient'>다음</span></a>";
		}
		/*System.out.println("list@AdminMemberListServlet="+list);*/
		
		
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/search/gameSearchList.jsp";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("param", "teamSearchList");
		request.setAttribute("list", list);	//게임 및 로고 리스트
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
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
