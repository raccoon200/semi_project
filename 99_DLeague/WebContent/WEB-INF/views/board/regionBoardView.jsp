<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, com.dleague.region.model.vo.*, java.util.*" %>
<%
	RegionBoard board = (RegionBoard)request.getAttribute("board");	
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");
	List<RegionBoardComment> regionbcList = (List<RegionBoardComment>)request.getAttribute("regionbcList");
	
	HashMap<String,String> regionMap = new HashMap<String,String>();
	for(int i=0; i<regionList.size(); i++) {
		Region region = regionList.get(i);
		regionMap.put(region.getRegionCode(), region.getRegionName());
	}
	
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
</style>
<h2>지역게시판</h2>
<table class="board-table">
	<tr>
		<th>번호</th>
		<td width="120px"><%=board.getBoard_region_no() %></td>
		<th>작성일</th>
		<td width="120px"><%=board.getBoard_region_date() %></td>
		<th>조회수</th>
		<td width="120px"><%=board.getCount() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5"><%=board.getBoard_region_title() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="5"><%=board.getBoard_region_writer() %></td>
	</tr>
	<tr>
		<th>지역</th>
		<td colspan="5"><%=regionMap.get(board.getBoard_regioncode()) %></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="5"><%=board.getOriginal_file_name() %></td>
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><%=board.getBoard_region_content() %></td>
	</tr>
</table>
<% if(memberLoggedIn!=null && board.getBoard_region_writer().equals(memberLoggedIn.getUserId())){ %>
<input type="button" class="updateBtn" value="수정">
<input type="button" class="deleteBtn" value="삭제" />
<%} %>
<div id="comment-container">
	<div class="comment-editor">
		<form name="boardCommentFrm" action="<%=request.getContextPath()%>/board/regionBoardCommentInsert" method="post">
			<textarea name="boardCommentContent" cols="80" rows="3"></textarea>
			<button type="submit" id="btn-insert">등록</button>
			<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>" />
			<input type="hidden" name="boardRef" value="<%=board.getBoard_region_no()%>" />
			<input type="hidden" name="boardCommentRef" value="0" />
			<input type="hidden" name="boardCommentLevel" value="1" />
		</form>
	</div> <!-- end of div.comment-editor -->
	
	<% if(regionbcList != null){ %>
	<!-- 댓글목록테이블 -->
	<table id="tbl-comment">
	<%for(RegionBoardComment bc : regionbcList) { 
		if(bc.getBoard_region_comment_level()==1){
	%>
		<tr class="level1">
			<td>
				<sub class="comment-writer"><%=bc.getBoard_region_comment_writer() %></sub>
				<sub class="comment-date"><%=bc.getBoard_region_comment_date() %></sub>
				<br />
				<%=bc.getBoard_region_comment_content() %>
			</td>
			<td>
				<button class="btn-reply" value="<%=bc.getBoard_region_comment_no()%>">답글</button>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_region_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_region_comment_no()%>">삭제</button>
				<%} %>
			</td>
		</tr>
	<% } else { %>
		<tr class="level2">
			<td>
				<sub class="comment-writer"><%=bc.getBoard_region_comment_writer() %></sub>
				<sub class="comment-date"><%=bc.getBoard_region_comment_date() %></sub>
				<br />
				<%=bc.getBoard_region_comment_content() %>
			</td>
			<td>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_region_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_region_comment_no()%>">삭제</button>
				<%} %>
			</td>
		</tr>
	
	<% } //end of if
	  } %>
	</table>
	<%} %>	
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		