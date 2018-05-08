<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>회원관리</title>
</head>
<body>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
	
%>
<style>
section#memberList-container{text-align:center;}
section#memberList-container table#tbl-member{
	width:100%; 
	border:1px solid gray;
	border-collapse:collapse;
}
table#tbl-member th, table#tbl-member td{
	border:1px solid gray;
	padding:10px;
} 
div#search-container{padding:3px; margin:0 0 10px 0; background:rgba(0,188,212,0.3);}
div#search-userId{display:inline-block;}
div#search-userName, div#search-gender{display:none;}

div#pageBar{margin-top:10px; text-align:center; background:rgba(0,188,212,0.3);}
div#pageBar span{margin:0 5px;}
</style>
<script>
$(function(){
	
	$("#searchType").change(function(){
		$("#search-userId").hide();	
		$("#search-userName").hide();	
		$("#search-regionCode").hide();
		
		$("#search-"+$(this).val()).css('display','inline-block');
	});	
});

</script>
<section id="memberList-container">
	<h2>회원관리</h2>
	<!-- 검색영역 -->
	<div id="search-container">
		검색타입 : 
		<select name="searchType" id="searchType">
			<option value="userId">아이디</option>
			<option value="userName">회원명</option>
			<option value="regionCode">지역명</option>
		</select>
		<div id="search-userId">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="userId"/>
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력하세요." required/>
				<button type="submit">검색</button>			
			</form>
		</div>
		<div id="search-userName">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="userName"/>
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 회원명을 입력하세요." required/>
				<button type="submit">검색</button>			
			</form>
		</div>
		<div id="search-regionCode">
			<form action="<%=request.getContextPath()%>/admin/memberFinder">
				<input type="hidden" name="searchType" value="regionCode"/>
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 지역명을 입력하세요." required/>
				<button type="submit">검색</button>			
			</form>
		</div>
	</div>
	<!-- 회원목록 -->
	<table id="tbl-member">
		<tr>
			<th>No</th>
			<th>회원명</th>
			<th>회원ID</th>
			<th>팀이름</th>
			<th>지역</th>
			<th>회원등급</th>
			<th>회원관리</th>
			
		</tr>
		<%if(list==null || list.isEmpty()){ %>
		<tr>
			<td colspan="7" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} else { 
			for(Member m : list){
		%>		
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/member/memberView?userId=<%=m.getUserId()%>">
						<%=m.getUserId()%>
					</a>
				</td>
				<td><%=m.getUserName()%></td>
				<td><%=m.getUserId%></td>
				<td><%=m.getTeamName()%></td>
				<td><%=m.getRegionCode()%></td>
				<td><%=m.getUserGrade()%></td>
				<td><%=m.getUserAdmin()%></td>
			</tr>
		
		
		
		<%}
		} %>
	</table>
	</section>
</body>
</html>