<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="java.util.*, com.dleague.board.model.vo.*" %>
<% 
	List<RegionBoard> boardList = (ArrayList<RegionBoard>)request.getAttribute("regionBoard");
	
%>
<style>
table.board-table{
	border:1px solid black;
	border-collapse:collapse;
	
}
table.board-table tr{
	border:1px solid black;
	
}
table.board-table tr th, td{
	border:1px solid black;
	padding:3px;
}
table.board-table tr:hover{
	background:cyan;
}
</style>

<h2>지역게시판</h2>

<table class="board-table">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>지역</th>
		<th>첨부파일</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<%if(boardList!=null && !boardList.isEmpty()) { 
		for(int i=0; i<boardList.size(); i++) {
			RegionBoard board = boardList.get(i);	
	%>
	<tr>
		<td><%=board.getBoard_region_no() %></td>
		<td><%=board.getBoard_region_title() %></td>
		<td><%=board.getBoard_region_writer() %></td>
		<td><%=board.getBoard_regioncode() %></td>
		<td><%=board.getOriginal_file_name() %></td>
		<td><%=board.getBoard_region_date() %></td>
		<td><%=board.getCount() %></td>
	</tr>
	<%}
	}else { %>
	<tr>
		<td colspan="7">데이터가 없습니다</td>
	</tr>
	<%} %>
</table>

<br />
<br />
<br />
<br />
<br />
<br />

<br />
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		