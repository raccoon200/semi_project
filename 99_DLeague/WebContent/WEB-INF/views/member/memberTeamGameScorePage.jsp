<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String gameNo = (String)request.getAttribute("gameNo"); 
	String teamName = (String)request.getAttribute("teamName");	
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
<style>
div#gameScore-container{
	background:white;
}
div#gameScore-container table {
	margin:0 auto;
	border-spacing: 20px;
}
div#gameScore-container table tr:last-of-type td {
	text-align:center;
	text-size:12px;
}
</style>
<script>
function fn_ScoreGo() {
	if($("[name=home]").val()=="" || $("[name=away]").val()=="" ) { 
		alert("점수를 입력하십시오!!");
		return false;
	} else {
		return true;
	}
}
</script>
</head>
<body>
	<div id="gameScore-container">
		<form name="gameScoreFrm" onsubmit="return fn_ScoreGo();" action="<%=request.getContextPath()%>/member/memberTeamActivity" method="post" >
			<table>
				<tr>
					<th colspan="2">경기 결과를 입력하시오</th>
				</tr>
				<tr>
					<th>HOME TEAM</th>
					<th>AWAY TEAM</th>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="number" name="home" min="0" max="200"/>&nbsp;&nbsp;&nbsp;&nbsp;:</td>
					<td><input type="number" name="away" min="0" max="200"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="btn" value="확인" />&nbsp;
						<input type="button" class="btn" onclick="self.close();" value="닫기" />						
					</td>
				</tr>
			</table>
			<input type="hidden" name="gameNo" value="<%=gameNo%>" />
			<input type="hidden" name="gameNo" value="<%=teamName%>" />
		</form>
	</div>
</body>
</html>