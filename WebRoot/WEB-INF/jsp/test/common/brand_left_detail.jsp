<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" import="com.provence.web.util.ParamUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<ul class="brand">
	<li><a class="brand-item" href="brand.do?action=list"><span>品牌</span></a></li>
	<c:forEach items="${brandDTOList}" var="brandDto">
		<li><c:if test="${brandDto.idBrd == currentBrandId}"
				var="selectBrd">
				<span class='brand-item selected'> <span><a href="brand.do?action=detail&id=${brandDto.idBrd}"> ${brandDto.nameBrd}</a></span>
				</span>
			</c:if> <c:if test="${brandDto.idBrd != currentBrandId }">
				<a class='brand-item'
					href="brand.do?action=detail&id=${brandDto.idBrd}"> <span>${brandDto.nameBrd}</span>
				</a>
			</c:if>
			<ul class="cat ${selectBrd ? 'cat-selected':'' }">
				<c:forEach items="${brandDto.categoryDTOList}" var="categoryDto">
					<li><c:if test="${categoryDto.idCat == currentCategoryId}"
							var="selectCat">
							<span class="cat-item ${selectCat ? 'selected':'' }">								
								<span><a href="brand.do?action=detail&id=${brandDto.idBrd}&categoryId=${categoryDto.idCat}">${categoryDto.nameCat}</a></span>
							</span>
						</c:if> <c:if test="${categoryDto.idCat != currentCategoryId}"
							var="selectCat">
							<a class="cat-item"
								href="brand.do?action=detail&id=${brandDto.idBrd}&categoryId=${categoryDto.idCat}"> <span>${categoryDto.nameCat}</span>
							</a>
						</c:if></li>
				</c:forEach>
			</ul></li>

	</c:forEach>
</ul>
<div class="shopping-wrapper">
	<ul class="shopping">
		<li class="shopping-item"><a href="http://weibo.com/AimeBio"><img
				src="<%=IMAGE_PATH%>sina.png" /></a></li>
		<li class="shopping-item"><a href="http://blog.sina.com.cn/u/5109575066"><img src="<%=IMAGE_PATH %>blognew.png" /></a></li>
	</ul>
</div>

<div class="shopping-wrapper">
	<ul class="shopping">
		<li class="shopping-item"><a href="http://shop111875235.taobao.com/?spm=a230r.7195193.1997079397.20.hE2MtH"><img src="<%=IMAGE_PATH%>shop-taobao.png" /></a></li>
		<li class="shopping-item"><a href="http://www.nnkou.com/plws.html"><img src="<%=IMAGE_PATH%>shop-nnkou.png" /></a><li>
		<li class="shopping-item"><a href="http://www.ujipin.com/s-k%E9%98%B3%E5%85%89%E6%99%AE%E7%BD%97%E6%97%BA%E6%96%AF-c0.html"><img src="<%=IMAGE_PATH%>shop-ujipin.png" /></a><li>
		<!--  <li class="shopping-item"><a href="javascript:;"></a></li> -->
	</ul>
</div>

<!-- 
<div>
	<img src="<%=IMAGE_PATH%>sale.png" />
</div>
 -->