<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dleague.search.model.vo.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
<style>
	img{
	    width: 400px;
	    height: 300px;
	    display: inline-block;
	    float: left;
	}
	div#bu,#a,#b,#c,#d{border: 1px solid black;}
	div#bu{height: 550px; width: 700px; display: inline-block;}
	div#a{height: 100px; width: 200px; line-height: 20px; text-align: center; display: inline-block;}
	div#b{height: 100px; width: 200px;line-height: 20px; text-align: center; display: inline-block;}
	div#c{height: 80px; width: 200px; line-height: 10px; text-align: center; display: inline-block;}
	div#d{height: 80px; width: 200px; line-height: 10px; text-align: center; display: inline-block;}

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
        <img src="img/fighting.jpg" alt="">
        <div id="a">
            <h1>팀이름</h1>
            <h2>투톱체제</h2>
        </div>
        <br>
        <div id="b">
            <h1>팀장</h1>
            <h2>대연</h2>
        </div>
        <br>
        <div id="c">
            <h1>팀원수</h1>
            <h2> 6명</h2>
        </div>
        <br> <br>
        <div id="d">
            <h1>활동지역</h1>
            <h2>서울</h2>
         </div>
         <div id="d">
            <h1>창단일</h1>
            <h2>2018-05-01</h2>
        </div>
        <br><br>
        <textarea name="" id="" cols="79" rows="7">팀소개텍스트</textarea>
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
            <tr>
            <td class="ranking" scope="row">1</td>
            <td>콜로라도</td>
            <td>서울</td>
            <td>90</td>
            <td>1991-05-01</td>
            </tr>
            <tr>
            <td class="ranking" scope="row">2</td>
            <td>샌디에이고</td>
            <td>부산</td>
            <td>24</td>
            <td>2007-05-01</td>
            </tr>
            <tr>
            <td class="ranking" scope="row">3</td>
            <td>뉴욕m</td>
            <td>경기도</td>
            <td>23</td>
            <td>2015-05-01</td>
            </tr>
            <tr>
            <td class="ranking" scope="row">4</td>
            <td>애틀랜타</td>
            <td>강원도</td>
            <td>5</td>
            <td>2008-05-01</td>
            </tr>
            <tr>
            <td class="ranking" scope="row">5</td>
            <td>밀워키</td>
            <td>전라남도</td>
            <td>83</td>
            <td>2002-02-02</td>
            </tr>
            <tr>
            <td class="ranking" scope="row">6</td>
            <td>lad</td>
            <td>경상북도</td>
            <td>30</td>
            <td>2001-05-01</td>
        </tr>
        </tbody>
        <tfoot>
            <tr>
            <td>종합</td>
            <td colspan="2">총 팀원수</td>
            <td colspan="3">6명</td>
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