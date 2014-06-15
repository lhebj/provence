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
<link rel="stylesheet" type="text/css"
	href="assets/lib/blueprint/screen.css" media="screen, projection" />
<link rel="stylesheet" type="text/css"
	href="assets/lib/blueprint/print.css" media="print" />
<!--[if lt IE 8]><link rel="stylesheet" href="assets/lib/blueprint/ie.css" type="text/css" media="screen, projection" /><![endif]-->
<link rel="stylesheet" href="assets/css/jquery.wysiwyg.css"
	type="text/css" />
<script type="text/javascript" src="assets/lib/jquery.js"></script>
<script type="text/javascript" src="assets/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.image.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.link.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.table.js"></script>
<script type="text/javascript"
	src="assets/js/controls/bootstrap-wysiwyg.js"></script>
<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#wysiwyg')
									.wysiwyg(
											{
												controls : {
													bold : {
														visible : true
													},
													italic : {
														visible : true
													},
													underline : {
														visible : true
													},
													strikeThrough : {
														visible : true
													},

													justifyLeft : {
														visible : true
													},
													justifyCenter : {
														visible : true
													},
													justifyRight : {
														visible : true
													},
													justifyFull : {
														visible : true
													},

													indent : {
														visible : true
													},
													outdent : {
														visible : true
													},

													subscript : {
														visible : false
													},
													superscript : {
														visible : false
													},

													undo : {
														visible : true
													},
													redo : {
														visible : true
													},

													insertOrderedList : {
														visible : true
													},
													insertUnorderedList : {
														visible : true
													},
													insertHorizontalRule : {
														visible : true
													},

													cut : {
														visible : true
													},
													copy : {
														visible : true
													},
													paste : {
														visible : true
													},
													html : {
														visible : true
													},
													increaseFontSize : {
														visible : true
													},
													decreaseFontSize : {
														visible : true
													},
													exam_html : {
														exec : function() {
															this
																	.insertHtml('<abbr title="exam">Jam</abbr>');
															return true;
														},
														visible : true
													}
												},
												events : {
													click : function(event) {
														if ($("#click-inform:checked").length > 0) {
															event
																	.preventDefault();
															alert("You have clicked jWysiwyg content!");
														}
													}
												}
											});
						});
	})(jQuery);
</script>
<style type="text/css">
#wysiwyg {
	overflow: scroll;
	max-height: 300px;
	max-width: 1500px
}
</style>
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
		<h3>添加走进普罗旺斯</h3>
	</div>

	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="intoProvenceAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<input name="id" type="hidden" value="${intoProvenceDto.idInp}" />
    	<input name="typeInp" type="hidden" value="${type}" />
		<table>
			<tr>
				<td width='60'>图片</td>
				<td ><input name="FILE" type="FILE" id="file"
					size="50" /></td>
			</tr>
			<tr>
				<td width='60'>内容</td>
				<td><textarea id="wysiwyg" style="width:900px;height:600px"
						name="contentInp">${intoProvenceDto.contentInp}</textarea></td>
				</td>
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
