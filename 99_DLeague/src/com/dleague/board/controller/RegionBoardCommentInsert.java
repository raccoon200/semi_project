package com.dleague.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.RegionBoardComment;

/**
 * Servlet implementation class RegionBoardCommentInsert
 */
@WebServlet("/board/regionBoardCommentInsert")
public class RegionBoardCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionBoardCommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String regionBoardCommentContent = request.getParameter("boardCommentContent");
		String regionBoardCommentWriter = request.getParameter("boardCommentWriter");
		int regionBoardRef = Integer.parseInt(request.getParameter("boardRef"));
		int regionBoardCommentRef = Integer.parseInt(request.getParameter("boardCommentRef"));
		int regionBoardCommentLevel = Integer.parseInt(request.getParameter("boardCommentLevel"));
		
		RegionBoardComment regionBoardComment = new RegionBoardComment();
		regionBoardComment.setBoard_region_comment_content(regionBoardCommentContent);
		regionBoardComment.setBoard_region_comment_writer(regionBoardCommentWriter);
		regionBoardComment.setBoard_region_ref(regionBoardRef);
		regionBoardComment.setBoard_region_comment_ref(regionBoardCommentRef);
		regionBoardComment.setBoard_region_comment_level(regionBoardCommentLevel);
		
		int result = new BoardService().insertRegionBoardComment(regionBoardComment);
		
		String view = "";
		
		if(result>0) {
			view="/WEB-INF/views/board/regionBoardView?no="+regionBoardRef;
		}else {
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", "댓글 등록 실패!");
			request.setAttribute("loc", "/WEB-INF/views/board/regionBoardView?no="+regionBoardRef);
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
