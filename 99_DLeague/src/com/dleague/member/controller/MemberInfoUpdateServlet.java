package com.dleague.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.common.MyFileRenamePolicy;
import com.dleague.member.model.service.MemberService;
import com.dleague.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberInfoUpdateServlet
 */
@WebServlet("/member/MemberInfoUpdate")
public class MemberInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "파일오류인코드오류![form:enctype]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				  .forward(request, response);
			return;
		}
		
		//1.b saveDirectory
		String saveDirectory = getServletContext().getRealPath("upload/member"); 
				
		//System.out.println("saveDirectory="+saveDirectory);
		
		//1.c maxPostSize
		int maxPostSize = 1024*1024*10;
	
		//1.d MultipartRequest객체생성 ==> 파일rename정책 커스터마이징s
		MultipartRequest multiReq = new MultipartRequest(request, 
												   saveDirectory, 
												   maxPostSize, 
												   "UTF-8", 
												   new MyFileRenamePolicy());
		
		String userId = multiReq.getParameter("userId");
		String password = multiReq.getParameter("password");
		String userName = multiReq.getParameter("userName");
		String regioncode = multiReq.getParameter("regioncode");
		String phone = multiReq.getParameter("phone");
		String email = multiReq.getParameter("email");
		String birthday = multiReq.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		java.sql.Date enrolldate = java.sql.Date.valueOf(multiReq.getParameter("enrolldate"));
		
		String teamname = multiReq.getParameter("teamName");
		String profile = multiReq.getParameter("profile"); 
		String grade = multiReq.getParameter("grade");
		String photo = multiReq.getFilesystemName("up_file");//실제시스템에 저장된 파일명
		//System.out.println(birthday);
		//System.out.println(userId);
		//System.out.println(enrolldate);
		//System.out.println("servlet@"+teamname);
		Member member = new Member(userId, password, userName, regioncode, phone, email, birthday, teamname
				, profile, grade, photo, enrolldate);
		int result = new MemberService().memberInfoUpdate(member);
		String msg = "";
		String loc = "/member/logout";
		if(result>0) msg = "성공적으로 수정되었습니다! 프로필 사진은 재로그인 시에 변경됩니다!";
		else msg = "수정오류! 관리자에게 문의하시오!";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("imgPath", photo);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
