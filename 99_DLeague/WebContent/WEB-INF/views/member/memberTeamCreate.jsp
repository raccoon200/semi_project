<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%@ page import="com.dleague.region.model.vo.*, java.util.*" %>
<%
	List<Region> regionList = (List<Region>)request.getAttribute("regionList");
%>

<style>
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

function fn_fileUpload(value){
	
	if(value.files && value.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
           $('#profileImg').attr('src', e.target.result);
		}
      }
      reader.readAsDataURL(value.files[0]);

}
function fn_validate(){
	if($("[name=teamName]").val().trim().length==0) {
		alert("팀이름을 입력해주세요");
		return false;
	}
	return true;
}
</script>
<h2>팀 생성</h2>
<form action="<%=request.getContextPath() %>/member/memberTeamCreateEnd" method="post" onsubmit="return fn_validate();" enctype="multipart/form-data">
	
	<table class="team-register-table">
		<tr>
			<th>팀이름</th>
			<td>
			<input type="text" name="teamName" id="" required/>
			</td>
			
			<th>팀로고</th>
			
		</tr>
		<tr>
			<th>신청자(팀장)</th>
			<td class="left"><input type="text" name="t_register_writer" id="" value='<%=memberLoggedIn!=null?memberLoggedIn.getUserId():"" %>' readonly/></td>
			<td rowspan="2">
			<img src="<%=request.getContextPath() %>/images/team/default.png" id="profileImg" width="60px" height="60px" alt="" />
			<input type="file" name="up_file" id="" accept=".gif, .jpg, .png" onchange="fn_fileUpload(this);"/>
			</td>
			
		</tr>
		<tr>
			<th>지역</th>
			<td>
				<select name="regionCode" id="">
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
			<th colspan="3">팀소개</th>
		</tr>
		<tr>
			<td colspan="3" class="view-content"><textarea name="introduce" id="" cols="100" rows="8" ></textarea></td>
		</tr>
		<tr>
			<th colspan="3">팀 신청 메시지</th>
		</tr>
		<tr>
			<td colspan="3" class="view-content"><textarea name="register_msg" id="" cols="100" rows="8" ></textarea></td>
		</tr>
	</table>
	<div class="btn-area">
		<input class="btn" type="submit" value="신청" />
		<input class="btn" type="reset" value="초기화" />
	</div>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		