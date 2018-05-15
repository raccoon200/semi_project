package com.dleague.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
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
         request.setCharacterEncoding("UTF-8");
         request.setAttribute("msg", "첨부파일오류[form:enctype]");
         request.setAttribute("loc", "/member/memberEnroll");
         request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
         .forward(request, response);
         return;
      }
         
      String saveDirectory = getServletContext().getRealPath("upload/member");
      System.out.println("saveDirectory="+saveDirectory);
      
      int maxPostSize = 1024*1024*10;
      
      MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
      
      String userId  = multiReq.getParameter("userId");
      String password = multiReq.getParameter("password");
      String userName = multiReq.getParameter("userName"); 
      String regioncode = multiReq.getParameter("regioncode");
      String phone = multiReq.getParameter("phone");
      String email ="";
      if("1".equals(multiReq.getParameter("selectEmail"))) {
    	  email = multiReq.getParameter("email1")+("@")+multiReq.getParameter("email2");
      }else {
    	  email = multiReq.getParameter("email1")+("@")+multiReq.getParameter("selectEmail"); 
      }
      String birthday =multiReq.getParameter("birthday");
      String profile = multiReq.getParameter("profile");
      String photo = multiReq.getFilesystemName("up_file");
      System.out.println("userid ="+userId);

      System.out.println("password@MemberEnrollEndServlet="+password);
      
      Member member = new Member();
      member.setUserId(userId);
      member.setPassword(password);
      member.setUserName(userName);
      member.setRegioncode(regioncode);
      member.setPhone(phone);
      member.setEmail(email);
      member.setBirthday(birthday);
      member.setProfile(profile);
      member.setPhoto(photo);
      System.out.println("입력한 회원정보 : "+member);
      
      int result = new MemberService().insertMember(member);
      
      String view = "/WEB-INF/views/common/msg.jsp";
      String msg = "";
      
      String loc = "/";
      
      if(result>0)
         msg = "회원가입 성공!";
      else 
         msg = "회원가입 실패 !!";
      
      request.setAttribute("msg", msg);
      request.setAttribute("loc", loc);
      request.setAttribute("imgPath", photo);

      RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
      reqDispatcher.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}