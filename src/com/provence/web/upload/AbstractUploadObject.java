package com.provence.web.upload;

import javax.servlet.http.HttpServletRequest;

import com.provence.pojo.Content;

public abstract class AbstractUploadObject {
	
	public abstract void upload(HttpServletRequest request, Content content);
	
	public abstract String getSourceType();
}
