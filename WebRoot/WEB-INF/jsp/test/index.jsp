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
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>reset.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>body.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>func.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>index.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>register.css?v=<%=version%>" />
<style type="text/css">
body {
	background: url("<%=IMAGE_PATH%>/index-bg.png") no-repeat center 0;
}

.main-section{
	margin-bottom:138px;
}
</style>
<!--
	<%if(request.getHeader( "User-Agent" ).toLowerCase().indexOf( "msie" ) >= 0 || request.getHeader( "User-Agent" ).toLowerCase().indexOf( "rv:11.0" ) >= 0 ) {%>
		<bgsound loop="infinite" volume="-2500" src="music/zhile.mp3">
	<%}else{%>
		<embed src="music/zhile.mp3" loop="true" VOLUME=0 hidden="true"></embed>
	<%}%>
	-->
	
<script type="text/javascript" src="http://player.youku.com/jsapi"></script>
<%@ include file="common/tongji.jsp"%>
</head>

<body>
	<div id="bgmusic">	 
	<!-- 
	<%if(request.getHeader( "User-Agent" ).toLowerCase().indexOf( "msie" ) >= 0 || request.getHeader( "User-Agent" ).toLowerCase().indexOf( "rv:11.0" ) >= 0 ) {%>
		<bgsound loop="infinite" volume="-2500" src="music/zhile.mp3" >
	<%}else{ %>
		<audio id="audio" src="music/zhile.mp3" hidden="hidden" autoplay="autoplay" volume="0.1" loop="loop"></audio>
	<%}%>
	 -->
	</div>
	<div class="main-section">
		<%@ include file="head.jsp"%>
		<div class="index-container">
			<div id="index-slides">
				<c:forEach items="${indexDtoList}" var="indexDto">
					<div class="index-item">
						<span> <c:if test="${indexDto.typeIdx =='pic'}">
								<img src="${indexDto.path}"></img>
							</c:if> <!-- 视频时，显示一个默认图片，默认图片的数据位 <img src="${indexDto.path}"></img>-->
							<c:if test="${indexDto.typeIdx =='video'}">
								<img class="video-pic" src="${indexDto.path}"></img>
								<input type="hidden" id="vid" value="${indexDto.vid}">
								<div id="video-play" class="video-play">
									<div class="video-side"></div>
									<div id="youkuplayer" style="width:968px;height:515px"></div>
									<div class="video-side right-video-side">
										<a href="javascript:;">关<br />闭<br />视<br />频
										</a>
									</div>
								</div>
							</c:if>
						</span>
					</div>

				</c:forEach>
			</div>
			<div class="icon-nav-wrapper">
				<ul class="icon-nav-container clearfix">
					<li class="icon-nav-item"><a href="news.do"><img
							src="<%=IMAGE_PATH%>index-news.png" /></a></li>
					<li class="icon-nav-item"><a href="brand.do?action=list"><img
							src="<%=IMAGE_PATH%>index-star.png" /></a></li>
					<li class="icon-nav-item"><a href="aimeBio.do"><img
							src="<%=IMAGE_PATH%>index-aimebio.png" /></a></li>
					<li class="icon-nav-item"><a
						href="intoProvence.do?action=intro"><img
							src="<%=IMAGE_PATH%>index-sun.png" /></a></li>
					<li class="icon-nav-item"><a href="fraBioAuth.do"><img
							src="<%=IMAGE_PATH%>index-bio.png" /></a></li>
					<li class="icon-nav-item video-pic"><a href="javascript:;"><img
							src="<%=IMAGE_PATH%>index-video.png" /></a></li>
					<li class="icon-nav-item"><a href="http://weibo.com/AimeBio"><img
							src="<%=IMAGE_PATH%>sina.png" /></a></li>
					<!-- <li class="icon-nav-item"><a href="javascript:;"><img src="<%=IMAGE_PATH%>qq.png" /></a></li> -->
					<li class="icon-nav-item"><a
						href="http://blog.sina.com.cn/u/5109575066"><img
							src="<%=IMAGE_PATH%>blognew.png" /></a></li>
					<li class="icon-nav-item index-shopping "><a
						href="javascript:;"><img
							src="<%=IMAGE_PATH%>index-shopping.png" /></a> 
							<ul class="shopping-contaiter">
								<li class="shopping-item"><a href="http://shop111875235.taobao.com/?spm=a230r.7195193.1997079397.20.hE2MtH"><img src="<%=IMAGE_PATH%>shop-taobao.png" /></a><li>
								<li class="shopping-item"><a href="http://www.nnkou.com/plws.html"><img src="<%=IMAGE_PATH%>shop-nnkou.png" /></a><li>
								<li class="shopping-item"><a href="http://www.ujipin.com/s-k%E9%98%B3%E5%85%89%E6%99%AE%E7%BD%97%E6%97%BA%E6%96%AF-c0.html"><img src="<%=IMAGE_PATH%>shop-ujipin.png" /></a><li>
							</ul>
					</li>
					<li class="icon-nav-item "><a href="contactus.do"><img
							src="<%=IMAGE_PATH%>index-contact.png" /></a></li>
					<li class="icon-nav-item "><a href="contactus.do"><img
							src="<%=IMAGE_PATH%>index-email.png" /></a></li>
				</ul>
			</div>
		</div>
		
		<div class="index-footer">
				<p class="copyright">Copyright &copy;2014 PRODEPRO All Rights Reserved.</p>
		</div>


	</div>

<script type="text/javascript"
	src="<%=JS_PATH%>common/jquery.js?v=<%=version%>%>"></script>
<script type="text/javascript"
	src="<%=JS_PATH%>common/jquery.slides.js?v=<%=version%>"></script>
<script type="text/javascript" src="<%=JS_PATH%>index.js?v=<%=version%>"></script>
<script type="text/javascript"
	src="<%=JS_PATH%>register.js?v=<%=version%>"></script>
	<%@ include file="common/baidutongji.jsp" %>
</body>
</html>
