<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.notice.model.vo.*, java.util.*" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");
	
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


<h2>공지사항 - 수정</h2>
<form action="<%=request.getContextPath()%>/notice/noticeUpdateEnd?notice_no=<%=notice.getNotice_no() %>" method="post" enctype="multipart/form-data">
	
	<table class="notice-table">
		<tr>
			<th>제목</th>
			<td colspan="5">
				<input type="text" name="notice_title" required value="<%=notice.getNotice_title()%>"/>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="5">
				<input type="text" readonly name="notice_writer" value='<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>' />
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td id="upTd" colspan="5">
				<%if(notice.getOriginal_file_name() != null){ %>
            		<!-- 파일태그에 value속성은 임의로 변경할 수 없음. -->
            		<input type="file" name="up_file" onchange="fn_changeFile()"/>
            		<span id="fname"><%=notice.getOriginal_file_name() %></span>
            		<!-- 파일변경대비 기존파일이름 필드 -->
            		<input type="hidden" name="old_file" value="<%=notice.getOriginal_file_name()%>"/>
            		<input type="hidden" name="old_file_path" value="<%=notice.getRenamed_file_name() %>"/>
            		<input type="hidden" name="file_empty" value="" />
            	<%} else { %>            	
	            	<input type="file" name="up_file"/>
            	<%} %>
			</td>
		</tr>
		<tr>
			<th colspan="6">내용</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content">
				<textarea name="notice_content" id="" cols="100" rows="10" required><%=notice.getNotice_content() %></textarea>
			</td>
		</tr>
	</table>
	<div class="btn-area">
		<input class="btn" type="submit" value="수정" />
		<input class="btn" type="button" value="취소"  onclick='location.href="<%=request.getContextPath()%>/notice/noticeView?no=<%=notice.getNotice_no() %>"'/>
	</div>
</form>
<script>
function fn_changeFile(value) {
	console.log();
	var fileValue = $("[name=up_file]").val().split("\\");
	var fileName = fileValue[fileValue.length-1];
	if($("[name=up_file]")[0].files.length==0){
		$("#fname").html("파일 없음");
		$("#fname").show();
		$("[name=file_empty]").val('true');
	}else if(fileName==""){
		$("#fname").show();
		$("[name=file_empty]").val('false');
	}else{
		$("#fname").hide();
		$("[name=file_empty]").val('false');
	}

}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		