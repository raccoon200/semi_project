<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, com.dleague.region.model.vo.*, java.util.*" %>
<%
	FreeBoard board = (FreeBoard)request.getAttribute("board");	
	
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
table.board-table th{
	width:60px
}
td.view-content{
	height:150px;
}
#fname{
	position:absolute;
	top:12px;
	left:85px;
	color:black;
	background:white;
	font-size:14px;
	padding-right:30px;
}
</style>
<script>
$(function(){
	$("[name=up_file]").change(function(){
		//$(this).val()은 선택한 파일명임.
		if($(this).val()==""){
			$("#fname").show();
		}	
		else{
			$("#fname").hide();
		}
	});	
});

function validate(){
	var content = $("[name=content]").val();
	if(content.trim().length==0){
		alert("내용을 입력하세요.");
		return false;
	}
	return true;
}
</script>
<h2>자유게시판 - 수정</h2>
<form action="<%=request.getContextPath() %>/board/freeBoardUpdateEnd" method="post" onsubmit="return fn_validate();" enctype="multipart/form-data">
	<input type="hidden" name="board_free_no" value="<%=board.getBoard_free_no() %>" />
	<table class="board-table">	
		<tr>
			<th>제목</th>
			<td colspan="5">
			<input type="text" name="board_free_title" id="" required value="<%=board.getBoard_free_title()%>"/>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="5"><input type="text" name="board_free_writer" id="" value="<%=memberLoggedIn.getUserId() %>" readonly/></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="5" style="position:relative">
				<%if(board.getOriginal_file_name() != null){ %>
            		<!-- 파일태그에 value속성은 임의로 변경할 수 없음. -->
            		<input type="file" name="up_file"/>
            		<span id="fname"><%=board.getOriginal_file_name() %></span>
            		<!-- 파일변경대비 기존파일이름 필드 -->
            		<input type="hidden" name="old_file" value="<%=board.getOriginal_file_name()%>"/>
            	<%} else { %>            	
	            	<input type="file" name="up_file"/>
            	<%} %>
			</td>
		</tr>
		<tr>
			<th colspan="6">내용</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content"><textarea name="board_free_content" id="" cols="100" rows="10" required><%=board.getBoard_free_content() %></textarea></td>
		</tr>
	</table>
	<input type="submit" value="수정" />
	<input type="button" value="취소" />
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		