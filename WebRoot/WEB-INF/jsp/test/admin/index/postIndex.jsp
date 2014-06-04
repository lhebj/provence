<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil,com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<h1>添加首页图片</h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="indexAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<table>
			<tr>
				<td width='60'></td>
				<td><input type="radio" name="typeIdx" value="pic"
					checked="checked"/>图片 | 
					<input type="radio" name="typeIdx"	value="video" onclick="document.getElementById('showPlaycode').style.display='';document.getElementById('showImageUpload').style.display='none';" />视频</td>
			</tr>
			<tr id="showPlaycode" style="display:none;">
				<td width='60'>视频代码(width=968,height=515)</td>
				<td><textarea style="width:400px;height:200px"
						name="playcodeIdx"></textarea></td>
			</tr>
			<tr>
				<td width='60'>选择上传图片</td>
				<td><input name="attach1" type="FILE" id="attach1" size="50"></td>
			</tr>

			<tr>
				<td width='60'></td>
				<td><input class="btn btn-primary" name="ok" type="submit"
					value="提交"> <input type="button" value="取消" class="btn"
					onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</form>

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
