<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

    <title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Le styles -->
<style type="text/css">
#top {
	width: 1000px;
	height: 150px;
	margin: 0 auto;
}
</style>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="assets/css/bootstrap-responsive.min.css" rel="stylesheet">

<%@ include file="common/tongji.jsp"%>
</head>

<body>

	<div align="center">
		<div class="page-header">
			<h1>登录</h1>
		</div>
		<FORM class="form-horizontal" name="form1" METHOD="POST"
			ACTION="j_acegi_security_check">
			<table>
				<tr>
					<td width='60'>用户名</td>
					<td width='200'><input name="j_username" type="text" value="" /></td>
				</tr>
				<tr>
					<td width='60'>密 码</td>
					<td width='200'><input name="j_password" type="password"
						value="" /></td>
				</tr>
				<c:if test="${type == 'fail'}">
					<tr>
						<td></td>
						<td><b>用户名或密码错误</b></td>
					</tr>
				</c:if>
				<tr>
					<td width='60'></td>
					<td width='200'><input class="btn btn-primary" name="ok"
						type="submit" value="登录"> <input type="button" value="取消"
						class="btn" onclick="javascript:window.history.go(-1);" /></td>
				</tr>

			</table>
		</form>
	</div>
	<script src="assets/js/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
