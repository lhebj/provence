package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IUserDAO;
import com.provence.pojo.User;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {


	@Resource
	private IBasicHibernateDAO basicHibernateDao;
	
	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(user);
	}

	@Override
	public User findUserDetailById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(User.class, id);
	}
	
	
	public User findUserByUsername(String username){
		String hql = " from User where usernameU=:usernameU ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("usernameU", username);
		List<User> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public User findUserByEmail(String email){
		String hql = " from User where emailU=:emailU ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("emailU", email);
		List<User> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(user);
	}
	
	public void deleteUserById(Long id){
		String sql = " delete from pro_user_u where id_u=:id_u";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_u", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<User> getUserList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from User where isEnabledU=true order by idU desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
	
	public int getUserTotalCount(){
		String hql = " from User";
		return basicHibernateDao.getTotalCount(hql);
	}

}
