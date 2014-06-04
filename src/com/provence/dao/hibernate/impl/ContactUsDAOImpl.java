package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IContactUsDAO;
import com.provence.pojo.ContactUs;

@Repository("contactUsDAO")
public class ContactUsDAOImpl implements IContactUsDAO {
	

	@Resource
	private IBasicHibernateDAO basicHibernateDao;


	@Override
	public void saveOrUpdateContactUs(ContactUs contactUs) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(contactUs);
	}

	@Override
	public ContactUs findContactUsById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(ContactUs.class, id);
	}
	
	public ContactUs findContactUsByType(String type){
		String hql = " from ContactUs where typeCtu=:typeCtu ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeCtu", type);
		List<ContactUs> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteContactUs(ContactUs contactUs) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(contactUs);
	}

	@Override
	public List<ContactUs> getContactUsList(int limit) {
		// TODO Auto-generated method stub
		String hql = " from ContactUs ";
		return basicHibernateDao.getResultList(0, limit, hql);
	}

}
