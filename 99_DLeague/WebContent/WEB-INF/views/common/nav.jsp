<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dleague.member.model.vo.*" %>

<script>
console.log("<%=param%>");
</script>
      <section id="center">
			<nav id="nav">
			
			
			<!-- 공지사항 -->
			<% if(param=="notice"){ %>
			<h2 id="nav-header">공지사항</h2>
			<ul class="nav-list">
				<li><a id="nav-selected" href="<%=request.getContextPath() %>/notice/noticeList">공지사항</a></li>
			</ul>
			<%} %>
			
			<!-- 게시판 -->
<<<<<<< HEAD
			<% if(param=="freeBoard" || param=="regionBoard" || param=="complain") {%>
			<h2 id="nav-header">게시판</h2>
			<hr style="border:0;height:2px;background: rgb(244,244,244);"/>
=======
			<% if(param=="freeBoard" || param=="regionBoard" || param=="complainBoard") {%>
			<h3 id="nav-header">게시판</h3>
>>>>>>> branch 'master' of https://github.com/raccoon200/semi_project
			<ul class="nav-list">
				<li><a id='<%=param=="freeBoard"?"nav-selected":""%>' href="<%=request.getContextPath() %>/board/freeBoard">자유게시판</a></li>
				<li><a id='<%=param=="regionBoard"?"nav-selected":""%>' href="<%=request.getContextPath() %>/board/regionBoard">지역게시판</a></li>
				<li><a id='<%=param=="complain"?"nav-selected":""%>' href="<%=request.getContextPath() %>/board/complainBoard">신고게시판</a></li>
			</ul>
			<%} %>
			<!-- 로그인/회원가입 -->
			<%if(param=="login" || param=="enroll") {%>
			<h2 id="nav-header">로그인/회원가입</h2>
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
			<%if(param=="memberTeamMemberManagement" || param=="memberTeamGameAcceptPage") {%>
			<h2 id="nav-header">팀 관리</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath()%>/member/memberTeamManagement?teamName=<%=memberLoggedIn.getTeamname()%>" id='<%=param=="memberTeamMemberManagement"?"nav-selected":""%>'>팀원 관리</a></li>
				<li><a href="#">팀원 수락</a></li>
				<li><a href="<%=request.getContextPath()%>/member/memberTeamGameAcceptPage?teamName=<%=memberLoggedIn.getTeamname()%>" id='<%=param=="memberTeamGameAcceptPage"?"nav-selected":""%>'>팀 경기 수락</a></li>
			</ul>
			<%} %>
			<%if(param=="memberInfo" || param=="memberTeamInfo" || param=="memberTeamManagement") {%>
			<h2 id="nav-header">마이페이지</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/member/memberInfo" id="<%=param=="memberInfo"?"nav-selected":"" %>" >내 정보</a></li>
				<li><a href="<%=request.getContextPath() %>/member/memberTeamInfo" id="<%=param=="memberTeamInfo"?"nav-selected":"" %>">내 팀 정보</a></li>
				<li><a href="<%=request.getContextPath() %>/member/memberTeamManagementPage?teamName="<%=memberLoggedIn.getTeamname()%>" id="<%=param=="memberTeamManagement"?"nav-selected":"" %>">내 팀 관리</a></li>
			</ul> 
			<%} %>
			<%if(param=="adminPage" || param=="adminPageTeam") {%>
			<!-- 관리자페이지 -->
			<h2 id="nav-header">관리자페이지</h2>
			<ul class="nav-list">
				<li><a href="<%=request.getContextPath() %>/admin/adminPage" id="<%=param=="adminPage"?"nav-selected":"" %>" >회원 관리</a></li>
				<li><a href="<%=request.getContextPath() %>/admin/adminPageTeam" id="<%=param=="adminPageTeam"?"nav-selected":"" %>">팀 관리</a></li>
				<li><a href="#">팀 수락</a></li>
				<li><a href="#">접속 통계</a></li>
			</ul>  
			<%} %>
		</nav>
		<section id="content">