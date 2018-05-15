package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.FreeBoardComment;
import com.dleague.board.model.vo.RegionBoardComment;

/**
 * Servlet implementation class FreeBoardCommentInsertServlet
 */
@WebServlet("/board/freeBoardCommentInsert")
public class FreeBoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String freeBoardCommentContent = request.getParameter("boardCommentContent");
		String freeBoardCommentWriter = request.getParameter("boardCommentWriter");
		int freeBoardRef = Integer.parseInt(request.getParameter("boardRef"));
		int freeBoardCommentRef = Integer.parseInt(request.getParameter("boardCommentRef"));
		int freeBoardCommentLevel = Integer.parseInt(request.getParameter("boardCommentLevel"));
		
		FreeBoardComment freeBoardComment = new FreeBoardComment();
		freeBoardComment.setBoard_free_comment_content(freeBoardCommentContent);
		freeBoardComment.setBoard_free_comment_writer(freeBoardCommentWriter);
		freeBoardComment.setBoard_free_ref(freeBoardRef);
		freeBoardComment.setBoard_free_comment_ref(freeBoardCommentRef);
		freeBoardComment.setBoard_free_comment_level(freeBoardCommentLevel);
		
		System.out.println(freeBoardComment);
		int result = new BoardService().insertFreeBoardComment(freeBoardComment);
		
		String view = "";
		
		if(result>0) {
			view="/board/freeBoardView?no="+freeBoardRef;
		}else {
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", "댓글 등록 실패!");
			request.setAttribute("loc", "/board/freeBoardView?no="+freeBoardRef);
		}
		request.setAttribute("param", "freeBoard");
		
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
