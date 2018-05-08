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

</script>
<div class="row">
	<div class="col-md-6">
		<h2>날짜 및 시간 선택</h2>
	</div>
</div>

	<input type="text" id="date-format" class="form-control floating-label" placeholder="Begin Date Time" style="width: 250px;">


<%@ include file="/WEB-INF/views/common/footer.jsp" %>	