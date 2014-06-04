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
		<h1>品牌管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postBrand"><button style="width: 82px;"
				class="btn btn-primary" type="button">添加品牌</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td width="100">品牌名</td>
			<td width="200">品牌logo</td>
			<td width="40">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${brandLogoDTOList}" var="brandLogoDto">
				<tr>
					<td><a href="brand.do?action=detail&id=${brandLogoDto.idBrd}">${brandLogoDto.nameBrd}</a></td>
					<td><a href="brand.do?action=detail&id=${brandLogoDto.idBrd}"><img
							src="${brandLogoDto.logoPath}"></img></a></td>
					<td><a
						href="admin.do?action=postBrand&id=${brandLogoDto.idBrd}"><button
								style="width: 82px;" class="btn btn-primary" type="button">编辑</button></a>
						<a href="brandAdmin.do?action=delete&id=${brandLogoDto.idBrd}"  onclick="javascript:return del_sure()"><button
								style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						<a
						href="admin.do?action=manageCategory&brandId=${brandLogoDto.idBrd}"><button
								style="width: 82px;" class="btn btn-primary" type="button">分类管理</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
