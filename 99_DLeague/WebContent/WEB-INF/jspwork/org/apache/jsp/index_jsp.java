/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
<<<<<<< HEAD
 * Generated at: 2018-05-20 07:01:02 UTC
=======
 * Generated at: 2018-05-20 12:33:12 UTC
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dleague.member.model.vo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
<<<<<<< HEAD
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526799624085L));
=======
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526800152158L));
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
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
      out.write("\t    width: 130px;\r\n");
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
      out.write("\t    font-weight: bold;\r\n");
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
      out.write("\t}\n");
      out.write("\t</style>\n");
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
      out.write("          \t\t  \r\n");
      out.write("                  <a href=\"");
      out.print((memberLoggedIn!=null)?request.getContextPath()+"/member/memberInfoPage":"javascript:window.alert('로그인 후 사용가능합니다.')");
      out.write("\" id='");
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
      out.write("                        <!-- onclick=\"return fn_validate_team_info();\" -->\r\n");
      out.write("                        <li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamInfoPage?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("&userId=");
      out.print(memberLoggedIn.getUserId() );
      out.write("\" >내 팀 정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
 if("팀장".equals(memberLoggedIn.getGrade())) {
      out.write("\r\n");
      out.write("                        \t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamManagement?teamName=");
      out.print(memberLoggedIn.getTeamname());
      out.write("\">내 팀 관리</a></li>\r\n");
      out.write("                        ");
} 
      out.write("\r\n");
      out.write("                        ");
 if("선수".equals(memberLoggedIn.getGrade())) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"main-nav-sub-li\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/memberTeamCreate?userId=");
      out.print(memberLoggedIn.getUserId());
      out.write("\">팀생성</a><li>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/js/vmcslider/src/style.css\" type=\"text/css\" />\r\n");
      out.write("<style>\n");
      out.write("div.effect{\r\n");
      out.write("    position: relative;\r\n");
      out.write("\twidth: 1000px;\r\n");
      out.write("\theight: 391.922px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmargin-top: 136px;\r\n");
      out.write("}\r\n");
      out.write("div.effect>img{\r\n");
      out.write("\twidth: 1000px;\r\n");
      out.write("}\r\n");
      out.write(".effect:after {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    display: block;\r\n");
      out.write("    content: \"\";\r\n");
      out.write("    top: 0;\r\n");
      out.write("    left: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    background: linear-gradient(90deg, white, rgba(255, 255, 255, 0) 10%, rgba(255, 255, 255, 0) 90%, #fff 100%);\r\n");
      out.write("    z-index: 5; \r\n");
      out.write("}\n");
      out.write("</style>\r\n");
      out.write("<div class=\"effect\">\r\n");
      out.write("\t<div id=\"slider\">\r\n");
      out.write("\t<a href=\"#\"><img id=\"main-img\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/index/main.jpg\" alt=\"main\" /></a>\r\n");
      out.write("\t<a href=\"#\"><img id=\"main-img2\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/index/main2.jpg\" alt=\"main2\" /></a>\r\n");
      out.write("\t<a href=\"#\"><img id=\"main-img3\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/index/main3.jpg\" alt=\"main3\" /></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/vmcslider/vmc.slider.full.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$('#slider').vmcSlider({\r\n");
      out.write("\twidth: 1000,\r\n");
      out.write("\theight: 392,\r\n");
      out.write("\tgridCol: 10,\r\n");
      out.write("\tgridRow: 5,\r\n");
      out.write("\tgridVertical: 20,\r\n");
      out.write("\tgridHorizontal: 10,\r\n");
      out.write("\tautoPlay: true,\r\n");
      out.write("\tascending: true,\r\n");
      out.write("\teffects: [\r\n");
      out.write("\t\t'fade', 'fadeLeft', 'fadeRight', 'fadeTop', 'fadeBottom', 'fadeTopLeft', 'fadeBottomRight',\r\n");
      out.write("\t\t'blindsLeft', 'blindsRight', 'blindsTop', 'blindsBottom', 'blindsTopLeft', 'blindsBottomRight',\r\n");
      out.write("\t\t'curtainLeft', 'curtainRight', 'interlaceLeft', 'interlaceRight', 'mosaic', 'bomb', 'fumes'\r\n");
      out.write("\t],\r\n");
      out.write("\tie6Tidy: false,\r\n");
      out.write("\trandom: true,\r\n");
      out.write("\tduration: 2000,\r\n");
      out.write("\tspeed: 1000\r\n");
      out.write("});\r\n");
      out.write("</script>\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("<div id=\"footer-wrapper\">\r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("\"><img id=\"footer-image\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/headerImage.png\" /></a>\r\n");
      out.write("        <p>팀명 : 투톱체제<br>\r\n");
      out.write("      \t팀원 : 김대연, 최지수, 박희영, 배성인, 이연경<br>\r\n");
      out.write("\t\t주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
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
