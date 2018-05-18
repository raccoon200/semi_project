<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.memberTeam.model.vo.*, com.dleague.game.model.vo.Game"%>
<%
	List<Game> memberTeamActivity = (List<Game>)request.getAttribute("memberTeamActivity");
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
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
<h2>팀 활동 이력</h2>
    <hr />
    <table class="tbl_type"  cellspacing="0">
    <colgroup>
        <col width="10%"> 
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="20%">
        <col width="20%">
    </colgroup>
    <thead>
    <tr>
    	<th scope="col">선택</th>
    	<th scope="col">게임번호</th>
        <th scope="col">홈팀</th>
        <th scope="col">어웨이팀</th>
        <th scope="col">경기날짜</th>
        <th scope="col">경기등록날짜</th>
        <th scope="col">시작시간</th>
        <th scope="col">경기내용</th>
        <th scope="col">실시</th>
        <th scope="col">미실시</th>
    </tr>
    </thead>
    <tbody>
    <%if(memberTeamActivity == null || memberTeamActivity.isEmpty()){ %>
		<tr>
			<td colspan="10" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ 
			for(Game game : memberTeamActivity){%>			
				<td><input type="radio" name="choose" id="choose" value="<%=game.getGameNo()%>" onchange="fn_choose_change(this)"/></td>
				<td class="ranking" scope="row"><%=game.getGameNo() %></td>
				<td><%=game.getHome() %></td>
				<td><%=game.getAway() %></td>
				<td><%=game.getGameDate() %></td>
				<td><%=game.getGameRegDate() %></td>
				<td><%=game.getStartTime() %></td>
				<td><%=game.getGameContent() %></td>
				<td><input type="button" value="실시" class="btn" onclick = "fn_gameOK()"/></td>
				<td><input type="button" value="미실시" class="btn"/></td>
			<tr>
		<%}} %>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="10">
		</td>
		<td>
		</td>
		</tr>
		</tfoot>
		</table>
<script>
var choose = "";
function fn_choose_change(choose) {
	this.choose = choose.value;	
}
function fn_gameOK() {
	if (choose=="") {
		alert("대상을 선택해주세요!");
	}
	else {
		if(confirm("해당 팀과의 경기를 하셨습니까??")) {
			var url = "<%=request.getContextPath()%>/member/memberTeamGameScorePage?teamName=<%=memberLoggedIn.getTeamname()%>&gameNo="+choose;
			var title = "memberTeamGameScorePage";
			var status = "left=500px, top=200px, width=450px, height=260px";
			
			var popup = window.open(url, title, status);
			
				<%-- location.href = "<%=request.getContextPath()%>/member/memberTeamActivityGameOK; --%>
		}
	}
}

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>