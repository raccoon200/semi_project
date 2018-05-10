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
span.sp{font-size:20px;font-weight: bold;}
div#allDiv{text-align:center;}
div#allDiv2{text-align:left; padding: 5px 20px 0 10px;}
table td#td1{text-aling:center; padding:50px 0 0 0;}
</style>
<div id="allDiv">
<div id="allDiv2">
<h2>경기검색</h2>
<hr />
<table class="table table-hover">
<%-- <%if(!list.isEmpty()){ %>
	<%for(Game g : list){ %> --%>
	<pre>  <span class="sp" id="sp1">경기날짜</span>                        <span class="sp" id="sp2">경기팀</span>                    <span class="sp" id="sp3">게임시간<span/>   <span class="sp" id="sp4">상제정보</span></pre>
	<tr>
		<td id="td1"><h3>2018-09-01</h3></td>
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
		<td id="td1"><h3 >16:00</h3></td>
		<td>
			<%-- <%if (g.getAway() == null){ %> --%>
			<div class="alert alert-warning center">
				상세정보
			</div>
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
</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	