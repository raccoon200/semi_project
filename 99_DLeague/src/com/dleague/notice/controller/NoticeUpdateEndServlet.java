package com.dleague.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.board.model.service.BoardService;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.common.MyFileRenamePolicy;
import com.dleague.notice.model.service.NoticeService;
import com.dleague.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/notice/noticeUpdateEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지 수정 오류!");
			request.setAttribute("loc", "/notice/noticeList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String saveDirectory = getServletContext().getRealPath("upload/notice");
		int maxPostSize = 1024*1024*10; //10MB
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
		
		int notice_no = Integer.parseInt(multiReq.getParameter("notice_no"));
		String notice_title = multiReq.getParameter("notice_title");
		String notice_writer = multiReq.getParameter("notice_writer");
		String notice_content = multiReq.getParameter("notice_content");
		String renamed_file_name = multiReq.getFilesystemName("up_file");//실제시스템에 저장된 파일명
		String original_file_name = multiReq.getOriginalFileName("up_file");//사용자가 업로드한 파일명
		String old_file = multiReq.getParameter("old_file");
		String old_file_path = multiReq.getParameter("old_file_path"); 
		Notice notice = new Notice();
		notice.setNotice_no(notice_no);
		notice.setNotice_title(notice_title);
		notice.setNotice_content(notice_content);
		notice.setNotice_writer(notice_writer);
		notice.setRenamed_file_name(renamed_file_name);
		notice.setOriginal_file_name(original_file_name);
		
		if(original_file_name==null) {
			notice.setOriginal_file_name(old_file);
			notice.setRenamed_file_name(old_file_path);
		}
		
		
		int result = new NoticeService().updateNotice(notice);
	
		if(result>0) {
			result = notice_no;
		}
		String view = "";
	
		if(result>0) {
			view="/notice/noticeView?no="+result;
		}else {
			String msg = "공지 수정 실패!";
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/notice/noticeList");
		}
		
		request.setAttribute("param", "notice");
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
