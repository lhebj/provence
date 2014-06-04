package com.provence.dao.hibernate.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.StringUtil;

@Repository("basicHibernateDao")
public class BasicHibernateDAOImpl implements IBasicHibernateDAO {
	
	@Resource
	public SessionFactory sessionFactory;

	public static String DIR_DESC = "desc";
	public static String DIR_ASC = "asc";
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public <T> void saveOrUpdate(T entity){
		getCurrentSession().saveOrUpdate(entity);
	}
	
	public <T> void delete(T entity){
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getById(Class<T> clazz, Serializable id){
		return (T)getCurrentSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T loadById(Class<T> clazz, Serializable id){
		return (T)getCurrentSession().load(clazz, id);
	}
	
	public int getTotalCount(String hql) throws DataAccessException {
		return getTotalCount(hql, Collections.<String, Object>emptyMap());
	}

	public int getTotalCount(String hql, Map<String, Object> param) throws DataAccessException {
		Session session = getCurrentSession();
		Integer amount = new Integer(0);
		int sqlFrom = hql.indexOf("from");
		int sqlOrderby = hql.indexOf("order by");
		String countStr = "";
		if (sqlOrderby > 0) {
			countStr = "select count(*) " + hql.substring(sqlFrom, sqlOrderby);
		} else {
			countStr = "select count(*) " + hql.substring(sqlFrom);
		}
		Query query = null;
		query = session.createQuery(countStr);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		List list = query.list();
		if (!list.isEmpty()) {
			if (hql.indexOf("group by") != -1 || hql.indexOf("GROUP BY") != -1) {
				amount = list.size();
			} else {
				amount = new Integer(list.get(0).toString());
			}

		} else {
			return 0;
		}
		return amount.intValue();
	}

	/**
	 * 使用主键查询count
	 */
	public int getTotalCountByDirectHQL(String hql, Map<String, Object> param) throws DataAccessException {
		Session session = getCurrentSession();
		Integer amount = new Integer(0);
		Query query = null;
		query = session.createQuery(hql);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		List list = query.list();
		if (!list.isEmpty()) {
			if (hql.indexOf("group by") != -1 || hql.indexOf("GROUP BY") != -1) {
				amount = list.size();
			} else {
				if (list.get(0) != null){
					amount = new Integer(list.get(0).toString());
				} else {
					return 0;
				}
			}

		} else {
			return 0;
		}
		return amount.intValue();
	}

	public int getTotalCountBySQL(String hql, Map<String, Object> param) throws DataAccessException {
		Session session = getCurrentSession();
		Integer amount = new Integer(0);
		int sqlFrom = hql.indexOf("from");
		int sqlOrderby = hql.indexOf("order by");
		String countStr = "";
		if (sqlOrderby > 0) {
			countStr = "select count(*) " + hql.substring(sqlFrom, sqlOrderby);
		} else {
			countStr = "select count(*) " + hql.substring(sqlFrom);
		}
		Query query = null;
		query = session.createSQLQuery(countStr);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		List list = query.list();
		if (!list.isEmpty()) {
			if (hql.indexOf("group by") != -1 || hql.indexOf("GROUP BY") != -1) {
				amount = list.size();
			} else {
				amount = new Integer(list.get(0).toString());
			}

		} else {
			return 0;
		}
		return amount.intValue();
	}

	/**
	 * 使用主键查询count
	 */
	public int getTotalCountByDirectSQL(String sql, boolean groupBy, Map<String, Object> param) {
		Session session = getCurrentSession();
		Integer amount = new Integer(0);
		Query query = null;
		query = session.createSQLQuery(sql);
		if (param != null) {
			for (String key : getPlaceHolderList(sql)) {
				Object value = param.get(key);
				query.setParameter(key, value);
			}
		}
		List list = query.list();
		if (!list.isEmpty()) {
			if (groupBy) {
				amount = list.size();
			} else {
				amount = new Integer(list.get(0).toString());
			}

		} else {
			return 0;
		}
		return amount.intValue();
	}

	public Map<String, Object> getResult(final int start, final int limit, String hql) {
		return getResult(start, limit, hql, Collections.<String, Object>emptyMap());
	}

	public Map<String, Object> getResult(String hql) {
		return getResult(0, 0, hql);
	}

	public Map<String, Object> getResult(final int start, final int limit, String hql, Map<String, Object> param) {
		Session session = getCurrentSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		int count;
		Query query = null;
		query = session.createQuery(hql);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (limit != 0) {
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		list = query.list();
		if(limit == 0){	// query.list()查所有内容的情形，比如excel导出
			count = list.size();
		} else {
			count = getTotalCount(hql, param);
		}
		map.put(CommonStaticConst.LIST, list);
		map.put(CommonStaticConst.TOTALCOUNT, count);
		return map;
	}

	public int getTotalCountBySqlQuery(String sql, Map<String, Object> param)  {
		Session session = getCurrentSession();
		Integer amount = new Integer(0);
		int sqlFrom = sql.indexOf("from");
		int sqlOrderby = sql.indexOf("order by");
		String countStr = "";
		if (sqlOrderby > 0) {
			countStr = "select count(*) " + sql.substring(sqlFrom, sqlOrderby);
		} else {
			countStr = "select count(*) " + sql.substring(sqlFrom);
		}
		Query query = null;
		query = session.createSQLQuery(countStr);
		for (String key : getPlaceHolderList(sql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		List list = query.list();
		if (!list.isEmpty()) {
			if (sql.indexOf("group by") != -1 || sql.indexOf("GROUP BY") != -1) {
				amount = list.size();
			} else {
				amount = new Integer(list.get(0).toString());
			}

		} else {
			return 0;
		}
		return amount.intValue();
	}

	public Map<String, Object> getResultBySqlQuery(final int start, final int limit, String sql, Map<String, Object> param) {
		Session session = getCurrentSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		int count;
		Query query = null;
		query = session.createSQLQuery(sql);
		for (String key : getPlaceHolderList(sql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (limit != 0) {
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		list = query.list();
		if(limit == 0){	// query.list()查所有内容的情形，比如excel导出
			count = list.size();
		} else {
			count = getTotalCountBySqlQuery(sql, param);
		}
		map.put(CommonStaticConst.LIST, list);
		map.put(CommonStaticConst.TOTALCOUNT, count);

		return map;
	}

	/**
	 * 注�?此方法的select中，一定�?包�?�多个字段或对象
	 * �?�个字段或对象是�?会�??回List<Object[]>的
	 */
	public List<Object[]> getResultListBySqlQuery(final int start, final int limit, String sql, Map<String, Object> param) {
		Session session = getCurrentSession();
		Query query = null;
		query = session.createSQLQuery(sql);
		for (String key : getPlaceHolderList(sql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (limit != 0) {
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}

	public <T> List<T> getResultList(final int start, final int limit, String hql, Map<String, Object> param) {
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (limit != 0) {
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return query.list();
	}

	public <T> List<T> getResultList(final int start, final int limit, String hql) {
		return getResultList(start, limit, hql, Collections.<String, Object>emptyMap());
	}

	public <T> List<T> getResultList(String hql, Map<String, Object> param) {
		return getResultList(0, 0, hql, param);
	}

	/**
	 * 批�?更新
	 * 
	 * @param session
	 * @param hql
	 * @param param
	 * @return 影�?的行数
	 */
	public int executeUpdate(String hql, Map<String, Object> param) {
		Session session = getCurrentSession();
		int temp = 0;
		Query query = null;
		query = session.createQuery(hql);
		for (String key : getPlaceHolderList(hql)) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		temp = query.executeUpdate();
		return temp;
	}

	/**
	 * 执行sql
	 * 
	 * @param type
	 * @return
	 */
	public void executeSql(String sql, Map<String, Object> param) {
		Session session = getCurrentSession();
		Query query = null;
		query = session.createSQLQuery(sql);
		if (param != null) {
			for (String key : getPlaceHolderList(sql)) {
				Object value = param.get(key);
				query.setParameter(key, value);
			}
		}
		query.executeUpdate();
	}
	
	/**
	 * 获�?�sql/hql中的所有�?��?符(形如":XXX")
	 * @author zyang
	 */
	public static List<String> getPlaceHolderList(String sql){
		if(sql.indexOf(":") == -1){
			return Collections.<String>emptyList();
		}
		// 剔除sql中的字符串
		StringBuilder clearedSqlBuff = new StringBuilder();
		int idx1 = 0, idx2 = 0, idx = 0, minIdx = 0;
		int sqlLen = sql.length();
		while(idx < sqlLen){
			idx1 = sql.indexOf("'", idx);
			idx2 = sql.indexOf("\"", idx);
			if(idx1 == -1){
				idx1 = sql.length();
			}
			if(idx2 == -1){
				idx2 = sql.length();
			}
			minIdx = Math.min(idx1, idx2);
			clearedSqlBuff.append(sql.substring(idx, minIdx));
			if(minIdx == sqlLen){
				break;
			}
			idx = (idx1 < idx2? sql.indexOf("'", idx1 + 1): sql.indexOf("\"", idx2 + 1)) + 1;
		}
		String clearedSql = clearedSqlBuff.toString();
		// 按�?缀":"查找sql中的�?��?符
		List<String> placeHolderList = new LinkedList<String>();
		String prefix = ":";
		int clearedSqlLen = clearedSql.length();
		int prefixLen = prefix.length();
		int beginIdx = clearedSql.indexOf(prefix), 
			endIdx;
		if(beginIdx == -1) {
			return Collections.<String>emptyList();
		}
		while(beginIdx != -1){
			beginIdx += prefixLen;	// �?��?符的第一个字�?
			endIdx = beginIdx;
			char c;
			while(endIdx < clearedSqlLen){
				c = clearedSql.charAt(endIdx);
				if(!Character.isLetter(c) && c != '_' && (c < '0' || c > '9')){
					break;
				}
				endIdx ++;
			}
			if(endIdx <= beginIdx + 1){
				continue;
			}
			placeHolderList.add(clearedSql.substring(beginIdx, endIdx));
			beginIdx = clearedSql.indexOf(prefix, endIdx);
		}
		return placeHolderList;
	}
	
	/**
	 * param中的value转Long的工具方法，默认会覆盖param中的value
	 */
	@Override
	public Long convertToLong(String key, Map<String, Object> param){
		return convertToLong(key, param, true);
	}
	
	/**
	 * param中的value转Long的工具方法
	 */
	@Override
	public Long convertToLong(String key, Map<String, Object> param, boolean override){
		Object obj = null;
		if(StringUtil.isNull(key) || (obj = param.get(key)) == null){
			return null;
		}
		Long num = null;
		if(obj instanceof Long){
			num = (Long) obj;
		} else {
			try {
				num = Long.valueOf(obj.toString());
				if(override){
					param.put(key, num);
				}
			} catch (NumberFormatException e) {
			}
		}
		return num;
	}
	
}
