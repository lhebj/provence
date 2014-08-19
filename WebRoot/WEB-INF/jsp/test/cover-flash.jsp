<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="common/common.jsp"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><%=LocalizationUtil.getClientString("SEO.Title", request)%></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords"
	content="<%=LocalizationUtil.getClientString("SEO.Keywords", request)%>">
<meta http-equiv="description"
	content="<%=LocalizationUtil.getClientString("SEO.Description", request)%>">
<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css" />
<style type="text/css">
html { overflow-x: hidden; overflow-y: hidden; }
</style>

<%@ include file="common/tongji.jsp"%>
</head>

<body>
	<div 
		style="cursor: hand; position:absolute; opacity: 0.1;width:100%; height:100%; z-index:1; visibility: visible; text-align:center;">
		<a href="index.do"> <img
			src="images/blank.png"
			width="100%" height="100%" border="0"></a>
	</div>
	<div style="z-index:-1;text-align:center;">
		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
			codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0"
			width="100%" height="100%" id="flashlogo">
			<param name="movie" value="music/cover-new-1.swf">
			<param name="quality" value=high>
			<embed src="music/cover-new-1.swf" quality=high
				width="100%" height="100%" 
				type="application/x-shockwave-flash"
				pluginspage="http://www.macromedia.com/go/getflashplayer"
				wmode="transparent">
			</embed>
			<param name="wmode" value="transparent" />
		</object>
	</div>


</body>
</html>