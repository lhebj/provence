package com.provence.service.news.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.INewsInfoDAO;
import com.provence.pojo.NewsInfo;
import com.provence.service.news.INewsInfoService;

@Service(value = "newsInfoService")
public class NewsInfoServiceImpl implements INewsInfoService {

	@Resource
	private INewsInfoDAO newsInfoDAO;
	
	@Override
	public void saveOrUpdateNewsInfo(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		newsInfoDAO.saveOrUpdateNewsInfo(newsInfo);
	}

	@Override
	public NewsInfo findNewsInfoById(Long id) {
		// TODO Auto-generated method stub
		return newsInfoDAO.findNewsInfoById(id);
	}

	@Override
	public void deleteNewsInfo(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		newsInfoDAO.deleteNewsInfo(newsInfo);
	}
		
	@Override
	public void deleteNewsInfoById(Long id){
		newsInfoDAO.deleteNewsInfoById(id);
	}

	@Override
	public List<NewsInfo> getNewsInfoList(int start, int limit) {
		// TODO Auto-generated method stub
		return newsInfoDAO.getNewsInfoList(start, limit);
	}

	@Override
	public int getNewsInfoTotalCount(){
		return newsInfoDAO.getNewsInfoTotalCount();
	}
}
