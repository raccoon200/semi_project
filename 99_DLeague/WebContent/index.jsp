<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/js/vmcslider/src/style.css" type="text/css" />
<style>
div.effect{
    position: relative;
	width: 1000px;
	height: 391.922px;
	margin: 0 auto;
	margin-top: 136px;
}
div.effect>img{
	width: 1000px;
}
.effect:after {
    position: absolute;
    display: block;
    content: "";
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(90deg, white, rgba(255, 255, 255, 0) 10%, rgba(255, 255, 255, 0) 90%, #fff 100%);
    z-index: 5; 
}
</style>
<div class="effect">
	<div id="slider">
	<a href="#"><img id="main-img" src="<%=request.getContextPath() %>/images/index/main.jpg" alt="main" /></a>
	<a href="#"><img id="main-img2" src="<%=request.getContextPath() %>/images/index/main2.jpg" alt="main2" /></a>
	<a href="#"><img id="main-img3" src="<%=request.getContextPath() %>/images/index/main3.jpg" alt="main3" /></a>
	</div>
</div>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/vmcslider/vmc.slider.full.js"></script>
<script>
$('#slider').vmcSlider({
	width: 1000,
	height: 392,
	gridCol: 10,
	gridRow: 5,
	gridVertical: 20,
	gridHorizontal: 10,
	autoPlay: true,
	ascending: true,
	effects: [
		'fade', 'fadeLeft', 'fadeRight', 'fadeTop', 'fadeBottom', 'fadeTopLeft', 'fadeBottomRight',
		'blindsLeft', 'blindsRight', 'blindsTop', 'blindsBottom', 'blindsTopLeft', 'blindsBottomRight',
		'curtainLeft', 'curtainRight', 'interlaceLeft', 'interlaceRight', 'mosaic', 'bomb', 'fumes'
	],
	ie6Tidy: false,
	random: true,
	duration: 2000,
	speed: 1000
});
</script>>
<footer id="footer">
<div id="footer-wrapper">
    <a href="<%=request.getContextPath()%>"><img id="footer-image" src="<%=request.getContextPath() %>/images/headerImage.png" /></a>
        <p>팀명 : 투톱체제<br>
      	팀원 : 김대연, 최지수, 박희영, 배성인, 이연경<br>
		주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4층</p>
    </div>
</footer>