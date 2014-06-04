<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
Integer httpStatusCode = (Integer)request.getAttribute("httpStatusCode");
if(httpStatusCode == null || httpStatusCode != response.SC_INTERNAL_SERVER_ERROR){
	response.setStatus(response.SC_NOT_FOUND);
}
%>
<input type="hidden" name="basePath" id="basePath" value="<%=basePath%>"></input>
<input type="hidden" name="redirectUrl" id="redirectUrl" value="${redirectUrl}"></input>
    您访问的页面不存在. <br>
    
<script>
setTimeout(function() {
	var basePath = document.getElementById("basePath").value;
	var redirectUrl = document.getElementById("redirectUrl").value;
	if(redirectUrl){
		window.location.href = redirectUrl;
	}else{
		window.location.href = basePath;
	}
}, 3000);
</script>
  </body>
</html>
