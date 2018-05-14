<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <%@ include file="/WEB-INF/views/common/nav.jsp" %>
    <%@ page import="com.dleague.member.model.vo.*, com.dleague.region.model.vo.*, java.util.*" %>
    <%
    Member m = (Member)request.getAttribute("member");
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");

    %>
    <style>
    table{align:center;}
    #profileImg{width:150px; height:150px;} 
#imgsection{position: relative; left:500px; top:-655px;}

    </style>
<script>
function fn_checkIdDuplicate(){
	console.log("aa");
	var userId = $("#userId_").val().trim();
	if(userId.length<4){
		alert('아이디는 4글자 이상부터 가능합니다.');
		return;
	}
	
	var url = "<%=request.getContextPath()%>/member/checkIdDuplicate";
	var title = "checkIdDuplicate";
	var status = "left=350px, top=100px, width=300px, height=200px";
	var popup = window.open("",title,status);
	
	var checkIdDuplicateFrm = document.checkIdDuplicateFrm;
	checkIdDuplicateFrm.userId.value=userId;
	
	checkIdDuplicateFrm.target = title;
	checkIdDuplicateFrm.action = url;
	checkIdDuplicateFrm.submit();
	
}
function checked() {
	var idtext = document.getElementById("userId");
	var patext = document.getElementById("password");
	var cpatext = document.getElementById("password_chk");
	var mtext = document.getElementById("email");
	var nametext = document.getElementById("userName");
	var intro = document.getElementBYId("profile");
	
	var userId = idtext.value;
	var password = patext.value;
	var password_chk = cpatext.value;
	var email = mtext.value;
	var userName = nametext.value;
	
	var regExp1 = /^[a-zA-Z0-9]{4,12}$/;
	//id와 비밀번호의 유효성 검사
	var regExp2 = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/i;
	//email 유효성검사
	var regname = /^[가-힝]{2,}$/;
	// 이름 유효성 검사
	
	if(!regExp1.test(userId))
		//아이디 유효성 검사 후 4~12자의 영문 대소문자와 숫자의 유효성이 안맞다면
		//공백을 주고 알람을 띄운다.
		//밑에 동일한 유효성 검사
	{
		alert("Id를 제대로 입력해주세요.");
		idtext.value = "";
		idtext.focus();
		return false;
	}
	else if(!regExp1.test(password))
		{
		alert("비밀번호를 제대로 입력해주세요.");
		patext.value="";
		patext.focus();
		return false;
		}
	else if(!(password_chk.slice(0, password_chk.length) === password.slice(0,password.length)))
		{
		alert("비밀번호가 동일하지 않습니다.");
		cpatext.value = "";
		cpatext.focus();
		return false;
		}
	else if ((password_chk.slice(0, password_chk.length) === id.slice(0, id.length)))
		{
		alert("비밀번호가 ID와 동일하면 안됩니다.");
		patext.value= "";
		patext.focus();
		cpatext.value= "";
		cpatext.focus();
		return false;
		}
	else if (!regExp2.test(email))
		{
		alert("올바른 이메일 형식이 아닙니다.");
		mtext.value= "";
		mtext.focus();
		return false;
		}
	else if(!regname.test(userName))
		{
		alert("이름을 제대로 입력해주세요.");
		nametext.value ="";
		nametext.focus();
		return false;
		}
	else if (intro.value ==""){
		alert("자기 소개란을 100자 내외로 입력해주세요.");
		return false;
	}
	else {
		if(checks())
			{
			alert("회원가입중입니다.");
			return true;
			}
		else {
			return false;
		}
	}
}
	
		//http://bitjava.tistory.com/35 <-참조
		
		
	
		

</script>
<section id = "enroll-container">
<h2>회원가입 정보입력</h2>
<form name="memberEnrollFrm" action="<%=request.getContextPath() %>/member/memberEnrollEnd" method="post" enctype="multipart/form-data">
 <!--  -->
<!-- onsubmit="return fn_enrollValidate(); -->
<table class = "table table-bordered table-hover" style="text-align: center; border : 1px solid #dddddd">
<thead>
<tr>
<th colspan="3"><h4>회원 가입</h4></th>
</thead>
<tbody>
<tr>


<tr>
<td style ="width:110px;"><h5>아이디</h5></td>
<td>
<input class="form-control" type="text" name="userId" id="userId_" required/>
<td style="width:110p;"> <input type="button" value="아이디체크"
id="btn-idValid" onclick="fn_checkIdDuplicate()"/>
<input type = "hidden" name="idValid" value="0" />
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>비밀번호</h5></td>
<td>
<input class="form-control" type="password" name="password" id="password_" />
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>비밀번호 확인</h5></td>
<td>
<input class="form-control" type="password" id="password_chk" />
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>이름</h5></td>
<td>
<input class="form-control" type="text" name="userName" id="userName"/>
</td>
</tr>
<tr>
<!-- <th>Photo</th>
<td>
<input type="file" name="photo" id="photo"/>
 </td>
 </tr> -->
 
<tr>
<td style ="width:110px;"><h5>생년월일</h5></td>
<td>
<input class="form-control" type="date" name="birthday" id="birthday"/>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>휴대폰</h5></td>
<td>
<input class="form-control" type="tel" id="phone" name="phone"
placeholder="(-없이)01012345678" maxlength="11"/>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>이메일</h5></td>

<td>
<input type="text" name="email"  id="email_" >@
<input type="text" name = "email" id="email_1" disabled value="naver.com">
<select name="selectEmail" id="selectEmail">
<option value="1">직접입력</option>

<option value="naver.com" selected>naver.com</option>
<option value="daum.net">daum.net</option>
<option value="hotmail.com">hotmail.com</option>
<option value="gmail.com">gmail.com</option>

</select>
<script>
//자동완성 함수
$("#selectEmail").change(function() {
   $("#selectEmail option:selected").each(function() {
      if($(this).val() =='1') {
         $("#email_1").val("");
         $("#email_1").attr("disabled",false);
         }else {
            $("#email_1").val($(this).text());
            $("#email_1").attr("disabled",true);
         }
      
   });
});

</script>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5>거주지역</h5></td>
<td>
            <select name="regioncode" id="">
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
<td style ="width:110px;"><h5>프로필</h5></td>
<td>
<textarea id="profile" name="profile" maxlength="2048" style="height:180px;"></textarea>
</td></tr>
</table>
<input type="submit" value="가입" />
<input type="reset" value="취소" />
 <section id="imgsection">
<input type="image" src="<%=request.getContextPath() %>/images/profile/default.jpg" id="profileImg"/>
<br /> 
<div style="position:relative;">
 <input type="file" name="up_file" id="up_file" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);" /> 
<!-- <span id="fname">프로필 사진 변경</span>
 --></div>
</section>
</form>
<form name="checkIdDuplicateFrm" method="post">
<input type="hidden" name="userId"/>
</form>
</section>
<script>
$(function (){

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
<%
String messageContent = null;
if(session.getAttribute("messageContent") != null) {
messageContent = (String) session.getAttribute("messageContent");}
String messageType=null;
if(session.getAttribute("messageType") != null) {
   messageType = (String) session.getAttribute("messageType");
}
if(messageContent != null) {
   %>
   <div class= "modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="vertical-alignment-helper">
   <div class = "modal-content <% if(messageType.equals("오류메시지")) out.println("panel-warning"); else out.println("panel-success"); %>">
   <div class= "modal-header panel-heading">
   <button type="button" class="close" data-dismiss="modal">
   <span aria-hidden="true">&times;</span>
   </button>
   <h4 class="modal-title">
   <%=messageType %></h4>
   </div>
   <div class= "modal-body">
   <%=messageContent %></div>
   <div class="modal-footer">
   <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button></div>
   </div>
   </div>
   </div>
   <script>
   $('#messageModal').modal("show");
   </script>
   <%
   session.removeAttribute("messageContent");
   session.removeAttribute("messageType");
}
   %>
   
 


<%@ include file="/WEB-INF/views/common/footer.jsp" %>


