<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.member.model.vo.*"%>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
	
	int totalMember = (Integer)request.getAttribute("totalMember");

%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
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
	.btn {
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
	
	.btn:hover {
	  color: #fff;
	  border: 1px solid rgba(223,190,106,0);
	  color: $white;
	  background-position: 99% 50%;
	} 
    /* 버튼 디자인 */
</style>
<script>
function fn_teamMemberOut() {
	
}
</script>
 <!--ui object -->
    <table class="tbl_type"  cellspacing="0">
        <legend>◎회원관리</legend>
        
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
    	<th scope="col">선택</th>
        <th scope="col">순번</th>
        <th scope="col">아이디</th>
        <th scope="col">이름</th>
        <th scope="col">핸드폰번호</th>
        <th scope="col">이메일</th>
        <th scope="col">생년월일</th>
        <th scope="col">프로필</th>
        <th scope="col">등급</th>
    </tr>
    </thead>
    <tbody>
    <%if(list == null || list.isEmpty()){ %>
		<tr>
			<td colspan="5" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%}else{ 
			for(Member m : list){%>
			<tr>
				<td><input type="radio" name="choose" id="choose" value="<%=m.getUserId()%>"/></td>
				<td class="ranking" scope="row"><%=m.getRnum() %></td>
				<td><%=m.getUserId() %></td>
	        	<td><%=m.getUserName() %></td>
		        <td><%=m.getPhone() %></td>
		        <td><%=m.getEmail() %></td>
	        	<td><%=m.getBirthday() %></td>
	        	<td><%=m.getProfile() %></td>
	        	<td><%=m.getGrade() %></td>
			</tr>
		<%}
		} %>
		 
    </tbody>
    
    <tfoot>
        <tr>
        <td>종합</td>
        <td>총 인원수</td>
        <td>전체</td>
        <td colspan="6"><%= totalMember%>명</td>
        </tr>
        <tr>
        <input type="button" value="제명" class="btn" onclick="fn_teamMemberOut();"/>
        </tr>
        </tfoot>
    </table>
    <!--//ui object -->
    <!-- <div id="container"> -->
    <div class="pagination" >
    	<%=request.getAttribute("pageBar") %>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>