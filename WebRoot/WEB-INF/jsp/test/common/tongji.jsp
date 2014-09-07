<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.HashMap" %>
<%	
	String serverName = request.getServerName();
	boolean isAimebio = serverName.indexOf("aimebio") > -1 ;
	boolean isProdepro = serverName.indexOf("prodepro") > -1 ;
%>
<% if(isAimebio) {%>
<script type="text/javascript" src="http://js.tongji.linezing.com/3503409/tongji.js"></script><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/3503409/tongji.gif"/></a></noscript>
<%} %>

<% if(isProdepro) {%>
<script type="text/javascript" src="http://js.tongji.linezing.com/3503410/tongji.js"></script><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/3503410/tongji.gif"/></a></noscript>
<%} %>