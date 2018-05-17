<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="java.util.*, com.dleague.board.model.vo.*, com.dleague.region.model.vo.*" %>
<% 
	List<FreeBoard> boardList = (ArrayList<FreeBoard>)request.getAttribute("freeBoard");

%>
<style>
/*테이블*/
a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
a:visited {
	color: #666;
	font-weight:bold;
	text-decoration:none;
}
a:active,
a:hover {
	color: #bd5a35;
	text-decoration:underline;
}


table a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
table a:active,
table a:hover {
	color: #bd5a35;
	text-decoration:underline;
}
table {
	font-family: 'Nanum Gothic', sans-serif;
	/* font-family:Arial, Helvetica, sans-serif; */
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	/* margin:20px; */
	border:#ccc 1px solid;
	border-radius:3px;
	box-shadow: 0 1px 2px #d1d1d1;
	width:100%;
	
}
table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;
	font-size: 15px;
	background: #c3d4ee;
	text-align: center;
}
table th:first-child{
	padding-left:20px;
}
table tr:first-of-type{
	pointer-events: none;
}
table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table tr{
	text-align: center;
	padding-left:20px;
}
table tr td:first-child{
	font-weight:bold;
	padding-left:20px;
	border-left: 0;
	font-size:14px;
}
table tr td {
	font-weight:bold;
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table tr:last-child td{
	border-bottom:0;
}
table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}

/*테이블끝*/
/* table.board-table{
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
} */
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
			<th width="10%">번호</th>
			<th width="40%">제목</th>
			<th width="12%">작성자</th>
			<th width="13%">첨부파일</th>
			<th width="15%">작성일</th>
			<th width="15%">조회수</th>
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