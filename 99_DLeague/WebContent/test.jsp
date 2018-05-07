<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DLeague</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<style>
/********** 전체컨테이너 **********/
div#container	{width:960px; margin:0 auto;}

/********** header **********/
header			{ height:120px; position:relative; padding:10px 0 0 0;}
header h1 		{margin-left:10px;}


/* 메인메뉴 */
header nav {
	 
	width:100%; 
	margin-top:15px;
	position:relative;
}
ul.main-nav {
	display:table;
	padding:0px; /*ul태그가 가진 기본padding초기화*/
	margin:auto;
}
ul.main-nav li.main-nav-list{
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

ul.main-nav li.main-nav-list a{
	display:block;
	padding:.5em;
	text-decoration:none;
	color:#292929;
}
ul.main-nav li.main-nav-list:hover{border-radius:5px;}


/*header*/
div#header-div{
	display:block;
	height:50px;
}
img#header-image {
	padding-left:10px;
	width:60px;
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
div.main-nav-sub ul{
	background:rgb(245,245,245);
	padding:0px;
	border-radius:5px;
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
	background:rgba(173,255,165,0.8);
	
}
section#content{
	display:inline-block;
	margin:2px;
	width:758px;
	background:white;
	border:1px solid rgb(245,245,245);
	
}
/*nav*/
nav#nav{
background:rgb(255,255,255);
border:2px solid rgb(173,255,165);
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
nav#nav ul.nav-list li:hover{
	background:rgb(173,255,165);
}
nav#nav ul.nav-list li a{
	text-decoration:none;
	color:gray;
}
nav#nav h2#nav-header{
	font-family:"휴먼모음T", sans-serif;
	text-align:center;
	padding:0px;
}

/*footer*/
footer{
	background:rgb(240,240,240);
	padding:5px;
	display:block;
}
footer p {
	font-family:"휴먼모음T", sans-serif;
	color:gray;
	text-align:center;
	font-size:0.7em;
}
</style>
<script>
$(function() {
	$("#main-nav-board").hover(function() {
		$("#main-nav-sub-board").show();
	}, function() {
		$("#main-nav-sub-board").hide();
	});
	$("#main-nav-register").hover(function() {
		$("#main-nav-sub-register").show();
	}, function() {
		$("#main-nav-sub-register").hide();
	});
	$("#main-nav-search").hover(function() {
		$("#main-nav-sub-search").show();
	}, function() {
		$("#main-nav-sub-search").hide();
	});
	$("#main-nav-mypage").hover(function() {
		$("#main-nav-sub-mypage").show();
	}, function() {
		$("#main-nav-sub-mypage").hide();
	});
});

</script>
</head>
<body>
	<div id="container">
		<header>
			<div id="header-div">
			<img id="header-image" src="<%=request.getContextPath() %>/images/headerImage.png" alt="" />
			<ul id="header-list">
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
				<li><a href="#">관리자페이지</a></li>
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
		<nav id="nav">
			
			<!-- 로그인/회원가입 -->
			<!-- <h2 id="nav-header"></h2>
			<ul class="nav-list">
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
			공지사항 
			<h2 id="nav-header">공지사항</h2>
			<ul class="nav-list">
				<li><a href="#">공지사항</a></li>
			</ul> -->
			<!-- 게시판 -->
			<h2 id="nav-header">게시판</h2>
			<hr style="border:0;height:2px;background: rgb(244,244,244);"/>
			<ul class="nav-list">
				<li><a href="#">자유게시판</a></li>
				<li><a href="#">지역게시판</a></li>
				<li><a href="#">신고게시판</a></li>
			</ul>
			<!-- 경기등록  -->
			<!-- <h2 id="nav-header">경기등록</h2>
			<ul class="nav-list">
				<li><a href="#">경기등록</a></li>
				<li><a href="#">내팀경기일정</a></li>
			</ul>
			검색 
			<h2 id="nav-header">검색</h2>
			<ul class="nav-list">
				<li><a href="#">팀검색</a></li>
				<li><a href="#">경기검색</a></li>
			</ul>
			마이페이지 
			<h2 id="nav-header">마이페이지</h2>
			<ul class="nav-list">
				<li><a href="#">내 팀 정보</a></li>
				<li><a href="#">내 정보</a></li>
				<li><a href="#">내 팀 관리</a></li>
			</ul>
			관리자페이지 
			<h2 id="nav-header">관리자페이지</h2>
			<ul class="nav-list">
				<li><a href="#">회원 관리</a></li>
				<li><a href="#">팀 관리</a></li>
				<li><a href="#">팀 수락</a></li>
				<li><a href="#">접속 통계</a></li>
			</ul> -->
		</nav>
		<section id="content">
	
		
		</section>
		
		
		
		</section>
		<footer>
			<p>팀명 : 투톱체제</p>
			<p>팀원 : 김대연, 최지수, 박희영, 배성인, 이연경</p>
			<p>주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>
		</footer>
	</div>
</body>
</html>