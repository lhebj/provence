package com.provence.service.content;

import com.provence.pojo.Content;

public interface IContentService {

	public void saveOrUpdateContent(Content content);
	
	public Content findContentDetailById(Long id);
	
	public void deleteContent(Content content);
}
