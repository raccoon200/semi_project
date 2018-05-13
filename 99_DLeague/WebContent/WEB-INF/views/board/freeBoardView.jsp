<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, java.util.*" %>
<%
	FreeBoard board = (FreeBoard)request.getAttribute("board");	
	List<FreeBoardComment> freebcList = (List<FreeBoardComment>)request.getAttribute("freebcList");
	
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

div#comment-container button#btn-insert{
	width:80px;
	height:50px;
	color:white;
	background: rgb(64,128,183);
	position:relative;
	top:-20px;
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

/*level2 패딩처리*/
table#tbl-comment tr.level2 td:first-of-type{padding-left:30px; background:rgb(250,250,250)}

/*삭제버튼*/
table#tbl-comment button.btn-delete{
	
	display:none;
}
table#tbl-comment tr:hover button.btn-delete{
	display:inline;
}
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
		var html = '<td style="display:none; text-align:left;" colspan="2">';
		html += '<form action="<%=request.getContextPath()%>/board/freeBoardCommentInsert" method="post">';
		html += '<textarea name="boardCommentContent" cols="60" rows="3"></textarea>';
		html += '<button type="submit" id="btn-insert">등록</button>';
		html += '<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>" />';
		html += '<input type="hidden" name="boardRef" value="<%=board.getBoard_free_no()%>" />';
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
        location.href="<%=request.getContextPath()%>/board/freeBoardCommentDelete?no=<%=board.getBoard_free_no() %>&del="+$(this).val();
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

<h2>자유게시판</h2>
<table class="board-table">
	<tr>
		<th>번호</th>
		<td width="120px"><%=board.getBoard_free_no() %></td>
		<th>작성일</th>
		<td width="120px"><%=board.getBoard_free_date() %></td>
		<th>조회수</th>
		<td width="120px"><%=board.getCount() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5"><%=board.getBoard_free_title() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="5"><%=board.getBoard_free_writer() %></td>
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
		<td colspan="6" class="view-content"><%=board.getBoard_free_content() %></td>
	</tr>
</table>
<% if(memberLoggedIn!=null && (board.getBoard_free_writer().equals(memberLoggedIn.getUserId())) ){ %>
<input type="button" class="updateBtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/board/freeBoardUpdate?no=<%=board.getBoard_free_no()%>'">
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/freeBoardDelete?no=<%=board.getBoard_free_no() %>'"/>
<%} %>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getUserId())){ %>
<input type="button" class="deleteBtn" value="삭제" onclick="location.href='<%=request.getContextPath() %>/board/freeBoardDelete?no=<%=board.getBoard_free_no() %>'"/>
<%} %>
<div id="comment-container">
	<div class="comment-editor">
		<form name="boardCommentFrm" action="<%=request.getContextPath()%>/board/freeBoardCommentInsert" method="post">
			<textarea name="boardCommentContent" cols="80" rows="3"></textarea>
			<button type="submit" id="btn-insert">등록</button>
			<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn!=null?memberLoggedIn.getUserId():""%>" />
			<input type="hidden" name="boardRef" value="<%=board.getBoard_free_no()%>" />
			<input type="hidden" name="boardCommentRef" value="0" />
			<input type="hidden" name="boardCommentLevel" value="1" />
		</form>
	</div> <!-- end of div.comment-editor -->
	
	<% if(freebcList != null){ %>
	<!-- 댓글목록테이블 -->
	<table id="tbl-comment">
	<%for(FreeBoardComment bc : freebcList) { 
		if(bc.getBoard_free_comment_level()==1){
	%>
		<tr class="level1">
			<td>
				<sub class="comment-writer"><%=bc.getBoard_free_comment_writer() %></sub>
				<sub class="comment-date"><%=bc.getBoard_free_comment_date() %></sub>
				<br />
				<%=bc.getBoard_free_comment_content() %>
			</td>
			<td>
				<button class="btn-reply" value="<%=bc.getBoard_free_comment_no()%>">답글</button>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_free_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_free_comment_no()%>">삭제</button>
				<%} %>
			</td>
		</tr>
	<% } else { %>
		<tr class="level2">
			<td>
				<sub class="comment-writer"><%=bc.getBoard_free_comment_writer() %></sub>
				<sub class="comment-date"><%=bc.getBoard_free_comment_date() %></sub>
				<br />
				<sub class="comment-content"><%=bc.getBoard_free_comment_content() %></sub>
			</td>
			<td>
				<!-- 삭제버튼추가 -->
				<%if(memberLoggedIn != null &&
					("admin".equals(memberLoggedIn.getUserId())
					|| bc.getBoard_free_comment_writer().equals(memberLoggedIn.getUserId()))
						){ %>
					<button class="btn-delete" value="<%=bc.getBoard_free_comment_no()%>" >삭제</button>
				<%} %>
			</td>
		</tr>
	
	<% } //end of if
	  } %>
	</table>
	<%} %>	
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		