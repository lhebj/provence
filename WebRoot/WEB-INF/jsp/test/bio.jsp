<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<c:set var="requestURI" value="${requestURI }" scope="page"></c:set>
<% navBar.put((String)pageContext.getAttribute("requestURI"), "selected"); %>
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
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>body.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>bio.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>register.css?v=<%=version%>" />
	<!-- background:url("<%=IMAGE_PATH%>/bg.jpg") no-repeat center 0; -->
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
  ${header.refers }
  <div class="main-section">
	  <%@ include file="head.jsp" %>
	  <div class="banner">
	  	<%@ include file="common/banner.jsp"%>
	  </div>
	<div class="main-nav clearfix">
		<div class="left-nav">
						
		</div>
		<div class="right-nav">
			
		</div>
	</div>
	   <c:forEach items="${bioDtoList}" var="bioDto" varStatus="bioStatus">
	   		<div class="news-container ${bioStatus.first ? 'special-container' : '' } ${bioStatus.last ? 'last-content' : '' } clearfix">
	   			<div class="news-content">
	   			<c:if test="${bioDto.picPlaceBio =='left'}">
	   				<div class="news-wrappper news-left img-container img-wrapper">
						<img src="${bioDto.path}" />
					</div>
	   			</c:if>
	   			<c:if test="${bioDto.picPlaceBio =='right'}">
	   				<div class="news-wrappper news-right img-container img-wrapper">
						<img src="${bioDto.path}" />
					</div>
	   			</c:if>
					<h3 class="title">${bioDto.titleBio}</h3><br/>
					<%if(LocalizationUtil.getLocale(request).equals(Locale.CHINA)) {%>
					<div class="content">${bioDto.contentBio}</div>
					<%} else{ %>
					<div class="content_en">${bioDto.contentBio}</div>
					<%} %>
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
