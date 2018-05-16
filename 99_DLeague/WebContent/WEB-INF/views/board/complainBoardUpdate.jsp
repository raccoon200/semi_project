<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, java.util.*, com.dleague.member.model.service.*" %>
<%
	Complain complain = (Complain)request.getAttribute("complainBoard");
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

</script>
<h2>신고게시판 - 수정</h2>
<form action="<%=request.getContextPath()%>/board/complainBoardFormEnd" method="post">
<table class="board-table">
	<tr>
		<th>제목</th>
		<td colspan="5">
			<input type="text" name="complain_title" value="<%=complain.getComplain_title() %>" required/>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="2"><input type="text" name="complain_writer" id="" value="<%=complain.getComplain_writer()%>" readonly/></td>
	</tr>
	<tr>
		<th>용의자/용의팀</th>
		<td>
		<select name="complain_type" id="">
			<option value="c_userid" <%="c_userid".equals(complain.getComplain_type())?"selected":"" %>>용의자</option>
			<option value="c_teamname" <%="c_teamname".equals(complain.getComplain_type())?"selected":"" %>>용의팀</option>
		</select>
		<input type="text" name="c_complain" id="" value='<%="c_userid".equals(complain.getComplain_type())?complain.getC_userId():complain.getC_teamname() %>' required/>
		
		</td>
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><textarea name="complain_content" id="" cols="80" rows="10"><%=complain.getComplain_content() %></textarea></td>
	</tr>
</table>
<input type="submit" value="작성" />
<input type="button" value="취소" />
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		