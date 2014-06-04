package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IBioDAO;
import com.provence.pojo.Bio;

@Repository("bioDAO")
public class BioDAOImpl implements IBioDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateBio(Bio bio) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(bio);
	}

	@Override
	public Bio findBioById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Bio.class, id);
	}

	@Override
	public void deleteBio(Bio bio) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(bio);
	}

	@Override
	public void deleteBioById(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_bio where id_bio=:id_bio";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_bio", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<Bio> getBioList(int start, int limit, String typeBio) {
		// TODO Auto-generated method stub
		String hql = " from Bio where typeBio=:typeBio order by idBio desc ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeBio", typeBio);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getBioTotalCount(String typeBio) {
		// TODO Auto-generated method stub
		String hql = " from Bio where typeBio=:typeBio";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeBio", typeBio);
		return basicHibernateDao.getTotalCount(hql, param);
	}

}
