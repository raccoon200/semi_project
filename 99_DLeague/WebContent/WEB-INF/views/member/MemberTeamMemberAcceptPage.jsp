<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.memberTeam.model.vo.MemberRegister"%>
<%List<MemberRegister> memberRegisterList = (List<MemberRegister>)request.getAttribute("memberRegisterList"); %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<style>
/* 테이블 공통 UI Object */
	.tbl_type,.tbl_type th,.tbl_type td{border:0}
    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
    .tbl_type caption{display:none}
    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    .tbl_type td.ranking{font-weight:bold}
    /* //테이블 공통 UI Object */
        
</style>
<script>

function fn_memberTeamMemberAccept(choose) {
	if(confirm("해당 회원을 팀원으로 받아들이시겠습니까??")) location.href="<%=request.getContextPath()%>/member/memberTeamMemberAccept?teamName=<%=memberLoggedIn.getTeamname()%>&userId="+choose;
}
function fn_memberTeamMemberRefuse(choose) {
	if(confirm("해당 회원의 신청을 거절하시겠습니까??")) location.href="<%=request.getContextPath()%>/member/memberTeamMemberRefuse?teamName=<%=memberLoggedIn.getTeamname()%>&userId="+choose;
}
</script>
</head>
<body>
 
	<h2>팀원 수락</h2>
	<hr />
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
    	<th scope="col">아이디</th>
    	<th scope="col">메시지</th>
        <th scope="col">신청 날짜</th>
        <th scope="col">상태</th>
        <th scope="col">승인</th>
        <th scope="col">거절</th>
        
    </tr>
    </thead>
    <tbody> 
    <%if(memberRegisterList == null || memberRegisterList.isEmpty()){ %>
		<tr>
			<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ %>
		<% for(MemberRegister memberRegister : memberRegisterList){%>
		<td><%=memberRegister.getUserId()%></td>
		<td><%=memberRegister.getMsg() %></td>
		<td><%=memberRegister.getRegisterDate() %></td>
		<td><%=memberRegister.getYN()==null?"승인대기중":"거절함" %></td>
		<td><button class="btn" onclick ="fn_memberTeamMemberAccept(this.value)" value="<%=memberRegister.getUserId()%>">승인</button></td>
		<td><button class="btn" onclick ="fn_memberTeamMemberRefuse(this.value)" value="<%=memberRegister.getUserId()%>">거절</button></td>		
    	
	<tr>
	<%} }%>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="5">
		</td>
		<td>
		</td>
		</tr>
		</tfoot>
		</table>
    
</body>
</html>