package com.dleague.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet("/board/boardFileDownload")
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.실제파일저장경로를 절대경로로 가져오기
        String saveDirectory = getServletContext().getRealPath("/upload/board");
		String rName = request.getParameter("rName");
		String oName = request.getParameter("oName");
		System.out.printf("oName=%s, rName=%s\n",oName, rName);
		System.out.println(saveDirectory+"/"+rName);
		
		
		//2.입출력스트림 생성, IOException처리는 tomcat으로 던져서 처리함.
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(saveDirectory+"/"+rName));
		//출력스트림은 response객체의 outputstream을 사용함.
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		//3.브라우져에 따른 인코딩분기
		String resFilename = "";
		boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1 
					  || request.getHeader("user-agent").indexOf("Trident") != -1;
		System.out.println("isMSIE="+isMSIE);
		if(isMSIE){
			//ie는 utf-8인코딩을 명시적으로 해줌. 공백을 의미하는 +를 %20로 치환.
			resFilename = URLEncoder.encode(oName, "UTF-8");
			System.out.println("ie : "+resFilename);
								
			resFilename = resFilename.replaceAll("\\+", "%20");
			System.out.println("ie : "+resFilename);
		} else {
			//?
			resFilename = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
			System.out.println("not ie : "+resFilename);
			
		}

		//4.response헤더작성. 
		//반드시 출력코드보다 먼저 작성할 것.
		//application/octet-stream : 이진데이터(실행파일 또는 다운로드파일)를 담고 있을때 사용하는 MIME타입
		//content-disposition : attachment (indicating it should be downloaded; 
		//most browsers presenting a 'Save as' dialog, 
		//prefilled with the value of the filename parameters if present).
		response.setContentType("application/octet-stream");
		response.setHeader(
				"Content-Disposition",
				"attachment;filename=" + resFilename);
		
		//5. 파일쓰기
		int read = -1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bos.close();
		bis.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
