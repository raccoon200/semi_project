/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-15 12:28:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;
import com.dleague.member.model.vo.*;
import com.dleague.board.model.vo.*;
import java.util.*;
import com.dleague.member.model.service.*;

public final class complainBoardForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526380599489L));
    _jspx_dependants.put("/WEB-INF/views/common/nav.jsp", Long.valueOf(1526387219183L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1526380612202L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("com.dleague.board.model.vo");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.dleague.member.model.service");
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
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic\" rel=\"stylesheet\">\r\n");
      out.write("<title>DLeague</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\theader#header{ \r\n");
      out.write("\t    width: 100%;\r\n");
      out.write("\t    height:119px; \r\n");
      out.write("\t    padding:10px 0 0 0;\r\n");
      out.write("\t    background: white;\r\n");
      out.write("\t    position: fixed;\r\n");
      out.write("\t    top: 0px;\r\n");
      out.write("\t    left: 0px;\r\n");
      out.write("\t    border-bottom: 1px solid #f3f3f3;\r\n");
      out.write("\t    z-index: 150;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#header-div{\r\n");
      out.write("\t    display:block;\r\n");
      out.write("\t    width: 100%;\r\n");
      out.write("\t    height:41px;\r\n");
      out.write("\t    background: #f3f3f3;\r\n");
      out.write("\t    position: fixed;\r\n");
      out.write("\t    top: 0px;\r\n");
      out.write("\t    left: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv.header-div-wrap{\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    width: 960px;\r\n");
      out.write("\t    height: 41px;\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    background: #f3f3f3;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv.header-div-wrapping-nav{\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    width: 960px;\r\n");
      out.write("\t    height: 77px;\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    background: white;\r\n");
      out.write("\t    top: 31px;\r\n");
      out.write("\t}\r\n");
      out.write("\timg#header-image{\r\n");
      out.write("\t    height: 77px;\r\n");
      out.write("\t}\r\n");
      out.write("\theader#header nav{\r\n");
      out.write("\t    float: right;\r\n");
      out.write("\t}\r\n");
      out.write("\tul.main-nav{\r\n");
      out.write("\t    display:table;\r\n");
      out.write("\t    padding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("\t    margin-top: 23px;\r\n");
      out.write("\t    margin-bottom: 0px;\r\n");
      out.write("\t    vertical-align: baseline;\r\n");
      out.write("\t    list-style: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t.main-nav-list{\r\n");
      out.write("\t    float: left;\r\n");
      out.write("\t    padding-top: 7px;\r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-list:hover{\r\n");
      out.write("\t    border-bottom: 3px solid rgb(64,128,183); \r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-list:hover>div{\r\n");
      out.write("\t    border-top: 3px solid rgb(64,128,183); \r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-list:hover>a{\r\n");
      out.write("\t    color: rgb(64,128,183); \r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-list:hover div.main-nav-sub{\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t}\r\n");
      out.write("\t.main-nav-list>a{\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t    padding: 0 0 19px;\r\n");
      out.write("\t    margin: 0 35px;\r\n");
      out.write("\t    font-size: 20px;\r\n");
      out.write("\t    color: #121212;\r\n");
      out.write("\t    font-family: 'Do Hyeon', sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("\t.main-nav-list>a:link{\r\n");
      out.write("\t    text-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\tul#header-list {\r\n");
      out.write("\t    display:block;\r\n");
      out.write("\t    float:right;\r\n");
      out.write("\t    display:table;\r\n");
      out.write("\t    padding:0px; /*ul태그가 가진 기본padding초기화*/\r\n");
      out.write("\t    margin:auto;\r\n");
      out.write("\t    margin-top: 7px;\r\n");
      out.write("\t}\r\n");
      out.write("\tul#header-list li{\r\n");
      out.write("\t    display:inline;\r\n");
      out.write("\t    list-style-type:none;\r\n");
      out.write("\t    padding:10px;\r\n");
      out.write("\t    font-size: 11px;\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("\tul#header-list li a{\r\n");
      out.write("\t    text-decoration:none;\r\n");
      out.write("\t    font-size: 9px;\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t    color:black;\r\n");
      out.write("\t}\r\n");
      out.write("\t.main-nav-sub-li{\r\n");
      out.write("\t    list-style-type:none;\r\n");
      out.write("\t    text-align: center;\r\n");
      out.write("\t    padding-bottom: 10px;\r\n");
      out.write("\t    padding-top: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.main-nav-sub-ul{\r\n");
      out.write("\t    padding: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv.main-nav-sub{\r\n");
      out.write("\t    border: 1px solid rgb(64,128,183);\r\n");
      out.write("\t    display: none;\r\n");
      out.write("\t    background: white;\r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-sub-li a{\r\n");
      out.write("\t    text-decoration:none;\r\n");
      out.write("\t    font-size: 15px;\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t    color:black;\r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-sub-li:hover{\r\n");
      out.write("\t    background: rgb(64,128,183);\r\n");
      out.write("\t}\r\n");
      out.write("\tli.main-nav-sub-li:hover>a{\r\n");
      out.write("\t    color: white;\r\n");
      out.write("\t}\r\n");
      out.write("\t/*section-center*/\r\n");
      out.write("\tsection#center{\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    width: 960px;\r\n");
      out.write("\t    min-height: 960px;\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    padding-top: 168px;\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\tnav#nav{\r\n");
      out.write("\t    float: left;\r\n");
      out.write("\t    width: 175px;\r\n");
      out.write("\t    padding: 12px 0 0 14px;\r\n");
      out.write("\t    margin-right: 45px;\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t    position: fixed;\r\n");
      out.write("\t}\r\n");
      out.write("\th3#nav-header{\r\n");
      out.write("\t    font-size: 23px;\r\n");
      out.write("\t    width: 115px;\r\n");
      out.write("\t    margin: 0 0 30px 15px;\r\n");
      out.write("\t    padding-bottom: 25px;\r\n");
      out.write("\t    border-bottom: 4px solid rgb(64,128,183);\r\n");
      out.write("\t    color: #111;\r\n");
      out.write("\t    line-height: 1.3;\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t    font-weight: bold;\r\n");
      out.write("\t}\r\n");
      out.write("\tul.nav-list{\r\n");
      out.write("\t    margin-left: 15px;\r\n");
      out.write("\t    list-style: none;\r\n");
      out.write("\t    margin: 0;\r\n");
      out.write("\t    margin-left: 15px; \r\n");
      out.write("\t    padding: 0;\r\n");
      out.write("\t    border: 0;\r\n");
      out.write("\t    font: inherit;\r\n");
      out.write("\t    vertical-align: baseline;\r\n");
      out.write("\t}\r\n");
      out.write("\tul.nav-list li{\r\n");
      out.write("\t    padding: 0;\r\n");
      out.write("\t    margin-bottom: 15px;\r\n");
      out.write("\t}\r\n");
      out.write("\tul.nav-list li>a{\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t    font-size: 17px;\r\n");
      out.write("\t    color: #7c7c7c;\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t    text-decoration:none;\r\n");
      out.write("\t}\r\n");
      out.write("\ta#nav-selected{\r\n");
      out.write("\t    color: rgb(64,128,183);\r\n");
      out.write("\t    font-weight: bolder;\r\n");
      out.write("\t}\r\n");
      out.write("\tsection#content{\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    display:inline-block;\r\n");
      out.write("\t    margin:2px;\r\n");
      out.write("\t    width:750px;\r\n");
      out.write("\t    min-height: 300px;\r\n");
      out.write("\t    background:white;\r\n");
      out.write("\t    padding-left:10px;\r\n");
      out.write("\t    left: 206px;\r\n");
      out.write("\t}\r\n");
      out.write("\tul.nav-list li>a:hover{\r\n");
      out.write("\t    font-weight: bolder;\r\n");
      out.write("\t    color: rgb(64,128,183);\r\n");
      out.write("\t}\r\n");
      out.write("\tul.main-nav>li.main-nav-list a#header-selected{\r\n");
      out.write("\t    color:rgb(64,128,183);\r\n");
      out.write("\t}\r\n");
      out.write("\tul.main-nav>li.header-selected{\r\n");
      out.write("\t    border-bottom: 3px solid rgb(64,128,183);\r\n");
      out.write("\t}\r\n");
      out.write("\tfooter#footer{\r\n");
      out.write("\t    background:#222;\r\n");
      out.write("\t    padding:5px;\r\n");
      out.write("\t    display:block;\r\n");
      out.write("\t    height: 220px;\r\n");
      out.write("\t}\r\n");
      out.write("\tfooter#footer p {\r\n");
      out.write("\t    font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\t    color:gray;\r\n");
      out.write("\t    text-align:center;\r\n");
      out.write("\t    font-size:15px;\r\n");
      out.write("\t    display: inline-block;\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    top: 80px;\r\n");
      out.write("\t    left: 307px;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#footer-wrapper{\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    width: 960px;\r\n");
      out.write("\t    height: 220px;\r\n");
      out.write("\t    margin: 0 auto;         \r\n");
      out.write("\t}\r\n");
      out.write("\timg#footer-image{\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t    height: 77px;\r\n");
      out.write("\t    top: 54px;\r\n");
      out.write("\t    left: 170px;\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("<script>\r\n");
if(memberLoggedIn!=null) { 
      out.write(" \r\n");
      out.write("   function fn_validate_team_info() {\r\n");
      out.write("      if(");
      out.print(memberLoggedIn.getTeamname());
      out.write("!=null) {\r\n");
      out.write("         return true;   \r\n");
      out.write("      }\r\n");
      out.write("      if(confirm(\"팀이 없습니다. 팀 생성 하시겠습니까??\")) location.href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberTeamCreate\";\r\n");
      out.write("\r\n");
      out.write("      return false;\r\n");
      out.write("   }\r\n");
} 
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("        <div id=\"header-div\">\r\n");
      out.write("            <div class=\"header-div-wrap\">\r\n");
      out.write("                <ul id=\"header-list\">\r\n");
      out.write("\t\t\t\t");
if(memberLoggedIn==null) {
      out.write("\r\n");
      out.write("\t\t\t\t    <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberEnroll\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t    <li>|</li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/loginPage\">로그인</a></li>\r\n");
      out.write("\t\t\t\t ");
} else if("admin".equals(memberLoggedIn.getUserId())) { 
      out.write("\r\n");
      out.write("\t\t\t\t    <li>");
      out.print(memberLoggedIn.getUserId() );
      out.write("님 환영합니다!</li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t    <li>|</li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminPage\">관리자페이지</a></li>\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t ");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t    <li>");
      out.print(memberLoggedIn.getUserId() );
      out.write("님 환영합니다!</li>\r\n");
      out.write("\t\t\t\t       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t ");
} 
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"header-div-wrapping-nav\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("\"><img id=\"header-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.png\" /></a>\r\n");
      out.write("            <nav>\r\n");
      out.write("            <ul class=\"main-nav\">\r\n");
      out.write("\t\t\t   <li id=\"main-nav-notice\" class=\"main-nav-list \"><a href=\"");
      out.print(request.getContextPath());
      out.write("/notice/noticeList\">공지사항</a></li>\r\n");
      out.write("               \r\n");
      out.write("               <li id=\"main-nav-board\" class='main-nav-list ");
      out.print(param=="freeBoard"||param=="regionBoard"||param=="complainBoard"?"header-selected":"");
      out.write("'>\r\n");
      out.write("                   <a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\" id='");
      out.print(param=="freeBoard"||param=="regionBoard"||param=="complainBoard"?"header-selected":"");
      out.write("'>게시판</a>\r\n");
      out.write("                   <div class=\"main-nav-sub\" id=\"main-nav-sub-board\">\r\n");
      out.write("                       <ul class=\"main-nav-sub-ul\">\r\n");
      out.write("                           <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/freeBoard\" >자유게시판</a></li>\r\n");
      out.write("                           <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/regionBoard\" >지역게시판</a></li>\r\n");
      out.write("                           <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/complainBoard\">신고게시판</a></li>\r\n");
      out.write("                       </ul>\r\n");
      out.write("                   </div>  \r\n");
      out.write("               </li>\r\n");
      out.write("               <li id=\"main-nav-register\" class='main-nav-list ");
      out.print(param=="gameRegister"||param=="myGameList"?"header-selected":"");
      out.write("'>\r\n");
      out.write("               \t  <a href=\"");
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
      out.write("               <li id=\"main-nav-search\" class='main-nav-list ");
      out.print(param=="teamSearch"?"header-selected":"");
      out.write("'>\r\n");
      out.write("                  <a href=\"");
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
      out.write("               <li id=\"main-nav-mypage\" class='main-nav-list ");
      out.print(param=="memberInfo"||param=="memberTeamInfo"?"header-selected":"");
      out.write("'>\r\n");
      out.write("                  <a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfoPage\" id='");
      out.print(param=="memberInfo"||param=="memberTeamInfo"?"header-selected":"");
      out.write("'>마이페이지</a>\r\n");
      out.write("                  <!-- 마이페이지 -->\r\n");
      out.write("                  <div class=\"main-nav-sub\" id=\"main-nav-sub-mypage\">\r\n");
      out.write("                     <ul class=\"main-nav-sub-ul\">\r\n");
      out.write("                         ");
if(memberLoggedIn!=null) {
      out.write(" \r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberInfoPage\">내 정보</a></li>\r\n");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfoPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" onclick=\"return fn_validate_team_info();\">내 팀 정보</a></li>\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
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
      out.write("         </div>\r\n");
      out.write("      </header>");
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
      out.write("      <section id=\"center\">\r\n");
      out.write("\t\t\t<nav id=\"nav\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 공지사항 -->\r\n");
      out.write("\t\t\t");
 if(param=="notice"){ 
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">공지사항</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a id=\"nav-selected\" href=\"");
      out.print(request.getContextPath() );
      out.write("/notice/noticeList\">공지사항</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 게시판 -->\r\n");
      out.write("\t\t\t");
 if(param=="freeBoard" || param=="regionBoard" || param=="complain") {
      out.write("\r\n");
      out.write("\t\t\t<h3 id=\"nav-header\">게시판</h3>\r\n");
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
      out.write("\t\t\t<h2 id=\"nav-header\">로그인/회원가입</h2>\r\n");
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
      out.write("\t\t\t");
if(param=="memberTeamMemberManagement" || param=="memberTeamGameAcceptPage") {
      out.write("\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">팀 관리</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberTeamManagement?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" id='");
      out.print(param=="memberTeamMemberManagement"?"nav-selected":"");
      out.write("'>팀원 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀원 수락</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/member/memberTeamGameAcceptPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\" id='");
      out.print(param=="memberTeamGameAcceptPage"?"nav-selected":"");
      out.write("'>팀 경기 수락</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
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
      out.write("\t\t\t</ul> \r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
if(param=="adminPage" || param=="adminPageTeam") {
      out.write("\r\n");
      out.write("\t\t\t<!-- 관리자페이지 -->\r\n");
      out.write("\t\t\t<h2 id=\"nav-header\">관리자페이지</h2>\r\n");
      out.write("\t\t\t<ul class=\"nav-list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/adminPage\" id=\"");
      out.print(param=="adminPage"?"nav-selected":"" );
      out.write("\" >회원 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/adminPageTeam\" id=\"");
      out.print(param=="adminPageTeam"?"nav-selected":"" );
      out.write("\">팀 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">팀 수락</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">접속 통계</a></li>\r\n");
      out.write("\t\t\t</ul>  \r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<section id=\"content\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("table.board-table{\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tborder-collapse:collapse;\r\n");
      out.write("\twidth:680px;\r\n");
      out.write("}\r\n");
      out.write("table.board-table tr{\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("table.board-table tr th{\r\n");
      out.write("\tbackground: rgb(64,128,183);\r\n");
      out.write("\tcolor:white;\r\n");
      out.write("}\r\n");
      out.write("table.board-table tr{\r\n");
      out.write("\theight:5px;\r\n");
      out.write("}\r\n");
      out.write("table.board-table tr th, td{\r\n");
      out.write("\tborder:1px solid rgb(100,100,100);\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\tfont-size:13px;\r\n");
      out.write("}\r\n");
      out.write("table.board-table tr:hover{\r\n");
      out.write("\tbackground:rgb(240,240,240);\r\n");
      out.write("}\r\n");
      out.write("table.board-table th{\r\n");
      out.write("\twidth:60px\r\n");
      out.write("}\r\n");
      out.write("td.view-content{\r\n");
      out.write("\theight:150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div#comment-container button#btn-insert{\r\n");
      out.write("\twidth:80px;\r\n");
      out.write("\theight:50px;\r\n");
      out.write("\tcolor:white;\r\n");
      out.write("\tbackground: rgb(64,128,183);\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\ttop:-20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.comment-viewer{\r\n");
      out.write("\twidth:670px;\r\n");
      out.write("\theight:60px;\r\n");
      out.write("\tborder:1px solid gray;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<h2>신고게시판 - 작성</h2>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/board/complainBoardFormEnd\" method=\"post\">\r\n");
      out.write("<table class=\"board-table\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<td colspan=\"5\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"complain_title\" required/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>작성자</th>\r\n");
      out.write("\t\t<td colspan=\"2\"><input type=\"text\" name=\"complain_writer\" id=\"\" value=\"");
      out.print(memberLoggedIn.getUserId());
      out.write("\" readonly/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>용의자/용의팀</th>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<select name=\"complain_type\" id=\"\">\r\n");
      out.write("\t\t\t<option value=\"c_userid\">용의자</option>\r\n");
      out.write("\t\t\t<option value=\"c_teamname\">용의팀</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<input type=\"text\" name=\"c_complain\" id=\"\" required/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"6\">내용</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"6\" class=\"view-content\"><textarea name=\"complain_content\" id=\"\" cols=\"80\" rows=\"10\"></textarea></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"submit\" value=\"작성\" />\r\n");
      out.write("<input type=\"button\" value=\"취소\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<footer id=\"footer\">\r\n");
      out.write("        <div id=\"footer-wrapper\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("\"><img id=\"footer-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.png\" /></a>\r\n");
      out.write("            <p>팀명 : 투톱체제<br>\r\n");
      out.write("          \t팀원 : 김대연, 최지수, 박희영, 배성인, 이연경<br>\r\n");
      out.write(" \t\t\t주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
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
