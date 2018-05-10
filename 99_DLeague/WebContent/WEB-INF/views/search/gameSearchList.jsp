<%@page import="com.dleague.game.model.vo.Game"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%
/* 	List<Game> list = (List<Game>)request.getAttribute("list");
	System.out.println(list); */
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
	text-align: center;
}
div.center{ 
	margin-top: 30px;
}
</style>
<script>
function fn_MemberList(gameNo){
	location.href= "<%=request.getContextPath()%>/game/gameView?no="+gameNo;
}
</script>
<h2>경기검색</h2>
<table class="table table-hover">
<%-- <%if(!list.isEmpty()){ %>
	<%for(Game g : list){ %> --%>
	<tr onclick="fn_MemberList('');">
		<td><h4>2018-09-01</h4></td>
		<td>
			<table style="display: inline-block;">
				<tr>
					<td>
						<img src="<%=request.getContextPath() %>/images/team/awayNull.png" alt="home" style="height: 112.188px;"/>
					</td>
				</tr>
				<tr>
					<td <%-- style='color: <%=memberLoggedIn.getTeamname().equals(g.getHome())?"red":""%>' --%>>
						홈팀		
					</td>
				</tr>
			</table>
			<h2 style="display: inline-block;">VS</h2>
			<table style="display: inline-block;">
				<tr>
					<td>
						<img src='<%=request.getContextPath() %>/images/team/awayNull.png' alt="home" style="height: 112.188px;"/>
					</td>
				</tr>
				<tr>
					<td <%-- style='color: <%=memberLoggedIn.getTeamname().equals(g.getAway())?"red":""%>' --%>>
						<%-- <%=g.getAway()==null?"&nbsp;":g.getAway() %>	 --%>어웨이팀				
					</td>
				</tr>
			</table>			
		</td>
		<td><h4>게임시간</h4></td>
		<td>
			<%-- <%if (g.getAway() == null){ %> --%>
			<div class="alert alert-warning center">
				상대 찾는중
			</div>
			<%-- <%} else if(g.getStatus() == null){ %> --%>
			<div class="alert alert-info center">
				경기 예정
			</div>
			<%-- <%} else if(g.getStatus().equals("Y")){ %> --%>
			<div class="alert alert-success center">
				경기 완료
			</div>
			<%-- <%} else {%> --%>
			<div class="alert alert-danger center">
				경기 미실시
			</div>
			<%-- <%} %> --%>
		</td>
	</tr>
<%-- 	<%} %>
<%} else{ %> --%>
	<tr>
		<td colspan="4"><br />
		<br />
		<br /><h4>내팀 경기 일정이 없습니다.</h4><br />
		<br /></td>
	</tr>
<%-- <%} %> --%>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	