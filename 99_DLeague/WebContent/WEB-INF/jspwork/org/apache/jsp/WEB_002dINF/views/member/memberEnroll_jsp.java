/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
<<<<<<< HEAD
 * Generated at: 2018-05-10 15:47:19 UTC
=======
<<<<<<< HEAD
 * Generated at: 2018-05-11 02:06:04 UTC
=======
 * Generated at: 2018-05-11 01:37:17 UTC
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;
import com.dleague.member.model.vo.*;
import com.dleague.region.model.vo.*;
import java.util.*;

public final class memberEnroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
<<<<<<< HEAD
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1525911796072L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525911796161L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525755067096L));
=======
<<<<<<< HEAD
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526004343137L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525997593444L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525739378072L));
=======
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526002466324L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1525997228621L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525925026858L));
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.dleague.member.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.dleague.region.model.vo");
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
      out.write("    ");
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
      out.write("\r\n");
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
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberEnroll\">회원가입</a></li>\r\n");
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
      out.print(param=="gameRegister"||param=="myGameList"?"header-selected":"");
      out.write("'>경기등록</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-register\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"main-nav-sub-ul\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\">경기등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/myGameList\">내팀경기일정</a></li>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/gameSearchList\">경기 검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li id=\"main-nav-mypage\" class=\"main-nav-list\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfoPage\" id='");
      out.print(param=="memberInfo"||param=="memberTeamInfo"?"header-selected":"");
      out.write("'>마이페이지</a>\r\n");
      out.write("\t\t\t\t\t\t<!-- 마이페이지 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main-nav-sub\" id=\"main-nav-sub-mypage\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfoPage\">내 정보</a></li>\r\n");
      out.write("<<<<<<< HEAD\n");
      out.write("\t\t\t\t\t\t\t\t");
if(memberLoggedIn!=null && memberLoggedIn.getUserId().equals("")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
if(memberLoggedIn.getUserId().equals("")) 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfoPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\">내 팀 정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("=======\n");
      out.write("\t\t\t\t\t\t\t\t ");
if(memberLoggedIn!=null) {
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfoPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" onclick=\"return fn_validate();\">내 팀 정보</a></li>\r\n");
      out.write(">>>>>>> branch 'master' of https://github.com/raccoon200/semi_project\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">내 팀 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t ");
} 
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t");
if(memberLoggedIn!=null&&"admin".equals(memberLoggedIn.getUserId())){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<li id=\"board\"><a href=\"#\">관리자페이지</a></li>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li id=\"admin\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/memberList\">회원관리</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"admin\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/memberList\">팀관리</a></li>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<!-- 메인메뉴 끝 -->\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<section id=\"center\">\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("    ");
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
if(param=="login" || param=="enroll") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\"></h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/loginPage\" id=id=");
      out.print(param=="login"?"nav-selected":"");
      out.write(">로그인</a></li>\r\n");
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
if(param=="gameRegister"||param=="myGameList") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 경기등록  -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">경기등록</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\" id='");
      out.print(param=="gameRegister"?"nav-selected":"");
      out.write("'>경기등록</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/myGameList\" id='");
      out.print(param=="myGameList"?"nav-selected":"");
      out.write("'>내팀경기일정</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="teamSearch"||param=="teamSearchList") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 검색 -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">검색</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" id='");
      out.print(param=="teamSearch"?"nav-selected":"");
      out.write("'>팀검색</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/gameSearchList\" id='");
      out.print(param=="teamSearchList"?"nav-selected":"");
      out.write("'>경기검색</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
if(param=="memberInfo" || param=="memberTeamInfo") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">마이페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfo\" id=\"");
      out.print(param=="memberInfo"?"nav-selected":"" );
      out.write("\" >내 정보</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfo\" id=\"");
      out.print(param=="memberTeamInfo"?"nav-selected":"" );
      out.write("\">내 팀 정보</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">내 팀 관리</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 관리자페이지 \r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">관리자페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회원 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 수락</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">접속 통계</a></li>\r\n");
      out.write("\t\t\t</ul>  -->\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<section id=\"content\">");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    Member m = (Member)request.getAttribute("member");
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");

    
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("    table{align:center;}\r\n");
      out.write("    #profileImg{width:150px; height:150px;} \r\n");
      out.write("#imgsection{position: relative; left:400px; top:-450px;}\r\n");
      out.write("    </style>\r\n");
      out.write("<script>\r\n");
      out.write("function fn_checkIdDuplicate(){\r\n");
      out.write("\tvar userId = $(\"#userId_\").val().trim();\r\n");
      out.write("\tif(userId.length<4){\r\n");
      out.write("\t\talert('아이디는 4글자 이상부터 가능합니다.');\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = \"");
      out.print(request.getContextPath());
      out.write("/member/checkIdDuplicate\";\r\n");
      out.write("\tvar title = \"checkIdDuplicate\";\r\n");
      out.write("\tvar status = \"left=350px, top=100px, width=300px, height=200px\";\r\n");
      out.write("\tvar popup = window.open(\"\",title,status);\r\n");
      out.write("\t\r\n");
      out.write("\tvar checkIdDuplicateFrm = document.checkIdDuplicateFrm;\r\n");
      out.write("\tcheckIdDuplicateFrm.userId.value=userId;\r\n");
      out.write("\t\r\n");
      out.write("\tcheckIdDuplicateFrm.target = title;\r\n");
      out.write("\tcheckIdDuplicateFrm.action = url;\r\n");
      out.write("\tcheckIdDuplicateFrm.submit();\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<section id = \"enroll-container\">\r\n");
      out.write("<h2>회원가입 정보입력</h2>\r\n");
      out.write("<form name=\"memberEnrollFrm\" action=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberEnrollEnd\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("<!-- onsubmit=\"return fn_enrollValidate(); -->\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>아이디</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"text\" name=\"userId\" id=\"userId_\" required/>\r\n");
      out.write("<input type=\"button\" value=\"아이디체크\"\r\n");
      out.write("id=\"btn-idValid\" onclick=\"fn_checkIdDuplicate()\"/>\r\n");
      out.write("<input type = \"hidden\" name=\"idValid\" value=\"0\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>비밀번호</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"password\" name=\"password\" id=\"password_\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>비밀번호 확인</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"password\" id=\"password_chk\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>이름</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"text\" name=\"userName\" id=\"userName\"/>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<!-- <th>Photo</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"file\" name=\"photo\" id=\"photo\"/>\r\n");
      out.write(" </td>\r\n");
      out.write(" </tr> -->\r\n");
      out.write(" \r\n");
      out.write("<tr>\r\n");
      out.write("<th>생년월일</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"date\" name=\"birthday\" id=\"birthday\"/>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>휴대폰</th>\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"tel\" id=\"phone\" name=\"phone\"\r\n");
      out.write("placeholder=\"(-없이)01012345678\" maxlength=\"11\"/>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>이메일</th>\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"text\" name=\"email\"  id=\"email_\" >@\r\n");
      out.write("<input type=\"text\" name = \"email\" id=\"email_1\" disabled value=\"naver.com\">\r\n");
      out.write("<select name=\"selectEmail\" id=\"selectEmail\">\r\n");
      out.write("<option value=\"1\">직접입력</option>\r\n");
      out.write("\r\n");
      out.write("<option value=\"naver.com\" selected>naver.com</option>\r\n");
      out.write("<option value=\"daum.net\">daum.net</option>\r\n");
      out.write("<option value=\"hotmail.com\">hotmail.com</option>\r\n");
      out.write("<option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("<script>\r\n");
      out.write("//자동완성 함수\r\n");
      out.write("$(\"#selectEmail\").change(function() {\r\n");
      out.write("\t$(\"#selectEmail option:selected\").each(function() {\r\n");
      out.write("\t\tif($(this).val() =='1') {\r\n");
      out.write("\t\t\t$(\"#email_1\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#email_1\").attr(\"disabled\",false);\r\n");
      out.write("\t\t\t}else {\r\n");
      out.write("\t\t\t\t$(\"#email_1\").val($(this).text());\r\n");
      out.write("\t\t\t\t$(\"#email_1\").attr(\"disabled\",true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>거주지역</th>   \r\n");
      out.write("<td>\r\n");
      out.write("\t\t\t\t<select name=\"regioncode\" id=\"\">\r\n");
      out.write("\t\t\t\t");
if(regionList!=null && !regionList.isEmpty()){
				for(int i=0; i<regionList.size(); i++) {
					Region region = regionList.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(region.getRegionCode());
      out.write('"');
      out.write('>');
      out.print( region.getRegionName());
      out.write("</option>\r\n");
      out.write("\t\t\t\t");

					}
				} 
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>프로필</th>\r\n");
      out.write("<td>\r\n");
      out.write("<textarea id=\"profile\" name=\"profile\" maxlength=\"2048\" style=\"height:180px;\"></textarea>\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"submit\" value=\"가입\" />\r\n");
      out.write("<input type=\"reset\" value=\"취소\" />\r\n");
      out.write(" <section id=\"imgsection\">\r\n");
      out.write("<input type=\"image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/profile/default.jpg\" id=\"profileImg\"/>\r\n");
      out.write("<br /> \r\n");
      out.write("<div style=\"position:relative;\">\r\n");
      out.write("<input type=\"file\" name=\"up_file\" id=\"up_file\" accept=\".gif, .jpg, .png\" onchange=\"fn_fileUpload(this);\" />\r\n");
      out.write("<!-- <span id=\"fname\">프로필 사진 변경</span>\r\n");
      out.write(" --></div>\r\n");
      out.write("</section>\r\n");
      out.write("</form>\r\n");
      out.write("<form name=\"checkIdDuplicateFrm\" method=\"post\">\r\n");
      out.write("<input type=\"hidden\" name=\"userId\"/>\r\n");
      out.write("</form>\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("$(function (){\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("$(\"[name=up_file]\").change(function(){ \r\n");
      out.write("\t//$(this).val()은 선택한 파일명임.\r\n");
      out.write("\tif($(this).val()==\"\"){\r\n");
      out.write("\t\t$(\"#fname\").show();\r\n");
      out.write("\t}\t\r\n");
      out.write("\telse{\r\n");
      out.write("\t\t$(\"#fname\").hide();\r\n");
      out.write("\t}\r\n");
      out.write("});\t\r\n");
      out.write("function fn_fileUpload(value){\r\n");
      out.write("\t if(value.files && value.files[0]) {\r\n");
      out.write("        var reader = new FileReader();\r\n");
      out.write("        reader.onload = function (e) {\r\n");
      out.write("             $('#profileImg').attr('src', e.target.result);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        }\r\n");
      out.write("        reader.readAsDataURL(value.files[0]);\r\n");
      out.write("\t}\r\n");
      out.write("</script> \r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
