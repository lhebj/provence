package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.INewsInfoDAO;
import com.provence.pojo.NewsInfo;

@Repository("newsInfoDAO")
public class NewsInfoDAOImpl implements INewsInfoDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateNewsInfo(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(newsInfo);
	}

	@Override
	public NewsInfo findNewsInfoById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(NewsInfo.class, id);
	}

	@Override
	public void deleteNewsInfo(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(newsInfo);
	}
	
	@Override
	public void deleteNewsInfoById(Long id){
		String sql = " delete from pro_newsinfo_nsi where id_nsi=:id_nsi";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_nsi", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<NewsInfo> getNewsInfoList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from NewsInfo order by idNsi desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
	
	@Override
	public int getNewsInfoTotalCount(){
		String hql = " from NewsInfo";
		return basicHibernateDao.getTotalCount(hql);
	}

}
