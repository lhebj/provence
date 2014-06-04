package com.provence.service.content.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IContentDAO;
import com.provence.pojo.Content;
import com.provence.service.content.IContentService;

@Service(value = "contentService")
public class ContentServiceImpl implements IContentService {

	@Resource
	private IContentDAO contentDAO;
	
	@Override
	public void saveOrUpdateContent(Content content) {
		// TODO Auto-generated method stub
		contentDAO.saveOrUpdateContent(content);
	}

	@Override
	public Content findContentDetailById(Long id) {
		// TODO Auto-generated method stub
		return contentDAO.findContentDetailById(id);
	}

	@Override
	public void deleteContent(Content content) {
		// TODO Auto-generated method stub
//		FileUtil.
		
		contentDAO.deleteContent(content);
	}

}
