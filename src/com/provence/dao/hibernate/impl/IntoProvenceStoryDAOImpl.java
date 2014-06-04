package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IIntoProvenceStoryDAO;
import com.provence.pojo.IntoProvenceStory;

@Repository("intoProvenceStoryDAO")
public class IntoProvenceStoryDAOImpl implements IIntoProvenceStoryDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateIntoProvenceStory(IntoProvenceStory intoProvenceStory) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(intoProvenceStory);
	}

	@Override
	public IntoProvenceStory findIntoProvenceStoryById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(IntoProvenceStory.class, id);
	}

	@Override
	public void deleteIntoProvenceStory(IntoProvenceStory intoProvenceStory) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(intoProvenceStory);
	}

	@Override
	public void deleteIntoProvenceStoryById(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_intoprovence_story_inps where id_inps=:id_inps";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_inps", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<IntoProvenceStory> getIntoProvenceStoryList(int start, int limit, String typeInps) {
		// TODO Auto-generated method stub
		String hql = " from IntoProvenceStory where typeInps=:typeInps order by idInps desc ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeInps", typeInps);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getIntoProvenceStoryTotalCount(String typeInps) {
		// TODO Auto-generated method stub
		String hql = " from IntoProvenceStory where typeInps=:typeInps";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeInps", typeInps);
		return basicHibernateDao.getTotalCount(hql, param);
	}

}
