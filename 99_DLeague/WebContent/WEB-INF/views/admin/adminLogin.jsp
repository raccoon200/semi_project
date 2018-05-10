<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>관리자 로그인</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

</head>
<body>
<div class="container ad" style="max-width:560px;">
<label>아이디</label>
<input type="text" name="adminID" class="form-control">
</div>
<label>비밀번호</label>
<input type="password" name="adminPassword" class="form-control">
<button type="submit" class="btn btn-primary">로그인</button>



</body>
</html>