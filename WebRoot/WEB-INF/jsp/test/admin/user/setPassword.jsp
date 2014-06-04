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
			<h1>设置密码</h1>
		</div>
		<FORM class="form-horizontal" name="form1" METHOD="POST"
			ACTION="admin.do?action=setPassword">
			<table>
				<tr>
					<td width='100' >旧密码</td>
					<td width='200'><input name="oldPassword" type="password" style="width:200px;height:30px" value="" /></td>
				</tr>
				<tr>
					<td width='100'>新密 码</td>
					<td width='200'><input name="newPassword" type="password" style="width:200px;height:30px" value="" /></td>
				</tr>
				<tr>
					<td width='100'>确认新密 码</td>
					<td width='200'><input name="newPasswordSure" type="password" style="width:200px;height:30px" value="" /></td>
				</tr>
				<c:if test="${message != null}">
					<tr>
						<td></td>
						<td>${message}</td>
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


	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
