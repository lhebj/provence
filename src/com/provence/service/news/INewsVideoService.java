package com.provence.service.news;

import java.util.List;

import com.provence.pojo.NewsVideo;

public interface INewsVideoService {

	public void saveOrUpdateNewsVideo(NewsVideo newsVideo);
	
	public NewsVideo findNewsVideoById(Long id);
	
	public void deleteNewsVideo(NewsVideo newsVideo);
	
	public void deleteNewsVideoById(Long id);
	
	public List<NewsVideo> getNewsVideoList (int start, int limit);
	
	
}
