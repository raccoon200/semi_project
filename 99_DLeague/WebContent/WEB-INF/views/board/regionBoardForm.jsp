<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.board.model.vo.*, com.dleague.region.model.vo.*, java.util.*" %>
<%
	RegionBoard board = (RegionBoard)request.getAttribute("board");	
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");
	
	HashMap<String,String> regionMap = new HashMap<String,String>();
	for(int i=0; i<regionList.size(); i++) {
		Region region = regionList.get(i);
		regionMap.put(region.getRegionCode(), region.getRegionName());
	} 
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
table.board-table tr:hover{
	background:rgb(240,240,240);
}
table.board-table th{
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
</style>

<h2>지역게시판</h2>
<form action="<%=request.getContextPath() %>/board/regionBoardFormEnd" method="post" onsubmit="return fn_validate();" enctype="multipart/form-data">
	<table class="board-table">
		<tr>
			<th>제목</th>
			<td colspan="5">
			<input type="text" name="board_region_title" id="" required/>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="5"><input type="text" name="board_region_writer" id="" value='<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>' readonly/></td>
		</tr>
		<tr>
			<th>지역</th>
			<td colspan="5">
				<select name="regionSelect" id="">
				<%if(regionList!=null && !regionList.isEmpty()){
				for(int i=0; i<regionList.size(); i++) {
					Region region = regionList.get(i);
				%>
					<option value="<%=region.getRegionCode()%>"><%= region.getRegionName()%></option>
				<%
					}
				} %>
				</select>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="5">
				<input type="file" name="up_file" id="" />
			</td>
		</tr>
		<tr>
			<th colspan="6">내용</th>
		</tr>
		<tr>
			<td colspan="6" class="view-content"><textarea name="board_region_content" id="" cols="100" rows="10" required></textarea></td>
		</tr>
	</table>
	<div class="btn-area">
		<input type="submit" value="등록" />
		<input type="reset" value="초기화" />
		<input type="button" value="취소" onclick="location.href='<%=request.getContextPath() %>/board/regionBoard'" />
	</div>
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>		