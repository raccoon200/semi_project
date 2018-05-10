<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
console.log("<%=param%>");
</script>
			<nav id="nav">
			
			
			<!-- 공지사항 
			<h2 id="nav-header">공지사항</h2>
			<ul class="nav-list">
				<li><a href="#">공지사항</a></li>
			</ul> --> 
			
			<!-- 게시판 -->
			<% if(param=="board") {%>
			<h2 id="nav-header">게시판</h2>
			<hr style="border:0;height:2px;background: rgb(244,244,244);"/>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/board/freeBoard">자유게시판</a></li>
				<li><a href="<%=request.getContextPath() %>/board/regionBoard" id="nav-selected">지역게시판</a></li>
				<li><a href="<%=request.getContextPath() %>/board/complainBoard">신고게시판</a></li>
			</ul>
			<%} %>
			<!-- 로그인/회원가입 -->
			<%if(param=="login" || param=="enroll") {%>
			<h2 id="nav-header"></h2>
			<ul class="nav-list">
				
				<li><a href="<%=request.getContextPath() %>/member/loginPage" id=id=<%=param=="login"?"nav-selected":""%>>로그인</a></li>
				
				<li><a href="#" id=<%=param=="enroll"?"nav-selected":""%>>회원가입</a></li>
			</ul>
			<%}%>
			<%if(param=="passwordCheck") {%>
			<h2 id = "nav-header">비밀번호 찾기</h2>
			<%} %>
			<%if(param=="passwordUpdate") {%>
			<h2 id="nav-header">비밀번호 변경</h2>
			<%} %>
			<%if(param=="gameRegister"||param=="myGameList") {%>
			<!-- 경기등록  -->
			<h2 id="nav-header">경기등록</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/game/gameRegister" id='<%=param=="gameRegister"?"nav-selected":""%>'>경기등록</a></li>
				<li><a href="<%=request.getContextPath() %>/game/myGameList" id='<%=param=="myGameList"?"nav-selected":""%>'>내팀경기일정</a></li>
			</ul>
			<%} %>
			<%if(param=="teamSearch"||param=="teamSearchList") {%>
			<!-- 검색 -->
			<h2 id="nav-header">검색</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/search/teamSearch" id='<%=param=="teamSearch"?"nav-selected":""%>'>팀검색</a></li>
				<li><a href="<%=request.getContextPath() %>/search/gameSearchList" id='<%=param=="teamSearchList"?"nav-selected":""%>'>경기검색</a></li>
			</ul>
			<%} %>
			
			<%if(param=="memberInfo" || param=="memberTeamInfo") {%>
			<h2 id="nav-header">마이페이지</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/member/memberInfo" id="<%=param=="memberInfo"?"nav-selected":"" %>" >내 정보</a></li>
				<li><a href="<%=request.getContextPath() %>/member/memberTeamInfo" id="<%=param=="memberTeamInfo"?"nav-selected":"" %>">내 팀 정보</a></li>
				<li><a href="#">내 팀 관리</a></li>
			</ul>
			<%} %>
			
			<!-- 관리자페이지 
			<h2 id="nav-header">관리자페이지</h2>
			<ul class="nav-list">
				<li><a href="#">회원 관리</a></li>
				<li><a href="#">팀 관리</a></li>
				<li><a href="#">팀 수락</a></li>
				<li><a href="#">접속 통계</a></li>
			</ul>  -->
		</nav>
		<section id="content">