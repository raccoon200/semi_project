<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.memberTeam.model.vo.*"%>
<%
	List<TeamRegister> list = (List<TeamRegister>)request.getAttribute("list");
	int totalMember = (int)request.getAttribute("totalMember");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
    #teamDiv{background:white; padding:10px 10px 10px 10px;}
    #teamDiv2{text-align:left; padding:0px 10px 0px 0px;}
    
    /* table Object */
    th{text-align:center} /* 부트스트랩으로 센터로안옴 */
   	legend{margin:30px 0 0 0;}
    .tbl_type{margin:auto;}
    .tbl_type,.tbl_type th,.tbl_type td{border:0}
    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
    .tbl_type caption{display:none}
    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    .tbl_type td.ranking{font-weight:bold}
    legend{padding:10px 0px 0px 40px;}
    /* table Object 끝 */
    
    /* 검색옵션 */ 
    #test{height: 100px; width: 500px; position:absolute; margin:0 0 0 30px;}
    #selectCode{height: 31px; width: 80px;}
    #searchName{height: 31px; width: 150px;}
    
    ul#autoComplete{
    background:white;
	min-width:152px;
	border:1px solid gray;
	display:inline-block;
	padding:0;
	margin:0 0 0 82px;
	}
	ul#autoComplete li{
		padding:0 10px;
		list-style:none;
		cursor:pointer;
	}
	ul#autoComplete li.sel{
		background:lightseagreen;
		color:white;
	}
	span.srchval{
		color:red;
	}
    #searchName{height: 31px; width: 150px;}
    /* 검색옵션 끝*/
    
    /* 버튼 */
    .button {
		margin:0 0 0 269px;
    	position:absolute;
      	height:33px;
	  display: inline;
	  vertical-align: top;
	 /*  position: relative; */
	  padding: 0 15px 0 15px;
	  line-height: 35px;
	  font-size: 15px;
	  font-weight: bold;
	  color: white;
	  text-align: center;
	  text-shadow: 0 -1px rgba(0, 0, 0, 0.5);
	  background: #576dce;
	  background-clip: padding-box;
	  border: 1px solid;
	  border-color: #374fbb #344cb3 #2b3e94;
	  border-radius: 2px;
	  background-image: -webkit-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 2px rgba(0, 0, 0, 0.2);
	}
	.button:hover, .button.hover {
	  background-color: #5f74d0;
	  border-color: #2d429c #2d429c #253680;
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 5px #576dce;
	}
	.button:active, .button.active {
	  border-color: #253680 #2b3e94 #3147a8;
	  background: #475fc9;
	  box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.8);
	}
	.button:after {
	  content: '>';
	  float: right;
	  /* position: relative; */
	  margin-left: 15px;
	  font: bold 18px/33px 'Comic Sans MS';
	  /* I tried everything but couldn't get the vertical alignment to be
	     consistent in IE, so this is a hack targeting IE8-9-10. */
	  line-height: 31px\0;
	  color: white;
	  text-shadow: 0 -1px #8696dc, 0 1px 1px rgba(0, 0, 0, 0.3);
	  -webkit-font-smoothing: subpixel-antialiased;
	}
	/*버튼끝*/
	
	/*페이지*/
	.pagination {
	    width: 645px;
	    margin: 0 0 0 36px;
	    text-align:center;
	} 
	.btn {
	    display: inline-block;
	    padding: 10px;
	    border-radius: 5px; /*optional*/
	    color: #aaa;
	    font-size: .875em;
	}
	.pagination {
	    background: #f2f2f2;
	    padding: 20px;
	    margin-bottom: 20px;
	}
	.page {
	    display: inline-block;
	    padding: 0px 9px;
	    margin-right: 4px;
	    border-radius: 3px;
	    border: solid 1px #c0c0c0;
	    background: #e9e9e9;
	    box-shadow: inset 0px 1px 0px rgba(255,255,255, .8), 0px 1px 3px rgba(0,0,0, .1);
	    font-size: .875em;
	    font-weight: bold;
	    text-decoration: none;
	    color: #717171;
	    text-shadow: 0px 1px 0px rgba(255,255,255, 1);
	}
	.page:hover, .page.gradient:hover {
	    background: #fefefe;
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FEFEFE), to(#f0f0f0));
	    background: -moz-linear-gradient(0% 0% 270deg,#FEFEFE, #f0f0f0);
	}
	.page.active {
	    border: none;
	    background: #616161;
	    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .8);
	    color: #f0f0f0;
	    text-shadow: 0px 0px 3px rgba(0,0,0, .5);
	}
	.page.gradient {
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#f8f8f8), to(#e9e9e9));
	    background: -moz-linear-gradient(0% 0% 270deg,#f8f8f8, #e9e9e9);
	}
	.pagination.dark {
	    background: #414449;
	    color: #feffff;
	}
	.page.dark {
	    border: solid 1px #32373b;
	    background: #3e4347;
	    box-shadow: inset 0px 1px 1px rgba(255,255,255, .1), 0px 1px 3px rgba(0,0,0, .1);
	    color: #feffff;
	    text-shadow: 0px 1px 0px rgba(0,0,0, .5);
	}
	.page.dark:hover, .page.dark.gradient:hover {
	    background: #3d4f5d;
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#547085), to(#3d4f5d));
	    background: -moz-linear-gradient(0% 0% 270deg,#547085, #3d4f5d);
	}
	.page.dark.active {
	    border: none;
	    background: #2f3237;
	    box-shadow: inset 0px 0px 8px rgba(0,0,0, .5), 0px 1px 0px rgba(255,255,255, .1);
	}
	.page.dark.gradient {
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#565b5f), to(#3e4347));
	    background: -moz-linear-gradient(0% 0% 270deg,#565b5f, #3e4347);
	}
	/*페이지끝*/
	
	table.tbl_type tr:hover{
		background:lightgray;
	}
	table.tbl_type tfoot tr:hover:last-of-type{
		background:none;
	}
    </style>
    <div id="teamDiv">
    	<div id="teamDiv2">
    	<h2>팀 신청 관리</h2>
    	<hr />
		</div>
    <!--ui object -->
    <table class="tbl_type"  cellspacing="0" >
        <legend>◎팀신청리스트</legend>
    <colgroup>
        <col width="10%"> 
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
        <th scope="col">신청 팀명</th>
        <th scope="col">신청자</th>
        <th scope="col">지역</th>
        <th scope="col">신청일</th>
        <th scope="col">수락여부</th>
        <th scope="col">관리</th>
    </tr>
    </thead>
    <tbody>
    <%if(list == null || list.isEmpty()){ %>
		<tr>
			<td colspan="8" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
	<%} else { %>
		<%for(TeamRegister tr : list){ %>
		<tr>
			<td class="ranking" scope="row"><%=tr.getRnum() %></td>
			<td><%=tr.getTeamName() %></td>
        	<td><%=tr.getT_register_writer() %></td>
	        <td>
	        <%if("G1".equals(tr.getRegionCode()) ) {%>
       			서울
       		<%}else if("G2".equals(tr.getRegionCode()) ) { %>
       			경기
       		<%}else if("G3".equals(tr.getRegionCode()) ) { %>
       			강원
       		<%}else if("G4".equals(tr.getRegionCode()) ) { %>
       			충북
       		<%}else if("G5".equals(tr.getRegionCode()) ) { %>
       			충남
       		<%}else if("G6".equals(tr.getRegionCode()) ) { %>
       			경북
       		<%}else if("G7".equals(tr.getRegionCode()) ) { %>
       			전북
       		<%}else if("G8".equals(tr.getRegionCode()) ) { %>
       			전남
       		<%}else if("G9".equals(tr.getRegionCode()) ) { %>
       			제주					
       		<%} %>
	        </td>
        	<td><%=tr.getRegister_date() %></td>
	        <td>
	        	<%if(tr.getStatus()==null){%>
	        		신청대기중
	        	<%}else if("N".equals(tr.getStatus())){ %>
	        		수락거부
	        	<%}else if("Y".equals(tr.getStatus())){ %>
	        		팀생성완료
	        	<%} %>
	        </td>
			<td><button  onclick="fn_teamAcceptView('<%=tr.getTeam_register_no()%>');">상세보기</button></td>
		</tr>
	<% 		} 
 	 	}%>
    </tbody>
    
    <script>
	<!-- 상세보기버튼 -->
	function fn_teamAcceptView(acceptNo){
		/* console.log(userId); */
		location.href="<%=request.getContextPath()%>/admin/adminAcceptView?acceptNo="+acceptNo;
	};
	<!-- 상세보기버튼끝 -->
    </script>
    
    <tfoot>
        <tr>
        <td colspan="1">총</td>
        <td colspan="3">팀신청리스트</td>
        <td colspan="3"><%=totalMember %>개 팀</td>
        </tr>
        </tfoot>
    </table>
    <!--//ui object -->
    <!-- <div id="container"> -->
    <div class="pagination" >
    	<%=request.getAttribute("pageBar") %>
	</div>
	<!-- </div> -->
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>