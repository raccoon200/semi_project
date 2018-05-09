<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dleague.member.model.vo.*" %>

<% Member member = (Member)request.getAttribute("Member"); %>
<style>
table{border:1px solid;}
#profileImg{width:150px; height:150px;}
#imgsection{position: relative; left:350px; top:-250px;}
</style>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<section>
<form action="">
<table>
<tr>
<td>
<label for="userId">아이디 </label>
</td>
<td><input type="text" name="userId" id="userId" value="<%=member.getUserId()%>"/></td>
</tr>
<tr><td>
<label for="password">비밀번호 </label></td>
<td>
<input type="password" name="password" id="password" value="<%=member.getPassword()%>"/></td>
</tr>

<tr><td>
<label for="userName">이름</label></td>
<td>
<input type="text" name="userName" id="userName" value="<%=member.getUserName()%>"/></td>
</tr>

<tr><td>
<label for="regioncode">지역코드</label></td>
<td>
<input type="text" name="regioncode" id="regioncode" value="<%=member.getRegioncode()%>"/></td>
</tr>

<tr><td>
<label for="phone">핸드폰번호</label></td>
<td>
<input type="text" name="phone" id="phone" value="<%=member.getPhone()%>"/></td>
</tr>

<tr><td>
<label for="email">이메일</label></td>
<td>
<input type="email" name="email" id="email" value="<%=member.getEmail()%>"/></td>
</tr>

<tr><td>
<label for="birthday">생년월일</label></td>
<td>
<input type="text" name="birthday" id="birthday" value="<%=member.getBirthday()%>"/></td>
</tr>

<tr><td>
<label for="teamname">팀이름</label></td>
<td>
<input type="text" name="teamname" id="teamname" readonly value="<%=member.getTeamname()%>"/></td>
</tr>

<tr><td>
<label for="profile">프로필</label></td>
<td>
<input type="text" name="profile" id="profile" value="<%=member.getProfile()%>"/></td>
</tr>

<tr>
<td>
<label for="grade">등급</label></td>
<td>
<input type="text" name="grade" id="grade" readonly value="<%=member.getGrade()%>"/></td>
</tr>
<tr>
<td>
<label for="enrolldate">가입날짜</label></td>
<td>
<input type="text" name="enrolldate" id="enrolldate" readonly value="<%=member.getEnrolldate()%>"/></td>
</tr>
</table>

</form>
<section id="imgsection">
<input type="image" src="" id="profileImg"/>
<br />
<input type="file" name="" id="" accept="image/*" onchange="fn_fileUpload()"/>
</section>
<script>

function fn_fileUpload(){
	$("#profileImg").attr("src", "<%=request.getContextPath()%>/images/headerImage.jpg");
}

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>