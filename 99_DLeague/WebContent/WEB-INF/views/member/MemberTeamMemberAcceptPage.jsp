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
    
    .btn {
	  display: inline-block;
	  background: transparent;
	  text-transform: uppercase;
	  font-weight: 500;
	  font-style: normal;
	  font-size: 1rem;
	  letter-spacing: 0.3em;
	  color:rgba(223,190,106,0.8);
	  border-radius: 0;
	  padding: 18px 80px 20px;
	  transition: all 0.7s ease-out;
	  background: linear-gradient(270deg, rgba(223,190,106,0.8), rgba(146,111,52,0.8), rgba(34,34,34,0), rgba(34,34,34,0));
	  background-position: 1% 50%;
	  background-size: 300% 300%;
	  text-decoration: none;
	  margin: 0.625rem;
	  border: none;
	  border: 1px solid rgba(223,190,106,0.8);
	}
	
	.btn:hover {
	  color: #fff;
	  border: 1px solid rgba(223,190,106,0);
	  color: $white;
	  background-position: 99% 50%;
	} 
    /* 버튼 디자인 */
    
</style>
<script>
var choose = "";
function fn_choose_change(choose) {
	this.choose = choose.value;		
}

function fn_memberTeamMemberAccept() {
	if (choose=="") {
		alert("대상을 선택해주세요!");
	}
	else {
		if(confirm("해당 회원을 팀원으로 받아들이시겠습니까??")) location.href="<%=request.getContextPath()%>/member/memberTeamMemberAccept?teamName=<%=memberLoggedIn.getTeamname()%>&userId="+choose;
	}
}
function fn_memberTeamMemberRefuse() {
	if (choose=="") {
		alert("대상을 선택해주세요!");
	}
	else {
		if(confirm("해당 회원의 신청을 거절하시겠습니까??")) location.href="<%=request.getContextPath()%>/member/memberTeamMemberRefuse?teamName=<%=memberLoggedIn.getTeamname()%>&userId="+choose;
	}
}
</script>
</head>
<body>
 
	<h2>팀원 수락</h2>
	<hr />
    <input type="button" value="승인" style="position:relative; " class="btn" onclick="fn_memberTeamMemberAccept()"/>
    <input type="button" value="거절" style="position:relative; " class="btn" onclick="fn_memberTeamMemberRefuse()"/>
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
        <th scope="col">선택</th>
    	<th scope="col">아이디</th>
    	<th scope="col">메시지</th>
        <th scope="col">신청 날짜</th>
        <th scope="col">상태</th>
    </tr>
    </thead>
    <tbody> 
    <%if(memberRegisterList == null || memberRegisterList.isEmpty()){ %>
		<tr>
			<td colspan="5" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ %>
		<% for(MemberRegister memberRegister : memberRegisterList){%>
		<td><input type="radio" name="choose" id="choose" value="<%=memberRegister.getUserId()%>" onchange="fn_choose_change(this)"/></td>
		<td><%=memberRegister.getUserId()%></td>
		<td><%=memberRegister.getMsg() %></td>
		<td><%=memberRegister.getRegisterDate() %></td>
		<td><%=memberRegister.getYN()==null?"승인대기중":"거절함" %></td>
	<tr>
	<%} }%>
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
    
</body>
</html>