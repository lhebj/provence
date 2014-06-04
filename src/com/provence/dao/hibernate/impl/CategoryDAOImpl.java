package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.ICategoryDAO;
import com.provence.pojo.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {
	

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(category);
	}

	@Override
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Category.class, id);
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_category_cat where id_cat=:id_cat";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_cat", id);
		basicHibernateDao.executeSql(sql, param);
	}
	
	public List<Category> getCategoryListByBrandId (Long brandId){
		String hql = " from Category where brand.idBrd=:brandId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("brandId", brandId);
		return basicHibernateDao.getResultList(0, Integer.MAX_VALUE, hql, param);
	}

}
