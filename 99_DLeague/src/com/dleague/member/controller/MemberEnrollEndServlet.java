package com.dleague.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dleague.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet("/member/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "첨부파일오류[form:enctype]");
			request.setAttribute("loc", "/member/memberEnroll");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			.forward(request, response);
			return;
		}
			
		String saveDirectory = getServletContext().getRealPath("/upload/memberEnroll");
		System.out.println("saveDirectory="+saveDirectory);
		
		int maxPostSize = 1024*1024*10;
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
		
		
		}
		
		
		
		request.setCharacterEncoding("UTF-8");
	
		String userId  = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName"); 
		String regioncode = request.getParameter("regioncode");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email"); 
		String birthday =request.getParameter("birthday");
		String profile = request.getParameter("profile"); 
		String photo = 
		
				Member member = new Member(userId, password, userName, regioncode, phone, email, birthday, null );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
