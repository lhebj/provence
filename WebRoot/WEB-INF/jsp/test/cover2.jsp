<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=LocalizationUtil.getClientString("Titel.index", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/func.css" />
	<style type="text/css">
		a, a:hover, a:link{
	text-decoration:none;
}
.main-section{
	width:900px;
	height:660px;
	margin:0 auto;
}
.button-container{
	padding-right:14px;
	margin-top:-64px;
	position:relative;
	z-index:120;
}
.button-container .button-item{
	margin-right:25px;
	float:right;
	line-height:64px;
	font-size:24px;
	color:#848c77;
	display:block;
}
	</style>
  </head>
  
  <body>    
<div class="main-section">
			<canvas id="canvas" width="900" height="660" style="overflow:hidden;"></canvas>
			<div class="button-container clearfix">
				<a class="button-item" href="index.do">Enter</a>
				<a class="button-item" href="index.do">Skip</a>
			</div>
		</div>
		<script src="<%=JS_PATH%>ball.js"></script>
		<script src="<%=JS_PATH%>animation.js"></script>
		<script>
			
		</script>
  </body>
</html>
