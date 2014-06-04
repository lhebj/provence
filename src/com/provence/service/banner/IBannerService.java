package com.provence.service.banner;

import java.util.List;

import com.provence.pojo.Banner;
import com.provence.web.dto.BannerDTO;

public interface IBannerService {

	public void saveOrUpdateBanner(Banner banner);
	
	public Banner findBannerById(Long id);
	
	public void deleteBanner(Banner banner);
	
	public List<BannerDTO> getRandomBannerList (int limit); 
}
