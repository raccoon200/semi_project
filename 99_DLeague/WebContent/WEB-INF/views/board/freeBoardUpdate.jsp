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
			<td id="upTd" colspan="5">
				<%if(board.getOriginal_file_name() != null){ %>
            		<!-- 파일태그에 value속성은 임의로 변경할 수 없음. -->
            		<input type="file" name="up_file" onchange="fn_changeFile(this)"/>
            		<span id="fname"><%=board.getOriginal_file_name() %></span>
            		<!-- 파일변경대비 기존파일이름 필드 -->
            		<input type="hidden" name="old_file" value="<%=board.getOriginal_file_name()%>"/>
            		<input type="hidden" name="old_file_path" value="<%=board.getRenamed_file_name() %>"/>
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
	<div class="btn-area">
		<input class="btn" type="submit" value="수정" />
		<input class="btn" type="button" value="취소" onclick='location.href="<%=request.getContextPath()%>/board/freeBoardView?no=<%=board.getBoard_free_no() %>"'/>
	</div>
</form>
<script>
function fn_changeFile(value) {
	var fileValue = $("[name=up_file]").val().split("\\");
	var fileName = fileValue[fileValue.length-1];
	if(fileName==""){
		$("#fname").show();
	}else{
		$("#fname").hide();
	}

}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		