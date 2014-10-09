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
    
    <title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/func.css" />
	<style type="text/css">
a, a:hover, a:link{
	text-decoration:none;
}
.main-section{
	width:897px;
	height:661px;
	margin:0 auto;
}
.img-item{
	width:897px;
	height:661px;
	position:absolute;
	top:0;
	left:0;
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
	width:70px;
	height:64px;
	z-index:100;
}
		</style>
		
		<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body>    
<div class="main-section" >
			<div style="overflow:hidden;position:relative;width:100%;height:661px;">
				<!-- 
				<div class="img-item" id="image1" style="display:none">
					<div class="img-wrapper" style="width:897px;height:661px;">
						<img src="<%=IMAGE_PATH %>cover-01.png" />
					</div>
				</div>
				<div class="img-item" id="image2" style="display:none">
					<div class="img-wrapper" style="width:897px;height:661px;">
						<img src="<%=IMAGE_PATH %>cover-03.png" />
					</div>
				</div>
				<div class="img-item" id="image3" style="display:none">
					<div class="img-wrapper" style="width:897px;height:661px;">
						<img src="<%=IMAGE_PATH %>cover-04.png" />
					</div>
				</div>
				 -->
				<div class="img-item" id="image-new">
					<div class="img-wrapper" style="width:897px;height:661px;">
						<a href="index.do"><img src="<%=IMAGE_PATH %>cover-new.png" /></a>
					</div>
				</div>
			</div>
			<div class="button-container clearfix">
				<!-- <a class="button-item" href="index.do"></a>
				<a class="button-item" href="index.do"></a> -->
			</div>
		</div>
		<!-- 
		<script>
			$(function(){
				#$("#image1").fadeIn(5000);
				setTimeout(function(){$("#image2").fadeIn(6000);}, 1000);
				setTimeout(function(){$("#image3").fadeIn(6000);}, 1000);
			});
		</script>
		 -->
		 <%@ include file="common/baidutongji.jsp" %>
  </body>
</html>