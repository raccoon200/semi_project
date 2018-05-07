<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp"%>
    <style>
    #teamDiv{background:white; padding:10px 10px 10px 10px;}
    #teamDiv2{text-align:right; padding:0px 40px 0px 0px;}
    /* UI Object */
    .tbl_type{margin:auto;}
    .tbl_type,.tbl_type th,.tbl_type td{border:0}
    .tbl_type{border:1px;width:90%;border-bottom:2px solid #dcdcdc;font-family:'돋움',dotum;font-size:12px;text-align:center;border-collapse:collapse}
    .tbl_type caption{display:none}
    .tbl_type tfoot{background-color:#f5f7f9;font-weight:bold}
    .tbl_type th{padding:7px 0 4px;border-top:2px solid #dcdcdc;border-right:1px solid #dcdcdc;border-left:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
    .tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    .tbl_type td.ranking{font-weight:bold}
    legend{padding:10px 0px 0px 40px;}
    /* //UI Object */
    
    /* 검색옵션 */
    select{height: 30px; width: 100px;}
    #search{height: 25px; width: 150px;}
    /* 검색옵션 끝*/
    
    /* 버튼 */
    .button {
      height:33px;
	  display: inline-block;
	  vertical-align: top;
	  position: relative;
	  padding: 0 15px 0 15px;
	  line-height: 35px;
	  font-size: 15px;
	  font-weight: bold;
	  color: white;
	  text-align: center;
	  text-transform: uppercase;
	  text-decoration: none;
	  text-shadow: 0 -1px rgba(0, 0, 0, 0.5);
	  background: #576dce;
	  background-clip: padding-box;
	  border: 1px solid;
	  border-color: #374fbb #344cb3 #2b3e94;
	  border-radius: 2px;
	  -webkit-font-smoothing: antialiased;
	  background-image: -webkit-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  background-image: -moz-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  background-image: -o-linear-gradient(top, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  background-image: linear-gradient(to bottom, #92a0df, #576dce 50%, #3f58c7 80%, #576dce);
	  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 2px rgba(0, 0, 0, 0.2);
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 2px rgba(0, 0, 0, 0.2);
	}
	.button:hover, .button.hover {
	  background-color: #5f74d0;
	  border-color: #2d429c #2d429c #253680;
	  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 5px #576dce;
	  box-shadow: inset 0 1px rgba(255, 255, 255, 0.2), inset 0 0 0 1px rgba(255, 255, 255, 0.1), 0 1px 5px #576dce;
	}
	.button:active, .button.active {
	  border-color: #253680 #2b3e94 #3147a8;
	  background: #475fc9;
	  -webkit-box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.8);
	  box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.8);
	}
	.button:before {
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
	}
	.button:after {
	  content: '>';
	  float: right;
	  position: relative;
	  margin-left: 15px;
	  font: bold 18px/33px 'Comic Sans MS';
	  /* I tried everything but couldn't get the vertical alignment to be
	     consistent in IE, so this is a hack targeting IE8-9-10. */
	  line-height: 31px\0;
	  color: #6377d1;
	  text-shadow: 0 -1px #8696dc, 0 1px 1px rgba(0, 0, 0, 0.3);
	  -webkit-font-smoothing: subpixel-antialiased;
	}
	/*버튼끝*/
    </style>
    <div id="teamDiv">
    <div id="teamDiv2">
    <select>
        <option value="서울시">서울시</option>
        <option value="부산시">부산시</option>
        <option value="경기도">경기도</option>
        <option value="제주도">제주도</option>
        <option value="전라남도">전라남도</option>
        <option value="경상북도">경상북도</option>
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