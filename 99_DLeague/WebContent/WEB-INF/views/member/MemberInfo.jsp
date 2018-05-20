<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dleague.member.model.vo.*" %>

<% Member member = (Member)request.getAttribute("Member"); %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<style>

#profileImg{width:150px; height:150px;}
#imgsection{position: relative; left:500px; top:-503px;}
 .btnM {
  display: inline-block;
  background: transparent;
  text-transform: uppercase;
  font-weight: 500;
  font-style: normal;
  font-size: 1rem;
  letter-spacing: 0.3em;
  color:rgba(223,190,106,0.8);
  border-radius: 0;
  padding: 18px 80px 20px;
  transition: all 0.7s ease-out;
  background: linear-gradient(270deg, rgba(223,190,106,0.8), rgba(146,111,52,0.8), rgba(34,34,34,0), rgba(34,34,34,0));
  background-position: 1% 50%;
  background-size: 300% 300%;
  text-decoration: none;
  margin: 0.625rem;
  border: none;
  border: 1px solid rgba(223,190,106,0.8);
}

.btnM:hover {
  cursor:pointer;
  color: #fff;
  border: 1px solid rgba(223,190,106,0);
  color: $white;
  background-position: 99% 50%;
}  
/* 버튼 디자인 */
</style>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<script>
function fn_memberOut() {
	
	if(confirm("정말 탈퇴하시겠습니까?")) {
		if("팀원"=="<%=memberLoggedIn.getGrade()%>") alert("팀을 먼저 탈퇴해주세요!");
		else if("팀장"=="<%=memberLoggedIn.getGrade()%>") alert("팀을 먼저 삭제해주세요!"); 
		else
		location.href="<%=request.getContextPath()%>/member/memberOut?userId=<%=memberLoggedIn.getUserId()%>";
	}
}
function fn_memberUpdateCheck() {
	if($("#up_file").val()=="") {
		change.innerHTML = "<input type=\'file\' name=\'my_file\' value=\'<%=memberLoggedIn.getPhoto()%>'";
		return true;
	} else return true;
}
function fn_update_password(){
	var url = "<%=request.getContextPath()%>/member/updatePassword?userId=<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>";
	var title = "updatePassword";
	var status = "left=500px, top=200px, width=450px, height=260px";
	
	var popup = window.open(url, title, status);
}
</script>
<section>
<form action="<%=request.getContextPath()%>/member/MemberInfoUpdate" method="post" enctype="multipart/form-data" onsubmit="return fn_memberUpdateCheck();">
<h2>내 정보</h2>
<hr /><br />
<table class="table table-striped" style="width: 60%;">
<tr>
<td>
<label for="userId">아이디 </label>
</td>
<td><input type="text" name="userId" id="userId" value="<%=member.getUserId()%>" readonly/></td>
</tr>
<%-- <tr><td>
<label for="password">비밀번호 </label></td>
<td>
<input type="password" name="password" id="password" value="<%=member.getPassword()%>" required/></td>
</tr> --%>

<tr><td>
<label for="userName">이름</label></td>
<td>
<input type="text" name="userName" id="userName" value="<%=member.getUserName()%>" required/></td>
</tr>

<tr><td>
<label for="regioncode">지역명</label></td>
<td>
<select id="regioncode" class="form-control" name= "regioncode" style="width: 50%;">
	<option value="G1" <%="G1".equals(member.getRegioncode())?"selected":""%>>서울</option>
	<option value="G2" <%="G2".equals(member.getRegioncode())?"selected":""%>>경기</option>
	<option value="G3" <%="G3".equals(member.getRegioncode())?"selected":""%>>강원</option>
	<option value="G4" <%="G4".equals(member.getRegioncode())?"selected":""%>>충북</option>
	<option value="G5" <%="G5".equals(member.getRegioncode())?"selected":""%>>충남</option>
	<option value="G6" <%="G6".equals(member.getRegioncode())?"selected":""%>>경북</option>
	<option value="G7" <%="G7".equals(member.getRegioncode())?"selected":""%>>전북</option>
	<option value="G8" <%="G8".equals(member.getRegioncode())?"selected":""%>>전남</option>
	<option value="G9" <%="G9".equals(member.getRegioncode())?"selected":""%>>제주</option>
</select>
<%-- <input type="text" name="regioncode" id="regioncode" value= "
<%if("G1".equals(member.getRegioncode()) ) {%>서울
" 
required/> --%></td>
</tr>

<tr><td>
<label for="phone">핸드폰번호</label></td>
<td>
<input type="text" name="phone" id="phone" value="<%=member.getPhone()%>" required/></td>
</tr>

<tr><td>
<label for="email">이메일</label></td>
<td>
<input type="email" class = "form-control" name="email" id="email" value="<%=member.getEmail()!=null?member.getEmail():""%>"/></td>
</tr>

<tr><td>
<label for="birthday">생년월일</label></td>
<td>
<input type="text" name="birthday" id="birthday" value="<%=member.getBirthday()%>" required readonly/></td>
</tr>

<tr><td>
<label for="teamname">팀이름</label></td>
<td>
<input type="text" name="teamName" id="teamName" readonly value="<%=member.getTeamname()!=null?member.getTeamname():""%>"/></td>
</tr>

<tr><td>
<label for="profile">프로필</label></td>
<td>
<input type="text" name="profile" id="profile" value="<%=member.getProfile()!=null?member.getProfile():""%>"/></td>
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
<input type="submit" value="수정" class="btn btn-primary"/>
<input type="reset" value="초기화" class="btn btn-primary"/>
<input type="button" value="비밀번호수정" class="btn btn-primary" onclick="fn_update_password()" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="회원 탈퇴" style="position:relative; " class="btn btn-danger" onclick="fn_memberOut()"/>
<section id="imgsection">
<input type="image" style="pointer-events: none;" id="profileImg" class="img-rounded"/>
<br /> 
<div style="position:relative;">
<input type="file" name="up_file" id="up_file" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);"/>

<span id="fname">프로필 사진 변경</span>
</div>
</section>
</form>
<script>
$(function (){

	if("<%=member.getPhoto()%>"=="default.jpg" || "<%=member.getPhoto()%>"=="null") {
        $('#profileImg').attr('src', "<%=request.getContextPath() %>/images/profile/default.jpg");
     } 
	else {
		$("#profileImg").attr("src", "<%=request.getContextPath()%>/upload/member/<%=member.getPhoto()%>");
	}
	$("input:text").addClass("form-control");
});
$("[name=up_file]").change(function(){ 
	//$(this).val()은 선택한 파일명임.
	if($("#up_file").val()=="") {
		$('#profileImg').attr('src', "<%=request.getContextPath() %>/images/profile/default.jpg");
	}
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