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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#box {
	width: 1000px;
	height: 500px;
	margin: 0 auto;
}

#left {
	width: 240px;
	height: 500px;
	float: left;
}

#right {
	width: 240px;
	height: 500px;
	float: right;
}

#center {
	width: 520px;
	height: 500px;
	float: left;
}
</style>
</head>

<body>
	<%@ include file="../homeHead.jsp"%>


	<div class="page-header">
		<h1>留言管理</h1>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td width="100">姓名/公司名称</td>
			<td width="20">性别</td>
			<td width="40">邮箱</td>
			<td width="40">城市</td>
			<td width="40">地址</td>
			<td width="100">留言时间</td>
			<td width="40">ip</td>
			<td width="40">手机</td>
			<td width="200">留言内容</td>
			<td width="40">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${messageDTOList}" var="messageDto">
				<tr>
					<td>${messageDto.nameMsg}</td>
					<td>${messageDto.sexMgs}</td>
					<td>${messageDto.emailMsg}</td>
					<td>${messageDto.cityMsg}</td>
					<td>${messageDto.addressMsg}</td>
					<td>${messageDto.dateCreateMsg}</td>
					<td>${messageDto.ipMsg}</td>
					<td>${messageDto.phoneMsg}</td>
					<td>${messageDto.messageMsg}</td>
					<td><a
						href="messageAdmin.do?action=delete&id=${messageDto.idMsg}"  onclick="javascript:return del_sure()">刪除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}



	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
