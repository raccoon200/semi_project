package com.dleague.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.board.model.vo.FreeBoardComment;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.vo.RegionBoardComment;
import com.dleague.region.model.service.RegionService;
import com.dleague.region.model.vo.Region;

/**
 * Servlet implementation class FreeBoardViewServlet
 */
@WebServlet("/board/freeBoardView")
public class FreeBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int no = Integer.parseInt(request.getParameter("no"));

		BoardService boardService = new BoardService();
		
		
		//쿠키검사 (조회수)
		Cookie[] cookies = request.getCookies();
		String boardCookieVal = "";
		boolean hasRead = false;
		
		if(cookies!=null) {
			for(Cookie c: cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				if("boardCookie".equals(name)) {
					boardCookieVal = value;
					if(boardCookieVal.contains("|"+no+"|")) {
						hasRead = true;
						break;
					}
					
				}
			}
		}
		//게시글 읽음여부 
		if(!hasRead) {
			//조회수 증가
			int result = boardService.increaseFreeCount(no);
			
			//쿠키생성
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal+"|"+no+"|");
//					boardCookie.setPath("/mvc/board");//작성안하면, 자동으로 현재경로로 셋팅됨.
			//boardCookie.setMaxAge(60*60*24);//작성안하면, 브라우져에서 영구저장.
			response.addCookie(boardCookie);
			
			
		}
		
		FreeBoard board = boardService.selectFreeBoardOne(no);
		
		//댓글 받아오는부분
		List<FreeBoardComment> freebcList = boardService.selectFreeCommentAll(no);
		
		request.setAttribute("param", "freeBoard");
		request.setAttribute("board", board);
		request.setAttribute("freebcList", freebcList);
		String view = "";
		if(board!=null) {
			view = "/WEB-INF/views/board/freeBoardView.jsp";
		}else {
			view = "/WEB-INF/views/board/freeList.jsp";
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
