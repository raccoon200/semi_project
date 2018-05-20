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
} */


button#btn-insert{
	width:80px;
	height:57px;
	color:white;
	background: /* rgb(64,128,183); */#FFC158;
	position:relative;
	float: right;
    margin: 0px 10px 0 0px;
}

table#tbl-comment{
	width:580px;
	margin-left:10px;
	border-collapse:collapse;
}
table#tbl-comment tr td {
	border-bottom:1px solid gray;
	border-top:1px solid gray;
	padding:5px;
	text-align:left;
	line-height:120%;
}
table#tbl-comment tr td:first-of-type{
	
}
table#tbl-comment tr td:last-of-type{
	text-align:right; 
	width:100px;
}
table#tbl-comment button.btn-reply{display:none;}
table#tbl-comment tr:hover{background:rgb(240,240,240);}
table#tbl-comment tr:hover button.btn-reply{display:inline;}
table#tbl-comment tr td {border:1px solid gray}
table#tbl-comment sub.comment-writer{
	font-size:12px;
	color:navy;
}
table#tbl-comment sub.comment-date{
	font-size:12px;
	color:gray;
}
/*  table a:link {
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
} */
/*테이블끝*/
table.board-table {
	font-family: 'Nanum Gothic', sans-serif;
	/* font-family:Arial, Helvetica, sans-serif; */
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	/* margin:20px; */
	border:#ccc 1px solid;
	border-radius:30px;
	box-shadow: 0 1px 2px #d1d1d1;
	width:100%;
	
}
table.board-table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;
	font-size: 15px;
	background: #FFDFAB;
	text-align: center;
}
table.board-table th:first-child{
	padding-left:20px;
}
table.board-table tr:first-of-type{
	pointer-events: none;
}
table.board-table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table.board-table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table.board-table tr{
	/* text-align: center; */
	padding-left:20px;
}
table.board-table tr td:first-child{
	font-weight:bold;
	padding-left:20px;
	border-left: 0;
	font-size:14px;
}
table.board-table tr td {
	font-weight:bold;
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table.board-table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table.board-table tr:last-child td{
	border-bottom:0;
}
table.board-table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table.board-table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table.board-table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}
/*테이블끝*/
.view-content {
	height:200px;
	border-radius:30px;
}
/*level2 패딩처리*/
table#tbl-comment tr.level2 td:first-of-type{padding-left:30px; background:rgb(250,250,250)}

/*삭제버튼*/
table#tbl-comment button.btn-delete{
	
	display:none;
}
table#tbl-comment tr:hover button.btn-delete{
	display:inline;
}
button.btn-reply{float:right;}
button.btn-delete{float:right;}
#comment-container{padding:30px;}
.comment-writer{font-weight:bold; font-size:15px;}
</style>
<script>
$(function(){
	//textarea focus이벤트핸들러
    $("[name=boardCommentContent]").focus(function(e){
        if(<%=memberLoggedIn==null%>)
            fn_loginAlert();
    });
	
	//boardCommentFrm폼 유효성 검사
	$("[name=boardCommentFrm]").submit(function(e){
		if(<%=memberLoggedIn==null%>){
            fn_loginAlert();	
			e.preventDefault();
			return;
		}
		
		var len = $("[name=boardCommentContent]").val().trim().length;
		if(len==0) e.preventDefault();
		
	});
	
	//답글버튼 클릭시
	$(".btn-reply").on('click',function(){
		<%if(memberLoggedIn != null){%>
		//로그인한 경우
		var tr = $("<tr></tr>");
		var html = '<td style="display:none; text-align:left;" colspan="6">';
		html += '<form action="<%=request.getContextPath()%>/board/regionBoardCommentInsert" method="post">';
		html += '<textarea name="boardCommentContent" cols="80" rows="3" style="resize:none;"></textarea>';
		html += '<button type="submit" id="btn-insert">등록</button>';
		html += '<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>" />';
		html += '<input type="hidden" name="boardRef" value="<%=board.getBoard_region_no()%>" />';
		html += '<input type="hidden" name="boardCommentRef" value="'+$(this).val()+'" />';
		html += '<input type="hidden" name="boardCommentLevel" value="2" />';
		html += '</form></td>';
	
		tr.html(html);
		//생성된 노드를 페이지에 추가
		tr.insertAfter($(this).parent().parent()).children("td").slideDown(800);
		//한번버튼클릭후에는 이벤트핸들러
		$(this).off("click");
		
		//이벤트핸들러 추가
		tr.find('form').submit(function(e){
			if(<%=memberLoggedIn==null%>){
	            fn_loginAlert();	
				e.preventDefault();
				return;
			}
			
			var len = $(this).children("textarea").val().trim().length;
			if(len==0) e.preventDefault();
			
		});
		
		//포커스
		tr.find("textarea").focus();
		
		<%} else {%>
		//로그인하지 않은 경우
		alert('로그인하세요');
		
		<%} %>
		
	});
	
	//삭제버튼 클릭시
    $(".btn-delete").click(function(){
        if(!confirm("정말 삭제하시겠습니까?")) return;
        //삭제처리후 돌아올 현재게시판번호도 함께 전송함.
        location.href="<%=request.getContextPath()%>/board/regionBoardCommentDelete?no=<%=board.getBoard_region_no() %>&del="+$(this).val();
    });
	
	
	
});
function fn_loginAlert(){
	alert("로그인후 이용하실 수 있습니다.");
	$("#userId").focus();
}
function fn_fileDowload(oName, rName){
	//ie는 자동으로 인코딩처리하지 않음.
	var url = "<%=request.getContextPath() %>/board/boardFileDownload";
	//한글파일명이 있을 수 있으므로, 명시적으로 encoding
	oName = encodeURIComponent(oName);
	location.href =  url+'?oName='+oName+"&rName="+rName;
}
</script>

<h2>지역게시판</h2>
<hr />
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
		<td colspan="5">
		<% if(board.getOriginal_file_name() != null){ %>
		<a href="javascript:fn_fileDowload('<%= board.getOriginal_file_name() %>','<%=board.getRenamed_file_name() %>');">
			<img alt="첨부파일" src="<%=request.getContextPath() %>/images/fileImage.png" width=16px>
			<%= board.getOriginal_file_name() %>
		</a>
		<% }%>
		</td>
	</tr>
	<tr>
		<th colspan="6">내용</th>
	</tr>
	<tr>
		<td colspan="6" class="view-content"><%=board.getBoard_region_content() %></td>
	</tr>
<!-- </table> -->
<div id="comment-container">
	<div class="comment-editor">
	<!-- <table class="board-table"> -->
	<th width="20%">댓글입력 : </th>
		<td width="80%" colspan="6">
		<form name="boardCommentFrm" action="<%=request.getContextPath()%>/board/regionBoardCommentInsert" method="post">
			<textarea name="boardCommentContent" cols="70" rows="3.2" style="resize:none;"></textarea>
			<button type="submit" id="btn-insert">등록</button>
			<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>" />
			<input type="hidden" name="boardRef" value="<%=board.getBoard_region_no()%>" />
			<input type="hidden" name="boardCommentRef" value="0" />
			<input type="hidden" name="boardCommentLevel" value="1" />
		</form>
		</td>
	</div> <!-- end of div.comment-editor -->
	
	<% if(regionbcList != null){ %>
	<tr>
	<!-- 댓글목록테이블 -->
	<!-- <table id="tbl-comment"> -->
	<%for(RegionBoardComment bc : regionbcList) { 
		if(bc.getBoard_region_comment_level()==1){
	%>
		<tr class="level1">
			<td>
				<sub class="comment-writer">ID : <%=bc.getBoard_region_comment_writer() %></sub>
				<br />
				<sub class="comment-date">입력날짜 : <%=bc.getBoard_region_comment_date() %></sub>
			</td>
			<td colspan="6">
				<%=bc.getBoard_region_comment_content() %>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_region_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_region_comment_no()%>">삭제</button>
				<%} %>
				<button class="btn-reply" value="<%=bc.getBoard_region_comment_no()%>">답글</button>
			</td>
		</tr>
	<% } else { %>
		<tr class="level2">
			<td>
				<pre>        ┖▶</pre>
			</td>
			<td colspan="6">
				<sub class="comment-writer"><%=bc.getBoard_region_comment_writer() %></sub>
				<sub class="comment-date"><%=bc.getBoard_region_comment_date() %></sub>
				<br />
				<sub class="comment-content"><%=bc.getBoard_region_comment_content() %></sub>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_region_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_region_comment_no()%>" >삭제</button>
				<%} %>
			</td>
		</tr>
	
	<% } //end of if
	  } %>
		</tr>
	</table>
	<%} %>	
<% if(memberLoggedIn!=null && (board.getBoard_region_writer().equals(memberLoggedIn.getUserId())) ){ %>
<input type="button" class="updateBtn" value="글수정" onclick="location.href='<%=request.getContextPath()%>/board/regionBoardUpdate?no=<%=board.getBoard_region_no()%>'">
<input type="button" class="deleteBtn" value="글삭제" onclick="location.href='<%=request.getContextPath() %>/board/regionBoardDelete?no=<%=board.getBoard_region_no() %>'"/>
<%} %>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId()) && !"admin".equals(board.getBoard_region_writer())){ %>
<input type="button" class="deleteBtn" value="글삭제" onclick="location.href='<%=request.getContextPath() %>/board/regionBoardDelete?no=<%=board.getBoard_region_no() %>'"/>
<%} %>
<br /><br /><br />
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		