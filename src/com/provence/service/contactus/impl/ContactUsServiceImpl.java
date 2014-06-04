package com.provence.service.contactus.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IContactUsDAO;
import com.provence.pojo.ContactUs;
import com.provence.service.contactus.IContactUsService;
import com.provence.web.dto.ContactUsDTO;

@Service(value = "contactUsService")
public class ContactUsServiceImpl implements IContactUsService {
	
	@Resource
	private IContactUsDAO contactUsDAO;
	

	@Override
	public void saveOrUpdateContactUs(ContactUs contactUs) {
		// TODO Auto-generated method stub
		contactUsDAO.saveOrUpdateContactUs(contactUs);
	}

	@Override
	public ContactUs findContactUsById(Long id) {
		// TODO Auto-generated method stub
		return contactUsDAO.findContactUsById(id);
	}

	public ContactUs findContactUsByType(String type){
		return contactUsDAO.findContactUsByType(type);
	}
	@Override
	public void deleteContactUs(ContactUs contactUs) {
		// TODO Auto-generated method stub
		contactUsDAO.deleteContactUs(contactUs);
	}

	@Override
	public List<ContactUsDTO> getContactUsList(int limit) {
		// TODO Auto-generated method stub
		List<ContactUsDTO> dtoList = new ArrayList<ContactUsDTO>();
		List<ContactUs> list = contactUsDAO.getContactUsList(limit);
		for (ContactUs cu : list){
			dtoList.add(cu.toDTO());
		}		
		return dtoList;
	}

}
