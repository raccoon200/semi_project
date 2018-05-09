<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.search.model.vo.*"%>
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
	String rogo="";
	for(Team t : list){
		teamName = t.getTeamName();
		capTain = t.getCapTain();
		rCode = t.getRegionCode();
		foundInDate = t.getFoundingDate();
		introduce=t.getIntroduce();
		rogo=t.getTeamLogo();
	}
	for(TeamMember tm2 : memberList){
		rnum = tm2.getRnum();
	}
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<style>
	img#logoimg{width: 250px;height: 200px;display: inline-block;margin: 50px 0 0 0;}
	img#logo{width: 200px;height: 80px;display: inline-block;}
	div#logoDiv{width: 200px;height: 80px;display: inline-block; }
	div#imgDiv{width: 410px;height: 315px;display: inline-block;float: left;text-align:center;}
	/* div#bu,#a,#b,#c,#d{border: 1px solid black;} */
	div#bu{height: 590px; width: 700px; display: inline-block;}
	div#a{border-radius: 10px;background:lightgreen;height: 100px; width: 200px; line-height: 20px; text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#b{border-radius: 10px;background:lightgreen;height: 80px; width: 200px;line-height: 10px; text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#c{border-radius: 10px;background:lightgreen;height: 80px; width: 200px; line-height: 10px; text-align: center; display: inline-block; margin:10px 0 0 0;}
	div#d{height: 80px; width: 200px;line-height: 10px; text-align: center; display: inline-block;}
	
	h1#aa{color:#2828CD;}
	h1#bb{color:#DB631F;}
	
    /* 테이블 공통 UI Object */
    .tbl_type,.tbl_type th,.tbl_type td{border:0}
    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
    .tbl_type caption{display:none}
    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    .tbl_type td.ranking{font-weight:bold}
    /* //테이블 공통 UI Object */

    /*memberTable*/
    div#memberTable{width: 350px; display: inline-block;}
    /*memberTable*/
    /*teamTable*/
    div#teamTable{width: 350px; display: inline-block;}
    /*teamTable*/
</style>
    <div id="bu">
    	<div id="imgDiv">
        	<img id="logoimg" src="<%=request.getContextPath() %>/images/team/default.jpg" alt="첨부파일" style="display:<%=rogo==null?"inline":"none" %>;"/>
        </div>
        <div id="a">
            <h1 id="bb">팀이름</h1>
            <h2><%=teamName %></h2>
        </div>
        <br>
        <div id="b">
            <h1 id="bb">팀장</h1>
            <h2><%=capTain %></h2>
        </div>
        <br>
        <div id="c">
            <h1 id="bb">팀원수</h1>
            <h2> <%=rnum %>명</h2>
        </div>
        <br /> <br /><br />
        <div id="d">
            <h1 id="aa">활동지역</h1>
            <h2>
            	<%if("G1".equals(rCode) ) {%>
        			서울
        		<%}else if("G2".equals(rCode) ) { %>
        			경기
        		<%}else if("G3".equals(rCode) ) { %>
        			강원
        		<%}else if("G4".equals(rCode) ) { %>
        			충북
        		<%}else if("G5".equals(rCode) ) { %>
        			충남
        		<%}else if("G6".equals(rCode) ) { %>
        			경북
        		<%}else if("G7".equals(rCode) ) { %>
        			전북
        		<%}else if("G8".equals(rCode) ) { %>
        			전남
        		<%}else if("G9".equals(rCode) ) { %>
        			제주					
	        	<%} %>
            </h2>
         </div>
         <div id="d">
            <h1 id="aa">창단일</h1>
            <h2><%=foundInDate %></h2>
        </div>
        <div id="logoDiv">
        	<img id="logo" src="<%=request.getContextPath() %>/images/headerImage.jpg" alt="첨부파일"/>
        </div>
        <br><br>
        <textarea name="" id="" cols="93" rows="7" readonly style="resize: none"><%=introduce %></textarea>
    </div>
    <br>
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
        <%for(TeamMember tm : memberList){ %>
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
            <td colspan="3"><%=rnum %>명</td>
            </tr>
            </tfoot>
        </table>
        <!--//ui object -->
    </div >
<div id="teamTable">
        <!--ui object -->
        <table class="tbl_type"  cellspacing="0">
                <legend>◎팀활동내역</legend>
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
                <th scope="col">순번</th>
                <th scope="col">팀명</th>
                <th scope="col">지역</th>
                <th scope="col">소속선수</th>
                <th scope="col">창단일</th>
                <th scope="col">경기수</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                <td class="ranking" scope="row">1</td>
                <td>콜로라도</td>
                <td>서울</td>
                <td>90</td>
                <td>1991-05-01</td>
                <td>120</td>
                </tr>
                <tr>
                <td class="ranking" scope="row">2</td>
                <td>샌디에이고</td>
                <td>부산</td>
                <td>24</td>
                <td>2007-05-01</td>
                <td>100</td>
                </tr>
                <tr>
                <td class="ranking" scope="row">3</td>
                <td>뉴욕m</td>
                <td>경기도</td>
                <td>23</td>
                <td>2015-05-01</td>
                <td>23</td>
                </tr>
                <tr>
                <td class="ranking" scope="row">4</td>
                <td>애틀랜타</td>
                <td>강원도</td>
                <td>5</td>
                <td>2008-05-01</td>
                <td>1</td>
                </tr>
                <tr>
                <td class="ranking" scope="row">5</td>
                <td>밀워키</td>
                <td>전라남도</td>
                <td>83</td>
                <td>2002-02-02</td>
                <td>10</td>
                </tr>
                <tr>
                <td class="ranking" scope="row">6</td>
                <td>lad</td>
                <td>경상북도</td>
                <td>30</td>
                <td>2001-05-01</td>
                <td>30</td>
            </tr>
            </tbody>
            <tfoot>
                <tr>
                <td>종합</td>
                <td>총 팀수</td>
                <td>서울</td>
                <td colspan="3">6개팀</td>
                </tr>
                </tfoot>
            </table>
            <!--//ui object -->
        </div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>