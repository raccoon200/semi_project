<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%--isErrorPage설정을 true로 하면, exception내장객체 사용가능 --%>
<!DOCTYPE>
<html lang="ko">
<head>
<meta charset=UTF-8>
<title>에러페이지</title>
<style>
    img#basketball{
        position: relative;
        width: 100px;
        height: 100px;
        animation-name: ani1;
        animation-duration: 3s;
        animation-direction: alternate-reverse;
        animation-iteration-count: infinite;
    }
    @keyframes ani1{
        from{
            top: 0px;
            left: -20px;
        }
        to{
            transform: rotateZ(360deg);
            top: 0px;
            left : 450px;
        }
    }
    body#error{text-align: center;}
    span#e-msg{color: red; font-size: 1.5em;}
</style>
</head>
<body id="error">
	<h2>오류</h2>
    <p><span id="e-msg">잘못된 경로로 접근하였습니다.</span></p>
    <p>관리자에게 문의하세요</p>
    
    <br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
    <br />
    <br>
    <br>
    <br>
    <br>
    <br>
    <img src="<%=request.getContextPath() %>/images/common/basketball.png" alt="basketball" id="basketball">
</body>
</html>