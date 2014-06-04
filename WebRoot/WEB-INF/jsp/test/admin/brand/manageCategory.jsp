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
		<h1>分类管理</h1>
		<h3>所属品牌： ${brandDTO.nameBrd}</h3>
	</div>
	<div>
		<a href="admin.do?action=postCategory&brandId=${brandDTO.idBrd}"><button style="width: 82px;"
				class="btn btn-primary" type="button">添加分类</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td width="100">分类名</td>
			<td width="40">操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${categoryDTOList}" var="categoryDTO">
				<tr>
					<td>${categoryDTO.nameCat}</td>
					<td><a
						href="admin.do?action=postCategory&id=${categoryDTO.idCat}&brandId=${brandDTO.idBrd}"><button
								style="width: 82px;" class="btn btn-primary" type="button">编辑</button></a>
						<a href="categoryAdmin.do?action=delete&id=${categoryDTO.idCat}"  onclick="javascript:return del_sure()"><button
								style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						<a
						href="admin.do?action=manageProduct&categoryId=${categoryDTO.idCat}"><button
								style="width: 82px;" class="btn btn-primary" type="button">产品管理</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
       
    <%@ include file="../homeFoot.jsp" %>
  </body>
</html>
