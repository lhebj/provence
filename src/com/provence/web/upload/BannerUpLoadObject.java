package com.provence.web.upload;

import javax.servlet.http.HttpServletRequest;

import com.provence.pojo.Content;

public class BannerUpLoadObject extends AbstractUploadObject {

	public String sourceType = "banner";
	
	@Override
	public void upload(HttpServletRequest request, Content content) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSourceType() {
		// TODO Auto-generated method stub
		return null;
	}

}
