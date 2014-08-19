<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="common/common.jsp" %>
<% navBar.put("news", "selected"); %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=BASE_Path%>">
    
    <title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>body.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>news.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>register.css?v=<%=version%>" />
	<style type="text/css">
		body{
			background:url("<%=IMAGE_PATH%>/bg.jpg") center 0;
		}
	</style>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.slides.js"></script>
	<script type="text/javascript" src="<%=JS_PATH%>banner.js"></script>
	<script type="text/javascript" src="<%=JS_PATH%>register.js"></script>
	<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body>
  	<div class="main-section">
	  <%@ include file="head.jsp" %>
	  	<div class="banner">
			<%@ include file="common/banner.jsp"%>
		</div>
	    <!--<c:forEach items="${newsVideoDtoList}" var="newsVideoDto">
							<div ><span>标题：<b>${newsVideoDto.titleNsv}</b></div>
							<div >
								<span>视频 <img src="${newsVideoDto.playcodeNsv}"></img>
								</span>
							</div>
							
	    </c:forEach>-->
	    
			<div class="video-container clearfix">
				<div class="vidie-wrappper news-left img-container img-wrapper">
					${showNewsVideoDto.playcodeNsv}
				</div>
				<ul class="video-anchor news-right">
				<c:forEach items="${newsVideoDtoList}" var="newsVideoDto">
					<!-- todo 做成异步的 -->
					<li class="video-item"><a href="news.do?idNsv=${newsVideoDto.idNsv}">${newsVideoDto.titleNsv}</a></li>
			 		</c:forEach>
				</ul>
			</div>
							<!-- <div><a href="bannerAdmin.do?action=delete&id=${bannerDto.idBa}">刪除</a></div>  -->
	  
			<c:forEach items="${newsInfoDtoList}" var="newsInfoDto">
				<div class="news-container clearfix">
					<div class="news-wrappper news-left img-container img-wrapper">
						<img src="${newsInfoDto.path}" />
					</div>
					<div class="news-content news-right last-content">
						<h3 class="title">${newsInfoDto.titleNsi}</h3><br/>
						<p class="content">${newsInfoDto.contentNsi}</p>
					</div>
				</div>	
	    	</c:forEach>
	    	<div class="pagination">
	    		${pageutil}
	    	</div>
	    <%@ include file="common/footer.jsp" %>
    </div>
  </body>
</html>
