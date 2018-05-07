package com.dleague.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.member.model.service.MemberService;

/**
 * Servlet implementation class MemberPasswordUpdate
 */
@WebServlet("/member/passwordUpdate")
public class MemberPasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPasswordUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2.변수 담기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//3.비즈니스 로직
		int result = new MemberService().passwordUpdate(userId, password);
		
		//4.결과에 따른 분기
		String view="/WEB-INF/views/common/msg.jsp";
		String msg="";
		String loc="/";
		if(result>0) {
			msg = "성공적으로 수정되었습니다!";
			
		} else {
			msg = "오류 발생! 관리자에게 문의하시오!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher 
		= request.getRequestDispatcher(view);
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
