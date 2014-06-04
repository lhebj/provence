<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil,com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#box {
	width: 1000px;
	height: 500px;
	margin: 0 auto;
}

#left {
	width: 240px;
	height: 500px;
	float: left;
	
	line-height:18px;
	font-family:"adobe 黑体";
	font-size:12px;
	text-align:justify;
	text-justify:inter-ideograph;
}

#right {
	width: 240px;
	height: 500px;
	float: right;
	
	
	line-height:18px;
	font-family:"adobe 黑体";
	font-size:12px;
	text-align:justify;
	text-justify:inter-ideograph;
}

#center {
	width: 520px;
	height: 500px;
	float: left;
	
	line-height:18px;
	font-family:"adobe 黑体";
	font-size:12px;
	text-align:justify;
	text-justify:inter-ideograph;
}
</style>
</head>

<body>
	<%@ include file="../homeHead.jsp"%>


	<div id="box">
		<div id="left">
			<div>
				<B><%=LocalizationUtil.getClientString("Contact.contactUs", request)%></B> <span><a href="admin.do?action=postContactUs&type=contact">编辑</a></span>
			</div>
			<div>${contact.contentCtu}</div>
		</div>

		<div id="right">
			<div>
				<B><%=LocalizationUtil.getClientString("Contact.stores", request)%></B> <span><a href="admin.do?action=postContactUs&type=stores">编辑</a></span>
			</div>
			<div>${stores.contentCtu}</div>
		</div>
		<div id="center">
			<div>
				<B><%=LocalizationUtil.getClientString("Contact.hr", request)%></B> <span><a href="admin.do?action=postContactUs&type=hr">编辑</a></span>
			</div>
			<div>${hr.contentCtu}</div>
		</div>
			
	</div>
	
	<%@ include file="../homeFoot.jsp" %>

</body>
</html>
