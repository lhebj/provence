<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil,com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%@ include file="../homeHead.jsp"%>

	<div class="page-header">
		<h1>用户管理</h1>
	</div>
	<div>
		<a href="admin.do?action=modifyPassword"><button
				style="width: 82px;" class="btn btn-primary" type="button">修改密码</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>邮箱</td>
			<td>城市</td>
			<td>国家</td>
			<td>生日</td>
			<td>注册日期</td>
			<td>手机</td>
			<td>ip</td>
			<td>地址</td>
			<td>邮编</td>
			<td>操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${userDtoList}" var="userDto">
				<tr>
					<td>${userDto.usernameU}</td>
					<td>${userDto.sexU}</td>
					<td>${userDto.emailU}</td>
					<td>${userDto.cityU}</td>
					<td>${userDto.countryU}</td>
					<td>${userDto.dateBirthdayU}</td>
					<td>${userDto.dateRegisterU}</td>
					<td>${userDto.mobileU}</td>
					<td>${userDto.ipU}</td>
					<td>${userDto.addressU}</td>
					<td>${userDto.zipcodeU}</td>
					<td><a
						href="userAdmin.do?action=delete&username=${userDto.usernameU}"  onclick="javascript:return del_sure()">刪除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}


	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
