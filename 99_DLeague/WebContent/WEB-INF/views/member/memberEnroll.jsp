<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function fn_checkIdDuplicate(){
	var userid = $("#userid_").val().trim();
	if(userid.length<4){
		alert('아이디는 4글자 이상부터 가능합니다.');
		return;
	}
	
	var url = "<%=request.getContextPath()%>/member/checkIdDuplicate";
	var title = "checkDuplicate";
	var status = "left=350px, top=100px, width=300px, height=200px";
	var popup = window.open("",title,status);
	
	var checkIdDuplicateFrm = document.checkIdDuplicateFrm;
	checkIdDuplicateFrm.userid.value=userid;
	
	checkIdDuplicateFrm.target = title;
	checkIdDuplicateFrm.action = url;
	checkIdDuplicateFrm.submit();
}
</script>
<section id = "enroll-container">
<h2>회원가입 정보입력</h2>
<form name="memberEnrollFrm" action="<%=request.getContextPath() %>/member/memberEnrollEnd" method="post" onsubmit="return fn_enrollValidate();">
<table>
<tr>
<th>아이디</th>
<td>
<input type="text" name="userid" id="userid_" required/>
<input type="button" value="아이디체크"
id="btn-idValid" onclick="fn_checkIdDuplicate()"/>
<input type = "hidden" name="idValid" value="0" />
</td>
</tr>
<tr>
<th>비밀번호</th>
<td>
<input type="password" name="password" id="password_" />
</td>
</tr>
<tr>
<th>비밀번호 확인</th>
<td>
<input type="password" id="password_chk" />
</td>
</tr>
<tr>
<th>이름</th>
<td>
<input type="text" name="username" id="username"/>
</td>
</tr>
<tr>
<th>첨부파일</th>
<td>
<% if(m.getOriginalFileName() != null){ %>
<a href="javascript:fn_fileDownload('<%=m.getOriginalFileName() %>','<%=m.getRenamedFileName() %>');">
<img alt="첨부파일" src="<%=request.getContextPath() %>/images/file.png" width=16px>
<%= m.getOriginalFileName() %>
</a>
<% }%>
 </td>
 </tr>
<tr>
<th>생년월일</th>
<td>
<input type="date" name="birthday" id="birthday"/>
</td>
</tr>
<tr>
<th>휴대폰</th>
<td>
<input type="tel" id="phone" name="phone"
placeholder="(-없이)01012345678" maxlength="11"/>
</td>
</tr>
<tr>
<th>거주지역</th>
<td>
<input type="radio" id="regioncode1" name="regioncode"/>
<label for = "regioncode1">서울</label>
<input type="radio" id="regioncode2" name="regioncode"/>
<label for = "regioncode2">경기</label>
<input type="radio" id="regioncode3" name="regioncode"/>
<label for = "regioncode3">강원</label>
<input type="radio" id="regioncode4" name="regioncode"/>
<label for = "regioncode4">충남</label>
<input type="radio" id="regioncode5" name="regioncode"/>
<label for = "regioncode5">충북</label>
<input type="radio" id="regioncode6" name="regioncode"/>
<label for = "regioncode6">전남</label>
<input type="radio" id="regioncode7" name="regioncode"/>
<label for = "regioncode7">경북</label>
<input type="radio" id="regioncode8" name="regioncode"/>
<label for = "regioncode8">경남</label>
<th>프로필</th>
<td>
<textarea id="profile" name="profile" maxlength="2048" style="height:180px;"></textarea>
</td></tr>
</table>
</section>


