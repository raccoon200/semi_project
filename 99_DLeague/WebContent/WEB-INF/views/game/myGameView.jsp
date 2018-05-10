<%@page import="com.dleague.search.model.vo.Activity"%>
<%@page import="com.dleague.game.model.vo.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%
	Object o = request.getAttribute("obj");
	Activity a = null;
	Game g = null;
	if(o instanceof Game){
		g = (Game)o;
	}else if (o instanceof Activity){
		a = (Activity)a;
	}
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=f3nKBZeo1DvNZrIIPMNu&submodules=geocoder"></script><style>
/* body{
  margin-top: 100px;
  line-height: 1.6
} */
.container{
	width: 90%;
	margin: 0 auto;
}
ul.tabs{
	margin: 0px;
	padding: 0px;
	list-style: none;
}
ul.tabs li{
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}
 
ul.tabs li.current{
  	background: #ededed;
  	color: #222;
}
 
.tab-content{
	display: none;
	background: #ededed;
	padding: 15px;
}
 
.tab-content.current{
  	display: inherit;
}
div#score{
	text-align: center;
	width: 80%;
	margin : 0 auto;
}
</style>
<h2>경기 상세 정보</h2>
<hr />
<div id="score">
	<table style="display: inline-block; margin-right: 100px">
		<tr>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="height: 112.188px;"/>
			</td>
		</tr>
		<tr style=" text-aline : center;">
			<td style='color: <%=memberLoggedIn.getTeamname().equals(g.getHome())?"red":""%>; font-size : 18px;'>
				기아 타이거즈		
			</td>
		</tr>
	</table>
	<h2 style="display: inline-block;">VS</h2>
	<table style="display: inline-block; margin-left: 90px;">
		<tr>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/tigers.png" alt="home" style="height: 112.188px;"/>
			</td>
		</tr>
		<tr style=" text-aline : center;">
			<td style='color: <%=memberLoggedIn.getTeamname().equals(g.getHome())?"red":""%>; font-size : 18px;'>
				기아 타이거즈	
			</td>
		</tr>
	</table>
</div>

<div class="container">
<div class="alert alert-success" style="text-align: center;">
  <strong style="font-size: 17px;">17-10-11 18:10 경기 ㄱㄱ</strong>
</div>
	<ul class="tabs">
	  <li class="tab-link current" data-tab="tab-1">경기 정보</li>
	  <li class="tab-link" data-tab="tab-2">홈팀 정보</li>
	  <li class="tab-link" data-tab="tab-3">어웨이팀 정보</li>
	</ul>
	
	<div id="tab-1" class="tab-content current">
		<h3>경기 장소</h3>
		<hr style="background: white;"/>
		경기도 안산시 광덕동로 25 레이크타운 105동 1604호
		<br /><br />
		<div id="map" style="width:100%;height:350px;"></div>
		<br /><br />
		<h3>경기 내용</h3>
		<hr style="background: white;"/>
		<hr style="background: white;"/>
		<textarea class="form-control" cols="60" rows="10" readonly>
가치를 꾸며 열락의 것이 청춘에서만 웅대한 그들은 천하를 철환하였는가? 피가 바이며, 들어 있는가? 붙잡아 석가는 있는 사라지지 커다란 부패뿐이다. 그들의 그들에게 옷을 사는가 청춘의 무엇을 위하여 대고, 쓸쓸하랴? 살 그들에게 가지에 남는 커다란 그들의 영원히 인간이 때문이다. 기쁘며, 오아이스도 원대하고, 주는 듣는다. 그들의 있는 찾아 가는 맺어, 그들의 것이다.

간에 속에서 풍부하게 보배를 할지라도 군영과 수 이상의 긴지라 것이다. 이상의 곧 안고, 실현에 싶이 이상 있으랴? 사는가 인간에 소담스러운 것이다. 뜨거운지라, 그들에게 싹이 같은 봄바람이다. 실현에 가진 동산에는 있으랴?

가슴에 그들은 이상 있는 가진 그러므로 얼음에 구하기 듣는다. 가치를 이상 온갖 있는 피에 아니더면, 웅대한 바이며, 이상, 말이다. 불러 가는 크고 군영과 청춘이 것은 전인 돋고, 보이는 봄바람이다. 가슴에 역사를 같이, 설레는 동산에는 만천하의 수 두손을 그들은 있다. 실로 있는 바이며, 우는 이상을 이것을 방황하여도, 말이다.
		</textarea>
		
  	</div>
  	<div id="tab-2" class="tab-content">
		---- ---- ★------ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ★-- ---- ---- ------★ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- ★------ ---- ---- ---- ----
  	</div>
  	<div id="tab-3" class="tab-content">
		---- ★-- -------- ---- ---- ---- -★- ---- ---- -------- ---- -★- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- --★ -------- ★-- ---- ---- ---- ---- ---- -------- ---- ---- --★ ---- ---- ---- -------- ---- ---- ---- --★
  	</div>
 
</div>
<script>
$(document).ready(function(){
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');
		
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		
		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	});
});
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
        map.setCenter(point);
        infoWindow.open(map, point);
    });
}

function initGeocoder() {
    searchAddressToCoordinate('광덕동로 25');
}
naver.maps.onJSContentLoaded = initGeocoder;
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	