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
		<h1>添加分类 </h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="categoryAdmin.do?action=save">
		<input name="id" type="hidden" value="${categoryDTO.idCat}" />
		<table>
			<tr>
				<td width='60'>品牌名</td>
				<td><input name="brandId" type="hidden"
					value="${brandDTO.idBrd}" /> ${brandDTO.nameBrd}</td>
			</tr>
			<tr>
				<td width='60'>分类名</td>
				<td><input name="nameCat" type="text" style="width:400px;height:30px"
					value="${categoryDTO.nameCat}" /></td>
			</tr>
			<tr>
				<td width='60'></td>
				<td><input class="btn btn-primary" name="ok" type="submit"
					value="提交"> <input type="button" value="取消" class="btn"
					onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</FORM>
	
	<%@ include file="../homeFoot.jsp" %>
</body>
</html>
