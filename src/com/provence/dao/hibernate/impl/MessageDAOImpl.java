package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IMessageDAO;
import com.provence.pojo.Message;

@Repository("messageDAO")
public class MessageDAOImpl implements IMessageDAO {

	
	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateMessage(Message message) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(message);
	}

	@Override
	public Message findMessageById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Message.class, id);
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(message);
	}

	@Override
	public void deleteMessageById(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_message_msg where id_msg=:id_msg";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_msg", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<Message> getMessageList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from Message order by idMsg desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}

	@Override
	public int getMessageTotalCount() {
		// TODO Auto-generated method stub
		String hql = " from Message";
		return basicHibernateDao.getTotalCount(hql);
	}

}
