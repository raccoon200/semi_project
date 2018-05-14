package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class FreeBoardFormEndServlet
 */
@WebServlet("/board/freeBoardFormEnd")
public class FreeBoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 작성 오류!");
			request.setAttribute("loc", "/board/freeBoard");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String saveDirectory = getServletContext().getRealPath("upload/board");
		int maxPostSize = 1024*1024*10; //10MB
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
		
		String board_free_title = multiReq.getParameter("board_free_title");
		String board_free_writer = multiReq.getParameter("board_free_writer");
		String renamedFileName = multiReq.getFilesystemName("up_file");
		String originalFileName = multiReq.getOriginalFileName("up_file");
		String board_free_content =multiReq.getParameter("board_free_content");
		
		FreeBoard board =new FreeBoard();
		board.setBoard_free_title(board_free_title);
		board.setBoard_free_writer(board_free_writer);
		board.setBoard_free_content(board_free_content);
		board.setOriginal_file_name(originalFileName);
		board.setRenamed_file_name(renamedFileName);
		
		int result = new BoardService().insertFreeBoard(board);
		if(result>0) {
			result = new BoardService().selectRecentFreeBoardNo();
		}
		String view = "";
	
		if(result>0) {
			view="/board/freeBoardView?no="+result;
		}else {
			String msg = "게시글 등록 실패!";
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", "");
			request.setAttribute("loc", "/board/freeBoard");
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
