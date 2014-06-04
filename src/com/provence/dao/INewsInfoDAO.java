package com.provence.dao;

import java.util.List;

import com.provence.pojo.NewsInfo;

public interface INewsInfoDAO {

	public void saveOrUpdateNewsInfo(NewsInfo newsInfo);
	
	public NewsInfo findNewsInfoById(Long id);
	
	public void deleteNewsInfo(NewsInfo newsInfo);
	
	public void deleteNewsInfoById(Long id);
	
	public List<NewsInfo> getNewsInfoList (int start, int limit); 
	
	public int getNewsInfoTotalCount();
}
