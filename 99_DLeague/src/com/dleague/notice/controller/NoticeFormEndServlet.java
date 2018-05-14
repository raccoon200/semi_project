package com.dleague.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.board.model.service.BoardService;
import com.dleague.common.MyFileRenamePolicy;
import com.dleague.notice.model.service.NoticeService;
import com.dleague.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class NoticeFormEndServlet
 */
@WebServlet("/notice/noticeFormEnd")
public class NoticeFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파일업로드로직
				//1.a multipart/form-data 여부 검사
				//org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload
				if(!ServletFileUpload.isMultipartContent(request)) {
					request.setAttribute("msg", "공지작성오류[form:enctype]");
					request.setAttribute("loc", "/notice/noticeList");
					request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
						  .forward(request, response);
					return;
				}
				
				//1.b saveDirectory
				String saveDirectory = getServletContext().getRealPath("/upload/notice");
				
				//1.c maxPostSize
				int maxPostSize = 1024*1024*10;
			
				//1.d MultipartRequest객체생성 ==> 파일rename정책 커스터마이징
				MultipartRequest multiReq = new MultipartRequest(request, 
														   saveDirectory, 
														   maxPostSize, 
														   "UTF-8", 
														   new MyFileRenamePolicy());

				//2.파라미터 가져오기
				//request객체가 아닌 MultipartRequest객체에서 가져옴.
				String notice_title = multiReq.getParameter("notice_title");
				String notice_writer = multiReq.getParameter("notice_writer");
				String notice_content = multiReq.getParameter("notice_content");
				String renamed_file_name = multiReq.getFilesystemName("up_file");//실제시스템에 저장된 파일명
				String original_file_name = multiReq.getOriginalFileName("up_file");//사용자가 업로드한 파일명
				
				Notice notice = new Notice();
				notice.setNotice_title(notice_title);
				notice.setNotice_content(notice_content);
				notice.setNotice_writer(notice_writer);
				notice.setRenamed_file_name(renamed_file_name);
				notice.setOriginal_file_name(original_file_name);
				
				//3.비지니스로직 처리
				//result에 새글번호를 가져옴.
				int result = new NoticeService().insertNotice(notice);
				if(result>0) {
					result = new NoticeService().selectRecentNoticeNo();
				}
				
				//4.view단 처리위임.
				String view = "/WEB-INF/views/common/msg.jsp";
				String msg = "";
				String loc = "/notice/noticeList";
				if(result>0) {
					view = "/notice/noticeView?no="+result;
				}
				else {
					msg = "공지 등록 실패!";
				}
				request.setAttribute("param", "notice");
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
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
