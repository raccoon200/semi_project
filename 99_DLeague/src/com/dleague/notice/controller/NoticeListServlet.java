package com.dleague.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.notice.model.service.NoticeService;
import com.dleague.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/noticeList")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
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
		

		
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		//2. 업무로직처리
		
		List<Notice> noticeList = new NoticeService().selectNoticeAll(cPage, numPerPage, searchValue);
		
		//2.2 전체게시글수, 전체페이지수 구하기
		int totalBoardCount = new NoticeService().selectNoticeCount(searchValue);
		
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
			pageBar += "<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+(pageNo-1)+"'>[이전]</a> ";
		}
		
		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
//				while(pageNo<=pageEnd && pageNo<=totalPage){
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/notice/noticeList?&cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			//pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		
		
		if(noticeList!=null && !noticeList.isEmpty()) {
			request.setAttribute("param", "notice");
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageBar", pageBar);
			request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp").forward(request,response);
		}else {
			//region_board테이블에 값이 없을 경우
			request.setAttribute("param", "notice");

			request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp").forward(request,response);
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
