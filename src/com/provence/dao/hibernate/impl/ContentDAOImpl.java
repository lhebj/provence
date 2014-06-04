package com.provence.dao.hibernate.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IContentDAO;
import com.provence.pojo.Content;


@Repository("contentDAO")
public class ContentDAOImpl implements IContentDAO {
	
	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateContent(Content content) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(content);
	}

	@Override
	public Content findContentDetailById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Content.class, id);
	}

	@Override
	public void deleteContent(Content content) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(content);
	}

}
