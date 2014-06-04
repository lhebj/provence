package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IIntoProvenceDAO;
import com.provence.pojo.IntoProvence;

@Repository("intoProvenceDAO")
public class IntoProvenceDAOImpl implements IIntoProvenceDAO {
	

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateIntoProvence(IntoProvence intoProvence) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(intoProvence);
	}

	@Override
	public IntoProvence findIntoProvenceById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(IntoProvence.class, id);
	}

	@Override
	public void deleteIntoProvence(IntoProvence intoProvence) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(intoProvence);
	}

	@Override
	public List<IntoProvence> getIntoProvenceList(int start, int limit, String typeInp) {
		// TODO Auto-generated method stub
		String hql = " from IntoProvence where typeInp=:typeInp order by idInp desc ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeInp", typeInp);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getIntoProvenceTotalCount(String typeInp) {
		// TODO Auto-generated method stub
		String hql = " from IntoProvence where typeInp=:typeInp";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeInp", typeInp);
		return basicHibernateDao.getTotalCount(hql, param);
	}

}
