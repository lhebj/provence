<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String nav_lang_class = "";
	if(Locale.FRANCE.equals(LocalizationUtil.getLocale(request))){
		nav_lang_class = "frence_nav";
	}
%>
<div class="head">
				<div class="head-logo clearfix">
					<a class="logo" href="index.do"></a>
					<div class="head-right head-func">
						<a href="javascript:register_show();"><%=LocalizationUtil.getClientString("Register", request) %></a>
						<span class="language">
							<a href="switchLan.do?lan=zh"><img src="<%=IMAGE_PATH %>china.png" /></a>
							<a href="switchLan.do?lan=fr"><img src="<%=IMAGE_PATH %>france.png" /></a>
							<a href="switchLan.do?lan=en"><img src="<%=IMAGE_PATH %>english.png" /></a>
						</span>
					</div>
				</div>
				<div class="head-nav clearfix">
					<div class="head-left">
						<ul class="head-nav-container clearfix">
							<li class="">
								<a class='head-nav-item <%=navBar.get("news") %> <%=nav_lang_class%> ' href="news.do">
									<%=LocalizationUtil.getClientString("Nav.news", request) %>
								</a>
							</li>
							<li class="">
								<a class='head-nav-item <%=navBar.get("brand") %> <%=nav_lang_class%> ' href="brand.do?action=list">
									<%=LocalizationUtil.getClientString("Nav.brand", request) %>
								</a>
							</li>
							<li class="">
								<a class='head-nav-item <%=navBar.get("aimeBio") %> <%=nav_lang_class%> ' href="aimeBio.do">
									<%=LocalizationUtil.getClientString("Nav.aboutAimeBio", request) %>
								</a>
							</li>
							<li class="">
								<a class='head-nav-item <%=navBar.get("intoProvence") %> <%=nav_lang_class%> ' href="intoProvence.do?action=intro">
									<%=LocalizationUtil.getClientString("Nav.intoProvence", request) %>
								</a>
							</li>
							<li class="">
								<a class='head-nav-item <%=navBar.get("fraBioAuth") %> <%=nav_lang_class%> ' href="fraBioAuth.do">
									<%=LocalizationUtil.getClientString("Nav.franceBioAuth", request) %>
								</a>
							</li>
							<li class="">
								<a class='head-nav-item <%=navBar.get("contact") %> last-item <%=nav_lang_class%> ' href="contactus.do">
									<%=LocalizationUtil.getClientString("Nav.contact", request)%>
								</a>
							</li>
						</ul>
					</div>
					<div class="head-right search-container">
						<form name="form1" METHOD="POST" ACTION="product.do?action=list">
							<input class="search-area" type="text" name="wd" value="${wd}" />
							<input class="search-logo" name="ok" type= "submit" value=""/>
		
						</form>
					</div>
				</div>
			</div>
			<%@ include file="common/register.jsp" %>