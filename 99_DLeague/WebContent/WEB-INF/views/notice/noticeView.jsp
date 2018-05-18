<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.notice.model.vo.*, java.util.*" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");	
	
%>
<style>
/* table.notice-table{
	border:1px solid black;
	border-collapse:collapse;
	width:680px;
}
table.notice-table tr{
	border:1px solid black;

}
table.notice-table tr th{
	background: rgb(64,128,183);
	color:white;
}
table.notice-table tr{
	height:5px;
		
}
table.notice-table tr th, td{
	border:1px solid rgb(100,100,100);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.notice-table tr:hover{
	background:rgb(240,240,240);
}
table.notice-table th{
	width:60px
} */
table a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
table a:active,
table a:hover {
	color: #bd5a35;
	text-decoration:underline;
}
table.notice-table {
	font-family: 'Nanum Gothic', sans-serif;
	/* font-family:Arial, Helvetica, sans-serif; */
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	/* margin:20px; */
	border:#ccc 1px solid;
	border-radius:30px;
	box-shadow: 0 1px 2px #d1d1d1;
	width:100%;
	
}
table.notice-table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;
	font-size: 15px;
	background: #c3d4ee;
	text-align: center;
}
table.notice-table th:first-child{
	padding-left:20px;
}
table.notice-table tr:first-of-type{
	pointer-events: none;
}
table.notice-table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table.notice-table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table.notice-table tr{
	/* text-align: center; */
	padding-left:20px;
}
table.notice-table tr td:first-child{
	font-weight:bold;
	padding-left:20px;
	border-left: 0;
	font-size:14px;
}
table.notice-table tr td {
	font-weight:bold;
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table.notice-table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table.notice-table tr:last-child td{
	border-bottom:0;
}
table.notice-table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table.notice-table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table.notice-table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}
.view-content {
	height:200px;
	border-radius:30px;
}
</style>
<script>

function fn_loginAlert(){
	alert("로그인후 이용하실 수 있습니다.");
	$("#userId").focus();
}
function fn_fileDowload(oName, rName){
	//ie는 자동으로 인코딩처리하지 않음.
	var url = "<%=request.getContextPath() %>/notice/noticeFileDownload";
	//한글파일명이 있을 수 있으므로, 명시적으로 encoding
	oName = encodeURIComponent(oName);
	location.href =  url+'?oName='+oName+"&rName="+rName;
}
</script>

<h2>공지사항</h2>
<hr />
<table class="notice-table">
	<tr>
		<th>번호</th>
		<td width="40%"><%=notice.getNotice_no() %></td>
		<th>작성일</th>
		<td width="30%"><%=notice.getNotice_date() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5"><%=notice.getNotice_title() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="5"><%=notice.getNotice_writer() %></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="5">
		<% if(notice.getOriginal_file_name() != null){ %>
		<a href="javascript:fn_fileDowload('<%= notice.getOriginal_file_name() %>','<%=notice.getRenamed_file_name() %>');">
			<img alt="첨부파일" src="<%=request.getContextPath() %>/images/fileImage.png" width=16px>
			<%= notice.getOriginal_file_name() %>
		</a>
		<% }%>
		</td>
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><%=notice.getNotice_content() %></td>
	</tr>
</table>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId()) ){ %>
<input type="button" class="updateBtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/notice/noticeUpdate?no=<%=notice.getNotice_no()%>'">
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/notice/noticeDelete?no=<%=notice.getNotice_no() %>'"/>
<%} %>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>		