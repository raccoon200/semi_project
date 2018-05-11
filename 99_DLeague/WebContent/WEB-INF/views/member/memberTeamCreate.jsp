<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.region.model.vo.*, java.util.*" %>
<%
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");
%>

<style>
table.team-register-table{
	border:1px solid black;
	border-collapse:collapse;
	width:680px;
}
table.team-register-table tr{
	border:1px solid black;
	
}
table.team-register-table tr th{
	background: rgb(64,128,183);
	color:white;
}
table.team-register-table tr{
	height:5px;
}
table.team-register-table tr th, td{
	border:1px solid rgb(100,100,100);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.team-register-table tr:hover{
	background:rgb(240,240,240);
}
table.team-register-table th{
	width:60px
}
td.view-content{
	height:150px;
}
</style>
<h2>팀 생성</h2>
<form action="<%=request.getContextPath() %>/member/memberTeamCreateEnd" method="post" onsubmit="return fn_validate();" enctype="multipart/form-data">
	<table class="team-register-table">
		<tr>
			<th>팀이름</th>
			<td colspan="5">
			<input type="text" name="teamName" id="" required/>
			</td>
		</tr>
		<tr>
			<th>신청자(팀장)</th>
			<td colspan="5"><input type="text" name="board_region_writer" id="" value='<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>' readonly/></td>
		</tr>
		<tr>
			<th>지역</th>
			<td colspan="5">
				<select name="regionSelect" id="">
				<%if(regionList!=null && !regionList.isEmpty()){
				for(int i=0; i<regionList.size(); i++) {
					Region region = regionList.get(i);
				%>
					<option value="<%=region.getRegionCode()%>"><%= region.getRegionName()%></option>
				<%
					}
				} %>
				</select>
			</td>
		</tr>
		<tr>
			<th>팀로고</th>
			<td colspan="5">
				<input type="file" name="up_file" id="" />
			</td>
		</tr>
		<tr>
			<th colspan="6">팀소개</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content"><textarea name="introduce" id="" cols="100" rows="10" required></textarea></td>
		</tr>
		<tr>
			<th colspan="6">팀 신청 메시지</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content"><textarea name="register_msg" id="" cols="100" rows="10" required></textarea></td>
		</tr>
	</table>
	<input type="submit" value="신청" />
	<input type="reset" value="초기화" />
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		