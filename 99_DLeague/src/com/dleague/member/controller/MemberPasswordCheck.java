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
 * Servlet implementation class MemberPasswordCheck
 */
@WebServlet("/member/passwordCheck")
public class MemberPasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPasswordCheck() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2.파라미터값 변수에 기록하기
		String userId = request.getParameter("userId");
		String birthday = request.getParameter("birthday");
		//System.out.println(birthday);
		
		//3.비지니스로직
		int result = new MemberService().passwordCheck(userId, birthday);
		
		//4. 받은결과에 따라서 view단 분기
		String view = "";
		String msg = "";
		String loc ="/";
		
		if(result==MemberService.CHECK_OK) {
			request.setAttribute("userId", userId);
			request.setAttribute("param", "passwordUpdate");
			request.getRequestDispatcher("/WEB-INF/views/login/passwordUpdate.jsp").forward(request, response);
		}
		
		//체크 실패한경우
		else {
			view="/WEB-INF/views/common/msg.jsp";
			String Referer = request.getHeader("Referer"); //어디서 시도했는지
			String Origin  = request.getHeader("Origin");
			String url = request.getRequestURL().toString(); //url패턴까지
			String uri = request.getRequestURI(); //localhost빼고
			
			if(Origin == null) {
				Origin = url.replace(uri, "");
			}
			
			loc = Referer.replace(Origin+request.getContextPath(), "");
			
			if(result==MemberService.WRONG_BIRTHDAY) {
				msg="생년월일을 잘못 입력하셨습니다.";
			}
			else if(result==MemberService.WRONG_ID) {
				msg="존재하지 않는 아이디입니다.";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			RequestDispatcher reqDispatcher 
			= request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
