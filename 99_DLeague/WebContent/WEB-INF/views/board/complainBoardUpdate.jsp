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
	border:1px solid rgb(240,240,240);
	border-collapse:collapse;
	width:680px;
	
}
table.board-table tr{
	border:1px solid gray;
	
}
table.board-table tr th{
	background: rgb(147,213,245);
	color:white;
	border-radius: 1px;
}
table.board-table tr{
	height:5px;
}
table.board-table tr td{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.board-table tr th{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:center;
	font-size:13px;

}

table.board-table th{
	width:80px;
}
.view-content {
	height:200px;
}
.view-content textarea{
	resize:none;
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
span#fname{
	position:absolute;
	top:10px;
	left:85px;
	
	padding-top:2px;
	padding-bottom:3px;
	padding-right:420px;
	background:white;
}
td#upTd{
	position:relative;
}
</style>
<script>

</script>
<h2>신고게시판 - 수정</h2>
<form action="<%=request.getContextPath()%>/board/complainBoardUpdateEnd" method="post">
<input type="hidden" name="no" value="<%=complain.getComplain_no() %>" />
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
<div class="btn-area">
	<input class="btn" type="submit" value="수정" />
	<input class="btn" type="button" value="취소" onclick='location.href="<%=request.getContextPath()%>/board/complainBoardView?no=<%=complain.getComplain_no() %>"'/>
</div>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		