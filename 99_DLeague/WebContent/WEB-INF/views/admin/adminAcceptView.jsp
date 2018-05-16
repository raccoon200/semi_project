<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.dleague.memberTeam.model.vo.*"%>
<%
   List<TeamRegister> list = (List<TeamRegister>)request.getAttribute("list");
   
   //team정보
   String teamName="";
   String capTain="";
   String rCode="";
   String introduce="";
   String tr_msg;
   Date foundInDate=null;
   String rogo="";
   int t_reg_no=0;
   
   for(TeamRegister tr : list){
	   teamName = tr.getTeamName();
	   capTain=tr.getT_register_writer();
	   rCode = tr.getRegionCode();
	   introduce=tr.getIntroduce();
	   tr_msg=tr.getRegister_msg();
	   foundInDate=tr.getRegister_date();
	   rogo=tr.getTeamLogo();
	   t_reg_no=tr.getTeam_register_no();
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
   div#imgDiv{width: 410px;height: 315px;display: inline-block;float: left;text-align:center; border:3px solid skyblue; border-radius: 10px}
   /* div#bu,#a,#b,#c,#d{border: 1px solid black;} */
   div#bu{height: 590px; width: 700px; display: inline-block;}
   div#a{border-radius: 10px;background:lightgreen;height: 100px; width: 200px; text-align: center; display: inline-block; margin:10px 0 0 0;}
   div#b{border-radius: 10px;background:lightgreen;height: 80px; width: 200px; text-align: center; display: inline-block; margin:10px 0 0 0;}
   div#c{border-radius: 10px;background:lightgreen;height: 80px; width: 200px;  text-align: center; display: inline-block; margin:10px 0 0 0;}
   div#d{height: 80px; width: 200px; text-align: center; display: inline-block;}
   div#all{padding:10px}
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
	
	div#btDiv{padding:10px; display: inline-block;}
	.bt{padding:10px;}
</style>
   <h2>팀 신청 상세정보</h2>
   <hr />
   <div style="text-align: center" id="all">
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
            <h3 id="bb">신청자</h3>
            <h4><%=capTain %></h4>
        </div>
        <br>
        <div id="c">
            <h3 id="bb">팀원수</h3>
            <h4> 1 명</h4>
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
            <h2 id="aa">신청일</h2>
            <h3><%=foundInDate %></h3>
        </div>
        <br><br>
        <h3>팀소개글</h3>
        <textarea name="" id="" cols="85" rows="7" readonly style="resize: none"><%=introduce %></textarea>
        <br />
        <h3>팀신청 사유</h3>
        <textarea name="" id="" cols="85" rows="7" readonly style="resize: none"><%=introduce %></textarea>
    </div>
    <br>
    <div id="btDiv"><button class="bt" onclick="fn_success('Y')">팀수락</button></div> <div id="btDiv"><button class="bt" onclick="fn_success('N')">팀거절</button></div>
</div>
<script>
function fn_success(YorN){
	/* console.log(YorN); */
	var t_reg_no = <%=t_reg_no%>;
	if(YorN=='Y'){
		var Y = fn_confirmY();
		/* console.log(Y); */
		if(Y){
			location.href="<%=request.getContextPath()%>/admin/adminAcceptViewEnd?YorN="+YorN+"&t_reg_no="+t_reg_no;
		}else{}
	}else if(YorN=='N'){
		var N = fn_confirmN();
		if(N){
			location.href="<%=request.getContextPath()%>/admin/adminAcceptViewEnd?YorN="+YorN+"&t_reg_no="+t_reg_no;
		}else{}
	}
}
function fn_confirmY(){
	return confirm("팀을 수락하시겠습니까?");
}
function fn_confirmN(){
	return confirm("팀을 거절하시겠습니까?")
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>