<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dleague.member.model.vo.*,java.util.*" %>

<% List<Member> list = (List<Member>)request.getAttribute("list"); %>
<style>
table{border:1px solid;}
#profileImg{width:150px; height:150px;}
#imgsection{position: relative; left:350px; top:-250px;}
</style>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>

<section>
<form action="<%=request.getContextPath()%>/member/MemberInfoUpdate" method="post" enctype="multipart/form-data">
	<table>
	<tr>
	<td>
	<%for(Member member:list){ %>
	<label for="userId">아이디 </label>
	</td>
	<td><input type="text" name="userId" id="userId" value="<%=member.getUserId()%>" readonly/></td>
	</tr>
	<tr><td>
	<label for="password">비밀번호 </label></td>
	<td>
	<input type="password" name="password" id="password" value="<%=member.getPassword()%>" required/></td>
	</tr>
	
	<tr><td>
	<label for="userName">이름</label></td>
	<td>
	<input type="text" name="userName" id="userName" value="<%=member.getUserName()%>" required/></td>
	</tr>
	
	<tr><td>
	<label for="regioncode">지역코드</label></td>
	<td>
	<input type="text" name="regioncode" id="regioncode" value="<%=member.getRegioncode()%>" required/></td>
	</tr>
	
	<tr><td>
	<label for="phone">핸드폰번호</label></td>
	<td>
	<input type="text" name="phone" id="phone" value="<%=member.getPhone()%>" required/></td>
	</tr>
	
	<tr><td>
	<label for="email">이메일</label></td>
	<td>
	<input type="email" name="email" id="email" value="<%=member.getEmail()%>"/></td>
	</tr>
	
	<tr><td>
	<label for="birthday">생년월일</label></td>
	<td>
	<input type="text" name="birthday" id="birthday" value="<%=member.getBirthday()%>" required/></td>
	</tr>
	
	<tr><td>
	<label for="teamname">팀이름</label></td>
	<td>
	<input type="text" name="teamName" id="teamName" readonly value="<%=member.getTeamname()%>"/></td>
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
	<input type="text" name="grade" id="grade" readonly value="<%=member.getGrade()%>" required/></td>
	</tr>
	<tr>
	<td>
	<label for="enrolldate">가입날짜</label></td>
	<td>
	<input type="text" name="enrolldate" id="enrolldate" readonly value="<%=member.getEnrolldate()%>"/></td>
	</tr>
	
	
	</table>
	<br />
	<input type="submit" value="수정" />
	<input type="reset" value="초기화" />
	<section id="imgsection">
	<input type="image" <%-- src="<%=request.getContextPath()%>/upload/member/<%=member.getPhoto()%>" --%> id="profileImg"/>
	<br /> 
	<div style="position:relative;">
	<input type="file" name="up_file" id="up_file" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);" />
	<span id="fname">프로필 사진 변경</span>
	</div>
</section>
</form>
<script>
$(function (){

$("#profileImg").attr("src", "<%=request.getContextPath()%>/upload/board/<%=member.getPhoto()%>");
});
$("[name=up_file]").change(function(){ 
	//$(this).val()은 선택한 파일명임.
	if($(this).val()==""){
		$("#fname").show();
	}	
	else{
		$("#fname").hide();
	}
});	
function fn_fileUpload(value){
	 if(value.files && value.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
             $('#profileImg').attr('src', e.target.result);
			}
        }
        reader.readAsDataURL(value.files[0]);
	}
</script>
<%} %>
<style>

span#fname{
	position:absolute;
	left:76px;
	top:3px;
	width:285px;
	background:white;
}
</style>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>