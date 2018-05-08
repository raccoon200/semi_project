<%--
	작성자 : 김대연
	작성 날짜 : 2018.05.07
	수정 날짜 : X
	페이지 설명 : 경기 등록 페이지
	최근 수정 사항 : 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/js/pretty_date_time_picker/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/js/pretty_date_time_picker/css/material.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/js/pretty_date_time_picker/css/bootstrap-material-datetimepicker.css" />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/pretty_date_time_picker/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/pretty_date_time_picker/js/material.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/pretty_date_time_picker/js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/pretty_date_time_picker/js/bootstrap-material-datetimepicker.js"></script>
<script>
$(function() {
	$('#date-format').bootstrapMaterialDatePicker
	({
		format: 'dddd DD MMMM YYYY - HH:mm'
	});
});
//opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
  var pop = window.open("<%=request.getContextPath()%>/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
  
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
  //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.roadAddrPart2.value = roadAddrPart2;
	document.form.addrDetail.value = addrDetail;
	document.form.zipNo.value = zipNo;
}
</script>
<h2>경기 등록</h2>
<form name="form" id="form" method="post">
	<div class="row col-md-6">
		<h4>날짜 및 시간 선택</h4>
		<input type="text" id="date-format" class="form-control floating-label" placeholder="Begin Date Time" style="width: 250px;">
	</div>
	<br style="clear:both;"/>
	<br />
	<h4>경기 장소</h4>
	<table >
		<colgroup>
			<col style="width:20%"><col>
		</colgroup>
		<tbody>
			<tr>
				<th>우편번호</th>
				<td>
				    <input type="hidden" id="confmKey" name="confmKey" value=""  >
					<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
					<input type="button"  value="주소검색" onclick="goPopup();">
				</td>
			</tr>
			<tr>
				<th><label>도로명주소</label></th>
				<td><input type="text" id="roadAddrPart1" style="width:85%"></td>
			</tr>
			<tr>
				<th>상세주소</th>
					<td>
						<input type="text" id="addrDetail" style="width:40%" value="">
						<input type="text" id="roadAddrPart2"  style="width:40%" value="">
					</td>
			</tr>
		</tbody>
	</table>
	<br />
	<input type="submit" value="등록"/>
	<input type="reset" value="취소"/>
</form>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	