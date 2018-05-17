package com.dleague.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.Complain;
import com.dleague.board.model.vo.FreeBoard;

/**
 * Servlet implementation class ComplainBoardListServlet
 */
@WebServlet("/board/complainBoard")
public class ComplainBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터값 변수에 담기
		int numPerPage = 5;//한페이지당 수
		int cPage;//요청페이지
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage =1;
		}
		String searchType = null;
		String searchValue = null;
		if(request.getParameter("searchType")!=null) {
			searchType = request.getParameter("searchType");
			searchValue = request.getParameter("searchValue");
		}
		
		//2. 업무로직처리
		//2.1 현재페이지의 회원구하기
		
		List<Complain> complainBoardList = new BoardService().selectComplainAll(cPage, numPerPage, searchType, searchValue);

		//2.2 전체게시글수, 전체페이지수 구하기
		int totalBoardCount = new BoardService().selectComplainCount(searchType, searchValue);
		
		//(공식2)전체페이지수구하기
		int totalPage = (int)Math.ceil((double)totalBoardCount/numPerPage);
		
		//2.3 페이지바구성
		String pageBar = "";
		int pageBarSize = 5;
		//(공식3)시작페이지 번호 세팅
		//cPage = 5, pageBarSize=5 -> 1
		//cPage = 6, pageBarSize=5 -> 6
		int pageNo = ((cPage -1)/pageBarSize) * pageBarSize +1;
		//종료페이지 번호 세팅
		int pageEnd = pageNo + pageBarSize -1;
		
		//[이전] section
		if(pageNo == 1) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/board/complainBoard?cPage="+(pageNo-1)+"'><span class='page gradient'>이전</span></a>";
		}
		
		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
//				while(pageNo<=pageEnd && pageNo<=totalPage){
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='page active'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/board/complainBoard?&cPage="+pageNo+"'><span class='page gradient'>"+pageNo+"</span></a> ";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			//pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='"+request.getContextPath()+"/board/complainBoard?cPage="+pageNo+"'><span class='page gradient'>다음</span></a>";
		}
		
		
		
		if(complainBoardList!=null && !complainBoardList.isEmpty()) {
			request.setAttribute("param", "complain");
			request.setAttribute("complainBoardList", complainBoardList);
			request.setAttribute("pageBar", pageBar);
			request.getRequestDispatcher("/WEB-INF/views/board/complainBoardList.jsp").forward(request,response);
		}else {
			//region_board테이블에 값이 없을 경우
			request.setAttribute("param", "complain");

			request.getRequestDispatcher("/WEB-INF/views/board/complainBoardList.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
