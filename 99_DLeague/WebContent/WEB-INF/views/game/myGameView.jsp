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
	String place[] = null;
	boolean gameStatus = o instanceof Game;
	if(gameStatus){
		g = (Game)o;
		place = g.getPlace().split("#");
	}else{
		a = (Activity)a;
		place = a.getPlace().split("#");
	}
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=f3nKBZeo1DvNZrIIPMNu&submodules=geocoder"></script>
<style>
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
div.center{
	margin-top: 30px;
	text-align: center;
}
</style>
<h2>경기 상세 정보</h2>
<hr />
<div id="score">
	<table style="display: inline-block;">
		<tr>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/<%=gameStatus?g.getHomeLogo():a.getHomeLogo() %>" alt="home" style="width: 150px; height: 112.188px;"/>
			</td>
			<td rowspan="2">
				<h1 style= "display: inline-block; font-weight: 700; font-size: 70px; margin-left : 20px; margin-right : 60px;"><%=gameStatus?"&nbsp;":a.getResult().substring(0, a.getResult().indexOf(":"))%></h1>
			</td>
			<td rowspan="2">
				<h2 style="display: inline-block;">VS</h2>
			</td>
			<td rowspan="2">
				<h1 style= "display: inline-block; font-weight: 700; font-size: 70px; margin-left : 60px; margin-right : 20px;"><%=gameStatus?"&nbsp;":a.getResult().substring(a.getResult().indexOf(":")+1, a.getResult().length())%></h1>
			</td>
		</tr>
		<tr style=" text-aline : center;">
			<td style='color: <%=memberLoggedIn.getTeamname().equals(g.getHome())?"red":""%>; font-size : 18px;'>
				<%=gameStatus?g.getHome():a.getHome()%>
			</td>
			<td></td>
		</tr>
	</table>
	<table style="display: inline-block;">
		<tr>
		<%if (gameStatus&&g.getAway()!= null) {%>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/<%=g.getAwayLogo()%>" alt="home" style="width: 150px; height: 112.188px;"/>
			</td>
		<%} else if (gameStatus && g.getAway() == null) {%>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/awayNull.png" alt="home" style="width: 150px; height: 112.188px;"/>
			</td>
		<%} else{%>
			<td>
				<img src="<%=request.getContextPath() %>/images/team/<%=a.getAwayLogo()%>" alt="home" style="width: 150px; height: 112.188px;"/>
			</td>
		<%} %>
			
		</tr>
		<tr style=" text-aline : center;">
			<td style='color: <%=memberLoggedIn.getTeamname().equals(g.getAway())?"red":""%>; font-size : 18px;'>
				<%=gameStatus?g.getAway():a.getAway() %>	
			</td>
		</tr>
	</table>
</div>

<div class="container">
<%if (gameStatus && g.getAway() == null){ %>
	<div class="alert alert-warning center">
		<strong style="font-size: 17px;"><%=g.getGameDate() %> <%=g.getStartTime() %> 상대 찾는중</strong>
	</div>
<%} else if(gameStatus && g.getAway() != null){ %>
	<div class="alert alert-info center">
		<strong style="font-size: 17px;"><%=g.getGameDate() %> <%=g.getStartTime() %> 경기 예정</strong>
	</div>
<%} else if(gameStatus && g.getStatus().equals("N")){ %>
	<div class="alert alert-danger center">
		<strong style="font-size: 17px;"><%=g.getGameDate() %> <%=g.getStartTime() %> 경기 미실시</strong>
	</div>
<%} else {%>
	<div class="alert alert-success center">
		<strong style="font-size: 17px;"><%=a.getActivityDate() %> 경기 완료</strong>
	</div>
<%} %>
	<ul class="tabs">
	  <li class="tab-link current" data-tab="tab-1">경기 정보</li>
	  <li class="tab-link" data-tab="tab-2">홈팀 정보</li>
	  <li class="tab-link" data-tab="tab-3">어웨이팀 정보</li>
	</ul>
	
	<div id="tab-1" class="tab-content current">
		<h3>경기 장소</h3>
		<hr style="background: white;"/>
		
		<%=place[0]%> <%=place[1] %>
		<br /><br />
		<div id="map" style="width:100%;height:350px;"></div>
		<br /><br />
		<%if (gameStatus){ %>
		<h3>경기 내용</h3>
		<hr style="background: white;"/>
		
		<textarea class="form-control" cols="60" rows="10" readonly>
<%=g.getGameContent() %>
		</textarea>
		<% }%>
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
    center: new naver.maps.LatLng(<%=place[2]%>,<%=place[3]%>),
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
    searchAddressToCoordinate('<%=place[0]%>');
}
naver.maps.onJSContentLoaded = initGeocoder;
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	