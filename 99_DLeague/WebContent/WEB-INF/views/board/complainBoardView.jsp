<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, java.util.*" %>
<%
	Complain board = (Complain)request.getAttribute("complainBoard");	
	
	
%>
<style>
/* table.board-table{
	border:1px solid black;
	border-collapse:collapse;
	width:680px;
}
table.board-table tr{
	border:1px solid black;
	
}
table.board-table tr th{
	background: rgb(64,128,183);
	color:white;
}
table.board-table tr{
	height:5px;
}
table.board-table tr th, td{
	border:1px solid rgb(100,100,100);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.board-table tr:hover{
	background:rgb(240,240,240);
}
table.board-table th{
	width:60px
}
td.view-content{
	height:150px;
} */
/*테이블*/
/* a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
a:visited {
	color: #666;
	font-weight:bold;
	text-decoration:none;
}
a:active,
a:hover {
	color: #bd5a35;
	text-decoration:underline;
} */
td.view-content{
	height:150px;
}
table.board-table a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
table.board-table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
table.board-table a:active,
table.board-table a:hover {
	color: #bd5a35;
	text-decoration:underline;
}
table.board-table {
	font-family: 'Nanum Gothic', sans-serif;
	/* font-family:Arial, Helvetica, sans-serif; */
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	/* margin:20px; */
	border:#ccc 1px solid;
	border-radius:3px;
	box-shadow: 0 1px 2px #d1d1d1;
	width:100%;
	padding-top:10px;
	
}
table.board-table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;
	font-size: 15px;
	background: #FFCFF2;
	text-align: center;
}
table.board-table th:first-child{
	padding-left:20px;
}
table.board-table tr:first-of-type{
	pointer-events: none;
}
table.board-table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table.board-table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table.board-table tr{
	text-align: center;
	padding-left:20px;
}
table.board-table tr td:first-child{
	font-weight:bold;
	padding-left:20px;
	border-left: 0;
	font-size:14px;
}
table.board-table tr td {
	font-weight:bold;
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table.board-table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table.board-table tr:last-child td{
	border-bottom:0;
}
table.board-table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table.board-table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table.board-table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}

/*테이블끝*/
button#btn-insert{
	width:80px;
	height:57px;
	color:white;
	background: /* rgb(64,128,183); */#76AAEE;
	position:relative;
	float: right;
    margin: 0px 10px 0 0px;
}

div.comment-viewer{
	width:670px;
	height:60px;
	border:1px solid gray;
	
}
</style>
<script>

function fn_loginAlert(){
	alert("로그인후 이용하실 수 있습니다.");
	$("#userId").focus();
}
function fn_fileDowload(oName, rName){
	//ie는 자동으로 인코딩처리하지 않음.
	var url = "<%=request.getContextPath() %>/board/boardFileDownload";
	//한글파일명이 있을 수 있으므로, 명시적으로 encoding
	oName = encodeURIComponent(oName);
	location.href =  url+'?oName='+oName+"&rName="+rName;
}
</script>

<h2>신고게시판</h2>
<hr />
<table class="board-table">
	<tr>
		<th>번호</th>
		<td width="120px"><%=board.getComplain_no() %></td>
		<th>작성일</th>
		<td width="120px"><%=board.getComplain_date() %></td>
		<th>처리여부</th>
		<td width="120px"><%=board.getResult()!=null?"처리완료":"미처리" %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5"><%=board.getComplain_title() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="2"><%=board.getComplain_writer() %></td>
		<%if("c_userid".equals(board.getComplain_type())){ %>
		<th>용의자</th>
		<td colspan="2"><%=board.getC_userId() %></td>
		<%} else if("c_teamname".equals(board.getComplain_type())){ %>
		<th>용의팀</th>
		<td colspan="2"><%=board.getC_teamname() %></td>
		<%} %>
	</tr>
	<tr>
		
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><%=board.getComplain_content() %></td>
	</tr>
<div id="comment-container">
	<%if ("admin".equals(memberLoggedIn.getUserId())){ %>
	<div class="comment-editor">
	<tr>
		<form name="boardCommentFrm" action="<%=request.getContextPath()%>/board/complainResultInsert" method="post">
			<%if(board.getResult()==null) { %>
		<th width="20%">신고처리입력 : </th>
		<td width="80%" colspan="6">
			<textarea name="result" cols="70" rows="3" style="resize:none;" required></textarea>
			<input type="hidden" name="no" value="<%=board.getComplain_no()%>" />
				<button type="submit" id="btn-insert">등록</button>
		</td>
			<%} %>
		</form>
	</tr>
	</div>
	<%} %> 
	<%if(board.getResult()!=null) { %>
	<tr>
	<th width="20%">처리완료 : </th>
	<td colspan="6">
			<sub class="comment-writer"><%=memberLoggedIn.getUserId() %></sub>
			<sub class="comment-date"><%=board.getResult_Date() %></sub>
			<br />
			조치사항 : <%=board.getResult() %>
	</td>
	</tr>
	<%} %>
</table>
<br />
<% if(memberLoggedIn!=null && (board.getComplain_writer().equals(memberLoggedIn.getUserId()))){ %>
<input type="button" class="updateBtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/board/complainBoardUpdate?no=<%=board.getComplain_no()%>'">
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/complainBoardDelete?no=<%=board.getComplain_no() %>'"/>
<%} %>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId())){ %>
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/complainBoardDelete?no=<%=board.getComplain_no() %>'"/>
<%} %>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		