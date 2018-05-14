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
}
.view-content {
	height:200px;
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
				<input type="text" readonly name="notice_writer" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>" />
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="5" style="position:relative">
				<%if(notice.getOriginal_file_name() != null){ %>
            		<!-- 파일태그에 value속성은 임의로 변경할 수 없음. -->
            		<input type="file" name="up_file"/>
            		<span id="fname"><%=notice.getOriginal_file_name() %></span>
            		<!-- 파일변경대비 기존파일이름 필드 -->
            		<input type="hidden" name="old_file" value="<%=notice.getOriginal_file_name()%>"/>
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
				<textarea name="notice_content" id="" cols="80" rows="10" required><%=notice.getNotice_content() %></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" value="수정" />
	<input type="button" value="취소" />
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		