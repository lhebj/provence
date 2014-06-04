<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div id="banner-slides">
	<c:forEach items="${bannerDtoList}" var="bannerDto">
		<div class="banner">
			<img src="${bannerDto.path}"></img>
		</div>
	</c:forEach>
</div>