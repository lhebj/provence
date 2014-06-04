package com.provence.web.upload;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.provence.pojo.Content;
import com.provence.pojo.Index;
import com.provence.service.index.IIndexService;


public class IndexUpLoadObject extends AbstractUploadObject {
	
	@Resource
	private IIndexService indexService;
	
	public String sourceType = "index";

	@Override
	public void upload(HttpServletRequest request, Content content) {
		// TODO Auto-generated method stub
		Index index = new Index();
		index.setDateCreateIdx(new Date());
		index.setPic(content);
		index.setTypeIdx(Index.TYPE_PIC);
		indexService.saveOrUpdateIndex(index);
	}

	@Override
	public String getSourceType() {
		// TODO Auto-generated method stub
		return sourceType;
	}

}
