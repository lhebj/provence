package com.provence.dao.hibernate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBannerDAO;
import com.provence.dao.IBasicHibernateDAO;
import com.provence.pojo.Banner;

@Repository("bannerDAO")
public class BannerDAOImpl implements IBannerDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateBanner(Banner banner) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(banner);
	}

	@Override
	public Banner findBannerById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Banner.class, id);
	}

	@Override
	public void deleteBanner(Banner banner) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(banner);
	}

	@Override
	public List<Banner> getRandomBannerList(int limit) {
		// TODO Auto-generated method stub
		String hql = " from Banner order by rand() ";
		return basicHibernateDao.getResultList(0, limit, hql);
	}

}
