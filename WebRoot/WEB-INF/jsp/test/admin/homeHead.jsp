<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil,com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
#top {
	width: 1000px;
	height: 150px;
	margin: 0 auto;
}
</style>

<!-- Le styles -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="assets/css/bootstrap-responsive.min.css" rel="stylesheet">
<%
String urlQueryString = request.getQueryString();

%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="index.do">Provence</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li <%if(urlQueryString.contains("action=manageUsers")){ %>class="active"<%} %>><a href="admin.do?action=manageUsers">用户</a></li>
					<li <%if(urlQueryString.contains("action=manageIndex")){ %>class="active"<%} %>><a href="admin.do?action=manageIndex">首页</a></li>
					<li <%if(urlQueryString.contains("action=manageBanner")){ %>class="active"<%} %>><a href="admin.do?action=manageBanner">banner</a></li>
					<li class="dropdown" <%if(urlQueryString.contains("action=manageNews")){ %>class="active"<%} %>><a href="admin.do?action=manageNews"
						class="dropdown-toggle" data-toggle="dropdown">资讯 <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="admin.do?action=manageNewsVideo">资讯视频管理</a></li>
							<li><a href="admin.do?action=manageNewsInfo">资讯信息管理 </a></li>
						</ul></li>
					<li <%if(urlQueryString.contains("action=manageAimeBio")){ %>class="active"<%} %>><a href="admin.do?action=manageAimeBio">关于AimeBio</a></li>
					<li <%if(urlQueryString.contains("action=manageBrand")){ %>class="active"<%} %>><a href="admin.do?action=manageBrand">品牌</a></li>
					<li <%if(urlQueryString.contains("action=manageIntoProvence")){ %>class="active"<%} %>><a href="admin.do?action=manageIntoProvence&type=intro">走进普罗旺斯</a></li>
					<li <%if(urlQueryString.contains("action=manageFraBioAuth")){ %>class="active"<%} %>><a href="admin.do?action=manageFraBioAuth">法国Bio认证</a></li>
					<li <%if(urlQueryString.contains("action=manageContactUs")){ %>class="active"<%} %>><a href="admin.do?action=manageContactUs">联系我们</a></li>
					<li <%if(urlQueryString.contains("action=manageMessage")){ %>class="active"<%} %>><a href="admin.do?action=manageMessage">留言</a></li>
					<!-- <li class="active">用户：<%=WebUtil.getUserId(request)%>|<a href="logout.do">退出</a></li> -->
				</ul>
						<div class="navbar-text pull-right">用户：<%=WebUtil.getUserId(request)%> | <a href="logout.do">退出</a></div>
					
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>


<div id="top">