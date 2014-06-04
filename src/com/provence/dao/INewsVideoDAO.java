package com.provence.dao;

import java.util.List;

import com.provence.pojo.NewsVideo;

public interface INewsVideoDAO {

	public void saveOrUpdateNewsVideo(NewsVideo newsVideo);
	
	public NewsVideo findNewsVideoDetailById(Long id);
	
	public void deleteNewsVideo(NewsVideo newsVideo);
	
	public void deleteNewsVideoById(Long id);
		
	public List<NewsVideo> getNewsVideoList (int start, int limit); 
}
