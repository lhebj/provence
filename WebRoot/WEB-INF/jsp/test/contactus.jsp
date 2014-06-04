<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<% navBar.put("contact", "selected"); %>
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
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>contact.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>register.css?v=<%=version%>" />
	<style type="text/css">
		body{
			background:url("<%=IMAGE_PATH%>/bg.jpg")  center 0;
		}
	</style>
	<script>var BASE_URL = "<%=basePath%>";</script>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js?v=<%=version%>"></script>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.slides.js?v=<%=version%>"></script>
	<script type="text/javascript" src="<%=JS_PATH%>banner.js?v=<%=version%>"></script>
	<script type="text/javascript" src="<%=JS_PATH%>contact.js?v=<%=version%>"></script>
	<script type="text/javascript" src="<%=JS_PATH%>register.js?v=<%=version%>"></script>
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
		<div class="middle-nav">	
		</div>
		<div class="con-right-nav">		
		</div>
	</div>
	
	<div class="main-content clearfix">
	  <div class="left-part">
	  	<div class="contact-our">
						<h3 class="sub-title"><%=LocalizationUtil.getClientString("Contact.contactUs", request)%></h3>
						${contact.contentCtu}
					</div>
					<!-- 占位 -->
					<!-- 
					<div class="cooperation">
						<h3 class="sub-title">招商合作</h3>
						<p>合作与加盟普罗旺斯专卖店</p>
					</div>
					<div class="shopping-wrapper">
						<ul class="shopping">
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>sina.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>qq.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>tianmao.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>refeng.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>jd.png" /></a></li>
							<li class="shopping-item"><a href="javascript:;"></a></li>
						</ul>
					</div>
					 -->
	  </div>
	  <div class="middle-part">
					<div class="zp">
						<h3 class="sub-title"><%=LocalizationUtil.getClientString("Contact.hr", request)%></h3>
						${hr.contentCtu}
		
					</div>
					<div class="message">
						<h3 class="sub-title"><%=LocalizationUtil.getClientString("Message.leaveMessage", request)%></h3>
						<FORM name="form1" id="form1" METHOD="POST" ACTION="message.do?action=save">
						<ul class="message-wrapper">
							<li class="message-item clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.name", request)%><span class="star"></span></span>
								<input type="text" name="name" class="mes-content" />
							</li>
							<li class="message-item short clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.sex", request)%></span>
								<input type="radio" name="sex" value="male"
								checked="checked" /><%=LocalizationUtil.getClientString("sex-male", request)%>
								<input type="radio" name="sex" value="female" /><%=LocalizationUtil.getClientString("sex-female", request)%>
							</li>
							<li class="message-item short clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.city", request)%></span>
								<input type="text" name="city" class="mes-content" />
							</li>
							<li class="message-item clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.address", request)%></span>
								<input type="text" name="address" class="mes-content" />
							</li>
							<li class="message-item clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.phone", request)%></span>
								<input type="text" name="phone" class="mes-content" />
							</li>
							<li class="message-item clearfix">
								<span class="mes-title">Email<span class="star"></span></span>
								<input type="text" name="email" class="mes-content" />
							</li>
							<li class="message-item clearfix">
								<span class="mes-title"><%=LocalizationUtil.getClientString("Message.message", request)%><span class="star"></span></span>
								<input type="text" name="message" class="mes-content big-mes-content" />
							</li>
						</ul>
						<div class="bottom clearfix">
							<span class="star"></span>&nbsp;<%=LocalizationUtil.getClientString("Message.BeSureToFill", request)%>
							<!-- <span class="publish-button"><div onclick="document.getElementById('form1').submit()"><%=LocalizationUtil.getClientString("Message.post", request)%></div></span>  -->
							<span class="publish-button"><button><%=LocalizationUtil.getClientString("Message.post", request)%></button></span>
						</div>
						</FORM>
					</div>
				</div>
				<div class="con-right-part">
					<!-- <h3 class="sub-title"><%=LocalizationUtil.getClientString("Contact.stores", request)%></h3>  -->
					<h3 class="sub-title"><%=LocalizationUtil.getClientString("Contact.cooperation", request)%></h3>
					${stores.contentCtu}
				</div>
	</div>	  	
	      <%@ include file="common/footer.jsp" %>
      </div>
  </body>
</html>
