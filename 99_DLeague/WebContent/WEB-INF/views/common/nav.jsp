<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="<%=request.getContextPath() %>/board/FreeBoard">자유게시판</a></li>
				<li><a href="<%=request.getContextPath() %>/board/RegionBoard" id="nav-selected">지역게시판</a></li>
				<li><a href="<%=request.getContextPath() %>/board/ComplainBoard">신고게시판</a></li>
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