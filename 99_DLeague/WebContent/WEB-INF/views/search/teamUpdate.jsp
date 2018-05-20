<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.search.model.vo.*, java.util.*" %>
<%
	List<Team> list = (List<Team>)request.getAttribute("list");
	List<TeamMember> memberList = (List<TeamMember>)request.getAttribute("memberList");
	//team정보
	String teamName="";
	String capTain="";
	String rCode="";
	String introduce="";
	Date foundInDate=null;
	int rnum=0;
	String logo="";
	//팀정보
	for(Team t : list){
		teamName = t.getTeamName();
		capTain = t.getCapTain();
		rCode = t.getRegionCode();
		foundInDate = t.getFoundingDate();
		introduce=t.getIntroduce();
		logo=t.getTeamLogo();
	}
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table.team-register-table{
	border:1px solid rgb(240,240,240);
	border-collapse:collapse;
	width:680px;
	
}
table.team-register-table tr{
	border:1px solid gray;
	
}
table.team-register-table tr th{
	background: rgb(147,213,245);
	color:white;
	border-radius: 1px;
}
table.team-register-table tr{
	height:5px;
}
table.team-register-table tr td{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:left;
	font-size:13px;
}
table.team-register-table tr th{
	border:1px solid rgb(220,220,220);
	padding:10px;
	text-align:center;
	font-size:13px;

}
table.team-register-table tr:hover{
	background:rgb(240,240,240);
}
table.team-register-table th{
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
<script>
$(function (){
	
	$("#profileImg").attr("src", "<%=request.getContextPath() %>/images/team/<%=logo!=null?logo:"default.png"%>");
	});
	$("#up_file").value = "<%=logo%>";
	$("#up_file").val("<%=logo%>");
	console.log("<%=logo%>");
	console.log($("#up_file").val("<%=logo%>"));
	$("[name=up_file]").change(function(){ 
		//$(this).val()은 선택한 파일명임.
		if($(this).val()==""){
			$("#fname").show();
		}	
		else{
			$("#fname").hide();
		}
	});	
	function fn_fileUpload(value){
		 if(value.files && value.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	             $('#profileImg').attr('src', e.target.result);
				}
	        }
	        reader.readAsDataURL(value.files[0]);
		}
</script>
<h2>팀 정보수정</h2>
<hr />
<div id="allDiv">
<form action="<%=request.getContextPath() %>/search/TeamUpdateServletEnd" method="post" onsubmit="return fn_validate();" enctype="multipart/form-data">
	<table class="team-register-table">
		<tr>
			<th>팀이름</th>
			<td>
			<input type="text" name="teamName" id="" value="<%=teamName%>" readonly/>
			</td>
			
			<th>팀로고</th>
			
		</tr>
		<tr>
			<th>팀장</th>
			<td class="left">
				<%-- <input type="text" name="t_register_writer" id="" value='<%=capTain %>' readonly/> --%>
				<select name="t_register_writer" id="">
				<%for(TeamMember tm : memberList){ %>
					<option value="<%=tm.getUserId() %>"><%=capTain.equals(tm.getUserId())==true?tm.getUserId()+"(현재팀장)":tm.getUserId() %></option>
				<%} %>
				</select>
			</td>
			
			<td rowspan="2">
			<img src="<%=request.getContextPath() %>/images/team/<%=logo!=null?logo:"default.png"%>" id="profileImg" width="60px" height="60px" alt="" />
			<input type="file" name="up_file" id="up_file" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);"/>
			<span id="fname">프로필 사진 변경</span>
			</td>
			
		</tr>
		<tr>
			<th>지역</th>
			<td>
				<select name="regionCode" id="">
					<option value="<%=rCode%>">
						<%if("G1".equals(rCode)){ %>
							서울(현재활동지역)
						<%}else if("G2".equals(rCode)){ %>
							경기(현재활동지역)
						<%}else if("G3".equals(rCode)){ %>
							강원(현재활동지역)
						<%}else if("G4".equals(rCode)){ %>
							충북(현재활동지역)
						<%}else if("G5".equals(rCode)){ %>
							충남(현재활동지역)
						<%}else if("G6".equals(rCode)){ %>
							경북(현재활동지역)
						<%}else if("G7".equals(rCode)){ %>
							전북(현재활동지역)
						<%}else if("G8".equals(rCode)){ %>
							전남(현재활동지역)
						<%}else if("G9".equals(rCode)){ %>
							제주(현재활동지역)
						<%} %>
					</option>
					<option value="G1">서울</option>
			        <option value="G2">경기</option>
			        <option value="G3">강원</option>
			        <option value="G4">충북</option>
			        <option value="G5">충남</option>
			        <option value="G6">경북</option>
			        <option value="G7">전북</option>
			        <option value="G8">전남</option>
			        <option value="G9">제주</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th colspan="3">팀소개</th>
		</tr>
		<tr>
			<td colspan="3" class="view-content"><textarea name="introduce" id="" cols="100" rows="8" style="resize: none" ><%=introduce %></textarea></td>
		</tr>
	</table>
	
	<div id="inputDiv">
	<input type="submit" value="정보수정" />
	<input type="reset" value="초기화" />
	</div>
</form>
	<br />
<%-- 	<div id="btDiv"><button id="delbt" onclick="fn_teamDelete('<%=teamName%>');">팀해체</button></div>
 --%></div>
<script>
function fn_teamDelete(teamName){
	/* console.log(teamName); */
	if (confirm("정말 팀을 해체하시겠습니까??\n\n팀해체는 복구할 수 없습니다.") == true){    //확인
		location.href="<%=request.getContextPath()%>/search/teamDelete?teamName="+teamName;
	}else{   //취소
	    return;
	}

}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		