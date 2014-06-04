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

<title>普罗旺斯</title>
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
		<c:choose>
			<c:when test="${type =='intro'}">
				<h1>普罗旺斯简介</h1>
			</c:when>
			<c:otherwise>
				<a href="admin.do?action=manageIntoProvence&type=intro">普罗旺斯简介</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${type =='color'}">
				<h1>
					普罗旺斯的色</font>
				</h1>
			</c:when>
			<c:otherwise>
				<a href="admin.do?action=manageIntoProvence&type=color">普罗旺斯的色</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${type =='smell'}">
				<h1>普罗旺斯的香</h1>
			</c:when>
			<c:otherwise>
				<a href="admin.do?action=manageIntoProvence&type=smell">普罗旺斯的香</a>

			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${type =='taste'}">
				<h1>普罗旺斯的味</h1>
			</c:when>
			<c:otherwise>
				<a href="admin.do?action=manageIntoProvence&type=taste">普罗旺斯的味</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${type =='quality'}">
				<h1>普罗旺斯的质</h1>
			</c:when>
			<c:otherwise>
				<a href="admin.do?action=manageIntoProvence&type=quality">普罗旺斯的质</a>
			</c:otherwise>
		</c:choose>
	</div>


	<div>
		<h3>小故事</h3><b>${intoProvenceStoryDTO.storyInps}</b>
	</div>
	<div>
		<a
			href="admin.do?action=postIntoProvenceStroy&id=${intoProvenceStoryDTO.idInps}&type=${type}">编辑小故事</a>
	</div>
	
	<h1></h1>	
	
	<div>
		<a href="admin.do?action=postIntoProvence&type=${type}"><button
				style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"	style="width:100%;">
		<thread>
		<tr>
			<td style="width:200px;">图片</td>
			<td style="width:100px;">内容</td>
			<td style="width:30px;">发布时间</td>
			<td style="width:50px;">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${intoProvenceDtoList}" var="intoProvenceDto">
				<tr>
					<td><img src="${intoProvenceDto.path}"></img></td>
					<td>${intoProvenceDto.contentInp}</td>
					<td>${intoProvenceDto.dateCreateInp}</td>
					<td><a
						href="admin.do?action=postIntoProvence&id=${intoProvenceDto.idInp}&type=${type}"><button style="width: 82px;"
				class="btn btn-primary" type="button">编辑</button></a>
						<a href="intoProvenceAdmin.do?action=delete&id=${intoProvenceDto.idInp}"  onclick="javascript:return del_sure()"><button style="width: 82px;"
				class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}


	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
