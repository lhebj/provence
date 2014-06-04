package com.provence.service.news.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.INewsVideoDAO;
import com.provence.pojo.NewsVideo;
import com.provence.service.news.INewsVideoService;

@Service(value = "newsVideoService")
public class NewsVideoServiceImpl implements INewsVideoService {

	@Resource
	private INewsVideoDAO newsVideoDAO;
	
	@Override
	public void saveOrUpdateNewsVideo(NewsVideo newsVideo) {
		// TODO Auto-generated method stub
		newsVideoDAO.saveOrUpdateNewsVideo(newsVideo);
	}

	@Override
	public NewsVideo findNewsVideoById(Long id) {
		// TODO Auto-generated method stub
		return newsVideoDAO.findNewsVideoDetailById(id);
	}

	@Override
	public void deleteNewsVideo(NewsVideo newsVideo) {
		// TODO Auto-generated method stub
		newsVideoDAO.deleteNewsVideo(newsVideo);
	}
	
	public void deleteNewsVideoById(Long id){
		newsVideoDAO.deleteNewsVideoById(id);
	}

	@Override
	public List<NewsVideo> getNewsVideoList(int start, int limit) {
		// TODO Auto-generated method stub
		return newsVideoDAO.getNewsVideoList(start, limit);
	}

}
