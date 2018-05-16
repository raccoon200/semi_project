<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, java.util.*" %>
<%
	Complain board = (Complain)request.getAttribute("complainBoard");	
	
	
%>
<style>
table.board-table{
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
}

div#comment-container button#btn-insert{
	width:80px;
	height:50px;
	color:white;
	background: rgb(64,128,183);
	position:relative;
	top:-20px;
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
</table>
<% if(memberLoggedIn!=null && (board.getComplain_writer().equals(memberLoggedIn.getUserId())) ){ %>
<input type="button" class="updateBtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/board/complainBoardUpdate?no=<%=board.getComplain_no()%>'">
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/complainBoardDelete?no=<%=board.getComplain_no() %>'"/>
<%} %>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId())){ %>
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/complainBoardDelete?no=<%=board.getComplain_no() %>'"/>
<%} %>
<div id="comment-container">
	<%if ("admin".equals(memberLoggedIn.getUserId())){ %>
	<div class="comment-editor">
		<form name="boardCommentFrm" action="<%=request.getContextPath()%>/board/complainResultInsert" method="post">
			<%if(board.getResult()==null) { %>
			<textarea name="result" cols="80" rows="3" required></textarea>
			<input type="hidden" name="no" value="<%=board.getComplain_no()%>" />
				<button type="submit" id="btn-insert">등록</button>
			<%} %>
		</form>
	</div>
	<%} %> 
	<%if(board.getResult()!=null) { %>
	<div class="comment-viewer" >
			<sub class="comment-writer"><%=memberLoggedIn.getUserId() %></sub>
			<sub class="comment-date"><%=board.getResult_Date() %></sub>
			<br />
			<%=board.getResult() %>
	</div>
	<%} %>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		