/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-08 14:31:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.game;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;

public final class gameRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1525789833988L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525789833988L));
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	String param = (String)request.getAttribute("param");

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
      out.write("\twidth:750px;\r\n");
      out.write("\tbackground:white;\r\n");
      out.write("\tborder:1px solid rgb(245,245,245);\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("\tpadding-left:10px;\r\n");
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
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/\"><img id=\"header-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.jpg\" /></a>\r\n");
      out.write("\t\t\t<ul id=\"header-list\">\r\n");
      out.write("\t\t\t\t");
if(memberLoggedIn==null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/loginPage\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\t<!-- <li><a href=\"#\">관리자페이지</a></li> -->\r\n");
      out.write("\t\t\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<li>");
      out.print(memberLoggedIn.getUserId() );
      out.write("님 환영합니다!</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
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
      out.write("\t\t\t\t\t<li id=\"main-nav-register\" class='main-nav-list'><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\" id='");
      out.print(param=="gameRegister"?"header-selected":"");
      out.write("'>경기등록</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-register\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\">경기등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">내팀경기일정</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-search\" class=\"main-nav-list\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" id='");
      out.print(param=="teamSearch"?"header-selected":"");
      out.write("'>검색</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 검색 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-search\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" >팀 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"#\">경기 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-mypage\" class=\"main-nav-list\"><a href=\"#\">마이페이지</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 마이페이지 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-mypage\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/member/memberInfo\">내 정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">내 팀 정보</a></li>\r\n");
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
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("console.log(\"");
      out.print(param);
      out.write("\");\r\n");
      out.write("</script>\r\n");
      out.write("\t\t\t<nav id=\"nav\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 공지사항 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">공지사항</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t\t\t</ul> --> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 게시판 -->\r\n");
      out.write("\t\t\t");
 if(param=="board") {
      out.write("\r\n");
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
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<!-- 로그인/회원가입 -->\r\n");
      out.write("\t\t\t");
if(param=="login") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\"></h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/loginPage\" id=\"nav-selected\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" id=");
      out.print(param=="enroll"?"nav-selected":"");
      out.write(">회원가입</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="passwordCheck") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id = \"nav-header\">비밀번호 찾기</h2>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="passwordUpdate") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">비밀번호 변경</h2>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="gameRegister") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">경기등록</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\" id='");
      out.print(param=="gameRegister"?"nav-selected":"");
      out.write("'>경기등록</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내팀경기일정</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="teamSearch") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 검색 -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">검색</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" id='");
      out.print(param=="teamSearch"?"nav-selected":"");
      out.write("'>팀검색</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">경기검색</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<!--\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/css/material.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/css/bootstrap-material-datetimepicker.css\" />\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/js/material.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/js/moment-with-locales.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/pretty_date_time_picker/js/bootstrap-material-datetimepicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://openapi.map.naver.com/openapi/v3/maps.js?clientId=f3nKBZeo1DvNZrIIPMNu&submodules=geocoder\"></script>\r\n");
if(memberLoggedIn == null){ 
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\talert(\"로그인이 필요한 서비스 입니다.\\n\\n로그인을 해주새요.\");\r\n");
      out.write("\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
} else if(memberLoggedIn.getTeamname() == null){
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\talert(\"팀이 필요한 서비스입니다.\\n\\n팀을 생성하거나 팀가입을 해주세요.\");\r\n");
      out.write("\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
} 
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$('#date-format').bootstrapMaterialDatePicker\r\n");
      out.write("\t({\r\n");
      out.write("\t\tformat: 'YYYY년 MM월 DD일 ddd - HH:mm'\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("//opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. (\"팝업API 호출 소스\"도 동일하게 적용시켜야 합니다.)\r\n");
      out.write("//document.domain = \"abc.go.kr\";\r\n");
      out.write("\r\n");
      out.write("function goPopup(){\r\n");
      out.write("\t// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.\r\n");
      out.write("  var pop = window.open(\"");
      out.print(request.getContextPath());
      out.write("/jusoPopup.jsp\",\"pop\",\"width=570,height=420, scrollbars=yes, resizable=yes\"); \r\n");
      out.write("  \r\n");
      out.write("\t// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.\r\n");
      out.write("  //var pop = window.open(\"/popup/jusoPopup.jsp\",\"pop\",\"scrollbars=yes, resizable=yes\"); \r\n");
      out.write("}\r\n");
      out.write("/** API 서비스 제공항목 확대 (2017.02) **/\r\n");
      out.write("function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn\r\n");
      out.write("\t\t\t\t\t\t, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){\r\n");
      out.write("\t// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.\r\n");
      out.write("\tdocument.form.roadAddrPart1.value = roadAddrPart1;\r\n");
      out.write("\tdocument.form.roadAddrPart2.value = roadAddrPart2;\r\n");
      out.write("\tdocument.form.addrDetail.value = addrDetail;\r\n");
      out.write("\tdocument.form.zipNo.value = zipNo;\r\n");
      out.write("\tsearchAddressToCoordinate(roadAddrPart1);\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<h2>경기 등록</h2>\r\n");
      out.write("<form name=\"form\" id=\"form\" action=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegisterEnd\" method=\"post\" onsubmit=\"return fn_Validate();\">\r\n");
      out.write("\t<div class=\"row col-md-6\">\r\n");
      out.write("\t\t<h4>날짜 및 시간 선택</h4>\r\n");
      out.write("\t\t<input type=\"text\" name=\"date\" id=\"date-format\" value=\"\" class=\"form-control floating-label\" placeholder=\"날짜와 시간을 입력하세요.\" style=\"width: 250px;\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br style=\"clear:both;\"/>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<h4>경기 장소</h4>\r\n");
      out.write("\t<table >\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t\t\t<col style=\"width:20%\"><col>\r\n");
      out.write("\t\t</colgroup>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>우편번호</th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t    <input type=\"hidden\" id=\"confmKey\" name=\"confmKey\" value=\"\"  >\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"zipNo\" class=\"form-control floating-label\" name=\"zipNo\" readonly style=\"width:100px; display: inline-block;\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"btn btn-primary btn-sm\" value=\"주소검색\" onclick=\"goPopup();\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id = \"point_x\" name = \"point_x\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id = \"point_y\" name = \"point_y\" value=\"\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th><label>도로명주소</label></th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"gamePlace\" class=\"form-control floating-label\" id=\"roadAddrPart1\" readonly style=\"width:100%\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상세주소</th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"addrDetail\" class=\"form-control floating-label\" readonly style=\"width:45%; display: inline-block;\" value=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"roadAddrPart2\" class=\"form-control floating-label\" readonly style=\"width:45%; display: inline-block; font-size: 10px;\" value=\"\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<div id=\"map\" style=\"width:90%;height:350px;\"></div>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<h4>경기 내용</h4>\r\n");
      out.write("\t<textarea name=\"game_content\" id=\"game_content\" class=\"form-control\" cols=\"50\" rows=\"5\" placeholder=\"경기내용을 입력하세요.\"></textarea>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<input type=\"submit\" class=\"btn btn-primary btn-sm\" value=\"등록\"/>\r\n");
      out.write("\t<input type=\"reset\" class=\"btn btn-primary btn-sm\" value=\"취소\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("var map = new naver.maps.Map(\"map\", {\r\n");
      out.write("    center: new naver.maps.LatLng(126.8319882,37.3068984),\r\n");
      out.write("    zoom: 10,\r\n");
      out.write("    mapTypeControl: true\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var infoWindow = new naver.maps.InfoWindow({\r\n");
      out.write("    anchorSkew: true\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("map.setCursor('grap');\r\n");
      out.write("\r\n");
      out.write("function searchCoordinateToAddress(latlng) {\r\n");
      out.write("    var tm128 = naver.maps.TransCoord.fromLatLngToTM128(latlng);\r\n");
      out.write("\r\n");
      out.write("    infoWindow.close();\r\n");
      out.write("\r\n");
      out.write("    naver.maps.Service.reverseGeocode({\r\n");
      out.write("        location: tm128,\r\n");
      out.write("        coordType: naver.maps.Service.CoordType.TM128\r\n");
      out.write("    }, function(status, response) {\r\n");
      out.write("        if (status === naver.maps.Service.Status.ERROR) {\r\n");
      out.write("            return alert('Something Wrong!');\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var items = response.result.items,\r\n");
      out.write("            htmlAddresses = [];\r\n");
      out.write("\r\n");
      out.write("        for (var i=0, ii=items.length, item, addrType; i<ii; i++) {\r\n");
      out.write("            item = items[i];\r\n");
      out.write("            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]';\r\n");
      out.write("\r\n");
      out.write("            htmlAddresses.push((i+1) +'. '+ addrType +' '+ item.address);\r\n");
      out.write("            htmlAddresses.push('&nbsp&nbsp&nbsp -> '+ item.point.x +','+ item.point.y);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        infoWindow.setContent([\r\n");
      out.write("                '<div style=\"padding:10px;min-width:200px;line-height:150%;\">',\r\n");
      out.write("                '<h4 style=\"margin-top:5px;\">검색 좌표 : '+ response.result.userquery +'</h4><br />',\r\n");
      out.write("                htmlAddresses.join('<br />'),\r\n");
      out.write("                '</div>'\r\n");
      out.write("            ].join('\\n'));\r\n");
      out.write("\t\t\r\n");
      out.write("        infoWindow.open(map, latlng);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function searchAddressToCoordinate(address) {\r\n");
      out.write("    naver.maps.Service.geocode({\r\n");
      out.write("        address: address\r\n");
      out.write("    }, function(status, response) {\r\n");
      out.write("        if (status === naver.maps.Service.Status.ERROR) {\r\n");
      out.write("            return alert('Something Wrong!');\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var item = response.result.items[0],\r\n");
      out.write("            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]',\r\n");
      out.write("            point = new naver.maps.Point(item.point.x, item.point.y);\r\n");
      out.write("\r\n");
      out.write("        infoWindow.setContent([\r\n");
      out.write("                '<div style=\"padding:10px;min-width:200px;line-height:150%;\">',\r\n");
      out.write("                '<h4 style=\"margin-top:5px;\">검색 주소 : '+ response.result.userquery +'</h4><br />',\r\n");
      out.write("                addrType +' '+ item.address +'<br />',\r\n");
      out.write("                '<a href=\"https://map.naver.com/?eX='+point.x+'&eY='+point.y+'&eText='+item.address+'&sY=&sText=\" target=\"_blank\">길찾기</a></br>',\r\n");
      out.write("                '</div>'\r\n");
      out.write("            ].join('\\n'));\r\n");
      out.write("\t\tdocument.form.point_x.value = point.x;\r\n");
      out.write("\t\tdocument.form.point_y.value = point.y;\r\n");
      out.write("\r\n");
      out.write("        map.setCenter(point);\r\n");
      out.write("        infoWindow.open(map, point);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function initGeocoder() {\r\n");
      out.write("    searchAddressToCoordinate('광덕동로 25');\r\n");
      out.write("}\r\n");
      out.write("naver.maps.onJSContentLoaded = initGeocoder;\r\n");
      out.write("\r\n");
      out.write("function fn_Validate () {\r\n");
      out.write("\tif($(\"#date-format\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"시간을 입력해주세요.\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif($(\"#zipNo\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"경기 장소를 입력해주세요.\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif($(\"#game_content\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"경기 내용을 입력해주세요.\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
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
