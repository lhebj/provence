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

</head>

<body>
	<div align='center'>
		<embed src="music/cover-new-1.swf" type="application/x-shockwave-flash" width="100%" height="100%" loop="true" autostart="true"></embed>
	</div>
	<div style="display:none;"><a href="index.do">首页</a></div>
</body>
</html>