package com.provence.service.banner.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IBannerDAO;
import com.provence.pojo.Banner;
import com.provence.service.banner.IBannerService;
import com.provence.web.dto.BannerDTO;


@Service(value = "bannerService")
public class BannerServiceImpl implements IBannerService {
	

	@Resource
	private IBannerDAO bannerDAO;

	@Override
	public void saveOrUpdateBanner(Banner banner) {
		// TODO Auto-generated method stub
		bannerDAO.saveOrUpdateBanner(banner);
	}

	@Override
	public Banner findBannerById(Long id) {
		// TODO Auto-generated method stub
		return bannerDAO.findBannerById(id);
	}

	@Override
	public void deleteBanner(Banner banner) {
		// TODO Auto-generated method stub
		bannerDAO.deleteBanner(banner);
	}

	@Override
	public List<BannerDTO> getRandomBannerList(int limit) {
		// TODO Auto-generated method stub
		List<Banner> list = bannerDAO.getRandomBannerList(limit);
		List<BannerDTO> dtoList = new ArrayList<BannerDTO>();
		for(Banner banner: list){
			dtoList.add(banner.toDTO());
		}
		return dtoList;
	}

}
