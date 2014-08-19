<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.HashMap" %>
<%
	String version = "201406140214";
	String PATH = request.getContextPath();
	String BASE_Path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+PATH+"/";

	String debug = request.getParameter("debug"); 
	String STATIC_PATH = BASE_Path + "static/";
	String CSS_PATH = STATIC_PATH + "stylecss_optimize/";
	String JS_PATH = STATIC_PATH + "js_optimize/";
	
	if(debug != null && debug.equals("true")){
	 	CSS_PATH = STATIC_PATH + "src_css/";
	 	JS_PATH = STATIC_PATH + "src_js/";
	}
	
	String IMAGE_PATH = STATIC_PATH + "image/";
	HashMap<String,String> navBar = new HashMap<String, String>();
	navBar.put("news", "");
	navBar.put("brand", "");
	navBar.put("aimeBio", "");
	navBar.put("intoProvence", "");
	navBar.put("fraBioAuth", "");
	navBar.put("contact", "");
	
%>
