package com.provence.dao;

import com.provence.pojo.Content;

public interface IContentDAO {
	public void saveOrUpdateContent(Content content);
	
	public Content findContentDetailById(Long id);
	
	public void deleteContent(Content content);
}
