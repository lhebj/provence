<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="common/common.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站正在建设中</title>
</head>


<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="100%" align="center" valign="middle">
				<table width="578" height="228" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center" background="images/construction.gif"
							style="padding-left:70px;padding-top:20px;">
						<br /> <%=LocalizationUtil.getClientString("Cover.construction", request) %><br />
						<br /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
