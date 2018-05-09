<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<style>
form{
	text-align:center;
}
</style>
<body>
	<form action="<%=request.getContextPath()%>/member/passwordUpdate">
	<br /> <br /> <br />
	<label for="userId">유저 아이디: </label>
	<input type="text" name="userId" id="userId" value=<%=request.getAttribute("userId") %>  readonly/>
	<br /> <br />
	<label for="password">비밀번호 변경: </label>
	<input type="text" name="password" id="password" />
	<br /> <br />
	<input type="submit" value="변경" style="background:rgb(64,128,183); color:white;"/>
	<input type="reset" value="초기화" style="background:rgb(64,128,183); color:white;"/>
	<br /> <br /> <br />	
	</form>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</html>