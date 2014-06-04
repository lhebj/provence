package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IIndexDAO;
import com.provence.pojo.Index;


@Repository("indexDAO")
public class IndexDAOImpl implements IIndexDAO {
	
	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateIndex(Index index) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(index);
	}

	@Override
	public Index findIndexDetailById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Index.class, id);
	}

	@Override
	public void deleteIndex(Index index) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(index);
	}

	@Override
	public List<Index> getRandomIndexList(int limit, String typeIdx) {
		// TODO Auto-generated method stub
		String hql = " from Index  where typeIdx=:typeIdx order by rand() ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeIdx", typeIdx);
		return basicHibernateDao.getResultList(0, limit, hql, param);
	}

}
