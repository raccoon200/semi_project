package com.dleague.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dleague.search.model.searchService.searchService;

/**
 * Servlet implementation class TeamAutoSearchServlet
 */
@WebServlet("/search/teamAutoSearch")
public class TeamAutoSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamAutoSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글값대비 인코딩처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/csv; charset=utf-8");
		
		//2.파라미터 핸들링
		String searchName = request.getParameter("searchName");
		String selectCode = request.getParameter("selectCode");
		/*System.out.println("searchName="+searchName);*/
		
		//3.업무로직
		List<String> list = null;
		String csv= "";
		if(!searchName.trim().isEmpty()) {
			list = new searchService().selectByName(searchName,selectCode);
			//리턴된 값이 있는 경우만, csv처리
			if(!list.isEmpty()) {
				for(int i=0; i<list.size(); i++) {
					if(i!=0) csv += ",";
					csv += list.get(i);
				}
			}
		}
		System.out.println("csv="+csv);
		
		//4.응답객체 출력
		PrintWriter out = response.getWriter();
		out.append(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
