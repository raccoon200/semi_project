<%@page import="com.dleague.search.model.vo.TeamMember"%>
<%@page import="java.util.List"%>
<%@page import="com.dleague.search.model.vo.Team"%>
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
	Team tHome = (Team)request.getAttribute("tHome");
	Team tAway = (Team)request.getAttribute("tAway");
	
	List <TeamMember> hMemberList = (List<TeamMember>)request.getAttribute("hMemberList");
	List <TeamMember> aMemberList = (List<TeamMember>)request.getAttribute("aMemberList");
	
	List <Activity> hActivityList = (List<Activity>)request.getAttribute("hActivityList");
	List <Activity> aActivityList = (List<Activity>)request.getAttribute("aActivityList");
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
	width: 95%;
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
<style>
	img#logoimg{width: 250px;height: 200px;display: inline-block;margin: 50px 0 0 0;}
	img#logo{width: 200px;height: 80px;display: inline-block;}
	div#logoDiv{width: 200px;height: 80px;display: inline-block;}
	div#imgDiv{width: 366px;height: 315px;display: inline-block;float: left;text-align:center;}
	/* div#bu,#a,#b,#c,#d{border: 1px solid black;} */
	div#bu{height: 590px; width: 644px; display: inline-block;}
	div#a{border-radius: 10px;background:lightgreen;height: 100px; width: 200px; text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#b{border-radius: 10px;background:lightgreen;height: 80px; width: 200px; text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#c{border-radius: 10px;background:lightgreen;height: 80px; width: 200px;  text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#d{height: 80px; width: 200px; text-align: center; display: inline-block;}
	/*글자색깔*/
	h2#aa{color:#2828CD;}
	h2#bb{color:#DB631F;}
	h3#bb{color:#DB631F;}
	
    /* 테이블 공통 UI Object */
    th{text-align:center} /* 부트스트랩으로 센터로안옴 */
    .tbl_type,.tbl_type th,.tbl_type td{border:0}
    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
    .tbl_type caption{display:none}
    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    .tbl_type td.ranking{font-weight:bold}
    /* //테이블 공통 UI Object */

    /*memberTable*/
    div#memberTable{width: 100%; display: inline-block;}
    /*memberTable*/
    /*teamTable*/
    div#teamTable{width: 100%; display: inline-block;}
    /*teamTable*/
</style>
<script>
$(function() {
	if(<%=memberLoggedIn == null%>){
		alert("잘못된 경로입니다.");
		location.href="/";
	};
});
</script>
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
				<%if (gameStatus){ %>
					<%=g.getAway() !=null?g.getAway():"&nbsp;" %>	
				<% }else{%>
					<%=a.getAway() %>
				<%}%>
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
		<hr />
		<div>
	    <div id="bu">
	    	<div id="imgDiv">
	        	<img id="logoimg" src=
	        	<%if(tHome.getTeamLogo()!=null){ %>
	        		"<%=request.getContextPath() %>/images/team/<%=tHome.getTeamLogo() %>"
	        	<%}else{ %>
	        	 	"<%=request.getContextPath() %>/images/team/default.png" 
	        	<%} %>
	        	 alt="첨부파일"/>
	        </div>
	        <div id="a">
	            <h2 id="bb">팀이름</h2>
	            <h4><%=tHome.getTeamName() %></h4>
	        </div>
	        <br>
	        <div id="b">
	            <h3 id="bb">팀장</h3>
	            <h4><%=tHome.getCapTain()  %></h4>
	        </div>
	        <br>
	        <div id="c">
	            <h3 id="bb">팀원수</h3>
	            <h4> <%=hMemberList.size() %>명</h4>
	        </div>
	        <br /> <br /><br />
	        <div id="d">
	            <h2 id="aa">활동지역</h2>
	            <h3>
	            	<%if("G1".equals(tHome.getRegionCode()) ) {%>
	        			서울
	        		<%}else if("G2".equals(tHome.getRegionCode()) ) { %>
	        			경기
	        		<%}else if("G3".equals(tHome.getRegionCode()) ) { %>
	        			강원
	        		<%}else if("G4".equals(tHome.getRegionCode()) ) { %>
	        			충북
	        		<%}else if("G5".equals(tHome.getRegionCode()) ) { %>
	        			충남
	        		<%}else if("G6".equals(tHome.getRegionCode()) ) { %>
	        			경북
	        		<%}else if("G7".equals(tHome.getRegionCode()) ) { %>
	        			전북
	        		<%}else if("G8".equals(tHome.getRegionCode()) ) { %>
	        			전남
	        		<%}else if("G9".equals(tHome.getRegionCode()) ) { %>
	        			제주					
		        	<%} %>
	            </h3>
	         </div>
	         <div id="logoDiv">
	        	<img id="logo" src="<%=request.getContextPath() %>/images/headerImage.jpg" alt="첨부파일"/>
	        </div>
	         <div id="d">
	            <h2 id="aa">창단일</h2>
	            <h3><%=tHome.getFoundingDate() %></h3>
	        </div>
	        <br><br>
	        <textarea name="" id="" cols="85" rows="7" readonly style="resize: none"><%=tHome.getIntroduce() %></textarea>
	    </div>
	    <br>
	    <br />
	    <div id="memberTable">
	    <!--ui object -->
	    <table class="tbl_type"  cellspacing="0">
	        <legend>◎팀원정보</legend>
	        <colgroup>
	            <col width="10%"> 
	            <col width="15%">
	            <col width="10%">
	            <col width="10%">
	            <col width="15%">
	        </colgroup>
	        <thead>
	        <tr>
	            <th scope="col">순번</th>
	            <th scope="col">팀원</th>
	            <th scope="col">지역</th>
	            <th scope="col">등급</th>
	            <th scope="col">입단일</th>
	        </tr>
	        </thead>
	        <tbody>
	        <%for(TeamMember tm : hMemberList){ %>
	            <tr>
		            <td class="ranking" scope="row"><%=tm.getRnum() %></td>
		            <td><%=tm.getUserId() %></td>
		            <td>
		            	<%if("G1".equals(tm.getRegionCode()) ) {%>
		        			서울
		        		<%}else if("G2".equals(tm.getRegionCode()) ) { %>
		        			경기
		        		<%}else if("G3".equals(tm.getRegionCode()) ) { %>
		        			강원
		        		<%}else if("G4".equals(tm.getRegionCode()) ) { %>
		        			충북
		        		<%}else if("G5".equals(tm.getRegionCode()) ) { %>
		        			충남
		        		<%}else if("G6".equals(tm.getRegionCode()) ) { %>
		        			경북
		        		<%}else if("G7".equals(tm.getRegionCode()) ) { %>
		        			전북
		        		<%}else if("G8".equals(tm.getRegionCode()) ) { %>
		        			전남
		        		<%}else if("G9".equals(tm.getRegionCode()) ) { %>
		        			제주					
		        		<%} %>
		            </td>
		            <td><%=tm.getGrade() %></td>
		            <td><%=tm.getT_EnrollDate() %></td>
	            </tr>
	        <%} %>
	        </tbody>
	        <tfoot>
	            <tr>
	            <td>종합</td>
	            <td colspan="2">총 팀원수</td>
	            <td colspan="3"><%=hMemberList.size()%>명</td>
	            </tr>
	            </tfoot>
	        </table>
	        <!--//ui object -->
	    </div >
	    <br /><br />
	<div id="teamTable">
	        <!--ui object -->
	        <table class="tbl_type"  cellspacing="0">
	                <legend>◎팀활동내역</legend>
	            <colgroup>
	                <col width="10%"> 
	                <col width="10%">
	                <col width="10%">
	                <col width="25%">
	                <col width="10%">
	            </colgroup>
	            <thead>
	            <tr>
	                <th scope="col">게임번호</th>
	                <th scope="col">HomeTeam</th>
	                <th scope="col">AwayTeam</th>
	                <th scope="col">게임날짜</th>
	                <th scope="col">결과</th>
	            </tr>
	            </thead>
	            <tbody>
	            <%if(hActivityList.size()==0||hActivityList == null){ %>
	            <tr>
	                <td colspan="5">데이터가 없습니다.</td>
	            </tr>
	            <%}else{ %>
	            <%for(Activity act: hActivityList){ %>
	            <tr>
	                <td class="ranking" scope="row"><%=act.getActivity_No() %></td>
	                <td style="color:<%=((act.getHome().equals(tHome))?"red":"black" )%>"><%=a.getHome() %></td>
	                <td style="color:<%=((act.getAway().equals(tHome))?"red":"black" )%>"><%=a.getAway() %></td>
	                <td><%=act.getActivityDate() %></td>
	                <td><%=act.getResult() %></td>
	                </tr>
	            </tr>
	            <%}} %>
	            </tbody>
	            <tfoot>
	                <tr>
	                <td colspan="5">활동내역</td>
	                </tr>
	                </tfoot>
	            </table>
	            <!--//ui object -->
	        </div>
	</div>
  	</div>
  	<div id="tab-3" class="tab-content">
  	<%if(tAway != null){ %>
		<hr />
		<div>
	    <div id="bu">
	    	<div id="imgDiv">
	        	<img id="logoimg" src=
	        	<%if(tAway.getTeamLogo()!=null){ %>
	        		"<%=request.getContextPath() %>/images/team/<%=tAway.getTeamLogo() %>"
	        	<%}else{ %>
	        	 	"<%=request.getContextPath() %>/images/team/default.png" 
	        	<%} %>
	        	 alt="첨부파일"/>
	        </div>
	        <div id="a">
	            <h2 id="bb">팀이름</h2>
	            <h4><%=tAway.getTeamName() %></h4>
	        </div>
	        <br>
	        <div id="b">
	            <h3 id="bb">팀장</h3>
	            <h4><%=tAway.getCapTain()  %></h4>
	        </div>
	        <br>
	        <div id="c">
	            <h3 id="bb">팀원수</h3>
	            <h4> <%=aMemberList.size() %>명</h4>
	        </div>
	        <br /> <br /><br />
	        <div id="d">
	            <h2 id="aa">활동지역</h2>
	            <h3>
	            	<%if("G1".equals(tAway.getRegionCode()) ) {%>
	        			서울
	        		<%}else if("G2".equals(tAway.getRegionCode()) ) { %>
	        			경기
	        		<%}else if("G3".equals(tAway.getRegionCode()) ) { %>
	        			강원
	        		<%}else if("G4".equals(tAway.getRegionCode()) ) { %>
	        			충북
	        		<%}else if("G5".equals(tAway.getRegionCode()) ) { %>
	        			충남
	        		<%}else if("G6".equals(tAway.getRegionCode()) ) { %>
	        			경북
	        		<%}else if("G7".equals(tAway.getRegionCode()) ) { %>
	        			전북
	        		<%}else if("G8".equals(tAway.getRegionCode()) ) { %>
	        			전남
	        		<%}else if("G9".equals(tAway.getRegionCode()) ) { %>
	        			제주					
		        	<%} %>
	            </h3>
	         </div>
	         <div id="logoDiv">
	        	<img id="logo" src="<%=request.getContextPath() %>/images/headerImage.jpg" alt="첨부파일"/>
	        </div>
	         <div id="d">
	            <h2 id="aa">창단일</h2>
	            <h3><%=tAway.getFoundingDate() %></h3>
	        </div>
	        <br><br>
	        <textarea name="" id="" cols="85" rows="7" readonly style="resize: none"><%=tAway.getIntroduce() %></textarea>
	    </div>
	    <br>
	    <br />
	    <div id="memberTable">
	    <!--ui object -->
	    <table class="tbl_type"  cellspacing="0">
	        <legend>◎팀원정보</legend>
	        <colgroup>
	            <col width="10%"> 
	            <col width="15%">
	            <col width="10%">
	            <col width="10%">
	            <col width="15%">
	        </colgroup>
	        <thead>
	        <tr>
	            <th scope="col">순번</th>
	            <th scope="col">팀원</th>
	            <th scope="col">지역</th>
	            <th scope="col">등급</th>
	            <th scope="col">입단일</th>
	        </tr>
	        </thead>
	        <tbody>
	        <%for(TeamMember tm : aMemberList){ %>
	            <tr>
		            <td class="ranking" scope="row"><%=tm.getRnum() %></td>
		            <td><%=tm.getUserId() %></td>
		            <td>
		            	<%if("G1".equals(tm.getRegionCode()) ) {%>
		        			서울
		        		<%}else if("G2".equals(tm.getRegionCode()) ) { %>
		        			경기
		        		<%}else if("G3".equals(tm.getRegionCode()) ) { %>
		        			강원
		        		<%}else if("G4".equals(tm.getRegionCode()) ) { %>
		        			충북
		        		<%}else if("G5".equals(tm.getRegionCode()) ) { %>
		        			충남
		        		<%}else if("G6".equals(tm.getRegionCode()) ) { %>
		        			경북
		        		<%}else if("G7".equals(tm.getRegionCode()) ) { %>
		        			전북
		        		<%}else if("G8".equals(tm.getRegionCode()) ) { %>
		        			전남
		        		<%}else if("G9".equals(tm.getRegionCode()) ) { %>
		        			제주					
		        		<%} %>
		            </td>
		            <td><%=tm.getGrade() %></td>
		            <td><%=tm.getT_EnrollDate() %></td>
	            </tr>
	        <%} %>
	        </tbody>
	        <tfoot>
	            <tr>
	            <td>종합</td>
	            <td colspan="2">총 팀원수</td>
	            <td colspan="3"><%=aMemberList.size()%>명</td>
	            </tr>
	            </tfoot>
	        </table>
	        <!--//ui object -->
	    </div >
	    <br /><br />
	<div id="teamTable">
	        <!--ui object -->
	        <table class="tbl_type"  cellspacing="0">
	                <legend>◎팀활동내역</legend>
	            <colgroup>
	                <col width="10%"> 
	                <col width="10%">
	                <col width="10%">
	                <col width="25%">
	                <col width="10%">
	            </colgroup>
	            <thead>
	            <tr>
	                <th scope="col">게임번호</th>
	                <th scope="col">HomeTeam</th>
	                <th scope="col">AwayTeam</th>
	                <th scope="col">게임날짜</th>
	                <th scope="col">결과</th>
	            </tr>
	            </thead>
	            <tbody>
	            <%if(aActivityList.size()==0||aActivityList == null){ %>
	            <tr>
	                <td colspan="5">데이터가 없습니다.</td>
	            </tr>
	            <%}else{ %>
	            <%for(Activity act: hActivityList){ %>
	            <tr>
	                <td class="ranking" scope="row"><%=act.getActivity_No() %></td>
	                <td style="color:<%=((act.getHome().equals(tHome))?"red":"black" )%>"><%=a.getHome() %></td>
	                <td style="color:<%=((act.getAway().equals(tHome))?"red":"black" )%>"><%=a.getAway() %></td>
	                <td><%=act.getActivityDate() %></td>
	                <td><%=act.getResult() %></td>
	                </tr>
	            </tr>
	            <%}} %>
	            </tbody>
	            <tfoot>
	                <tr>
	                <td colspan="5">활동내역</td>
	                </tr>
	                </tfoot>
	            </table>
	            <!--//ui object -->
	        </div>
	</div>
	<%} else{%>
<br />
<br />
<br />
<br />
<br />
<br />
<div style="text-align: center;">
어웨이팀이 결정되지 않았습니다.
</div>
<br />
<br />
<br />
<br />
<br />
<br />
	<%} %>
  	</div>
  	<br />
<button type="button" class="btn btn-primary btn-block disabled" id="btn_game_register" onclick="fn_game_register();" disabled>경기 신청</button>
<%if(gameStatus && memberLoggedIn != null && tHome.getTeamName().equals(memberLoggedIn.getTeamname()) && "팀장".equals(memberLoggedIn.getGrade())) {%>
<button type="button" class="btn btn-danger btn-block" onclick="fn_delete_game();">삭제</button>
<%} %>
<script>
$(function(){
	if(<%=memberLoggedIn.getTeamname() == null%>){
		$("#btn_game_register").removeClass('disabled').removeAttr("disabled");
	}else if(<%=!tHome.getTeamName().equals(memberLoggedIn.getTeamname()) && tAway == null%>){
		$("#btn_game_register").removeClass('disabled').removeAttr("disabled");	
	}
});
<%if(gameStatus){%>
function fn_game_register() {
	location.href = "<%=request.getContextPath()%>/game/waitTeam?teamName=<%=memberLoggedIn.getTeamname()%>&gameNo=<%=g.getGameNo()%>";
}
<%}%>
<%if(gameStatus && memberLoggedIn != null && tHome.getTeamName().equals(memberLoggedIn.getTeamname()) && "팀장".equals(memberLoggedIn.getGrade())) {%>
function fn_delete_game() {
	location.href = "<%=request.getContextPath()%>/game/deleteGame?no=<%=g.getGameNo()%>";
}
<%}%>
</script>
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
<br /><br />
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	