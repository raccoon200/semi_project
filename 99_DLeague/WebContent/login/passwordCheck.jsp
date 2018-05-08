<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset=UTF-8>
<title>패스워드 색인</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js""></script>
<script>
function fn_checkValidate() {
	var birthdayVal = $("#birthday").val().replace(/ /gi, ""); //공백 제거한 값
	
	if(birthdayVal.length!=6) {
		alert("생년월일은 6자리로 입력하시오!");
		return false;
	}
	return true;
}
</script>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<body>
	<form action="<%=request.getContextPath()%>/member/passwordCheck" onsubmit="return fn_checkValidate();">
	
	<label for="userId">검색할 아이디: </label>
	<input type="text" name="userId" id="userId" placeholder="userId"/>
	<br /><br />
	<label for="birthday">생년월일: </label>
	<input type="text" name="birthday" id="birthday" placeholder="910209"/>
	<br /> <br />
	<input type="submit" value="전송" />
	<input type="reset" value="리셋" />
	
	</form>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</html>