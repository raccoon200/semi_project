<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.search.model.vo.*,com.dleague.member.model.vo.*"%>
<%
   List<Team> list = (List<Team>)request.getAttribute("list");
   List<TeamMember> memberList = (List<TeamMember>)request.getAttribute("memberList");
   List<Activity> activityList = (List<Activity>)request.getAttribute("activityList");
   /* Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn"); */
   
   //team정보
   String teamName="";
   String capTain="";
   String rCode="";
   String introduce="";
   Date foundInDate=null;
   int rnum=0;
   String rogo="";
   //팀정보
   for(Team t : list){
      teamName = t.getTeamName();
      capTain = t.getCapTain();
      rCode = t.getRegionCode();
      foundInDate = t.getFoundingDate();
      introduce=t.getIntroduce();
      rogo=t.getTeamLogo();
   }
   //팀원수
   for(TeamMember tm2 : memberList){
      rnum = tm2.getRnum();
   }
   //활동내역 경기 유/무확인
   int num=0;
   for(Activity a2: activityList){
      num = a2.getActivity_No();   
   }
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
   img#logoimg{width: 250px;height: 200px;display: inline-block;margin: 50px 0 0 0;}
   img#logo{width: 200px;height: 80px;display: inline-block;}
   div#logoDiv{width: 200px;height: 80px;display: inline-block;}
   div#imgDiv{width: 410px;height: 315px;display: inline-block;float: left;text-align:center;border:3px solid skyblue; border-radius: 10px}
   /* div#bu,#a,#b,#c,#d{border: 1px solid black;} */
   div#bu{height: 590px; width: 700px; display: inline-block;}
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
    div#memberTable{width: 350px; display: inline-block;}
    /*memberTable*/
    /*teamTable*/
    div#teamTable{width: 350px; display: inline-block;}
    /*teamTable*/
    /*수정삭제버튼*/
    div#btDiv{padding:30px; display: inline-block;}
    button#bt1, #bt2{padding:5px;}
    /*수정삭제버튼*/
    .btnM {
	  display: inline-block;
	  background: transparent;
	  text-transform: uppercase;
	  font-weight: 500;
	  font-style: normal;
	  font-size: 1rem;
	  letter-spacing: 0.3em;
	  color:rgba(223,190,106,0.8);
	  border-radius: 0;
	  padding: 18px 80px 20px;
	  transition: all 0.7s ease-out;
	  background: linear-gradient(270deg, rgba(223,190,106,0.8), rgba(146,111,52,0.8), rgba(34,34,34,0), rgba(34,34,34,0));
	  background-position: 1% 50%;
	  background-size: 300% 300%;
	  text-decoration: none;
	  margin: 0.625rem;
	  border: none;
	  border: 1px solid rgba(223,190,106,0.8);
	}
	
	.btnM:hover {
	  cursor:pointer;
	  color: #fff;
	  border: 1px solid rgba(223,190,106,0);
	  color: $white;
	  background-position: 99% 50%;
	}  
</style>
   <h2>팀상세정보</h2>
   <hr />
   <div style="text-align: center">
    <div id="bu">
       <div id="imgDiv">
           <img id="logoimg" src=
           <%if(rogo!=null){ %>
              "<%=request.getContextPath() %>/images/team/<%=rogo %>"
           <%}else{ %>
               "<%=request.getContextPath() %>/images/team/default.png" 
           <%} %>
            alt="첨부파일"/>
        </div>
        <div id="a">
            <h2 id="bb">팀이름</h2>
            <h4><%=teamName %></h4>
        </div>
        <br>
        <div id="b">
            <h3 id="bb">팀장</h3>
            <h4><%=capTain %></h4>
        </div>
        <br>
        <div id="c">
            <h3 id="bb">팀원수</h3>
            <h4> <%=rnum %>명</h4>
        </div>
        <br /> <br /><br />
        <div id="d">
            <h2 id="aa">활동지역</h2>
            <h3>
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
            </h3>
         </div>
         <div id="logoDiv">
           <img id="logo" src="<%=request.getContextPath() %>/images/headerImage.jpg" alt="첨부파일"/>
        </div>
         <div id="d">
            <h2 id="aa">창단일</h2>
            <h3><%=foundInDate %></h3>
        </div>
        <br><br>
        <h3> < 팀소개글 > </h3>
        <textarea name="" id="" cols="85" rows="7" readonly style="resize: none"><%=introduce %></textarea>
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
            <col width="10%">
        </colgroup>
        <thead>
        <tr>
            <th scope="col">순번</th>
            <th scope="col">팀원</th>
            <th scope="col">지역</th>
            <th scope="col">등급</th>
            <th scope="col">입단일</th>
            <th scope="col">강퇴</th>
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
               <td><input type="checkbox" class="kick" id="kick<%=tm.getRnum() %>" value="<%=tm.getUserId() %>" <%="팀장".equals(tm.getGrade())?"disabled":"" %> /></td>
            </tr>
        <%} %>
        </tbody>
        <tfoot>
            <tr>
            <td>종합</td>
            <td colspan="2">총 팀원수</td>
            <td colspan="2"><%=rnum %>명</td>
            <td><button onclick="fn_userKick('<%=teamName%>');">강퇴</button></td>
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
            <%if(num==0){ %>
            <tr>
                <td colspan="5">데이터가 없습니다.</td>
            </tr>
            <%}else{ %>
            <%for(Activity a: activityList){ %>
            <tr>
                <td class="ranking" scope="row"><%=a.getActivity_No() %></td>
                <td style="color:<%=((a.getHome().equals(teamName))?"red":"black" )%>"><%=a.getHome() %></td>
                <td style="color:<%=((a.getAway().equals(teamName))?"red":"black" )%>"><%=a.getAway() %></td>
                <td><%=a.getActivityDate() %></td>
                <td><%=a.getResult() %></td>
                </tr>
            </tr>
            <%} 
            } %>
            </tbody>
            <tfoot>
                <tr>
                <td colspan="5">활동내역</td>
                </tr>
                </tfoot>
            </table>
            <!--//ui object -->
        
            
        </div>
        <%if(memberLoggedIn!=null&&null==memberLoggedIn.getTeamname()&&!memberLoggedIn.getUserId().equals("admin")) {%>
        	<input type="button" value="팀 가입 신청" style="position:relative; " class="btnM" onclick="fn_memberTeamIn();"/>
        <%} %>
        <%if(memberLoggedIn!=null&&("admin".equals(memberLoggedIn.getUserId())||capTain.equals(memberLoggedIn.getUserId())) )  {%>
        <div id="btDiv">
              <button id="bt1" onclick="fn_teamUpdate('<%=teamName%>');">팀정보수정</button>
        </div>
        <%}else{ %>
        <div id="btDiv"></div>
        <%} %>
</div>
<script>
var userId = "<%=memberLoggedIn.getUserId()%>"
   function fn_teamUpdate(teamName){
      location.href="<%=request.getContextPath()%>/search/teamUpdate?teamName="+teamName;
      <%-- ,'<%=rCode%>','<%=capTain%>','<%=foundInDate%>','<%=introduce%>','<%=rogo%>'
            +"&rCode"+rCode+"&capTain"+capTain+"&foundInDate"+foundInDate+"&introduce"+introduce+"&logo"+logo; --%>
   };
   function fn_userKick(teamName){
      <%if(memberLoggedIn!=null&&("admin".equals(memberLoggedIn.getUserId())||capTain.equals(memberLoggedIn.getUserId())) ) {%>
      <%for(TeamMember tm3 : memberList){%>
         var checkbox=checkbox+","+ $("#kick<%=tm3.getRnum() %>:checked").val();
      <%}%>
          location.href="<%=request.getContextPath()%>/search/userKick?checkbox="+checkbox+"&teamName="+teamName;
       <%}else {%>
          fn_loginAlert()
       <%}%>
   };
   function fn_loginAlert(){
      alert("팀장만 가능한 기능입니다.");
   };
   function fn_memberTeamIn() {
	   var msg = window.prompt("신청 메시지를 뭐라고 보내시겠습니까??");
	   console.log(prompt);
	   if(msg=="") {
		   alert("메시지를 입력하세요!");
	   }
	   else if(msg==null) {} 
	   else{
	 	var userId = "<%=memberLoggedIn.getUserId()%>";
		   location.href = "<%=request.getContextPath()%>/member/memberTeamIn?teamName=<%=teamName%>&userId="+userId+"&msg="+msg;
	   }
   }
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>