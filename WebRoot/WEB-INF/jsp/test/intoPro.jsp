<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<% navBar.put("intoProvence", "selected");
HashMap<String,String> provenceItems = new HashMap<String,String>();
provenceItems.put("intro", "普罗旺斯简介");
provenceItems.put("color", "普罗旺斯的色"); 
provenceItems.put("smell", "普罗旺斯的香");
provenceItems.put("taste", "普罗旺斯的味");
provenceItems.put("quality", "普罗旺斯的质");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="typeInp" value="${typeInp }" scope="page"></c:set>
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
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>body.css" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>provence.css" />
	<style type="text/css">
		body{
			background:url("<%=IMAGE_PATH%>/provence-bg.png") center 0;
		}
		.main-section{
				margin-bottom:134px;
			}
	</style>
	
	<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body>
  <div class="main-section">
	  <%@ include file="head.jsp" %>
		<div class="banner">
			<img src="<%=IMAGE_PATH %>banner.png" />
		</div>
		<div class="main-nav clearfix">
			<div class="left-nav">
					
			</div>
			<div class="right-nav">
					<a href="javascript:;">走进普罗旺斯</a>
					<span class="cat">&gt;</span>
					<a href='intoProvence.do?action=${typeInp}'><%=provenceItems.get((String)pageContext.getAttribute("typeInp")) %></a>
			</div>
		</div>
		<div class="main-content clearfix">
				<div class="left-part">
					<ul class="brand">
						<li><span class="brand-item special"><span>走进普罗旺斯</span></span></li>
						<c:choose>
					    	<c:when test="${typeInp =='intro'}"> <li><span class="brand-item selected">普罗旺斯简介</span></li></c:when>   
					   		<c:otherwise><li><a class="brand-item" href="intoProvence.do?action=intro">普罗旺斯简介</a></li></c:otherwise>  
						</c:choose>
						<c:choose>
						   <c:when test="${typeInp =='color'}"> <li><span class="brand-item selected">普罗旺斯的色</span></li></c:when>   
						   <c:otherwise><li><a class="brand-item" href="intoProvence.do?action=color">普罗旺斯的色</a></li></c:otherwise>  
						</c:choose>
						<c:choose>
						   <c:when test="${typeInp =='smell'}"> <li><span class="brand-item selected">普罗旺斯的香</span></li></c:when>   
						   <c:otherwise><li><a class="brand-item" href="intoProvence.do?action=smell">普罗旺斯的香</a></li></c:otherwise>  
						</c:choose>
						<c:choose>
						   <c:when test="${typeInp =='taste'}"> <li><span class="brand-item selected">普罗旺斯的味</span></li></c:when>   
						   <c:otherwise><li><a class="brand-item" href="intoProvence.do?action=taste">普罗旺斯的味</a></li></c:otherwise>  
						</c:choose>
						<c:choose>
						   <c:when test="${typeInp =='quality'}"> <li><span class="brand-item selected">普罗旺斯的质</span></li></c:when>   
						   <c:otherwise><li><a class="brand-item" href="intoProvence.do?action=quality">普罗旺斯的质</a></li></c:otherwise>  
						</c:choose>
					</ul>
					<!-- 
					<div class="shopping-wrapper">
						<ul class="shopping">
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>sina.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>qq.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>tianmao.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>refeng.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>jd.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="" /></a></li>
						</ul>
					</div>
					<div>
						<img src="<%=IMAGE_PATH %>sale.png" />
					</div>
					 -->
				</div>
				
				<div class="right-part">
					<div class="provence clearfix">
						<div class="left-content">
							<img class="temp-pic" src="<%=IMAGE_PATH %>sun.png" />
							<p class="temp">${weatherData.lowTemp} ~ ${weatherData.lowTemp}</p>
							<p class="pro-title">普罗旺斯</p>
							<p class="date">2013.12.23</p>
							<p class="weekday">星期一</p>
						</div>
						<div class="right-content">
							${intoProvenceStoryDTO.storyInps}
						</div>
					</div>
					<c:forEach items="${intoProvenceDtoList}" var="intoProvenceDto">
					<div class="provence-item">
						<img class="show-pic" src="${intoProvenceDto.path}" />
						<p class="show-content">
							${intoProvenceDto.contentInp}
						</p>
					</div>
					</c:forEach>
				</div>
				
		</div>
	
	  <!-- <div ><span>小故事：<b>${intoProvenceStoryDTO.storyInps}</b></span></div>     -->
	    <div class="pagination">
	    		${pageutil}
	    </div>
	    <%@ include file="common/footer.jsp" %>
    </div>
  </body>
</html>
