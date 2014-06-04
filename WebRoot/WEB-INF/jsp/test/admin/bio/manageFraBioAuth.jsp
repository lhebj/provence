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
</head>

<body>
	<%@ include file="../homeHead.jsp"%>


	<div class="page-header">
		<h1>法国Bio认证管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postBio&type=FraBioAuth"><button
				style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table style="width:100%;" class="table table-bordered table-condensed table-hover">
		<tr>
			<td style="width:20%;">标题</td>
			<td style="width:35%;">内容</td>
			<td style="width:5%;">图片位置</td>
			<td style="width:20%;">图片</td>
			<td style="width:10%;">发布时间</td>
			<td style="width:10%;">操作</td>
		</tr>
		<tbody>
			<c:forEach items="${bioDtoList}" var="bioDto">
				<tr>
					<td>${bioDto.titleBio}</td>
					<td>${bioDto.contentBio}</td>
					<td>${bioDto.picPlaceBio}</td>
					<td><div style="width: 200px; height: 200px"><img src="${bioDto.path}"></img></div></td>
					<td>${bioDto.dateCreateBio}</td>
					<td><a
						href="admin.do?action=postBio&type=FraBioAuth&id=${bioDto.idBio}"><button
								style="width: 82px;" class="btn btn-primary" type="button">编辑</button></a>
						<a href="bioAdmin.do?action=delete&id=${bioDto.idBio}" onclick="javascript:return del_sure()"><button
								style="width: 82px;" class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}


	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
