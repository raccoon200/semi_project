/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-08 04:21:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;

public final class regionBoard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1525741890767L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525742204085L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525739268661L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.dleague.member.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
 Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>DLeague</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("/* 전체컨테이너 */\r\n");
      out.write("div#container\t{width:960px; margin:0 auto;}\r\n");
      out.write("\r\n");
      out.write("/*header*/\r\n");
      out.write("\r\n");
      out.write("header#header\t\t\t{ height:120px; position:relative; padding:10px 0 0 0;}\r\n");
      out.write("header#header h1 \t\t{margin-left:10px;}\r\n");
      out.write("\r\n");
      out.write("header#header nav {\r\n");
      out.write("\t \r\n");
      out.write("\twidth:100%; \r\n");
      out.write("\tmargin-top:15px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav {\r\n");
      out.write("\tdisplay:table;\r\n");
      out.write("\tpadding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav > li.main-nav-list{\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("\twidth:8em;\r\n");
      out.write("\theight:2em;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tpadding-left:15px;\r\n");
      out.write("\tpadding-right:15px;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tfont-size:1.2em;\r\n");
      out.write("\tbackground-color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.main-nav > li.main-nav-list > a{\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\tpadding:.5em;\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor:#292929;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav > li.main-nav-list:hover{border-radius:5px;}\r\n");
      out.write("\r\n");
      out.write("div#header-div{\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\theight:50px;\r\n");
      out.write("}\r\n");
      out.write("img#header-image {\r\n");
      out.write("\tpadding-left:10px;\r\n");
      out.write("\twidth:180px;\r\n");
      out.write("\theight:60px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list {\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tdisplay:table;\r\n");
      out.write("\tpadding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li{\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li a:hover{\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.main-nav-sub > ul{\r\n");
      out.write("\tbackground:rgb(245,245,245);\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("\tborder-radius:5px;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li{\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\tpadding:2px;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li > a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tfont-size:16px;\r\n");
      out.write("\tcolor:rgb(100,100,100);\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li> a:hover{\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub {\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\ttop:40px;\r\n");
      out.write("\tpadding:1px;\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-board{\r\n");
      out.write("\tleft:180px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-register{\r\n");
      out.write("\tleft:400px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-search{\r\n");
      out.write("\tleft:600px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-mypage{\r\n");
      out.write("\tleft:730px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section-center*/\r\n");
      out.write("section#center{\r\n");
      out.write("\theight:700px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\theight:auto;\r\n");
      out.write("\tbackground:rgb(64,128,183);\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("/*content*/\r\n");
      out.write("section#content{\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\tmargin:2px;\r\n");
      out.write("\twidth:758px;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tborder:1px solid rgb(245,245,245);\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("/*nav*/\r\n");
      out.write("nav#nav{\r\n");
      out.write("background:rgb(255,255,255);\r\n");
      out.write("border:2px solid rgb(64,128,183);\r\n");
      out.write("width:186px;\r\n");
      out.write("float:left;\r\n");
      out.write("margin-left:3px;\r\n");
      out.write("border-radius:5px;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list{\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li{\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tpadding-top:10px;\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("\tfont-size:1.2em;\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav#nav ul.nav-list li a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li a:hover{\r\n");
      out.write("\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("nav#nav h2#nav-header{\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*footer*/\r\n");
      out.write("footer#footer{\r\n");
      out.write("\tbackground:rgb(240,240,240);\r\n");
      out.write("\tpadding:5px;\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write("footer#footer p {\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-size:0.7em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*effect*/\r\n");
      out.write("ul.main-nav > li.main-nav-list a#header-selected {\r\n");
      out.write("\tcolor:rgb(64,128,183);\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li a#nav-selected{\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$(\".main-nav-list\").hover(function() {\r\n");
      out.write("\t\t$(this).children(\"div\").show();\r\n");
      out.write("\t\t$(this).children(\"a\").css(\"color\",\"rgb(64,128,183)\")\r\n");
      out.write("\t}, function() {\r\n");
      out.write("\t\t$(this).children(\"div\").hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($(this).children(\"a\").attr(\"id\")==\"header-selected\"){\r\n");
      out.write("\t\t\t$(this).children(\"a\").css(\"color\",\"rgb(64,128,183)\");\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\t$(this).children(\"a\").css(\"color\",\"black\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header id=\"header\">\r\n");
      out.write("\t\t\t<div id=\"header-div\">\r\n");
      out.write("\t\t\t<a href=\"#\"><img id=\"header-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.jpg\" /></a>\r\n");
      out.write("\t\t\t<ul id=\"header-list\">\r\n");
      out.write("\t\t\t\t");
if(memberLoggedIn==null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/login/login.jsp\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\t<!-- <li><a href=\"#\">관리자페이지</a></li> -->\r\n");
      out.write("\t\t\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<li>");
      out.print(memberLoggedIn.getUserId() );
      out.write("님 환영합니다!</li>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-notice\" class=\"main-nav-list\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-board\" class=\"main-nav-list\"><a href=\"#\" id=\"header-selected\">게시판</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 게시판 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-board\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\" >자유게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/regionBoard\" >지역게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/complainBoard\">신고게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-register\" class=\"main-nav-list\"><a href=\"#\" >경기등록</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-register\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">경기등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">내팀경기일정</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-search\" class=\"main-nav-list\"><a href=\"#\">검색</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 검색 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-search\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">팀 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">경기 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-mypage\" class=\"main-nav-list\"><a href=\"#\">마이페이지</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 마이페이지 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-mypage\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">내 팀 정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">내 정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">내 팀 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- <li id=\"board\"><a href=\"#\">관리자페이지</a></li> -->\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<!-- 메인메뉴 끝 -->\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<section id=\"center\">\r\n");
      out.write("\t\t");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t\t<nav id=\"nav\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 로그인/회원가입 -->\r\n");
      out.write("\t\t\t<!-- <h2 id=\"nav-header\"></h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">로그인</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t공지사항 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">공지사항</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t\t\t</ul> -->\r\n");
      out.write("\t\t\t<!-- 게시판 -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">게시판</h2>\r\n");
      out.write("\t\t\t<hr style=\"border:0;height:2px;background: rgb(244,244,244);\"/>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\">자유게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/regionBoard\" id=\"nav-selected\">지역게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/complainBoard\">신고게시판</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t<!-- <h2 id=\"nav-header\">경기등록</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">경기등록</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내팀경기일정</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t검색 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">검색</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀검색</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">경기검색</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t마이페이지 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">마이페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내 팀 정보</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내 정보</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내 팀 관리</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t관리자페이지 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">관리자페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회원 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 수락</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">접속 통계</a></li>\r\n");
      out.write("\t\t\t</ul> -->\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<section id=\"content\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2>지역게시판</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<footer id=\"footer\">\r\n");
      out.write("\t\t\t<p>팀명 : 투톱체제</p>\r\n");
      out.write("\t\t\t<p>팀원 : 김대연, 최지수, 박희영, 배성인, 이연경</p>\r\n");
      out.write("\t\t\t<p>주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('	');
      out.write('	');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
