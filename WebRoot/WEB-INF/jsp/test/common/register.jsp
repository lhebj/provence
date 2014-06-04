<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.provence.web.util.WebUtil, com.provence.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script id="register-tmpl" type="text/tmpl">
<div class="mask-level"></div>
				<div id="mask" class="mask clearfix">
					<div class="close"></div>
					<div class="register"><%=LocalizationUtil.getClientString("Register.info.button", request) %></div>
					<div class="mask-left">
						<h3 class="mask-title"><%=LocalizationUtil.getClientString("Register", request) %></h3>
						<ul>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("sex", request) %></p>
								<input class="sex" type="radio" name="sex" value="male" /><span class="sex-info"><%=LocalizationUtil.getClientString("sex-male", request) %></span>
								<input class="sex" type="radio" name="sex" value="female" /><span class="sex-info"><%=LocalizationUtil.getClientString("sex-female", request) %></span>
							</li>
							<li class="form-item special-form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("username", request) %><span class="star">*</span></p>
								<input class="form-item-content" type="text" name="username" style="margin-right:10px" />
								<p class="user-error-message error-message"><%=LocalizationUtil.getClientString("Register.username-validation.exist", request) %></p><p class="user-success-message success-message"><%=LocalizationUtil.getClientString("Register.username-validation.available", request) %></p>
							</li>
							<li class="form-item special-form-item clearfix">
								<p class="form-item-title"></p>
								<p class="special-form-item-content form-item-content"><%=LocalizationUtil.getClientString("Register.username-validation", request) %></p>
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("email", request) %><span class="star">*</span></p>
								<input class="form-item-content" type="text" name="email" style="margin-right:10px" />
								<p class="email-error-message error-message"><%=LocalizationUtil.getClientString("Register.email-validation.exist", request) %></p><p class="email-success-message success-message"><%=LocalizationUtil.getClientString("Register.email-validation.available", request) %></p>
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("birthday", request) %></p>
								<select name="year" class="date-select year-select">
									<option value=""></option>
								</select>
								<select name="month" class="date-select month-select">
									<option value=""></option>
								</select>
								<select name="day" class="date-select day-select">
									<option value=""></option>
								</select>
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("mobile", request) %></p>
								<input class="form-item-content" type="text" name="mobile" />
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("address", request) %></p>
								<input class="form-item-content" type="text" name="address" />
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("zipcode", request) %></p>
								<input class="form-item-content" type="text" name="zipcode" />
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("city", request) %></p>
								<input class="form-item-content" type="text" name="city" />
							</li>
							<li class="form-item clearfix">
								<p class="form-item-title"><%=LocalizationUtil.getClientString("country", request) %></p>
								<input class="form-item-content" type="text" name="country" />
								<span class="memo"><%=LocalizationUtil.getClientString("Register.info.star", request) %></span>
							</li>
						</ul>
					</div>
					<div class="mask-right">
						<!-- <%=LocalizationUtil.getClientString("Register.info-0", request) %><br/> -->
						<%=LocalizationUtil.getClientString("Register.info-1", request) %><br/>
						<br/>
						<%=LocalizationUtil.getClientString("Register.info-2", request) %><br/>
						<%=LocalizationUtil.getClientString("Register.info-3", request) %><br/>
						<%=LocalizationUtil.getClientString("Register.info-4", request) %><br/>
						<!-- <%=LocalizationUtil.getClientString("Register.info-5", request) %><br/> -->
					</div>
				</div>
</script>