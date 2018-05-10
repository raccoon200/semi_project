<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.search.model.vo.*"%>
<%
	List<Team> list = (List<Team>)request.getAttribute("list");
	Hashtable<String,Integer> ht = (Hashtable<String,Integer>)request.getAttribute("ht");
	int totalOneTeam = (Integer)request.getAttribute("totalOneTeam");
	String code="";
	for(Team t2 : list){
		code = t2.getRegionCode();
	}
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
    select{height: 30px; width: 100px;}
    
    #test{height: 100px; width: 500px; position:absolute; margin:0 0 0 30px;}
    
    ul#autoComplete{
    background:white;
	min-width:152px;
	border:1px solid gray;
	display:inline-block;
	padding:0;
	margin:0 0 0 105px;
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
    #searchName{height: 25px; width: 150px;}
    /* 검색옵션 끝*/
    
    /* 버튼 */
    .button {
    margin:0 0 0 295px;
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
    </style>
    <div id="teamDiv">
    <div id="teamDiv2">
    <h2>팀 검색</h2>
    <hr />
    	<div id="test">
		    <select id="selectCode">
		        <option value="G1">서울</option>
		        <option value="G2">경기</option>
		        <option value="G3">강원</option>
		        <option value="G4">충북</option>
		        <option value="G5">충남</option>
		        <option value="G6">경북</option>
		        <option value="G7">전북</option>
		        <option value="G8">전남</option>
		        <option value="G9">제주</option>
		    </select>
	    
		    <input type="text" id="searchName" />
		    <br/>
			<ul id="autoComplete"></ul>
			</div>
			<button class="button" id="teamOneSearch">팀검색</button>
		</div>
		<br />
	<script>
	<!-- 서치텍스트스 이벤트 -->
	$(function(){
		<%-- $("#searchName").focus(function(){
			location.href="<%=request.getContextPath()%>/search/teamAutoSearch";
		}); --%>
		$("#autoComplete").hide();
		$("#searchName").keyup(function(e){
			//console.log(e.key+", "+$(this).val());
			//방향키(ArrowUp, ArrowDown), 엔터(Enter)일 경우, 선택효과 및 선택처리함
			//그 외의 키일 경우 ajax요청처리
			var sel = $(".sel");
			var li = $("#autoComplete li");
			
			if(e.key == 'ArrowDown'){
				//아무것도 선택되지 않은 경우
				if(sel.length == 0){
					$("#autoComplete li:first").addClass("sel");
				}
				//선택된 sel이 마지막 li태그인 경우
				else if(sel.is(li.last())){
					//처리코드 없음, 못내려오게할려면 sel을없앤다
					sel.removeClass("sel");            
				}else{
					sel.removeClass("sel").next().addClass("sel");
				}
				
			}else if(e.key=='ArrowUp'){
				//아무것도 선택되지 않은 경우
				if(sel.length == 0){
					$("#autoComplete li:last").addClass("sel");
				}
				//선택된 sel이 마지막 li태그인 경우
				else if(sel.is(li.first())){
					sel.removeClass("sel");
				}else{
					sel.removeClass("sel").prev().addClass("sel");
				}
			}else if(e.key=="Enter"){
				$(this).val(sel.text());
				//검색어목록은 감추고, li태그는 삭제
				$("#autoComplete").hide().children().remove();
			}else{
				var searchName = $(this).val();
				var selectCode = $("#selectCode").val();
				$.ajax({
					<%-- url:"<%=request.getContextPath()%>/jq/autoComplete.do?searchName="+searchName, get방식일때--%>
					url:"<%=request.getContextPath()%>/search/teamAutoSearch",
					type:"post",
					data:"searchName="+searchName+"&selectCode="+selectCode,/* +"&age=" 두개이상일떄*/
					success:function(data){
						//console.log(data);
						//아무값도 넘어오지 않는 경우, data.split(",")의 길이가 1임.
						if(data.trim().length==0){
							$("#autoComplete").hide();					
						}else {
							var dataArr = data.split(",");
							var html = "";
							for(var i=0; i<dataArr.length; i++){
								html += "<li>"+dataArr[i]
								.replace(searchName,"<span class='srchval'>"+searchName+"</span>")+"</li> ";
							}
							$("#autoComplete").html(html).show();
						}
					},
					error:function(jqxhr, textStatus,errorThrown){
						console.log("ajax처리실패!");
					}
				});
			}
		});
	
		//부모요소에 이벤트 핸들러를 설정하고, 자식요소를 이벤트소스로 사용
		//click : enter와 동일한 효과
		$("#autoComplete").on("click","li",function(){
			$("#searchName").val($(this).text());
			$("#autoComplete").hide().children().remove();
		});
		//hover      호버는 on이 안먹힘
		//mouseover,mouseout도 가능하다.
		$("#autoComplete").on("mouseenter","li",function(){
			$(this).siblings().removeClass("sel");
			$(this).addClass("sel");
		});
		$("#autoComplete").on("mouseleave","li",function(){
			$(this).removeClass("sel");
		});
		
	});
	<!-- 서치텍스트스 이벤트 끝-->
	
	<!-- 검색 이벤트 -->
	$(function(){
		$("#teamOneSearch").click(function(){
			var searchName = $("#searchName").val();
			var selectCode = $("#selectCode").val();
			
			location.href="<%=request.getContextPath()%>/search/teamOneSearch?searchName="+searchName+"&selectCode="+selectCode;
		});
	});
	<!-- 검색 이벤트 끝-->
	
	</script>
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
				<td><a href="<%=request.getContextPath() %>/search/searchView?teamName=<%=t.getTeamName() %>"><%=t.getTeamName() %></a></td>
	        	<td id="code">
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
        <td>
	        <%if("G1".equals(code) ) {%>
				서울
			<%}else if("G2".equals(code) ) { %>
				경기
			<%}else if("G3".equals(code) ) { %>
				강원
			<%}else if("G4".equals(code) ) { %>
				충북
			<%}else if("G5".equals(code) ) { %>
				충남
			<%}else if("G6".equals(code) ) { %>
				경북
			<%}else if("G7".equals(code) ) { %>
				전북
			<%}else if("G8".equals(code) ) { %>
				전남
			<%}else if("G9".equals(code) ) { %>
				제주					
			<%} %>
        </td>
        <td colspan="3"><%=totalOneTeam %>개팀</td>
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