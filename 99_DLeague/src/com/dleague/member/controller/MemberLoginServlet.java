package com.dleague.member.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dleague.member.model.service.MemberService;
import com.dleague.member.model.vo.Member;



/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name="MemberLoginServlet", urlPatterns="/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2.파라미터값 변수에 기록하기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
	
		//3.비지니스로직
		int result = new MemberService().loginCheck(userId, password);
		
		//4. 받은결과에 따라서 view단 분기
		String view = "";
		String msg = "";
		String loc ="/";
		
		//로그인 후 이전 요청페이지로 리다이렉트함.
		String Referer = request.getHeader("Referer"); //어디서 시도했는지
		String Origin  = request.getHeader("Origin");
		String url = request.getRequestURL().toString(); //url패턴까지
		String uri = request.getRequestURI(); //localhost빼고
		
		if(Origin == null) {
			Origin = url.replace(uri, "");
		}
		
		loc = Referer.replace(Origin+request.getContextPath(), "");
		System.out.println("loc="+loc);
		
		if(result==MemberService.LOGIN_OK) {
			view="/";
			//회원정보 가져오기
			Member m = new MemberService().selectOne(userId);
		
			//request.setAttribute("memberLoggedIn", m);
			//세션이 존재하면, 해당세션을 리턴, 없으면 새로생성해서 리턴.
			HttpSession session = request.getSession();
			System.out.println(m);
			System.out.println("발급된 세션아이디 : "+session.getId());
			session.setAttribute("memberLoggedIn", m);
			//세션타임아웃설정
			session.setMaxInactiveInterval(30*60);
			
			//리다이렉트
			//더이상 request를 이용할 필요없음.
			response.sendRedirect(request.getContextPath());
		}
		//로그인 실패한경우
		else {
			view="/WEB-INF/views/common/msg.jsp";

			if(result==MemberService.WRONG_PASSWORD) {
				msg="패스워드를 잘못 입력하셨습니다.";
			}
			else if(result==MemberService.ID_NOT_EXIST) {
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
