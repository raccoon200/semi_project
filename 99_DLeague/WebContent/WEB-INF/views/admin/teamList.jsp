<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>팀관리</title>
</head>
<body>
<%
	List<Team> list = (List<Team>)request.getAttribute("list");
	
%>
<style>
section#memberList-container{text-align:center;}
section#memberList-container table#tbl-team{
	width:100%; 
	border:1px solid gray;
	border-collapse:collapse;
}
table#tbl-team th, table#tbl-team td{
	border:1px solid gray;
	padding:10px;
} 
div#search-container{padding:3px; margin:0 0 10px 0; background:rgba(0,188,212,0.3);}
div#search-teamName{display:inline-block;}
div#search-Area, div#teamNumber{display:none;}

div#pageBar{margin-top:10px; text-align:center; background:rgba(0,188,212,0.3);}
div#pageBar span{margin:0 5px;}
</style>
<script>
$(function(){
	
	$("#searchType").change(function(){
		$("#search-teamName").hide();	
		$("#search-regionCode").hide();	
		$("#search-teamNumber").hide();
		
		$("#search-"+$(this).val()).css('display','inline-block');
	});	
});

</script>
<section id="teamList-container">
	<h2>회원관리</h2>
	<!-- 검색영역 -->
	<div id="search-container">
		검색타입 : 
		<select name="searchType" id="searchType">
			<option value="teamName">팀명</option>
			<option value="Area">지역</option>
			<option value="teamNumber">팀인원</option>
		</select>
		<div id="search-teamName">
			<form action="<%=request.getContextPath()%>/admin/teamFinder">
				<input type="hidden" name="searchType" value="teamName"/>
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력하세요." required/>
				<button type="submit">검색</button>			
			</form>
		</div>
		<div id="search-regionCode">
			<form action="<%=request.getContextPath()%>/admin/teamFinder">
				<input type="hidden" name="searchType" value="Area"/>
				<input type="search" name="searchKeyword" size="25" placeholder="검색할 회원명을 입력하세요." required/>
				<button type="submit">검색</button>			
			</form>
		</div>
		
	</div>
	<!-- 회원목록 -->
	<table id="tbl-team">
		<tr>
			<th>No</th>
			<th>팀명</th>
			<th>지역</th>
			<th>팀인원</th>
			<th>창단일</th>
			<th>팀관리</th>
			
		</tr>
		<%if(list==null || list.isEmpty()){ %>
		<tr>
			<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} else { 
			for(Team t : list){
		%>		
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/team/teamView?teamName=<%=m.getTeamName()%>">
						<%=t.getTeamName()%>
					</a>
				</td>
				<td><%=t.getteamName()%></td>
				<td><%=t.getregionCode%></td>
				<td><%=t.getteamNumber()%></td>
				<td><%=t.getregisterDate()%></td>
				<td><%=t.getteamAdmin()%></td>
			</tr>
		
		
		
		<%}
		} %>
	</table>
	</section>
</body>
</html>