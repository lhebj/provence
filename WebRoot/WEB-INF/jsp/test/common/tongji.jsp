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



<!--  share  -->


<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"1","bdPos":"right","bdTop":"185.5"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
