/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-08 00:05:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teamSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1525669909302L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525666700273L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525666713681L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("/********** 전체컨테이너 **********/\r\n");
      out.write("div#container\t{width:960px; margin:0 auto;}\r\n");
      out.write("\r\n");
      out.write("/********** header **********/\r\n");
      out.write("header\t\t\t{ height:120px; position:relative; padding:10px 0 0 0;}\r\n");
      out.write("header h1 \t\t{margin-left:10px;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* 메인메뉴 */\r\n");
      out.write("header nav {\r\n");
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
      out.write("ul.main-nav li.main-nav-list{\r\n");
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
      out.write("ul.main-nav li.main-nav-list a{\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\tpadding:.5em;\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor:#292929;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav li:hover{background:rgb(230,230,230);}\r\n");
      out.write("ul.main-nav li:hover>a{color:black;}\r\n");
      out.write("\r\n");
      out.write("/*header*/\r\n");
      out.write("div#header-div{\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\theight:50px;\r\n");
      out.write("}\r\n");
      out.write("img#header-image {\r\n");
      out.write("\tpadding-left:10px;\r\n");
      out.write("\twidth:200px;\r\n");
      out.write("\theight:60px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list {\r\n");
      out.write("\t\r\n");
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
      out.write("\t\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub ul{\r\n");
      out.write("\tbackground:lightgray;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub ul li{\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub ul li a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tfont-size:16px;\r\n");
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
      out.write("\tleft:170px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-register{\r\n");
      out.write("\tleft:390px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-search{\r\n");
      out.write("\tleft:580px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-mypage{\r\n");
      out.write("\tleft:700px;\r\n");
      out.write("}\r\n");
      out.write("/*section-center*/\r\n");
      out.write("section#center{\r\n");
      out.write("\theight:700px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\theight:auto;\r\n");
      out.write("}\r\n");
      out.write("section#content{\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\twidth:760px;\r\n");
      out.write("\tbackground:gray;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("/*nav*/\r\n");
      out.write("nav#nav{\r\n");
      out.write("background:rgb(230,230,230);\r\n");
      out.write("width:190px;\r\n");
      out.write("float:left;\r\n");
      out.write("margin-right:10px;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list{\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li{\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tpadding-top:10px;\r\n");
      out.write("\tfont-size:1.2em;\r\n");
      out.write("\tlist-style-type:none;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("nav#nav h2#nav-header{\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*footer*/\r\n");
      out.write("footer{\r\n");
      out.write("\tbackground:rgb(240,240,240);\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write("footer p {\r\n");
      out.write("\tfont-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-size:0.7em;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$(\"#main-nav-board\").hover(function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-board\").show();\r\n");
      out.write("\t}, function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-board\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#main-nav-register\").hover(function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-register\").show();\r\n");
      out.write("\t}, function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-register\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#main-nav-search\").hover(function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-search\").show();\r\n");
      out.write("\t}, function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-search\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#main-nav-mypage\").hover(function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-mypage\").show();\r\n");
      out.write("\t}, function() {\r\n");
      out.write("\t\t$(\"#main-nav-sub-mypage\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<div id=\"header-div\">\r\n");
      out.write("\t\t\t<img id=\"header-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.PNG\" alt=\"\" />\r\n");
      out.write("\t\t\t<ul id=\"header-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">로그인</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-notice\" class=\"main-nav-list\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-board\" class=\"main-nav-list\"><a href=\"#\">게시판</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 게시판 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-board\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">자유게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">지역게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">신고게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-register\" class=\"main-nav-list\"><a href=\"#\">경기등록</a>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/search/teamSearch\">팀 검색</a></li>\r\n");
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
      out.write("\t\t<section id=\"center\">");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<nav id=\"nav\">\r\n");
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
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">자유게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">지역게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">신고게시판</a></li>\r\n");
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
      out.write("\t<section id=\"content\">");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("    #teamDiv{background:white; padding:10px 10px 10px 10px;}\r\n");
      out.write("    #teamDiv2{text-align:right; padding:0px 40px 0px 0px;}\r\n");
      out.write("    \r\n");
      out.write("    /* table Object */\r\n");
      out.write("    .tbl_type{margin:auto;}\r\n");
      out.write("    .tbl_type,.tbl_type th,.tbl_type td{border:0}\r\n");
      out.write("    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}\r\n");
      out.write("    .tbl_type caption{display:none}\r\n");
      out.write("    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}\r\n");
      out.write("    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}\r\n");
      out.write("    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}\r\n");
      out.write("    .tbl_type td.ranking{font-weight:bold}\r\n");
      out.write("    legend{padding:10px 0px 0px 40px;}\r\n");
      out.write("    /* table Object 끝 */\r\n");
      out.write("    \r\n");
      out.write("    /* 검색옵션 */\r\n");
      out.write("    select{height: 30px; width: 100px;}\r\n");
      out.write("    #search{height: 25px; width: 150px;}\r\n");
      out.write("    /* 검색옵션 끝*/\r\n");
      out.write("    \r\n");
      out.write("    /* 버튼 */\r\n");
      out.write("    .button {\r\n");
      out.write("      height:33px;\r\n");
      out.write("\t  display: inline;\r\n");
      out.write("\t  vertical-align: top;\r\n");
      out.write("\t /*  position: relative; */\r\n");
      out.write("\t  padding: 0 15px 0 15px;\r\n");
      out.write("\t  line-height: 35px;\r\n");
      out.write("\t  font-size: 15px;\r\n");
      out.write("\t  font-weight: bold;\r\n");
      out.write("\t  color: white;\r\n");
      out.write("\t  text-align: center;\r\n");
      out.write("\t  text-shadow: 0 -1px rgba(0, 0, 0, 0.5);\r\n");
      out.write("\t  background: #576dce;\r\n");
      out.write("\t  background-clip: padding-box;\r\n");
      out.write("\t  border: 1px solid;\r\n");
      out.write("\t  border-color: #374fbb #344cb3 #2b3e94;\r\n");
      out.write("\t  border-radius: 2px;\r\n");
      out.write("\t  background-image: -webkit-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);\r\n");
      out.write("\t  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 2px rgba(0, 0, 0, 0.2);\r\n");
      out.write("\t}\r\n");
      out.write("\t.button:hover, .button.hover {\r\n");
      out.write("\t  background-color: #5f74d0;\r\n");
      out.write("\t  border-color: #2d429c #2d429c #253680;\r\n");
      out.write("\t  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 5px #576dce;\r\n");
      out.write("\t}\r\n");
      out.write("\t.button:active, .button.active {\r\n");
      out.write("\t  border-color: #253680 #2b3e94 #3147a8;\r\n");
      out.write("\t  background: #475fc9;\r\n");
      out.write("\t  box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.8);\r\n");
      out.write("\t}\r\n");
      out.write("\t/* .button:before {\r\n");
      out.write("\t  content: '';\r\n");
      out.write("\t  position: absolute;\r\n");
      out.write("\t  top: 9px;\r\n");
      out.write("\t  right: 12px;\r\n");
      out.write("\t  width: 17px;\r\n");
      out.write("\t  height: 17px;\r\n");
      out.write("\t  background: #374fbb;\r\n");
      out.write("\t  border-radius: 9px;\r\n");
      out.write("\t  -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.4), 0 1px rgba(255, 255, 255, 0.2);\r\n");
      out.write("\t  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.4), 0 1px rgba(255, 255, 255, 0.2);\r\n");
      out.write("\t} */\r\n");
      out.write("\t.button:after {\r\n");
      out.write("\t  content: '>';\r\n");
      out.write("\t  float: right;\r\n");
      out.write("\t  /* position: relative; */\r\n");
      out.write("\t  margin-left: 15px;\r\n");
      out.write("\t  font: bold 18px/33px 'Comic Sans MS';\r\n");
      out.write("\t  /* I tried everything but couldn't get the vertical alignment to be\r\n");
      out.write("\t     consistent in IE, so this is a hack targeting IE8-9-10. */\r\n");
      out.write("\t  line-height: 31px\\0;\r\n");
      out.write("\t  color: white;\r\n");
      out.write("\t  text-shadow: 0 -1px #8696dc, 0 1px 1px rgba(0, 0, 0, 0.3);\r\n");
      out.write("\t  -webkit-font-smoothing: subpixel-antialiased;\r\n");
      out.write("\t}\r\n");
      out.write("\t/*버튼끝*/\r\n");
      out.write("\t\r\n");
      out.write("\t/*페이지*/\r\n");
      out.write("\t.pagination {\r\n");
      out.write("\t    width: 625px;\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    text-align:center;\r\n");
      out.write("\t} \r\n");
      out.write("\t.btn {\r\n");
      out.write("\t    display: inline-block;\r\n");
      out.write("\t    padding: 10px;\r\n");
      out.write("\t    border-radius: 5px; /*optional*/\r\n");
      out.write("\t    color: #aaa;\r\n");
      out.write("\t    font-size: .875em;\r\n");
      out.write("\t}\r\n");
      out.write("\t.pagination {\r\n");
      out.write("\t    background: #f2f2f2;\r\n");
      out.write("\t    padding: 20px;\r\n");
      out.write("\t    margin-bottom: 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.page {\r\n");
      out.write("\t    display: inline-block;\r\n");
      out.write("\t    padding: 0px 9px;\r\n");
      out.write("\t    margin-right: 4px;\r\n");
      out.write("\t    border-radius: 3px;\r\n");
      out.write("\t    border: solid 1px #c0c0c0;\r\n");
      out.write("\t    background: #e9e9e9;\r\n");
      out.write("\t    box-shadow: inset 0px 1px 0px rgba(255,255,255, .8), 0px 1px 3px rgba(0,0,0, .1);\r\n");
      out.write("\t    font-size: .875em;\r\n");
      out.write("\t    font-weight: bold;\r\n");
      out.write("\t    text-decoration: none;\r\n");
      out.write("\t    color: #717171;\r\n");
      out.write("\t    text-shadow: 0px 1px 0px rgba(255,255,255, 1);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page:hover, .page.gradient:hover {\r\n");
      out.write("\t    background: #fefefe;\r\n");
      out.write("\t    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FEFEFE), to(#f0f0f0));\r\n");
      out.write("\t    background: -moz-linear-gradient(0% 0% 270deg,#FEFEFE, #f0f0f0);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.active {\r\n");
      out.write("\t    border: none;\r\n");
      out.write("\t    background: #616161;\r\n");
      out.write("\t    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .8);\r\n");
      out.write("\t    color: #f0f0f0;\r\n");
      out.write("\t    text-shadow: 0px 0px 3px rgba(0,0,0, .5);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.gradient {\r\n");
      out.write("\t    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#f8f8f8), to(#e9e9e9));\r\n");
      out.write("\t    background: -moz-linear-gradient(0% 0% 270deg,#f8f8f8, #e9e9e9);\r\n");
      out.write("\t}\r\n");
      out.write("\t.pagination.dark {\r\n");
      out.write("\t    background: #414449;\r\n");
      out.write("\t    color: #feffff;\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.dark {\r\n");
      out.write("\t    border: solid 1px #32373b;\r\n");
      out.write("\t    background: #3e4347;\r\n");
      out.write("\t    box-shadow: inset 0px 1px 1px rgba(255,255,255, .1), 0px 1px 3px rgba(0,0,0, .1);\r\n");
      out.write("\t    color: #feffff;\r\n");
      out.write("\t    text-shadow: 0px 1px 0px rgba(0,0,0, .5);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.dark:hover, .page.dark.gradient:hover {\r\n");
      out.write("\t    background: #3d4f5d;\r\n");
      out.write("\t    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#547085), to(#3d4f5d));\r\n");
      out.write("\t    background: -moz-linear-gradient(0% 0% 270deg,#547085, #3d4f5d);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.dark.active {\r\n");
      out.write("\t    border: none;\r\n");
      out.write("\t    background: #2f3237;\r\n");
      out.write("\t    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .1);\r\n");
      out.write("\t}\r\n");
      out.write("\t.page.dark.gradient {\r\n");
      out.write("\t    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#565b5f), to(#3e4347));\r\n");
      out.write("\t    background: -moz-linear-gradient(0% 0% 270deg,#565b5f, #3e4347);\r\n");
      out.write("\t}\r\n");
      out.write("\t/*페이지끝*/\r\n");
      out.write("    </style>\r\n");
      out.write("    <div id=\"teamDiv\">\r\n");
      out.write("    <div id=\"teamDiv2\">\r\n");
      out.write("    <select>\r\n");
      out.write("        <option value=\"서울시\">서울시</option>\r\n");
      out.write("        <option value=\"부산시\">부산시</option>\r\n");
      out.write("        <option value=\"경기도\">경기도</option>\r\n");
      out.write("        <option value=\"제주도\">제주도</option>\r\n");
      out.write("        <option value=\"전라남도\">전라남도</option>\r\n");
      out.write("        <option value=\"경상북도\">경상북도</option>\r\n");
      out.write("    </select>\r\n");
      out.write("\t<input type=\"text\" id=\"search\" />\r\n");
      out.write("\t<button class=\"button\">팀검색</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <!--ui object -->\r\n");
      out.write("    <table class=\"tbl_type\"  cellspacing=\"0\">\r\n");
      out.write("        <legend>◎팀리스트</legend>\r\n");
      out.write("    <colgroup>\r\n");
      out.write("        <col width=\"10%\"> \r\n");
      out.write("        <col width=\"25%\">\r\n");
      out.write("        <col width=\"10%\">\r\n");
      out.write("        <col width=\"10%\">\r\n");
      out.write("        <col width=\"10%\">\r\n");
      out.write("        <col width=\"10%\">\r\n");
      out.write("    </colgroup>\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th scope=\"col\">순번</th>\r\n");
      out.write("        <th scope=\"col\">팀명</th>\r\n");
      out.write("        <th scope=\"col\">지역</th>\r\n");
      out.write("        <th scope=\"col\">소속선수</th>\r\n");
      out.write("        <th scope=\"col\">창단일</th>\r\n");
      out.write("        <th scope=\"col\">경기수</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">1</td>\r\n");
      out.write("        <td>콜로라도</td>\r\n");
      out.write("        <td>서울</td>\r\n");
      out.write("        <td>90</td>\r\n");
      out.write("        <td>1991-05-01</td>\r\n");
      out.write("        <td>120</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">2</td>\r\n");
      out.write("        <td>샌디에이고</td>\r\n");
      out.write("        <td>부산</td>\r\n");
      out.write("        <td>24</td>\r\n");
      out.write("        <td>2007-05-01</td>\r\n");
      out.write("        <td>100</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">3</td>\r\n");
      out.write("        <td>뉴욕m</td>\r\n");
      out.write("        <td>경기도</td>\r\n");
      out.write("        <td>23</td>\r\n");
      out.write("        <td>2015-05-01</td>\r\n");
      out.write("        <td>23</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">4</td>\r\n");
      out.write("        <td>애틀랜타</td>\r\n");
      out.write("        <td>강원도</td>\r\n");
      out.write("        <td>5</td>\r\n");
      out.write("        <td>2008-05-01</td>\r\n");
      out.write("        <td>1</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">5</td>\r\n");
      out.write("        <td>밀워키</td>\r\n");
      out.write("        <td>전라남도</td>\r\n");
      out.write("        <td>83</td>\r\n");
      out.write("        <td>2002-02-02</td>\r\n");
      out.write("        <td>10</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td class=\"ranking\" scope=\"row\">6</td>\r\n");
      out.write("        <td>lad</td>\r\n");
      out.write("        <td>경상북도</td>\r\n");
      out.write("        <td>30</td>\r\n");
      out.write("        <td>2001-05-01</td>\r\n");
      out.write("        <td>30</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("    <tfoot>\r\n");
      out.write("        <tr>\r\n");
      out.write("        <td>종합</td>\r\n");
      out.write("        <td>총 팀수</td>\r\n");
      out.write("        <td>서울</td>\r\n");
      out.write("        <td colspan=\"3\">6개팀</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </tfoot>\r\n");
      out.write("    </table>\r\n");
      out.write("    <!--//ui object -->\r\n");
      out.write("    <!-- <div id=\"container\"> -->\r\n");
      out.write("    <div class=\"pagination\" >\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">first</a>\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">2</a>\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">3</a>\r\n");
      out.write("        <span class=\"page active\">4</span>\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">5</a>\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">6</a>\r\n");
      out.write("        <a href=\"#\" class=\"page gradient\">last</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- </div> -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    </section>\r\n");
      out.write("</section>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>팀명 : 투톱체제</p>\r\n");
      out.write("\t\t\t<p>팀원 : 김대연, 최지수, 박희영, 배성인, 이연경</p>\r\n");
      out.write("\t\t\t<p>주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
