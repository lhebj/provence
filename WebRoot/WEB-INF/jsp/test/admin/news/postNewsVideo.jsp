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
		<h1>发布资讯视频</h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="newsVideoAdmin.do?action=save">
		<input name="id" type="hidden" value="${newsVideoDto.idNsv}" />
		<table>
			<tr>
				<td width='60'>标题</td>
				<td><input name="titleNsv" type="text" style="width:400px;height:30px"
					value="${newsVideoDto.titleNsv}" /></td>
			</tr>
			<tr id="showPlaycode">
				<td width='60'>视频代码(width=600,height=340)</td>
				<td><textarea style="width:400px;height:200px"
						name="playcodeNsv">${newsVideoDto.playcodeNsv}</textarea></td>
			</tr>
			<tr>
				<td width='60'></td>
				<td><input class="btn btn-primary" name="ok" type="submit"
					value="提交"> <input type="button" value="取消" class="btn"
					onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</FORM>

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
