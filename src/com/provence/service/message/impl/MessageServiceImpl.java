package com.provence.service.message.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IMessageDAO;
import com.provence.pojo.Message;
import com.provence.service.message.IMessageService;
import com.provence.web.dto.MessageDTO;

@Service(value = "messageService")
public class MessageServiceImpl implements IMessageService {

	@Resource
	private IMessageDAO messageDAO;
	@Override
	public void saveOrUpdateMessage(Message message) {
		// TODO Auto-generated method stub
		messageDAO.saveOrUpdateMessage(message);
	}

	@Override
	public Message findMessageById(Long id) {
		// TODO Auto-generated method stub
		return messageDAO.findMessageById(id);
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		messageDAO.deleteMessage(message);
	}

	@Override
	public void deleteMessageById(Long id) {
		// TODO Auto-generated method stub
		messageDAO.deleteMessageById(id);
	}

	@Override
	public List<MessageDTO> getMessageList(int start, int limit) {
		// TODO Auto-generated method stub
		List<MessageDTO> dtoList = new ArrayList<MessageDTO>();
		List<Message> list = messageDAO.getMessageList(start, limit);
		for(Message message: list){
			dtoList.add(message.toDTO());
		}
		return dtoList;
	}

	@Override
	public int getMessageTotalCount() {
		// TODO Auto-generated method stub
		return messageDAO.getMessageTotalCount();
	}

}
