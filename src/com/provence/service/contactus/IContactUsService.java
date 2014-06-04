package com.provence.service.contactus;

import java.util.List;

import com.provence.pojo.ContactUs;
import com.provence.web.dto.ContactUsDTO;

public interface IContactUsService {
	public void saveOrUpdateContactUs(ContactUs contactUs);
	
	public ContactUs findContactUsById(Long id);
	
	public ContactUs findContactUsByType(String type);
	
	public void deleteContactUs(ContactUs contactUs);
	
	public List<ContactUsDTO> getContactUsList (int limit); 
}
