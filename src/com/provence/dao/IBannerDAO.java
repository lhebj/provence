package com.provence.dao;

import java.util.List;

import com.provence.pojo.Banner;

public interface IBannerDAO {
	public void saveOrUpdateBanner(Banner banner);
	
	public Banner findBannerById(Long id);
	
	public void deleteBanner(Banner banner);
	
	public List<Banner> getRandomBannerList (int limit); 
}
