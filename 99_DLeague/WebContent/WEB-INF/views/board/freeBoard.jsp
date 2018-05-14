<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="java.util.*, com.dleague.board.model.vo.*, com.dleague.region.model.vo.*" %>
<% 
	List<FreeBoard> boardList = (ArrayList<FreeBoard>)request.getAttribute("freeBoard");

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
table.board-table tr th, td{
	border:1px solid rgb(100,100,100);
	padding:10px;
	text-align:center;
}
table.board-table tr:hover{
	background:rgb(240,240,240);
	cursor:pointer;
}
span.search-area{
	
}
section#region-board-area{
	padding-left:30px;

}
img#file-image{
	width:16px;
}
/*페이지바*/
div#pageBar {
	text-align:center;
	padding-top:10px;
}
div#pageBar a{
	font-size:20px;
	color:black;
	text-decoration:none;
}
div#pageBar a:hover{
	color:rgb(64,128,183);
}
div#pageBar span{
	font-size:20px;
	color:rgb(64,128,183);
}
.write-btn{
	margin-right:40px;
	float:right;
}
</style>
<script>
function fn_writeAuthorityCheck() {
	
	
}
$(function() {
	
	$("tr").click(function() {
		<% if(memberLoggedIn!=null) {%>
		if($(this).attr("id")!=null){
			location.href="<%=request.getContextPath()%>/board/freeBoardView?no="+$(this).attr("id");
		}
		<%} else {%>
		alert("로그인 후 이용할 수 있습니다");
		<%}%>
	})
	
	
});

function fn_search() {
	
	if($("#searchValue").val().trim().length==0) {
		if($("[name=searchType]").val()=="title")
			alert("검색할 제목을 입력하세요");
		else
			alert("검색할 아이디를 입력하세요");
		return false;
	}
	var searchValue = $("#searchValue").val().trim();
	var searchType = $("[name=searchType]").val();
<%-- 	location.href='<%=request.getContextPath()%>/board/regionBoard?region=<%=selectRegionCode%>&searchType="+searchType+"&searchValue="+searchValue+'; --%>
	return true;
	
}
</script>
<h2>자유게시판</h2>
<section id="free-board-area">
	<span class="search-area">
		<form action="<%=request.getContextPath() %>/board/freeBoard" method="get">
			<select name="searchType" id="">
				<option value="title">제목</option>
				<option value="name">아이디</option>
			</select>
			<input type="text" id="searchValue" name="searchValue"/>
			<input type="submit" value="검색" onclick="fn_search()"/>
		</form>
	</span>
	
	<table class="board-table">
		<tr>
			<th width="40">번호</th>
			<th width="210">제목</th>
			<th width="60">작성자</th>
			<th>첨부파일</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
		<%if(boardList!=null && !boardList.isEmpty()) { 
			for(int i=0; i<boardList.size(); i++) {
				FreeBoard board = boardList.get(i);	
		%>
		<tr id="<%=board.getBoard_free_no()%>">
			<td><%=board.getBoard_free_no()%></td>
			<td style="text-align:left"><%=board.getBoard_free_title() %></td>
			<td><%=board.getBoard_free_writer() %></td>
			<td><%if(board.getOriginal_file_name()!=null){%>
				<img id="file-image" src="<%=request.getContextPath() %>/images/fileImage.png" alt="파일이미지" />
				<%} %>
				
			</td>
			<td><%=board.getBoard_free_date() %></td>
			<td><%=board.getCount() %></td>
		</tr>
		<%}
		}else { %>
		<tr>
			<td colspan="7">데이터가 없습니다</td>
		</tr>
		<%} %>
	</table>
	<div id="pageBar">
		<%=(request.getAttribute("pageBar")!=null)?request.getAttribute("pageBar"):"" %>
		<%if(memberLoggedIn!=null) { %>
			<input type="button" class="write-btn" value="글쓰기" onclick="location.href='<%=request.getContextPath()%>/board/freeBoardForm'"/>
		<%} %>
	</div>
</section>
<br />
<br />
<br />
<br />
<br />
<br />

<br />
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		