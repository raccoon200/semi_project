<%--
	작성자 : 김대연
	작성 날짜 : 2018.05.07
	수정 날짜 : X
	페이지 설명 : 경기 등록 페이지
	최근 수정 사항 : 유효성 검사 및 서블릿 연결
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
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=f3nKBZeo1DvNZrIIPMNu&submodules=geocoder"></script>
<% String teamName = ""; %>
<%if(memberLoggedIn == null){ %>
<script>
$(function() {
	alert("로그인이 필요한 서비스 입니다.\n\n로그인을 해주새요.");
	location.href = "<%=request.getContextPath()%>/";
})
</script>
<%} else if(memberLoggedIn.getTeamname() == null){%>
<script>
$(function() {
	alert("팀이 필요한 서비스입니다.\n\n팀을 생성하거나 팀가입을 해주세요.");
	location.href = "<%=request.getContextPath()%>/";
})
</script>
<%
} else{
	teamName = memberLoggedIn.getTeamname();
}
%>
<script>
$(function() {
	$('#date-format').bootstrapMaterialDatePicker
	({
		format: 'YYYY년 MM월 DD일 ddd - HH:mm'
	});
	
	$("body").css("background-color","white");
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
	searchAddressToCoordinate(roadAddrPart1);
	
}
</script>

<h2>경기 등록</h2>
<form name="form" id="form" action="<%=request.getContextPath() %>/game/gameRegisterEnd" method="post" onsubmit="return fn_Validate();">
	<input type="hidden" name="teamName" value="<%=teamName%>"/>
	<div class="row col-md-6">
		<h4>날짜 및 시간 선택</h4>
		<input type="text" name="date" id="date-format" value="" class="form-control floating-label" placeholder="날짜와 시간을 입력하세요." style="width: 250px;">
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
					<input type="text" id="zipNo" class="form-control floating-label" name="zipNo" readonly style="width:100px; display: inline-block;">
					<input type="button" class="btn btn-primary btn-sm" value="주소검색" onclick="goPopup();">
					<input type="hidden" id = "point_x" name = "point_x" value=""/>
					<input type="hidden" id = "point_y" name = "point_y" value=""/>
				</td>
			</tr>
			<tr>
				<th><label>도로명주소</label></th>
				<td><input type="text" name="gamePlace" class="form-control floating-label" id="roadAddrPart1" readonly style="width:100%"></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>
					<input type="text" id="addrDetail" name="addrDetail" class="form-control floating-label" readonly style="width:45%; display: inline-block;" value="">
					<input type="text" id="roadAddrPart2" class="form-control floating-label" readonly style="width:45%; display: inline-block; font-size: 10px;" value="">
				</td>
			</tr>
		</tbody>
	</table>
	<br />
	<div id="map" style="width:90%;height:350px;"></div>
	<br />
	<h4>경기 내용</h4>
	<textarea name="game_content" id="game_content" class="form-control" cols="50" rows="5" placeholder="경기내용을 입력하세요."></textarea>
	<br />
	<input type="submit" class="btn btn-primary btn-sm" value="등록"/>
	<input type="reset" class="btn btn-primary btn-sm" value="취소"/>
</form>
<script>
var map = new naver.maps.Map("map", {
    center: new naver.maps.LatLng(126.8319882,37.3068984),
    zoom: 10,
    mapTypeControl: true
});

var infoWindow = new naver.maps.InfoWindow({
    anchorSkew: true
});

map.setCursor('grap');

function searchCoordinateToAddress(latlng) {
    var tm128 = naver.maps.TransCoord.fromLatLngToTM128(latlng);

    infoWindow.close();

    naver.maps.Service.reverseGeocode({
        location: tm128,
        coordType: naver.maps.Service.CoordType.TM128
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }

        var items = response.result.items,
            htmlAddresses = [];

        for (var i=0, ii=items.length, item, addrType; i<ii; i++) {
            item = items[i];
            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]';

            htmlAddresses.push((i+1) +'. '+ addrType +' '+ item.address);
            htmlAddresses.push('&nbsp&nbsp&nbsp -> '+ item.point.x +','+ item.point.y);
        }

        infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 좌표 : '+ response.result.userquery +'</h4><br />',
                htmlAddresses.join('<br />'),
                '</div>'
            ].join('\n'));
		
        infoWindow.open(map, latlng);
    });
}
function searchAddressToCoordinate(address) {
    naver.maps.Service.geocode({
        address: address
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }

        var item = response.result.items[0],
            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]',
            point = new naver.maps.Point(item.point.x, item.point.y);

        infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 주소 : '+ response.result.userquery +'</h4><br />',
                addrType +' '+ item.address +'<br />',
                '<a href="https://map.naver.com/?eX='+point.x+'&eY='+point.y+'&eText='+item.address+'&sY=&sText=" target="_blank">길찾기</a></br>',
                '</div>'
            ].join('\n'));
		document.form.point_x.value = point.x;
		document.form.point_y.value = point.y;

        map.setCenter(point);
        infoWindow.open(map, point);
    });
}

function initGeocoder() {
    searchAddressToCoordinate('광덕동로 25');
}
naver.maps.onJSContentLoaded = initGeocoder;

function fn_Validate () {
	if($("#date-format").val().trim().length == 0){
		alert("시간을 입력해주세요.");
		return false;
	}
	if($("#zipNo").val().trim().length == 0){
		alert("경기 장소를 입력해주세요.");
		return false;
	}
	if($("#game_content").val().trim().length == 0){
		alert("경기 내용을 입력해주세요.");
		return false;
	}
	
	return true;
}
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	