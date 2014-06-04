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
							$('#wysiwyg_zh')
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

<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#wysiwyg_en')
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

<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#wysiwyg_fr')
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

  </head>
  
  <body>
 <%@ include file="../homeHead.jsp" %>
  
	<div class="page-header">
		<h1><c:if test="${type =='AimeBio'}">发布 关于AimeBio</c:if>
    	<c:if test="${type =='FraBioAuth'}">发布 法国Bio认证 </c:if></h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="bioAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<input name="id" type="hidden" value="${bioDto.idBio}" />
    	<input name="typeBio" type="hidden" value="${type}" />
		<table>
			<tr>
				<td width='60'>中文标题</td>
				<td ><input name="titleBio" type="text" style="width:900px;height:30px"
					value="${bioDto.titleBio}" /></td>
			</tr>
			<tr>
				<td width='60'>英文标题</td>
				<td ><input name="titleEnBio" type="text" style="width:900px;height:30px"
					value="${bioDto.titleEnBio}" /></td>
			</tr>
			<tr>
				<td width='60'>法文标题</td>
				<td ><input name="titleFrBio" type="text" style="width:900px;height:30px"
					value="${bioDto.titleFrBio}" /></td>
			</tr>
			<tr>
				<td width='60'>中文内容</td>
				<td height='200'><textarea id="wysiwyg_zh" style="width:900px;height:200px"
						name="contentBio" >${bioDto.contentBio}</textarea></td>
			</tr>
			<tr>
				<td width='60'>英文内容</td>
				<td height='200'><textarea id="wysiwyg_en" style="width:900px;height:200px"
						name="contentEnBio" >${bioDto.contentEnBio}</textarea></td>
			</tr>
			<tr>
				<td width='60'>法文内容</td>
				<td height='200'><textarea id="wysiwyg_fr" style="width:900px;height:200px"
						name="contentFrBio" >${bioDto.contentFrBio}</textarea></td>
			</tr>
			<tr>
				<td width='60'>图片</td>
				<td ><input name="FILE" type="FILE" id="file"
					size="50"></td>
			</tr>
			<tr>
				<td width='60'>图片位置</td>
				<td >
				<c:if test="${bioDto.picPlaceBio=='left'}">
				<input type="radio" name="picPlaceBio" value="left" checked="checked">左边 | <input type="radio" name="picPlaceBio" value="right">右边
				</c:if>
				<c:if test="${bioDto.picPlaceBio=='right'}">
				<input type="radio" name="picPlaceBio" value="left">左边 | <input type="radio" name="picPlaceBio" value="right" checked="checked">右边
				</c:if>
				</td>
			</tr>

			<tr>
				<td width='60'></td>
				<td><input class="btn btn-primary" name="ok"
					type="submit" value="提交"> <input type="button" value="取消"
					class="btn" onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</form>
	
	<%@ include file="../homeFoot.jsp" %>
  </body>
</html>
