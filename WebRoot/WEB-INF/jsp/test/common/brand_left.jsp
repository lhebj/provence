<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ul class="brand">
	<li><a class="brand-item" href="javascript:;"><span>品牌</span></a></li>
	<c:forEach items="${brandDTOList}" var="brandDto">
		<li>
			<c:if var="selectBra" test="${ brandDto.nameBrd == pageScope.nameBrd}">
				<span class="brand-item selected" href="brand.do?action=detail&id=${brandDto.idBrd}"><span>${brandDto.nameBrd}</span></span>
			</c:if>
			<c:if var="selectBra" test="${ brandDto.nameBrd != pageScope.nameBrd}">
				<a class="brand-item" href="brand.do?action=detail&id=${brandDto.idBrd}"><span>${brandDto.nameBrd}</span></a>
			</c:if>
		</li>
	</c:forEach>
</ul>
<div class="shopping-wrapper">
	<ul class="shopping">
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>sina.png" /></a></li>
		<li class="shopping-item"><a href="http://blog.sina.com.cn/u/5109575066"><img src="<%=IMAGE_PATH %>blognew.png" /></a></li>
	</ul>
</div>
<!--
<div class="shopping-wrapper">
	<ul class="shopping">
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>sina.png" /></a></li>
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>qq.png" /></a></li>
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>tianmao.png" /></a></li>
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>refeng.png" /></a></li>
		<li class="shopping-item"><a href="javascript:;"><img src="<%=IMAGE_PATH %>jd.png" /></a></li>
		<li class="shopping-item"><a href="javascript:;"></a></li>
	</ul>
</div>

<div>
	<img src="<%=IMAGE_PATH %>sale.png" />
</div>
-->