<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userid = (String)request.getAttribute("userid");
    boolean isUsable = (boolean)request.getAttribute("isUsable");%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>아이디 체크</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script>
function fn_checkIdDuplicate(){
	var userid = $("#userid").val().trim();
	if(userid.length<4){
		alert('아이디는 4글자이상 가능합니다.');
		return false;
	}
	$("#userid").val(userid);
	return true;
	}
	function setUserId(userid){
		var frm = opener.document.memberEnrollFrm;
		frm.userid.value= userid;
		frm.idValid.value=1;
		frm.password.focus();
		self.close();
	}
</script>
<style>
div#checkid-container{text-align:center; padding-top:50px;}
span#duplicated{color:red; font-weight:bold;}
</style>
</head>
<body>
<div id="checkid-container">
<%if(isUsable==true){ %>
[<span><%=userid %></span>]는 사용 가능합니다.
<br /><br />
<button type="button" onclick="setUserId('<%=userid%> %>')">닫기</button>
<%} else { %>
[<span id="duplicated"><%=userid %></span>]는 이미 사용중입니다.
<br /><br />
<form action="<%=request.getContextPath() %>/member/checkIdDuplicate">
<input type="text" name="userid" id="userid" />&nbsp;
<input type="submit" value="아이디체크" onclick="return fn_checkIdDuplicate();"/>
</form>
<%} %>
</div>
</body>
</html>