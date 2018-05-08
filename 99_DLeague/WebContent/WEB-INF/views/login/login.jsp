<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" "text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>free login form -bootstrap</title>
 
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Style -->
   
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></scri.row>.containerpt>
    <![endif]-->
<style>
	.col-md-3{
		postion: relative;
		left: 250px;
	}
</style>   
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
  <body>
    <div class="container">
      <div class="row">
        <div class="page-header">
          <h2>로그인 </h2>
        </div>
        <div class="col-md-3">
          <div class="login-box well">
        <form id="loginFrm" method="post" action="<%=request.getContextPath() %>/member/login">
            <legend>로그인</legend>
            <div class="form-group">
                <label for="userId">아이디</label>
                <input name="userId" id="userId" placeholder="UserId" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input name="password" id="password" placeholder="Password" type="password" class="form-control" />
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" value="Login" />
            </div>
            <span class='text-center'><a href="<%=request.getContextPath() %>/login/passwordCheck.jsp" class="text-sm">비밀번호 찾기</a></span>
            <hr />
            <div class="form-group">
                <a href="" class="btn btn-default btn-block m-t-md">회원가입</a>
            </div>
        </form>
          </div>
        </div>
      </div>
    </div>
 
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->

  <script src="js/bootstrap.min.js"></script>
  </body>
  <%@ include file="/WEB-INF/views/common/footer.jsp"%>
  </html>
  