<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, java.util.*, com.dleague.member.model.service.*" %>

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
table.board-table tr:hover{
	background:rgb(240,240,240);
}
table.board-table th{
	width:120px;
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
	padding-left:30%;
	padding-top:5px;
}
</style>
<script>

</script>
<h2>신고게시판 - 작성</h2>
<form action="<%=request.getContextPath()%>/board/complainBoardFormEnd" method="post">
<table class="board-table">
	<tr>
		<th>제목</th>
		<td colspan="5">
			<input type="text" name="complain_title" required/>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="2"><input type="text" name="complain_writer" id="" value="<%=memberLoggedIn.getUserId()%>" readonly/></td>
	</tr>
	<tr>
		<th>용의자/용의팀</th>
		<td>
		<select name="complain_type" id="">
			<option value="c_userid">용의자</option>
			<option value="c_teamname">용의팀</option>
		</select>
		<input type="text" name="c_complain" id="" required/>
		
		</td>
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><textarea name="complain_content" id="" cols="100" rows="10"></textarea></td>
	</tr>
</table>
<div class="btn-area">
	<input class="btn" type="submit" value="작성" />
	<input class="btn" type="reset" value="초기화" />
	<input class="btn" type="button" value="취소" onclick="location.href='<%=request.getContextPath()%>/board/complainBoard'"/>
</div>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		