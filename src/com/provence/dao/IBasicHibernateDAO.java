package com.provence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

public interface IBasicHibernateDAO {

	public Session getCurrentSession();

	public <T> void saveOrUpdate(T entity);

	public <T> void delete(T entity);

	public <T> T getById(Class<T> clazz, Serializable id);
	
	public <T> T loadById(Class<T> clazz, Serializable id);

	public int getTotalCount(String hql) throws DataAccessException;

	public int getTotalCount(String hql, Map<String, Object> param) throws DataAccessException;

	public int getTotalCountByDirectHQL(String hql, Map<String, Object> param) throws DataAccessException;

	public int getTotalCountBySQL(String hql, Map<String, Object> param) throws DataAccessException;

	public int getTotalCountByDirectSQL(String sql, boolean groupBy, Map<String, Object> param) throws DataAccessException;

	public Map<String, Object> getResult(final int start, final int limit, String hql);

	public Map<String, Object> getResult(String hql);

	public Map<String, Object> getResult(final int start, final int limit, String hql, Map<String, Object> param);

	public int getTotalCountBySqlQuery(String sql, Map<String, Object> param);

	public Map<String, Object> getResultBySqlQuery(final int start, final int limit, String sql, Map<String, Object> param);

	public List<Object[]> getResultListBySqlQuery(final int start, final int limit, String sql, Map<String, Object> param);

	public <T> List<T> getResultList(final int start, final int limit, String hql, Map<String, Object> param);

	public <T> List<T> getResultList(final int start, final int limit, String hql);

	public <T> List<T> getResultList(String hql, Map<String, Object> param);

	public int executeUpdate(String hql, Map<String, Object> param);

	public void executeSql(String sql, Map<String, Object> param);

	Long convertToLong(String key, Map<String, Object> param);

	Long convertToLong(String key, Map<String, Object> param, boolean override);
	
}
