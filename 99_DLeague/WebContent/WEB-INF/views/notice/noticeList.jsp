<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="java.util.*, com.dleague.notice.model.vo.*" %>
<% 
	List<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");

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
	width:100%;
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
	padding:8px;
}
section#region-board-area{
	padding-left:30px;

}
img#file-image{
	width:16px;
}
/*페이지바*/
/* 
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
*/
.write-btn{
	float:right;
} 
/*페이지*/
	.pagination {
	    width: 100%;
	    margin: 0 0 0 0 aout;
	    text-align:center;
	} 
	.btn {
	    display: inline-block;
	    padding: 10px;
	    border-radius: 5px; /*optional*/
	    color: #aaa;
	    font-size: .875em;
	}
	.pagination {
	    background: #f2f2f2;
	    padding: 20px;
	    margin-bottom: 20px;
	}
	.page {
	    display: inline-block;
	    padding: 0px 9px;
	    margin-right: 4px;
	    border-radius: 3px;
	    border: solid 1px #c0c0c0;
	    background: #e9e9e9;
	    box-shadow: inset 0px 1px 0px rgba(255,255,255, .8), 0px 1px 3px rgba(0,0,0, .1);
	    font-size: .875em;
	    font-weight: bold;
	    text-decoration: none;
	    color: #717171;
	    text-shadow: 0px 1px 0px rgba(255,255,255, 1);
	}
	.page:hover, .page.gradient:hover {
	    background: #fefefe;
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FEFEFE), to(#f0f0f0));
	    background: -moz-linear-gradient(0% 0% 270deg,#FEFEFE, #f0f0f0);
	}
	.page.active {
	    border: none;
	    background: #616161;
	    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .8);
	    color: #f0f0f0;
	    text-shadow: 0px 0px 3px rgba(0,0,0, .5);
	}
	.page.gradient {
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#f8f8f8), to(#e9e9e9));
	    background: -moz-linear-gradient(0% 0% 270deg,#f8f8f8, #e9e9e9);
	}
	.pagination.dark {
	    background: #414449;
	    color: #feffff;
	}
	.page.dark {
	    border: solid 1px #32373b;
	    background: #3e4347;
	    box-shadow: inset 0px 1px 1px rgba(255,255,255, .1), 0px 1px 3px rgba(0,0,0, .1);
	    color: #feffff;
	    text-shadow: 0px 1px 0px rgba(0,0,0, .5);
	}
	.page.dark:hover, .page.dark.gradient:hover {
	    background: #3d4f5d;
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#547085), to(#3d4f5d));
	    background: -moz-linear-gradient(0% 0% 270deg,#547085, #3d4f5d);
	}
	.page.dark.active {
	    border: none;
	    background: #2f3237;
	    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .1);
	}
	.page.dark.gradient {
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#565b5f), to(#3e4347));
	    background: -moz-linear-gradient(0% 0% 270deg,#565b5f, #3e4347);
	}
/*페이지끝*/
/* 버튼 */
    .button {
    	position:absolute;
      	height:33px;
	  display: inline;
	  vertical-align: top;
	 /*  position: relative; */
	  padding: 0 15px 0 15px;
	  line-height: 35px;
	  font-size: 15px;
	  font-weight: bold;
	  color: white;
	  text-align: center;
	  text-shadow: 0 -1px rgba(0, 0, 0, 0.5);
	  background: #576dce;
	  background-clip: padding-box;
	  border: 1px solid;
	  border-color: #374fbb #344cb3 #2b3e94;
	  border-radius: 2px;
	  background-image: -webkit-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 2px rgba(0, 0, 0, 0.2);
	}
	.button:hover, .button.hover {
	  background-color: #5f74d0;
	  border-color: #2d429c #2d429c #253680;
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 5px #576dce;
	}
	.button:active, .button.active {
	  border-color: #253680 #2b3e94 #3147a8;
	  background: #475fc9;
	  box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.8);
	}
	.button:after {
	  content: '>';
	  float: right;
	  /* position: relative; */
	  margin-left: 15px;
	  font: bold 18px/33px 'Comic Sans MS';
	  /* I tried everything but couldn't get the vertical alignment to be
	     consistent in IE, so this is a hack targeting IE8-9-10. */
	  line-height: 31px\0;
	  color: white;
	  text-shadow: 0 -1px #8696dc, 0 1px 1px rgba(0, 0, 0, 0.3);
	  -webkit-font-smoothing: subpixel-antialiased;
	}
	/*버튼끝*/
	#searchType{height:32px;}
	#searchValue{height:32px;}
</style>
<script>
function fn_writeAuthorityCheck() {
	
	
}
$(function() {
	
	$("tr").click(function() {
		<% if(memberLoggedIn!=null) {%>
		if($(this).attr("id")!=null){
			location.href="<%=request.getContextPath()%>/notice/noticeView?no="+$(this).attr("id");
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
		return false;
	}
	var searchValue = $("#searchValue").val().trim();
	var searchType = $("[name=searchType]").val();
<%-- 	location.href='<%=request.getContextPath()%>/board/regionBoard?region=<%=selectRegionCode%>&searchType="+searchType+"&searchValue="+searchValue+'; --%>
	return true;
	
}
</script>
<h2>공지사항</h2>
<hr />
<section id="notice-area">
	<span class="search-area">
		<form action="<%=request.getContextPath() %>/notice/noticeList" method="get">
			<select name="searchType" id="searchType">
				<option value="title">제목</option>
			</select>
			<input type="text" id="searchValue" name="searchValue"/>
			<input type="submit" class="button" value="검색" onclick="fn_search()"/>
		</form>
	</span>
	<table class="board-table">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="12%">작성자</th>
			<th>첨부파일</th>
			<th width="15%">작성일</th>
		</tr>
		<%if(noticeList!=null && !noticeList.isEmpty()) { 
			for(int i=0; i<noticeList.size(); i++) {
				Notice notice = noticeList.get(i);	
		%>
		<tr id="<%=notice.getNotice_no()%>" >
			<td><%=notice.getNotice_no()%></td>
			<td style="text-align:left"><%=notice.getNotice_title() %></td>
			<td><%=notice.getNotice_writer() %></td>
			<td><%if(notice.getOriginal_file_name()!=null){%>
				<img id="file-image" src="<%=request.getContextPath() %>/images/fileImage.png" alt="파일이미지" />
				<%} %>
				
			</td>
			<td><%=notice.getNotice_date() %></td>
			
		</tr>
		<%}
		}else { %>
		<tr>
			<td colspan="7">데이터가 없습니다</td>
		</tr>
		<%} %>
	</table>
	<div id="pageBar" class="pagination">
		<%=(request.getAttribute("pageBar")!=null)?request.getAttribute("pageBar"):"" %>
		<%if(memberLoggedIn!=null) { %>
			<input type="button" class="write-btn" value="글쓰기" onclick="location.href='<%=request.getContextPath()%>/notice/noticeForm'"/>
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