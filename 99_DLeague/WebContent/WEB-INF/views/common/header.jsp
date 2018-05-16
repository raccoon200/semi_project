<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dleague.member.model.vo.*" %>
<% Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
   String param = (String)request.getAttribute("param");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
<title>DLeague</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

<style>
	header#header{ 
	    width: 100%;
	    height:119px; 
	    padding:10px 0 0 0;
	    background: white;
	    position: fixed;
	    top: 0px;
	    left: 0px;
	    border-bottom: 1px solid #f3f3f3;
	    z-index: 150;
	}
	div#header-div{
	    display:block;
	    width: 100%;
	    height:41px;
	    background: #f3f3f3;
	    position: fixed;
	    top: 0px;
	    left: 0px;
	}
	div.header-div-wrap{
	    position: relative;
	    width: 960px;
	    height: 41px;
	    margin: 0 auto;
	    background: #f3f3f3;
	}
	div.header-div-wrapping-nav{
	    position: relative;
	    width: 960px;
	    height: 77px;
	    margin: 0 auto;
	    background: white;
	    top: 31px;
	}
	img#header-image{
	    height: 77px;
	}
	header#header nav{
	    float: right;
	}
	ul.main-nav{
	    display:table;
	    padding:0px; /*ul태그가 가진 기본padding초기화*/
	    margin-top: 23px;
	    margin-bottom: 0px;
	    vertical-align: baseline;
	    list-style: none;
	}
	.main-nav-list{
	    float: left;
	    padding-top: 7px;
	}
	li.main-nav-list:hover{
	    border-bottom: 3px solid rgb(64,128,183); 
	}
	li.main-nav-list:hover>div{
	    border-top: 3px solid rgb(64,128,183); 
	}
	li.main-nav-list:hover>a{
	    color: rgb(64,128,183); 
	}
	li.main-nav-list:hover div.main-nav-sub{
	    display: block;
	}
	.main-nav-list>a{
	    display: block;
	    padding: 0 0 19px;
	    margin: 0 35px;
	    font-size: 20px;
	    color: #121212;
	    font-family: 'Do Hyeon', sans-serif;
	}
	.main-nav-list>a:link{
	    text-decoration: none;
	}
	ul#header-list {
	    display:block;
	    float:right;
	    display:table;
	    padding:0px; /*ul태그가 가진 기본padding초기화*/
	    margin:auto;
	    margin-top: 7px;
	}
	ul#header-list li{
	    display:inline;
	    list-style-type:none;
	    padding:10px;
	    font-size: 11px;
	    font-family: 'Nanum Gothic', sans-serif;
	}
	ul#header-list li a{
	    text-decoration:none;
	    font-size: 9px;
	    font-family: 'Nanum Gothic', sans-serif;
	    color:black;
	}
	.main-nav-sub-li{
	    list-style-type:none;
	    text-align: center;
	    padding-bottom: 10px;
	    padding-top: 10px;
	}
	.main-nav-sub-ul{
	    padding: 0px;
	}
	div.main-nav-sub{
	    border: 1px solid rgb(64,128,183);
	    display: none;
	    background: white;
	}
	li.main-nav-sub-li a{
	    text-decoration:none;
	    font-size: 15px;
	    font-family: 'Nanum Gothic', sans-serif;
	    color:black;
	}
	li.main-nav-sub-li:hover{
	    background: rgb(64,128,183);
	}
	li.main-nav-sub-li:hover>a{
	    color: white;
	}
	/*section-center*/
	section#center{
	    margin: 0 auto;
	    width: 960px;
	    min-height: 960px;
	    position: relative;
	    padding-top: 168px;
	
	}
	nav#nav{
	    float: left;
	    width: 175px;
	    padding: 12px 0 0 14px;
	    margin-right: 45px;
	    display: block;
	    position: fixed;
	}
	h3#nav-header{
	    font-size: 23px;
	    width: 115px;
	    margin: 0 0 30px 15px;
	    padding-bottom: 25px;
	    border-bottom: 4px solid rgb(64,128,183);
	    color: #111;
	    line-height: 1.3;
	    font-family: 'Nanum Gothic', sans-serif;
	    font-weight: bold;
	}
	ul.nav-list{
	    margin-left: 15px;
	    list-style: none;
	    margin: 0;
	    margin-left: 15px; 
	    padding: 0;
	    border: 0;
	    font: inherit;
	    vertical-align: baseline;
	}
	ul.nav-list li{
	    padding: 0;
	    margin-bottom: 15px;
	}
	ul.nav-list li>a{
	    display: block;
	    font-size: 17px;
	    color: #7c7c7c;
	    font-family: 'Nanum Gothic', sans-serif;
	    text-decoration:none;
	}
	a#nav-selected{
	    color: rgb(64,128,183);
	    font-weight: bolder;
	}
	section#content{
	    position: relative;
	    display:inline-block;
	    margin:2px;
	    width:750px;
	    min-height: 300px;
	    background:white;
	    padding-left:10px;
	    left: 206px;
	}
	ul.nav-list li>a:hover{
	    font-weight: bolder;
	    color: rgb(64,128,183);
	}
	ul.main-nav>li.main-nav-list a#header-selected{
	    color:rgb(64,128,183);
	}
	ul.main-nav>li.header-selected{
	    border-bottom: 3px solid rgb(64,128,183);
	}
	footer#footer{
	    background:#222;
	    padding:5px;
	    display:block;
	    height: 220px;
	}
	footer#footer p {
	    font-family: 'Nanum Gothic', sans-serif;
	    color:gray;
	    text-align:center;
	    font-size:15px;
	    display: inline-block;
	    position: relative;
	    top: 80px;
	    left: 307px;
	}
	div#footer-wrapper{
	    position: relative;
	    width: 960px;
	    height: 220px;
	    margin: 0 auto;         
	}
	img#footer-image{
	    position: relative;
	    height: 77px;
	    top: 54px;
	    left: 170px;
	}
	</style>
<script>
<%if(memberLoggedIn!=null) { %> 
   function fn_validate_team_info() {
      if(<%=memberLoggedIn.getTeamname()%>!=null) {
         return true;   
      }
      if(confirm("팀이 없습니다. 팀 생성 하시겠습니까??")) location.href="<%=request.getContextPath()%>/member/memberTeamCreate";

      return false;
   }
<%} %>
</script>
</head>
<body>
    <header id="header">
        <div id="header-div">
            <div class="header-div-wrap">
                <ul id="header-list">
				<%if(memberLoggedIn==null) {%>
				    <li><a href="<%=request.getContextPath() %>/member/memberEnroll">회원가입</a></li>
				    <li>|</li>
				    <li><a href="<%=request.getContextPath() %>/member/loginPage">로그인</a></li>
				 <%} else if("admin".equals(memberLoggedIn.getUserId())) { %>
				    <li><%=memberLoggedIn.getUserId() %>님 환영합니다!</li>
				    <li><a href="<%=request.getContextPath()%>/member/logout">로그아웃</a></li>
				    <li>|</li>
				    <li><a href="<%=request.getContextPath()%>/admin/adminPage">관리자페이지</a></li>
				    
				 <%}else{ %>
				    <li><%=memberLoggedIn.getUserId() %>님 환영합니다!</li>
				       <li><a href="<%=request.getContextPath()%>/member/logout">로그아웃</a></li>
				 <%} %>
                </ul>
            </div>
        </div>
        
        <div class="header-div-wrapping-nav">
            <a href="<%=request.getContextPath()%>"><img id="header-image" src="<%=request.getContextPath() %>/images/headerImage.png" /></a>
            <nav>
            <ul class="main-nav">
			   <li id="main-nav-notice" class="main-nav-list "><a href="<%=request.getContextPath()%>/notice/noticeList">공지사항</a></li>
               
               <li id="main-nav-board" class='main-nav-list <%=param=="freeBoard"||param=="regionBoard"||param=="complainBoard"?"header-selected":""%>'>
                   <a href="<%=request.getContextPath() %>/board/freeBoard" id='<%=param=="freeBoard"||param=="regionBoard"||param=="complainBoard"?"header-selected":""%>'>게시판</a>
                   <div class="main-nav-sub" id="main-nav-sub-board">
                       <ul class="main-nav-sub-ul">
                           <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/board/freeBoard" >자유게시판</a></li>
                           <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/board/regionBoard" >지역게시판</a></li>
                           <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/board/complainBoard">신고게시판</a></li>
                       </ul>
                   </div>  
               </li>
               <li id="main-nav-register" class='main-nav-list <%=param=="gameRegister"||param=="myGameList"?"header-selected":""%>'>
               	  <a href="<%=request.getContextPath() %>/game/gameRegister" id='<%=param=="gameRegister"||param=="myGameList"?"header-selected":""%>'>경기등록</a>
                  <!-- 경기등록  -->
                  <div class="main-nav-sub" id="main-nav-sub-register">
                     <ul class="main-nav-sub-ul">
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/game/gameRegister">경기등록</a></li>
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/game/myGameList">내팀경기일정</a></li>
                     </ul>
                  </div>
               </li>
               <li id="main-nav-search" class='main-nav-list <%=param=="teamSearch"?"header-selected":""%>'>
                  <a href="<%=request.getContextPath() %>/search/teamSearch" id='<%=param=="teamSearch"?"header-selected":""%>'>검색</a>
                  <!-- 검색 -->
                  <div class="main-nav-sub" id="main-nav-sub-search">
                     <ul class="main-nav-sub-ul">
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/search/teamSearch" >팀 검색</a></li>
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/search/gameSearchList">경기 검색</a></li>
                     </ul>
                  </div>
               </li>
               <li id="main-nav-mypage" class='main-nav-list <%=param=="memberInfo"||param=="memberTeamInfo"?"header-selected":""%>'>
                  <a href="<%=request.getContextPath() %>/member/memberInfoPage" id='<%=param=="memberInfo"||param=="memberTeamInfo"?"header-selected":""%>'>마이페이지</a>
                  <!-- 마이페이지 -->
                  <div class="main-nav-sub" id="main-nav-sub-mypage">
                     <ul class="main-nav-sub-ul">
                         <%if(memberLoggedIn!=null) {%> 
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/member/memberInfoPage">내 정보</a></li>

                        <%-- <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/member/memberTeamInfoPage?teamName=<%=memberLoggedIn.getTeamname()%>">내 팀 정보</a></li> --%>
                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/member/memberTeamInfoPage?teamName=<%=memberLoggedIn.getTeamname()%>" onclick="return fn_validate_team_info();">내 팀 정보</a></li>

                        <li class="main-nav-sub-li"><a href="<%=request.getContextPath() %>/member/memberTeamManagementPage?teamName=<%=memberLoggedIn.getTeamname()%>&userId=<%=memberLoggedIn.getUserId()%>">내 팀 관리</a></li>
                         <%} %> 
                     </ul>
                  </div>
               </li>
               
               <%-- 관리자메뉴 --%>
            <%--    <%if(memberLoggedIn!=null&&"admin".equals(memberLoggedIn.getUserId())){ %>
               <li id="admin"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
               <%} %>--%>
            </ul>
            
         </nav>
         <!-- 메인메뉴 끝 -->
         </div>
      </header>