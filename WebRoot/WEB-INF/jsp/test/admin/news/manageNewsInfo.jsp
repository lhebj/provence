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
		<h1>资讯管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postNewsInfo"><button
				style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table style="width:900px;" class="table table-bordered table-condensed table-hover">
		<thread>
		<tr>
			<td style="width:100px;">标题</td>
			<td style="width:100px;">内容</td>
			<td style="width:200px;">图片</td>
			<td style="width:30px;">发布时间</td>
			<td style="width:50px;">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${newsInfoDtoList}" var="newsInfoDto">
				<tr>
					<td>${newsInfoDto.titleNsi}</td>
					<td>${newsInfoDto.contentNsi}</td>
					<td><img src="${newsInfoDto.path}"></img></td>
					<td>${newsInfoDto.dateCreateNsi}</td>
					<td><a
						href="admin.do?action=postNewsInfo&id=${newsInfoDto.idNsi}"><button style="width: 82px;"
				class="btn btn-primary" type="button">编辑</button></a>
						<a href="newsInfoAdmin.do?action=delete&id=${newsInfoDto.idNsi}"  onclick="javascript:return del_sure()"><button style="width: 82px;"
				class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}


	<%@ include file="../homeFoot.jsp"%>

</body>
</html>
