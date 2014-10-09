<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=LocalizationUtil.getClientString("Titel.index", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body>
 <%@ include file="head.jsp" %>
  
    <br>    
    <table>
    <FORM name="form1" METHOD="POST" ACTION="register.do">
    	<tr><td><%=LocalizationUtil.getClientString("username", request) %>： <input name="username" type= "text" value="" /></td></tr>
    	<tr><td><%=LocalizationUtil.getClientString("sex", request) %>： <input type="radio" name="sex" value="male" checked="checked" /><%=LocalizationUtil.getClientString("sex-male", request) %>  
			<input type="radio" name="sex" value="female" /><%=LocalizationUtil.getClientString("sex-female", request) %> </td></tr>
		<tr><td><%=LocalizationUtil.getClientString("email", request) %>： <input name="email" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("birthday", request) %>： <input name="dateBirthday" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("mobile", request) %>： <input name="mobile" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("address", request) %>： <input name="address" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("zipcode", request) %>： <input name="zipcode" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("city", request) %>： <input name="city" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("country", request) %>： <input name="country" type= "text" value="" /></td></tr>
		
		<tr><td><input name="ok" type= "submit" value="提交"></td></tr>
	</form>
</table>
<%@ include file="common/baidutongji.jsp" %>
  </body>
</html>
