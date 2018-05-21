<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <%@ include file="/WEB-INF/views/common/nav.jsp" %>
    <%@ page import="com.dleague.member.model.vo.*, com.dleague.region.model.vo.*, java.util.*" %>
    <%
    Member m = (Member)request.getAttribute("member");
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");
    %>
        <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Style -->
    <style>
    table{align:center;}
    #profile{position: relative; left:-110px; top:0px;}
    #profileImg{width:100px; height:150px;} 
#imgsection{position: relative; left:535px; top:-265px;}


#userId_{width:80%; display:inline-block;}

#passwordCheckTd{
	position:relative;
}
#passwordCheckMessage {
	position:absolute;
	top:10px;
	left:10px;
}
    </style>
<script>
function fn_checkIdDuplicate(){
   
   var userId = $("#userId_").val().trim();
   if(userId.length<4){
      alert('아이디는 4글자 이상부터 가능합니다. \n (영대소문자와 숫자포함 4~12자)');
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

function fn_birthday() {
	 if($("#birthday").val().length!=6 || Number($("#birthday").val())==NaN) {
		/* alert("생년월일은 6자리숫자로입력해주세요"); */
		return false;
	}
	var year = Number($("#birthday").val().substr(0,2));
	var month = Number($("#birthday").val().substr(2,2));
	var day = Number($("#birthday").val().substr(4,2));
/* 	console.log("year="+year);
 */	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0 ));
	if(month <1 || month >12){
		return false;
	} else if(day <1 || day >31) {
		return false;
	}  /* else if ((month==4 || month==6 || month==9 || month=11) && day==31){
		return false;
	}  */ else if(month ==2) {
	    if (day >29 || (day==29 && !isleap)){
			return false;
	    }
	} 
	 return true;
}
function passwordCheckFunction() {
	var password = $('#password_').val();
	var passwordchk = $('#password_chk').val();
	if ( password != passwordchk) {
		$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
	} else if(password == passwordchk){
		$('#passwordCheckMessage').html('');
	}
	}

function fn_checked() {
	var idtext = document.getElementById("userId_");
	var patext = document.getElementById("password_");
	var cpatext = document.getElementById("password_chk");
	var mtext = document.getElementById("email_");
	var m1text = document.getElementById("email_1");
	var nametext = document.getElementById("userName");
	var bitext = document.getElementById("birthday");
	var phtext = document.getElementById("phone");
	var intro = document.getElementById("profile");
	
	var userId = idtext.value;
	var password = patext.value;
	var password_chk = cpatext.value;
	var email_ = mtext.value;
	var email_1 = m1text.value;
	var userName = nametext.value;
	var birthday = bitext.value;
	var phone = phtext.value;
	
	/* console.log(userId);
	console.log(password);
	console.log(password_chk);
	console.log("email ="+email_+"@"+email_1);
	console.log(userName);
	console.log(birthday);
	console.log(phone); */
	var regExp0 = /^[a-zA-Z0-9]{4,12}$/;
	var regExp1 = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
/* 	var regExp1 = /^[a-zA-Z0-9]{4,12}$/;
 */	//id와 비밀번호의 유효성 검사
	var regExp2 = /[a-z0-9]{2,}$/;
	var regExp3 = /[a-z0-9]{2,}\.[a-z0-9]{2,}$/;
	//email의 직접입력부분 유효성검사
	var regname = /^[가-힝]{2,5}$/;
	// 이름 유효성 검사
  	var regExp4 = /[0-9]{6,6}$/; 
	// 주민번호 유효성 검사
	var regph = /^01[0-9]{8,9}$/s;
	// 폰번호유효성 검사
/* 	console.log("userid ="+userId);
 */	if(!regExp0.test(userId))
	{
		alert("Id를 제대로 입력해주세요.");
		idtext.focus();
		return false;
	}else if($("[name=idValid]").val() != 1){
		alert("ID중복체크를 해주세요.")
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
	else if(!(password_chk.slice(0,password_chk.length) === password.slice(0,password.length)))
		{
		alert("비밀번호가 동일하지 않습니다.");
		cpatext.value = "";
		cpatext.focus();
		return false;
		}
	else if ((password_chk.slice(0, password_chk.length) === userId.slice(0, userId.length)))
		{
		alert("비밀번호가 ID와 동일하면 안됩니다.");
		patext.value= "";
		patext.focus();
		cpatext.value= "";
		cpatext.focus();
		return false;
		}
	else if(!regname.test(userName))
		{
			alert("이름을 제대로 입력해주세요.");
			nametext.value ="";
			nametext.focus();
			return false;
			}
	else if(!fn_birthday()||!regExp4.test(birthday)) {
		alert("생년월일을 제대로 입력해주세요."); 
		bitext.value="";
		bitext.focus();
		return false;
		
		
	}
	else if(!regph.test(phone))
		{
		alert("전화번호를 확인해주세요.");
		phtext.value="";
		phtext.focus();
		return false;
		}
	else if (!regExp2.test(email_))
		{
		alert("이메일을 확인해주세요.");
		mtext.value= "";
		mtext.focus();
		return false;
		}
	else if (!regExp3.text(email_1))
		{
		alert("직접입력부분을 확인해주세요.");
		m1text.value="";
		m1text.focus();
		return false;
		}
	else if (intro.value ==""){
		alert("자기 소개란을 100자 내외로 입력해주세요.");
		return false;
	}
	return true;
}
</script>
<section id = "enroll-container">

<form name="memberEnrollFrm" action="<%=request.getContextPath() %>/member/memberEnrollEnd" onsubmit="return fn_checked();" method="post" enctype="multipart/form-data">
<table class = "table table-bordered table-hover" style="text-align: center; border : 1px solid #dddddd">
<thead>
<tr>
<th colspan="3"><h4 style="font-weight : bold;">회원 가입</h4></th>
</thead>
<tbody>
<tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">아이디</h5></td>

<td style="text-align:left;">
<input class="form-control" type="text" name="userId" id="userId_" placeholder = "아이디를 입력하세요 . (영대소문자와 숫자포함 4~12자)" value ="" required/>

<input class = "btn btn-primary pull-right" value="중복검사" id="btn-idValid" onclick="fn_checkIdDuplicate()" style="width:100px;" />
<input type = "hidden" name="idValid" value="0" />
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">비밀번호</h5></td>
<td>
<input class="form-control" type="password" name="password" id="password_" placeholder ="비밀번호를 입력하세요. (1개의 숫자 혹은 특수 문자를 포함한 영문 대소문자 6~20자)" onkeyup="passwordCheckFunction();" value =""/>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">비밀번호 확인</h5></td>
<td>
<input class="form-control" type="password" id="password_chk" placeholder ="위와 동일한 비밀번호를 입력하세요." onkeyup="passwordCheckFunction();" value ="" />
</td>
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">이름</h5></td>
<td>
<input class="form-control" type="text" name="userName" id="userName" value ="" placeholder ="(이름 5글자내외)"/>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">생년월일</h5></td>
<td>
<input class="form-control" type="text" name="birthday" id="birthday" value ="" placeholder="(주민번호 앞 6자리)" maxlength="6"/> 
</td>
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">휴대폰</h5></td>
<td>
<input class="form-control" type="tel" id="phone" name="phone" placeholder="(-없이)01012345678" maxlength="11" value =""/>
</td>
</tr>
<tr>
<td style ="width:110px;"><h5 style="font-weight : bold;">이메일</h5></td>
<td style="text-align: left;">
<input type="text" name="email1"  id="email_" value =""  >@
<input type="text" name = "email2" id="email_1" disabled value="naver.com" value = "">
<select name="selectEmail" id="selectEmail"  style = "height:30px">
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
<td style ="width:110px;"><h5 style="font-weight : bold;">거주지역</h5></td>
<td style = "text-align:left;">
            <select name="regioncode" id="" style = "height:30px">
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
<td style ="width:110px;"><h5 style="font-weight : bold;">프로필</h5></td>
<td>
<textarea id="profile" name="profile" maxlength="2048" cols="50"style="height:180px;" placeholder = "자기소개란"></textarea>
</td>
</tr>
<tr>
<td style = "text-align: left" colspan="3" id="passwordCheckTd"><h5 style ="color: red;" id ="passwordCheckMessage" ></h5><input class = "btn btn-primary pull-right" type="submit" value="회원가입"><input class = "btn btn-primary pull-right" type="reset" value="취소"></td>
</tr>
</tbody>
</table>
 <section id="imgsection">
<input type="image" src="<%=request.getContextPath() %>/images/profile/default.jpg" id="profileImg"/>
<br /> 
<div style="position:relative;">
 <input type="file" name="up_file" id="up_file" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);"  /> 
</div>
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
   		var value2 = $("#up_file").val();
   if(value2=="") {
        $('#profileImg').attr('src', "<%=request.getContextPath() %>/images/profile/default.jpg");
     } 
        if(value.files && value.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                 $('#profileImg').attr('src', e.target.result);         
    			}
            }
            reader.readAsDataURL(value.files[0]);
   }
}

</script> 
 <%-- <%
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
    --%>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

