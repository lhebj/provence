<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="common/common.jsp"%>
<%
	navBar.put("intoProvence", "selected");
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
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>body.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>provence.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>register.css?v=<%=version%>" />
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>common/perfect-scrollbar.css?v=<%=version%>" />
<style type="text/css">
body {
	background: url("<%=IMAGE_PATH%>/bg.jpg") center 0;
}

.main-section {
	margin-bottom: 134px;
}
#perfect-scrollbar{
	position:relative;
}
</style>
<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
<script type="text/javascript" src="<%=JS_PATH%>common/jquery.slides.js"></script>
<script type="text/javascript" src="<%=JS_PATH%>common/jquery.mousewheel.js"></script>
<script type="text/javascript" src="<%=JS_PATH%>common/perfect-scrollbar.js"></script>
<script type="text/javascript" src="<%=JS_PATH%>banner.js"></script>
<script type="text/javascript" src="<%=JS_PATH%>register.js"></script>

<script language="JavaScript">
	function showDate() {
		offset=1;
		d = new Date();
		utc = d.getTime() + (d.getTimezoneOffset() * 60000);
		today = new Date(utc + (3600000 * offset));
		var seconds = today.getSeconds();
		if(seconds < 10){
			seconds = "0" + seconds;
		}
		//var date = today.getFullYear() + "." + (today.getMonth()+1) + "." + today.getDate() + " " + today.getHours() + ":" + today.getMinutes() + ":"	+ seconds;
		var date = today.getHours() + ":" + today.getMinutes() + ":" + seconds;
		document.getElementById("currentTime").innerHTML=date;
		window.setTimeout("showDate();", 1000);
	}
	window.onload=showDate;
	$(function(){
		$('#perfect-scrollbar').perfectScrollbar({suppressScrollX:true});
	});
</script>

<script>
function imagezoom(new_w, new_h){
    var img = document.createElement('img');
    img.src = this.src;
    var src_w = img.width;
    var src_h = img.height;
   
    var zoom_w = 0, zoom_h = 0;
    if(src_w > new_w || src_h > new_h){
        var scale_w = new_w / src_w;
        var scale_h = new_h / src_h;
        var b = scale_w < scale_h;
           
        if(b){
            zoom_w = src_w * scale_w;
            zoom_h = src_h * scale_w;
        }else{
            zoom_w = src_w * scale_h;
            zoom_h = src_h * scale_h;
        }
    }else{
        zoom_w = src_w;
        zoom_h = src_h;
    }
       
    this.style.marginLeft = Math.abs(new_w-zoom_w)/2+'px';
    this.style.marginTop = Math.abs(new_h-zoom_h)/2+'px';
    this.style.marginRight = Math.abs(new_w-zoom_w)/2+'px';
    this.style.marginBottom = Math.abs(new_h-zoom_h)/2+'px';
   
    this.width = zoom_w;
    this.height = zoom_h;
}
</script>

<%@ include file="common/tongji.jsp"%>
</head>

<body>
	<div class="main-section">
		<%@ include file="head.jsp"%>
		<div class="banner">
			<%@ include file="common/banner.jsp"%>
		</div>
		<div class="main-nav clearfix">
			<div class="left-nav"></div>
			<div class="right-nav">
				<a href="javascript:;">走进普罗旺斯</a> <span class="cat">&gt;</span> <a
					href='intoProvence.do?action=${typeInp}'><%=provenceItems.get((String) pageContext.getAttribute("typeInp"))%></a>
			</div>
		</div>
		<div class="main-content clearfix">
			<div class="left-part">
				<ul class="brand">
					<li><span class="brand-item special"><span>走进普罗旺斯</span></span></li>
					<c:choose>
						<c:when test="${typeInp =='intro'}">
							<li><span class="brand-item selected">普罗旺斯简介</span></li>
						</c:when>
						<c:otherwise>
							<li><a class="brand-item"
								href="intoProvence.do?action=intro">普罗旺斯简介</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${typeInp =='color'}">
							<li><span class="brand-item selected">普罗旺斯的色</span></li>
						</c:when>
						<c:otherwise>
							<li><a class="brand-item"
								href="intoProvence.do?action=color">普罗旺斯的色</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${typeInp =='smell'}">
							<li><span class="brand-item selected">普罗旺斯的香</span></li>
						</c:when>
						<c:otherwise>
							<li><a class="brand-item"
								href="intoProvence.do?action=smell">普罗旺斯的香</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${typeInp =='taste'}">
							<li><span class="brand-item selected">普罗旺斯的味</span></li>
						</c:when>
						<c:otherwise>
							<li><a class="brand-item"
								href="intoProvence.do?action=taste">普罗旺斯的味</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${typeInp =='quality'}">
							<li><span class="brand-item selected">普罗旺斯的质</span></li>
						</c:when>
						<c:otherwise>
							<li><a class="brand-item"
								href="intoProvence.do?action=quality">普罗旺斯的质</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<!-- 
				<div class="shopping-wrapper">
					<ul class="shopping">
						<li class="shopping-item"><a href="javascript:;"><img
								src="<%=IMAGE_PATH%>sina.png" /></a></li>
						<li class="shopping-item"><a href="javascript:;"><img
								src="<%=IMAGE_PATH%>qq.png" /></a></li>
						<li class="shopping-item"><a href="javascript:;"><img
								src="<%=IMAGE_PATH%>tianmao.png" /></a></li>
						<li class="shopping-item"><a href="javascript:;"><img
								src="<%=IMAGE_PATH%>refeng.png" /></a></li>
						<li class="shopping-item"><a href="javascript:;"><img
								src="<%=IMAGE_PATH%>jd.png" /></a></li>
						<li class="shopping-item"><a href="javascript:;"><img
								src="" /></a></li>
					</ul>
				</div>
				<div>
					<img src="<%=IMAGE_PATH%>sale.png" />
				</div>
				 -->
			</div>

			<div class="right-part">
				<div class="provence clearfix">
					<div class="left-content">
					<!-- 
						<c:choose>
						<c:when test="${weatherData.weather} == 'Sunny'}">
							<img class="temp-pic" src="<%=IMAGE_PATH%>sunny.png" />
						</c:when>
						<c:when test="${weatherData.weather} == 'Drizzle'}">
							<img class="temp-pic" src="<%=IMAGE_PATH%>drizzle.png" />
						</c:when>
						<c:when test="${weatherData.weather} == 'Mostly Cloudy'}">
							<img class="temp-pic" src="<%=IMAGE_PATH%>mostly-cloudy.png" />
						</c:when>
						<c:when test="${weatherData.weather} == 'Cloudy'}">
							<img class="temp-pic" src="<%=IMAGE_PATH%>cloudy.png" />
						</c:when>
						<c:otherwise>
							<img class="temp-pic" src="<%=IMAGE_PATH%>sunny.png" />
						</c:otherwise>
						</c:choose>
					 -->
					 	<img class="temp-pic" src="weather-icon-vega/${weatherData.imgCode}" onload="imagezoom.call(this, 164, 150);" />
						<p class="temp">${weatherData.lowTemp}℃ ~ ${weatherData.highTemp}℃</p>
						<p class="pro-title">普罗旺斯</p>
						<p class="date">${weatherData.date} <div id="currentTime"></div></p>
						<p class="weekday">${weatherData.weekDay}</p>
					</div>
					<div id="perfect-scrollbar" class="right-content">	
						<div>
						${intoProvenceStoryDTO.storyInps}
						</div>
					</div>
				</div>
				<c:forEach items="${intoProvenceDtoList}" var="intoProvenceDto">
					<div class="provence-item">
						<img class="show-pic" src="${intoProvenceDto.path}" />
						<div class="show-content">${intoProvenceDto.contentInp}</div>
					</div>
				</c:forEach>
			</div>

		</div>
 
		<div class="pagination">${pageutil}</div>
		<%@ include file="common/footer.jsp"%>
	</div>
</body>
</html>
