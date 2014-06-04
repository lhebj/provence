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
    <br>
    <br>
    <div ><a href="admin.do?action=manageNewsInfo">资讯管理</a> | <a href="admin.do?action=manageNewsVideo">资讯视频管理</a> </div>
    
    
    <%@ include file="../homeFoot.jsp" %>
  </body>
</html>
