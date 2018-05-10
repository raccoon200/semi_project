package com.dleague.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class RegionBoardFormEndServlet
 */
@WebServlet("/board/regionBoardFormEnd")
public class RegionBoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionBoardFormEndServlet() {
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
			request.setAttribute("loc", "/board/regionBoard");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String saveDirectory = getServletContext().getRealPath("upload/board");
		
		int maxPostSize = 1024*1024*10; //10MB
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
		
		String board_region_title = multiReq.getParameter("board_region_title");
		String board_region_writer = multiReq.getParameter("board_region_writer");
		String board_regioncode = multiReq.getParameter("regionSelect");
		String renamedFileName = multiReq.getFilesystemName("up_file");
		String originalFileName = multiReq.getOriginalFileName("up_file");
		String board_region_content =multiReq.getParameter("board_region_content");
		
		RegionBoard board =new RegionBoard();
		board.setBoard_region_title(board_region_title);
		board.setBoard_region_writer(board_region_writer);
		board.setBoard_regioncode(board_regioncode);
		board.setBoard_region_content(board_region_content);
		board.setOriginal_file_name(originalFileName);
		board.setRenamed_file_name(renamedFileName);
		
		int result = new BoardService().insertRegionBoard(board);
		if(result>0) {
			result = new BoardService().selectRecentRegionBoardNo();
		}
		String view = "";
	
		if(result>0) {
			view="/board/regionBoardView?no="+result;
		}else {
			String msg = "게시글 등록 실패!";
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", "");
			request.setAttribute("loc", "/board/regionBoard");
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
