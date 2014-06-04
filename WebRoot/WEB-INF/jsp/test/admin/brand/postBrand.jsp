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
														visible : true
													},
													superscript : {
														visible : true
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

													h4 : {
														visible : true,
														className : 'h4',
														command : ($.browser.msie || $.browser.safari) ? 'formatBlock'
																: 'heading',
														arguments : ($.browser.msie || $.browser.safari) ? '<h4>'
																: 'h4',
														tags : [ 'h4' ],
														tooltip : 'Header 4'
													},
													h5 : {
														visible : true,
														className : 'h5',
														command : ($.browser.msie || $.browser.safari) ? 'formatBlock'
																: 'heading',
														arguments : ($.browser.msie || $.browser.safari) ? '<h5>'
																: 'h5',
														tags : [ 'h5' ],
														tooltip : 'Header 5'
													},
													h6 : {
														visible : true,
														className : 'h6',
														command : ($.browser.msie || $.browser.safari) ? 'formatBlock'
																: 'heading',
														arguments : ($.browser.msie || $.browser.safari) ? '<h6>'
																: 'h6',
														tags : [ 'h6' ],
														tooltip : 'Header 6'
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
		<h1>添加或编辑品牌</h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="brandAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<input name="id" type="hidden" value="${brandDetailDTO.idBrd}" />
		<table>
			<tr>
				<td width='60'>品牌名称</td>
				<td><input name="nameBrd" type="text"
					style="width:900px;height:30px" value="${brandDetailDTO.nameBrd}" /></td>
			</tr>
			<tr>
				<td width='60'>品牌介绍</td>
				<td height='400'><textarea id="wysiwyg"
						style="width:900px;height:600px" name="introductionBrdd">${brandDetailDTO.introductionBrdd}</textarea></td>
			</tr>
			<tr>
				<td width='60'>新产品推荐</td>
				<td><input name="newproductnameBrdd" type="text"
					style="width:900px;height:30px"
					value="${brandDetailDTO.newproductnameBrdd}" /></td>
			</tr>
			<tr>
				<td width='60'>logo图片</td>
				<td><input name="logo" type="FILE" id="logo" size="50" /></td>
			</tr>
			<tr>
				<td width='60'>新产品图片1</td>
				<td><input name="newProductPic1" type="FILE"
					id="newProductPic1" size="50" /></td>
			</tr>
			<!-- 
			<tr>
				<td width='60'>新产品图片2</td>
				<td><input name="newProductPic2" type="FILE"
					id="newProductPic2" size="50" /></td>
			</tr>
 			-->
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
