<%@page import="com.dleague.search.model.vo.Activity"%>
<%@page import="com.dleague.game.model.vo.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<%
	Object o = request.getAttribute("obj");
	Activity a = null;
	Game g = null;
	if(o instanceof Game){
		g = (Game)o;
	}else if (o instanceof Activity){
		a = (Activity)a;
	}
	System.out.println(o);
	System.out.println(g);
	System.out.println(a);
%>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	