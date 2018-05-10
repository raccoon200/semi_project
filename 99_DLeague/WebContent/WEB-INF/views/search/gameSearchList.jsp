<%@page import="com.dleague.game.model.vo.Game"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%
	List<Game> list = (List<Game>)request.getAttribute("list");
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
table {text-align: center;}
div.center{margin-top: 30px;}
span.sp{font-size:20px;font-weight: bold;}
div#allDiv{text-align:center;}
div#allDiv2{text-align:left; padding: 5px 20px 0 10px;}
table td#td1{text-aling:center; padding:50px 0 0 20px;}
table td#td2{text-aling:center;padding:50px 10px 0 0;}
div#result{margin: 50px 10px 0 0;}

/*페이지*/
	.pagination {
	    width: 100%;
	    margin: 0 0 0 0 aout;
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
<div id="allDiv">
<div id="allDiv2">
<h2>경기검색</h2>
<hr />
<table class="table table-hover">
	<pre>  <span class="sp" id="sp1">경기날짜</span>                        <span class="sp" id="sp2">경기팀</span>                       <span class="sp" id="sp3">게임시간<span/> <span class="sp" id="sp4">상제정보</span></pre>
	<%if(list != null || list.isEmpty()){ %>
	<%for(Game g : list){ %>
	<tr>
		<td id="td1" class="td1"><h4><%=g.getGameDate() %></h4></td>
		<td>
			<table style="display: inline-block;">
				<tr>
					<td>
						<img src="<%=request.getContextPath() %>/images/team/<%=g.getHomeLogo()!=null?g.getHomeLogo():"default.png" %>" alt="home" style="height: 100px; width:130px;"/>
					</td>
				</tr>
				<tr>
					<td><%=g.getHome() %></td>
				</tr>
			</table>
			<h2 style="display: inline-block;">VS</h2>
			<table style="display: inline-block;">
				<tr>
					<td>
						<img src='<%=request.getContextPath() %>/images/team/<%=g.getAway()!=null? (g.getAwayLogo()!=null?g.getAwayLogo():"default.png"):"awayNull.png" %>' alt="away" style="height: 100px; width:130px;"/>
					</td>
				</tr>
				<tr>
					<td><%=g.getAway()!=null?g.getAway():"초청중" %></td>
				</tr>
			</table>			
		</td>
		<td id="td2" class="td1"><h3 ><%=g.getStartTime() %></h3></td>
		<td>
			<%if(g.getStatus()==null){ %>
			<div class="alert alert-info center" id="result">
				상세보기
			</div>
			<%}else if((g.getStatus()).equals("Y")){ %>
			<div class="alert alert-warning center" id="result">
				초청완료
			</div>
			<%} %> 
		</td>
	</tr>
<%} %>
<%} else{ %>
	<tr>
		<td colspan="4"><br />
		<br />
		<br /><h4>현재 등록된 경기가 없습니다.</h4><br />
		<br /></td>
	</tr>
<%} %>
</table>
	<!-- <div id="container"> -->
    <div class="pagination" >
    	<%=request.getAttribute("pageBar") %>
	</div>
	<!-- </div> -->
</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	