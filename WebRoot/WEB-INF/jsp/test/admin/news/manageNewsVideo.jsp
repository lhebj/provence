<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil,com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <%@ include file="../homeHead.jsp" %>
  
    
	<div class="page-header">
		<h1>资讯视频管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postNewsVideo"><button
				style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td width="100">标题</td>
			<td width="200">视频</td>
			<td width="40">发布时间</td>
			<td width="40">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${newsVideoDtoList}" var="newsVideoDto">
				<tr>
					<td>${newsVideoDto.titleNsv}</td>
					<td>${newsVideoDto.playcodeNsv}</td>
					<td>${newsVideoDto.dateCreateNsv}</td>
					<td><a
						href="admin.do?action=postNewsVideo&id=${newsVideoDto.idNsv}"><button style="width: 82px;"
				class="btn btn-primary" type="button">编辑</button></a>
						<a href="newsVideoAdmin.do?action=delete&id=${newsVideoDto.idNsv}"  onclick="javascript:return del_sure()"><button style="width: 82px;"
				class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
    
    
    <%@ include file="../homeFoot.jsp" %>
  </body>
</html>
