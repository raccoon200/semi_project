<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.notice.model.vo.*, java.util.*" %>
<%
	
	
%>
<style>
table.notice-table{
	border:1px solid rgb(240,240,240);
	border-collapse:collapse;
	width:680px;
	
}
table.notice-table tr{
	border:1px solid gray;
	
}
table.notice-table tr th{
	background: rgb(147,213,245);
	color:white;
	border-radius: 1px;
}
table.notice-table tr{
	height:5px;
}
table.notice-table tr td{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.notice-table tr th{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:center;
	font-size:13px;

}
table.notice-table tr:hover{
	background:rgb(240,240,240);
}
table.notice-table th{
	width:80px;
}
.view-content {
	height:200px;
	
}
.btn{
	border-radius:2px;
	border:1px solid rgb(240,240,240);
	background:rgb(147,213,245);
	color:white;
}
.btn-area{
	padding-left:40%;
	padding-top:5px;
}
</style>
<script>

function fn_loginAlert(){
	alert("로그인후 이용하실 수 있습니다.");
	$("#userId").focus();
}

</script>

<h2>공지사항 -작성</h2>
<form action="<%=request.getContextPath()%>/notice/noticeFormEnd" method="post" enctype="multipart/form-data">
	<table class="notice-table">
		<tr>
			<th>제목</th>
			<td colspan="5">
				<input type="text" name="notice_title" required/>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="5">
				<input type="text" readonly name="notice_writer" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>" />
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="5">
				<input type="file" name="up_file" id="" />
			</td>
		</tr>
		<tr>
			<th colspan="6">내용</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content">
				<textarea name="notice_content" id="" cols="100" rows="10" required></textarea>
			</td>
		</tr>
	</table>
	<div class="btn-area">
		<input class="btn" type="submit" value="등록" />
		<input class="btn" type="button" value="취소" />
	</div>
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		