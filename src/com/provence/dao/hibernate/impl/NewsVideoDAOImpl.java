package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.INewsVideoDAO;
import com.provence.pojo.NewsVideo;

@Repository("newsVideoDAO")
public class NewsVideoDAOImpl implements INewsVideoDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateNewsVideo(NewsVideo newsVideo) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(newsVideo);
	}

	@Override
	public NewsVideo findNewsVideoDetailById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(NewsVideo.class, id);
	}

	@Override
	public void deleteNewsVideo(NewsVideo newsVideo) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(newsVideo);
	}
	
	@Override
	public void deleteNewsVideoById(Long id){
		String sql = " delete from pro_newsvideo_nsv where id_nsv=:id_nsv";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_nsv", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<NewsVideo> getNewsVideoList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from NewsVideo order by idNsv desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}

}
