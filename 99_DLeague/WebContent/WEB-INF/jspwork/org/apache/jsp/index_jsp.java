/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-14 00:41:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;
import com.dleague.member.model.vo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526257179181L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1526197279649L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525739390861L));
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
      out.write("div#container   {width:960px; margin:0 auto;}\r\n");
      out.write("\r\n");
      out.write("/*header*/\r\n");
      out.write("\r\n");
      out.write("header#header         { height:120px; position:relative; padding:10px 0 0 0;}\r\n");
      out.write("header#header h1       {margin-left:10px;}\r\n");
      out.write("\r\n");
      out.write("header#header nav {\r\n");
      out.write("    \r\n");
      out.write("   width:100%; \r\n");
      out.write("   margin-top:15px;\r\n");
      out.write("   position:relative;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav {\r\n");
      out.write("   display:table;\r\n");
      out.write("   padding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("   margin:auto;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav > li.main-nav-list{\r\n");
      out.write("   list-style-type:none;\r\n");
      out.write("   width:8em;\r\n");
      out.write("   height:2em;\r\n");
      out.write("   float:left;\r\n");
      out.write("   padding-left:15px;\r\n");
      out.write("   padding-right:15px;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   font-size:1.2em;\r\n");
      out.write("   background-color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.main-nav > li.main-nav-list > a{\r\n");
      out.write("   display:block;\r\n");
      out.write("   padding:.5em;\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   color:#292929;\r\n");
      out.write("}\r\n");
      out.write("ul.main-nav > li.main-nav-list:hover{border-radius:5px;}\r\n");
      out.write("\r\n");
      out.write("div#header-div{\r\n");
      out.write("   display:block;\r\n");
      out.write("   height:50px;\r\n");
      out.write("}\r\n");
      out.write("img#header-image {\r\n");
      out.write("   padding-left:10px;\r\n");
      out.write("   width:180px;\r\n");
      out.write("   height:60px;\r\n");
      out.write("   float:left;\r\n");
      out.write("   display:inline;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list {\r\n");
      out.write("   display:block;\r\n");
      out.write("   float:right;\r\n");
      out.write("   display:table;\r\n");
      out.write("   padding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("   margin:auto;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li{\r\n");
      out.write("   display:inline;\r\n");
      out.write("   list-style-type:none;\r\n");
      out.write("   padding:10px;\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li a{\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   color:gray;\r\n");
      out.write("}\r\n");
      out.write("ul#header-list li a:hover{\r\n");
      out.write("   color:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.main-nav-sub > ul{\r\n");
      out.write("   background:rgb(245,245,245);\r\n");
      out.write("   padding:0px;\r\n");
      out.write("   border-radius:5px;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li{\r\n");
      out.write("   list-style-type:none;\r\n");
      out.write("   display:inline-block;\r\n");
      out.write("   padding:2px;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li > a{\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   font-size:16px;\r\n");
      out.write("   color:rgb(100,100,100);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub > ul > li> a:hover{\r\n");
      out.write("   color:black;\r\n");
      out.write("}\r\n");
      out.write("div.main-nav-sub {\r\n");
      out.write("   position:absolute;\r\n");
      out.write("   top:40px;\r\n");
      out.write("   padding:1px;\r\n");
      out.write("   display:none;\r\n");
      out.write("   \r\n");
      out.write("}\n");
      out.write("div#main-nav-sub-boardss{\r\n");
      out.write("   left:180px;\r\n");
      out.write("\tleft:180px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-register{\r\n");
      out.write("   left:400px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-search{\r\n");
      out.write("   left:600px;\r\n");
      out.write("}\r\n");
      out.write("div#main-nav-sub-mypage{\r\n");
      out.write("   left:730px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/*section-center*/\r\n");
      out.write("section#center{\r\n");
      out.write("   height:700px;\r\n");
      out.write("   overflow:hidden;\r\n");
      out.write("   height:auto;\r\n");
      out.write("   background:rgb(64,128,183);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("/*content*/\r\n");
      out.write("section#content{\r\n");
      out.write("   display:inline-block;\r\n");
      out.write("   margin:2px;\r\n");
      out.write("   width:750px;\r\n");
      out.write("   background:white;\r\n");
      out.write("   border:1px solid rgb(245,245,245);\r\n");
      out.write("   border-radius: 4px;\r\n");
      out.write("   padding-left:10px;\r\n");
      out.write("   \r\n");
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
      out.write("   padding:0px;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li{\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   padding-top:10px;\r\n");
      out.write("   color:gray;\r\n");
      out.write("   font-size:1.2em;\r\n");
      out.write("   list-style-type:none;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav#nav ul.nav-list li a{\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   color:gray;\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li a:hover{\r\n");
      out.write("\r\n");
      out.write("   color:black;\r\n");
      out.write("}\r\n");
      out.write("nav#nav h2#nav-header{\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("   padding:0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*footer*/\r\n");
      out.write("footer#footer{\r\n");
      out.write("   background:rgb(240,240,240);\r\n");
      out.write("   padding:5px;\r\n");
      out.write("   display:block;\r\n");
      out.write("}\r\n");
      out.write("footer#footer p {\r\n");
      out.write("   font-family:\"휴먼모음T\", sans-serif;\r\n");
      out.write("   color:gray;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("   font-size:0.7em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*effect*/\r\n");
      out.write("ul.main-nav > li.main-nav-list a#header-selected {\r\n");
      out.write("   color:rgb(64,128,183);\r\n");
      out.write("}\r\n");
      out.write("nav#nav ul.nav-list li a#nav-selected{\r\n");
      out.write("   color:black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("$(function() {\r\n");
      out.write("   $(\".main-nav-list\").hover(function() {\r\n");
      out.write("      $(this).children(\"div\").show();\r\n");
      out.write("      $(this).children(\"a\").css(\"color\",\"rgb(64,128,183)\")\r\n");
      out.write("   }, function() {\r\n");
      out.write("      $(this).children(\"div\").hide();\r\n");
      out.write("      \r\n");
      out.write("      if($(this).children(\"a\").attr(\"id\")==\"header-selected\"){\r\n");
      out.write("         $(this).children(\"a\").css(\"color\",\"rgb(64,128,183)\");\r\n");
      out.write("      }else {\r\n");
      out.write("         $(this).children(\"a\").css(\"color\",\"black\");\r\n");
      out.write("      }\r\n");
      out.write("   })\r\n");
      out.write("\r\n");
      out.write("<<<<<<< HEAD\n");
      out.write("});\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("=======\n");
      out.write("});\n");
      out.write(">>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git\n");
if(memberLoggedIn!=null) { 
      out.write(" \n");
      out.write("<<<<<<< HEAD\n");
      out.write("\r\n");
      out.write("   function fn_validate_team_info() {\r\n");
      out.write("\n");
      out.write("=======\n");
      out.write("   function fn_validate_team_info() {\n");
      out.write(">>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git\n");
      out.write("      if(");
      out.print(memberLoggedIn.getTeamname());
      out.write("!=null) {\r\n");
      out.write("         return true;   \r\n");
      out.write("      }\r\n");
      out.write("      if(confirm(\"팀이 없습니다. 팀 생성 하시겠습니까??\")) location.href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberTeamCreate\";\r\n");
      out.write("<<<<<<< HEAD\n");
      out.write("      return false;\r\n");
      out.write("\n");
      out.write("=======\n");
      out.write("      return false;\n");
      out.write(">>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git\n");
      out.write("   }\n");
      out.write("<<<<<<< HEAD\n");
      out.write("\n");
      out.write("=======\n");
      out.write(">>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git\n");
} 
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div id=\"container\">\r\n");
      out.write("      <header id=\"header\">\r\n");
      out.write("         <div id=\"header-div\">\r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath() );
      out.write("/\"><img id=\"header-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.jpg\" /></a>\r\n");
      out.write("         <ul id=\"header-list\">\r\n");
      out.write("            ");
if(memberLoggedIn==null) {
      out.write("\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberEnroll\">회원가입</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/loginPage\">로그인</a></li>\r\n");
      out.write("            ");
} else { 
      out.write("\r\n");
      out.write("               <li>");
      out.print(memberLoggedIn.getUserId() );
      out.write("님 환영합니다!</li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminPage\">관리자페이지</a></li>\r\n");
      out.write("               \r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("         </ul>\r\n");
      out.write("         \r\n");
      out.write("         </div>\r\n");
      out.write("         <nav>\r\n");
      out.write("            <ul class=\"main-nav\">\r\n");
      out.write("               <li id=\"main-nav-notice\" class=\"main-nav-list\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("               <li id=\"main-nav-board\" class=\"main-nav-list\"><a href=\"#\" id='");
      out.print(param=="freeBoard"||param=="regionBoard"||param=="complainBoard"?"header-selected":"");
      out.write("'>게시판</a>\r\n");
      out.write("                  <!-- 게시판 -->\r\n");
      out.write("                  <div class=\"main-nav-sub\" id=\"main-nav-sub-board\">\r\n");
      out.write("                     <ul class=\"main-nav-sub-ul\">\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\" >자유게시판</a></li>\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/regionBoard\" >지역게시판</a></li>\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/complainBoard\">신고게시판</a></li>\r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </li>\r\n");
      out.write("               <li id=\"main-nav-register\" class='main-nav-list'><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\" id='");
      out.print(param=="gameRegister"||param=="myGameList"?"header-selected":"");
      out.write("'>경기등록</a>\r\n");
      out.write("                  <!-- 경기등록  -->\r\n");
      out.write("                  <div class=\"main-nav-sub\" id=\"main-nav-sub-register\">\r\n");
      out.write("                     <ul class=\"main-nav-sub-ul\">\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/gameRegister\">경기등록</a></li>\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/game/myGameList\">내팀경기일정</a></li>\r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </li>\r\n");
      out.write("               <li id=\"main-nav-search\" class=\"main-nav-list\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" id='");
      out.print(param=="teamSearch"?"header-selected":"");
      out.write("'>검색</a>\r\n");
      out.write("                  <!-- 검색 -->\r\n");
      out.write("                  <div class=\"main-nav-sub\" id=\"main-nav-sub-search\">\r\n");
      out.write("                     <ul class=\"main-nav-sub-ul\">\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/teamSearch\" >팀 검색</a></li>\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/search/gameSearchList\">경기 검색</a></li>\r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </li>\r\n");
      out.write("               <li id=\"main-nav-mypage\" class=\"main-nav-list\"><a href=\"");
      out.write("\" id='");
      out.print(param=="memberInfo"||param=="memberTeamInfo"?"header-selected":"");
      out.write("'>마이페이지</a>\r\n");
      out.write("                  <!-- 마이페이지 -->\r\n");
      out.write("                  <div class=\"main-nav-sub\" id=\"main-nav-sub-mypage\">\r\n");
      out.write("                     <ul class=\"nav-list\">\r\n");
      out.write("                         ");
if(memberLoggedIn!=null) {
      out.write(" \r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfoPage\">내 정보</a></li>\r\n");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfoPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" onclick=\"return fn_validate_team_info();\">내 팀 정보</a></li>\r\n");
      out.write("\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberTeamManagementPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("&userId=");
      out.print(memberLoggedIn.getUserId());
      out.write("\">내 팀 관리</a></li>\r\n");
      out.write("                         ");
} 
      out.write(" \r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </li>\r\n");
      out.write("               \r\n");
      out.write("               ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("            \r\n");
      out.write("         </nav>\r\n");
      out.write("         <!-- 메인메뉴 끝 -->\r\n");
      out.write("      </header>\r\n");
      out.write("\n");
      out.write("      <section id=\"center\">\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
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
 if(param=="freeBoard" || param=="regionBoard" || param=="complainBoard") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">게시판</h2>\r\n");
      out.write("\t\t\t<hr style=\"border:0;height:2px;background: rgb(244,244,244);\"/>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a id='");
      out.print(param=="freeBoard"?"nav-selected":"");
      out.write("' href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\">자유게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a id='");
      out.print(param=="regionBoard"?"nav-selected":"");
      out.write("' href=\"");
      out.print(request.getContextPath() );
      out.write("/board/regionBoard\">지역게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a id='");
      out.print(param=="complainBoard"?"nav-selected":"");
      out.write("' href=\"");
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
if(param=="memberInfo" || param=="memberTeamInfo" || param=="memberTeamManagement") {
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
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamManagementPage?teamName=\"");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" id=\"");
      out.print(param=="memberTeamManagement"?"nav-selected":"" );
      out.write("\">내 팀 관리</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="adminPage" || param=="adminPage") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 관리자페이지 -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">관리자페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/adminPage\" id=\"");
      out.print(param=="adminPage"?"nav-selected":"" );
      out.write("\" >회원 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 수락</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">접속 통계</a></li>\r\n");
      out.write("\t\t\t</ul>  \r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<section id=\"content\">");
      out.write("\r\n");
      out.write("DLeague1\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("dfsf\r\n");
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
