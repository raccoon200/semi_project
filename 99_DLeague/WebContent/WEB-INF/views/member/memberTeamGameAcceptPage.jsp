<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.memberTeam.model.vo.*"%>
<%
	List<WaitTeam> list = (List<WaitTeam>)request.getAttribute("list");
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* table Object */
th{text-align:center} /* 부트스트랩으로 센터로안옴 */
legend{margin:30px 0 0 0;}
.tbl_type{margin:auto;}
.tbl_type,.tbl_type th,.tbl_type td{border:0}
.tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
.tbl_type caption{display:none}
.tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
.tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
.tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
.tbl_type td.ranking{font-weight:bold}
legend{padding:10px 0px 0px 40px;}
/* table Object 끝 */

</style>
<script>

function fn_memberTeamGameAccept(choose) {
	if(confirm("해당 팀과의 경기를 수락하시겠습니까?")) {
		location.href = "<%=request.getContextPath()%>/member/memberTeamGameAccept?teamName=<%=memberLoggedIn.getTeamname()%>&choose="+choose;
	}
}
function fn_memberTeamGameRefuse(choose) {
	if(confirm("해당 팀과의 경기를 거절하시겠습니까?")) {
		location.href = "<%=request.getContextPath()%>/member/memberTeamGameRefuse?teamName=<%=memberLoggedIn.getTeamname()%>&choose="+choose;
	}
}
</script>
<h2>팀 경기 수락</h2>
    <hr />
    
    <!-- <input type="button" value="경기 거절" style="position:relative; " class="btn" onclick="fn_memberTeamGameRefuse()"/> -->
    <table class="tbl_type"  cellspacing="0">
       
    <colgroup>
        <col width="10%"> 
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
    </colgroup>
    <thead>
    <tr>
    	<th scope="col">대기번호</th>
        <th scope="col">팀이름</th>
        <th scope="col">게임번호</th>
        <th scope="col">수락</th>
        <th scope="col">거절</th>
        
    </tr>
    </thead>
    <tbody>
    <%if(list == null || list.isEmpty()){ %>
		<tr>
			<td colspan="5" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ 
			for(WaitTeam waitTeam : list){%>
				
				<td class="ranking" scope="row"><%=waitTeam.getWaitNo() %></td>
				<td><%=waitTeam.getTeamName() %></td>
				<td><%=waitTeam.getGameNo() %></td>
				<td><button value="<%=waitTeam.getTeamName()%>" onclick="fn_memberTeamGameAccept(this.value)" class="btn">수락</button></td>
				<td><button value="<%=waitTeam.getTeamName()%>" onclick="fn_memberTeamGameRefuse(this.value)" class="btn">거절</button></td>
			<tr>
		<%}} %>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="4">
		</td>
		<td>
		</td>
		</tr>
		</tfoot>
		</table>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>