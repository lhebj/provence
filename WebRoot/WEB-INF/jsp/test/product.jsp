<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.provence.web.dto.ProductDetailDTO" %>
<%@ include file="common/common.jsp" %>
<% 
navBar.put("brand", "selected"); 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="nameBrd" value="${productDetailDTO.brandDTO.nameBrd}" scope="page"></c:set>
<c:set var="nameCat" value="${productDetailDTO.categoryDTO.nameCat}" scope="page"></c:set>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${productDetailDTO.productDTO.namePrd}-<%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	
	<meta http-equiv="description" content="<c:out value="${seoDescription}" />">
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>reset.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>body.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>func.css?v=<%=version %>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>brand-detail.css?v=<%=version%>" />
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>register.css?v=<%=version%>" />
	<style type="text/css">
		body{
			background:url("<%=IMAGE_PATH%>/bg.jpg")  center 0;
		}
	</style>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.js"></script>
	<script type="text/javascript" src="<%=JS_PATH%>common/jquery.slides.js"></script>
  	<script type="text/javascript" src="<%=JS_PATH%>banner.js"></script>
  	<script type="text/javascript" src="<%=JS_PATH%>register.js"></script>
  	
  	<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body>
  <div class="main-section">
	  <%@ include file="head.jsp" %>
	   <div class="banner">
	  	<%@ include file="common/banner.jsp"%>
	  </div>
	<div class="main-nav clearfix">
		<div class="left-nav">
						
		</div>
		<div class="right-nav">
			<a href="brand.do?action=list">品牌</a>
			<span class="cat">&gt;</span>
			<a href="brand.do?action=detail&id=${productDetailDTO.brandDTO.idBrd}">${productDetailDTO.brandDTO.nameBrd}</a>
			<span class="cat">&gt;</span>
			<a href="brand.do?action=detail&id=${productDetailDTO.brandDTO.idBrd}&categoryId=${productDetailDTO.categoryDTO.idCat}">${productDetailDTO.categoryDTO.nameCat}</a>
			<span class="cat">&gt;</span>
			<a href="javascript:;">${productDetailDTO.productDTO.namePrd}</a>		
		</div>
	</div>
	<div class="main-content clearfix">
	  <div class="left-part">
	  	<%@ include file="common/brand_left_detail.jsp" %>
	  </div>
	  <div class="right-part">
	  	<div class="brand-show-wrapper clearfix">
					
				<div class="pic-containers">
						<div class="img-wrapper big-wrapper">
								<img src="${productDetailDTO.bigPicPath}" />
						</div>
						<div class="divi"></div>
						<ul class="small-pic-container clearfix">
								<li class="img-wrapper small-wrapper">
									<img src="${productDetailDTO.smallPic1Path}" />
								</li>
								<li class="hivi"></li>
								<li class="img-wrapper small-wrapper">
									<img src="${productDetailDTO.smallPic2Path}" />
								</li>
								<li class="hivi"></li>
								<li class="img-wrapper small-wrapper">
									<img src="${productDetailDTO.smallPic3Path}" />
								</li>
						</ul>
				</div>
						
				<div class="brand-desc-word">
						<h3 class="title">${productDetailDTO.productDTO.namePrd}</h3>
						<div class="brand-description">
								${productDetailDTO.descriptionPrd}
						</div>
				</div>
						
						
		</div>
	  
	  
	  <div class="introduce-use-container">
						<ul class="choose-use-contains clearfix">
							<li class="contains-choose"><a class="selected" data-relative="contains-item" href="javascript:;">产品成分</a></li>
							<li class="use-choose" ><a  data-relative="use-item" href="javascript:;">使用说明</a></li>
						</ul>
						<ul class="item-use-contains" id="variableatag">
							<li class="contains-item">
								${productDetailDTO.ingredientsPrd}
							</li>
							<li class="use-item" style="display:none;">
								${productDetailDTO.instructionsPrd}
							</li>
						</ul>
					</div>
	  
	  </div>
	</div>
	    <%@ include file="common/footer.jsp" %>
    </div>
    <script  src="<%=JS_PATH%>common/jquery.js"></script>
    <script>
		$(function(){
			$(".choose-use-contains").on('click', function(event){
									$('a', this).removeClass("selected");
									$(event.target).addClass("selected");
									var classItem = $(event.target).attr('data-relative');
									classItem = '.' + classItem;
									$(classItem).siblings().hide();
									$(classItem).show();
								});		
		});
	</script>
	<%@ include file="common/baidutongji.jsp" %>
  </body>
</html>
