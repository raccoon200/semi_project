<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

=======
<%@ page import="com.dleague.member.model.vo.*"%>
<% Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn"); %>
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DLeague</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<style>
/* 전체컨테이너 */
div#container	{width:960px; margin:0 auto;}

/*header*/

header#header			{ height:120px; position:relative; padding:10px 0 0 0;}
header#header h1 		{margin-left:10px;}

header#header nav {
	 
	width:100%; 
	margin-top:15px;
	position:relative;
}
ul.main-nav {
	display:table;
	padding:0px; /*ul태그가 가진 기본padding초기화*/
	margin:auto;
}
ul.main-nav > li.main-nav-list{
	list-style-type:none;
	width:8em;
	height:2em;
	float:left;
	padding-left:15px;
	padding-right:15px;
	text-align:center;
	font-family:"휴먼모음T", sans-serif;
	font-size:1.2em;
	background-color:white;
}

ul.main-nav > li.main-nav-list > a{
	display:block;
	padding:.5em;
	text-decoration:none;
	color:#292929;
}
<<<<<<< HEAD
ul.main-nav > li.main-nav-list:hover{border-radius:5px;}
=======
<<<<<<< HEAD
ul.main-nav li:hover{background:rgb(230,230,230);}
ul.main-nav li:hover>a{color:black;}

/*header*/
div#header-div{
	display:block;
	height:50px;
}
img#header-image {
	padding-left:10px;
	width:200px;
	height:60px;
	float:left;
	display:inline;
}
ul#header-list {
	
	float:right;
	display:table;
	padding:0px; /*ul태그가 가진 기본padding초기화*/
	margin:auto;
}
ul#header-list li{
	display:inline;
	list-style-type:none;
	padding:10px;
	font-family:"휴먼모음T", sans-serif;
}
ul#header-list li a{
	text-decoration:none;
	font-family:"휴먼모음T", sans-serif;
	
	color:black;
}
div.main-nav-sub ul{
	background:lightgray;
	padding:0px;

}
div.main-nav-sub ul li{
	list-style-type:none;
	display:inline-block;
	padding:0px;
}
div.main-nav-sub ul li a{
	text-decoration:none;
	font-family:"휴먼모음T", sans-serif;
	font-size:16px;
	color:black;
}
div.main-nav-sub {
	position:absolute;
	top:40px;
	padding:1px;
	display:none;
	
}
div#main-nav-sub-board{
	left:170px;
}
div#main-nav-sub-register{
	left:390px;
}
div#main-nav-sub-search{
	left:580px;
}
div#main-nav-sub-mypage{
	left:700px;
}
/*section-center*/
section#center{
	height:700px;
	overflow:hidden;
	height:auto;
}
section#content{
	display:inline-block;
	width:760px;
	background:gray;
	
}
/*nav*/
nav#nav{
background:rgb(230,230,230);
width:190px;
float:left;
margin-right:10px;
}
nav#nav ul.nav-list{
	padding:20px;
}
nav#nav ul.nav-list li{
	font-family:"휴먼모음T", sans-serif;
	padding-top:10px;
	font-size:1.2em;
	list-style-type:none;
}
nav#nav ul.nav-list li a{
	text-decoration:none;
	color:black;
}
nav#nav h2#nav-header{
	font-family:"휴먼모음T", sans-serif;
	text-align:center;
}

/*footer*/
footer{
	background:rgb(240,240,240);
=======
ul.main-nav li.main-nav-list:hover{border-radius:5px;}
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git

div#header-div{
	display:block;
	height:50px;
}
img#header-image {
	padding-left:10px;
	width:180px;
	height:60px;
	float:left;
	display:inline;
}
ul#header-list {
	display:block;
	float:right;
	display:table;
	padding:0px; /*ul태그가 가진 기본padding초기화*/
	margin:auto;
}
ul#header-list li{
	display:inline;
	list-style-type:none;
	padding:10px;
	font-family:"휴먼모음T", sans-serif;
}
ul#header-list li a{
	text-decoration:none;
	font-family:"휴먼모음T", sans-serif;
	color:gray;
}
ul#header-list li a:hover{
	color:black;
}

div.main-nav-sub > ul{
	background:rgb(245,245,245);
	padding:0px;
	border-radius:5px;
}
div.main-nav-sub > ul > li{
	list-style-type:none;
	display:inline-block;
	padding:2px;
}
div.main-nav-sub > ul > li > a{
	text-decoration:none;
	font-family:"휴먼모음T", sans-serif;
	font-size:16px;
	color:rgb(100,100,100);
	
}
div.main-nav-sub > ul > li> a:hover{
	color:black;
}
div.main-nav-sub {
	position:absolute;
	top:40px;
	padding:1px;
	display:none;
	
}
div#main-nav-sub-board{
	left:180px;
}
div#main-nav-sub-register{
	left:400px;
}
div#main-nav-sub-search{
	left:600px;
}
div#main-nav-sub-mypage{
	left:730px;
}

/*section-center*/
section#center{
	height:700px;
	overflow:hidden;
	height:auto;
	background:rgb(64,128,183);
	
}
/*content*/
section#content{
	display:inline-block;
	margin:2px;
	width:758px;
	background:white;
	border:1px solid rgb(245,245,245);
	border-radius: 4px;
	
}
/*nav*/
nav#nav{
background:rgb(255,255,255);
border:2px solid rgb(64,128,183);
width:186px;
float:left;
margin-left:3px;
border-radius:5px;
}
nav#nav ul.nav-list{
	padding:0px;
}
nav#nav ul.nav-list li{
	font-family:"휴먼모음T", sans-serif;
	padding-top:10px;
	color:gray;
	font-size:1.2em;
	list-style-type:none;
	text-align:center;
}

nav#nav ul.nav-list li a{
	text-decoration:none;
	color:gray;
}
nav#nav ul.nav-list li a:hover{

	color:black;
}
nav#nav h2#nav-header{
	font-family:"휴먼모음T", sans-serif;
	text-align:center;
	padding:0px;
}

/*footer*/
footer#footer{
	background:rgb(240,240,240);
	padding:5px;
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
	display:block;
}
footer#footer p {
	font-family:"휴먼모음T", sans-serif;
	color:gray;
	text-align:center;
	font-size:0.7em;
}

</style>
<script>
$(function() {
	$(".main-nav-list").hover(function() {
		$(this).children("div").show();
		$(this).children("a").css("color","rgb(64,128,183)")
	}, function() {
		$(this).children("div").hide();
		$(this).children("a").css("color","black")
	})
	
});

</script>
</head>
<body>
	<div id="container">
		<header id="header">
			<div id="header-div">
<<<<<<< HEAD
			<a href="#"><img id="header-image" src="<%=request.getContextPath() %>/images/headerImage.jpg" alt="" /></a>
=======
<<<<<<< HEAD
			<img id="header-image" src="<%=request.getContextPath() %>/images/headerImage.PNG" alt="" />
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
			<ul id="header-list">
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
			
			</div>
			<nav>
				<ul class="main-nav">
					<li id="main-nav-notice" class="main-nav-list"><a href="#">공지사항</a></li>
					<li id="main-nav-board" class="main-nav-list"><a href="#">게시판</a>
						<!-- 게시판 -->
						<div class="main-nav-sub" id="main-nav-sub-board">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="#">자유게시판</a></li>
								<li class="main-nav-sub-li"><a href="#">지역게시판</a></li>
								<li class="main-nav-sub-li"><a href="#">신고게시판</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-register" class="main-nav-list"><a href="#">경기등록</a>
						<!-- 경기등록  -->
						<div class="main-nav-sub" id="main-nav-sub-register">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="#">경기등록</a></li>
								<li class="main-nav-sub-li"><a href="#">내팀경기일정</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-search" class="main-nav-list"><a href="#">검색</a>
						<!-- 검색 -->
						<div class="main-nav-sub" id="main-nav-sub-search">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="<%=request.getContextPath()%>/search/teamSearch">팀 검색</a></li>
								<li class="main-nav-sub-li"><a href="#">경기 검색</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-mypage" class="main-nav-list"><a href="#">마이페이지</a>
						<!-- 마이페이지 -->
						<div class="main-nav-sub" id="main-nav-sub-mypage">
							<ul class="nav-list">
								<li><a href="#">내 팀 정보</a></li>
								<li><a href="#">내 정보</a></li>
								<li><a href="#">내 팀 관리</a></li>
							</ul>
						</div>
					</li>
					<!-- <li id="board"><a href="#">관리자페이지</a></li> -->
					<%-- 관리자메뉴 --%>
				<%-- 	<%if(memberLoggedIn!=null&&"admin".equals(memberLoggedIn.getUserId())){ %>
					<li id="admin"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
					<%} %> --%>
				</ul>
				
			</nav>
			<!-- 메인메뉴 끝 -->
		</header>
		<section id="center">
=======
			<img id="header-image" src="<%=request.getContextPath() %>/images/headerImage.png" alt="" />
			<ul id="header-list">
				<% if(memberLoggedIn == null){%>
					<li><a href="">회원가입</a></li>
					<li><a href="<%=request.getContextPath() %>/login/login.jsp">로그인</a></li>
					<li><a href="#">관리자페이지</a></li>
					<%} else {%>		
					<li><%=memberLoggedIn.getUserId()%>님 환영합니다!</li>
				<%} %>
			</ul>
			
			</div>
			<nav>
				<ul class="main-nav">
					<li id="main-nav-notice" class="main-nav-list"><a href="#">공지사항</a></li>
					<li id="main-nav-board" class="main-nav-list"><a href="#">게시판</a>
						<!-- 게시판 -->
						<div class="main-nav-sub" id="main-nav-sub-board">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="#">자유게시판</a></li>
								<li class="main-nav-sub-li"><a href="#">지역게시판</a></li>
								<li class="main-nav-sub-li"><a href="#">신고게시판</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-register" class="main-nav-list"><a href="#">경기등록</a>
						<!-- 경기등록  -->
						<div class="main-nav-sub" id="main-nav-sub-register">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="#">경기등록</a></li>
								<li class="main-nav-sub-li"><a href="#">내팀경기일정</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-search" class="main-nav-list"><a href="#">검색</a>
						<!-- 검색 -->
						<div class="main-nav-sub" id="main-nav-sub-search">
							<ul class="main-nav-sub-ul">
								<li class="main-nav-sub-li"><a href="#">팀 검색</a></li>
								<li class="main-nav-sub-li"><a href="#">경기 검색</a></li>
							</ul>
						</div>
					</li>
					<li id="main-nav-mypage" class="main-nav-list"><a href="#">마이페이지</a>
						<!-- 마이페이지 -->
						<div class="main-nav-sub" id="main-nav-sub-mypage">
							<ul class="nav-list">
								<li><a href="#">내 팀 정보</a></li>
								<li><a href="#">내 정보</a></li>
								<li><a href="#">내 팀 관리</a></li>
							</ul>
						</div>
					</li>
					<!-- <li id="board"><a href="#">관리자페이지</a></li> -->
					<%-- 관리자메뉴 --%>
				<%-- 	<%if(memberLoggedIn!=null&&"admin".equals(memberLoggedIn.getUserId())){ %>
					<li id="admin"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
					<%} %> --%>
				</ul> 
				
			</nav>
			<!-- 메인메뉴 끝 -->
		</header>
		
		<section id="center">
		
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project.git
