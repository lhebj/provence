package com.provence.dao;

import java.util.List;

import com.provence.pojo.Message;

public interface IMessageDAO {
	public void saveOrUpdateMessage(Message message);
	
	public Message findMessageById(Long id);
	
	public void deleteMessage(Message message);
	
	public void deleteMessageById(Long id);
	
	public List<Message> getMessageList (int start, int limit); 
	
	public int getMessageTotalCount();
}
