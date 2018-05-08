<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.search.model.vo.*"%>
<%
	List<Team> list = (List<Team>)request.getAttribute("list");
	Hashtable<String,Integer> ht = (Hashtable<String,Integer>)request.getAttribute("ht");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
    <style>
    #teamDiv{background:white; padding:10px 10px 10px 10px;}
    #teamDiv2{text-align:right; padding:0px 40px 0px 0px;}
    
    /* table Object */
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
    select{height: 30px; width: 100px;}
    #search{height: 25px; width: 150px;}
    /* 검색옵션 끝*/
    
    /* 버튼 */
    .button {
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
	/* .button:before {
	  content: '';
	  position: absolute;
	  top: 9px;
	  right: 12px;
	  width: 17px;
	  height: 17px;
	  background: #374fbb;
	  border-radius: 9px;
	  -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.4), 0 1px rgba(255, 255, 255, 0.2);
	  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.4), 0 1px rgba(255, 255, 255, 0.2);
	} */
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
	    width: 625px;
	    margin: 0 auto;
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
    </style>
    <div id="teamDiv">
    <div id="teamDiv2">
    <select>
        <option value="서울">서울</option>
        <option value="경기">경기</option>
        <option value="충북">충북</option>
        <option value="충남">충남</option>
        <option value="경북">경북</option>
        <option value="전북">전북</option>
        <option value="전남">전남</option>
        <option value="제주">제주</option>
    </select>
	<input type="text" id="search" />
	<button class="button">팀검색</button>
	</div>
    <!--ui object -->
    <table class="tbl_type"  cellspacing="0">
        <legend>◎팀리스트</legend>
    <colgroup>
        <col width="10%"> 
        <col width="25%">
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
        <th scope="col">팀장</th>
        <th scope="col">창단일</th>
        <th scope="col">소속선수</th>
    </tr>
    </thead>
    <tbody>
    <%if(list == null || list.isEmpty()){ %>
		<tr>
			<td colspan="5" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ 
			for(Team t : list){%>
			<tr>
				<td class="ranking" scope="row"><%=t.getRnum() %></td>
				<td><%=t.getTeamName() %></td>
	        	<td>
	        		<%if("G1".equals(t.getRegionCode()) ) {%>
	        			서울
	        		<%}else if("G2".equals(t.getRegionCode()) ) { %>
	        			경기
	        		<%}else if("G3".equals(t.getRegionCode()) ) { %>
	        			강원
	        		<%}else if("G4".equals(t.getRegionCode()) ) { %>
	        			충북
	        		<%}else if("G5".equals(t.getRegionCode()) ) { %>
	        			충남
	        		<%}else if("G6".equals(t.getRegionCode()) ) { %>
	        			경북
	        		<%}else if("G7".equals(t.getRegionCode()) ) { %>
	        			전북
	        		<%}else if("G8".equals(t.getRegionCode()) ) { %>
	        			전남
	        		<%}else if("G9".equals(t.getRegionCode()) ) { %>
	        			제주					
	        		<%} %>
	        	</td>
		        <td><%=t.getCapTain() %></td>
		        <td><%=t.getFoundingDate() %></td>
	        	<td><%=ht.get(t.getTeamName()) %></td>
			</tr>
		<%}
		} %>
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
    <!-- <div id="container"> -->
    <div class="pagination" >
    	<%=request.getAttribute("pageBar") %>
        <!-- <a href="#" class="page gradient">first</a>
        <a href="#" class="page gradient">2</a>
        <a href="#" class="page gradient">3</a>
        <span class="page active">4</span>
        <a href="#" class="page gradient">5</a>
        <a href="#" class="page gradient">6</a>
        <a href="#" class="page gradient">last</a> -->
	</div>
	<!-- </div> -->
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>