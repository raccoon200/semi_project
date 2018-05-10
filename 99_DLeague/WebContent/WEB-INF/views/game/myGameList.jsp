<%@page import="com.dleague.game.model.vo.Game"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%
	List<Game> list = (List<Game>)request.getAttribute("list");
	System.out.println(list);
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
	text-align: center;
}
div.center{
	margin-top: 30px;
}
</style>
<h2>내 팀 경기 일정</h2>
<table class="table table-hover">
	<tr>
		<td>2018/12/12일</td>
		<td>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>
			<h2 style="display: inline-block;">VS</h2>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>			
		</td>
		<td>18 : 30</td>
		<td>
			<div class="alert alert-success center">
				경기 완료
			</div>
		</td>
	</tr>
	<tr>
		<td>2018/12/12일</td>
		<td>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>
			<h2 style="display: inline-block;">VS</h2>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>			
		</td>
		<td> 18 : 30</td>
		<td>
			<div class="alert alert-danger center">
				경기 미실시
			</div>
		</td>
	</tr>
	<tr>
		<td>2018/12/12일</td>
		<td>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>
			<h2 style="display: inline-block;">VS</h2>
			<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="width: 150px;"/>			
		</td>
		<td> 18 : 30</td>
		<td>
			<div class="alert alert-warning center">
				상대 찾는중
			</div>
		</td>
	</tr>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	