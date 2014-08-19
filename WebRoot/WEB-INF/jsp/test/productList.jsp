<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %> 
<c:set var="nameBrd" value="${brandDetailDTO.nameBrd}" scope="page"></c:set>
<% navBar.put("brand", "selected"); %>
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
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/reset.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/body.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/func.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>/register.css?v=<%=version%>" />
	<style type="text/css">
		body{
			background:url("<%=IMAGE_PATH%>/bg.jpg") no-repeat center 0;
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
	<div class="main-nav clearfix">
		<div class="left-nav">
						
		</div>
		<div class="right-nav">
		</div>
	</div>
	
	<div class="main-content clearfix">
	  <div class="left-part">
	  	<%@ include file="common/brand_left.jsp" %>
	  </div>
	  <div class="right-part">
		<div class="list-wrapper">
			<ul class="list-container clearfix">
				<c:forEach items="${productDTOList}" var="productDTO">
					<li class="list-item">
							<div class="">
								<a class="img-wrapper logo" href="product.do?action=detail&id=${productDTO.idPrd}">
									<img src="${productDTO.coverPath}" />
								</a>
							</div>
							<div class="desc-wrapper">
								<div class="detail-wrapper">
									<!-- 
									<p class="size">50L</p>
									 -->
									<div class="detail clearfix">
										<span class="show">${productDTO.namePrd}</span>
										<!-- 
										<span class="buying">250RMB&nbsp;购买</span>
										 -->
									</div>
								</div>
							</div>
						</li>
				</c:forEach>
			</ul>
		</div>
	  </div>
	</div>	  	
	     	<div class="pagination">
	    		${pageutil}
	    	</div>
	      <%@ include file="common/footer.jsp" %>
      </div>
  </body>
</html>
