package com.provence.dao;

import java.util.List;

import com.provence.pojo.ContactUs;

public interface IContactUsDAO {
	public void saveOrUpdateContactUs(ContactUs contactUs);
	
	public ContactUs findContactUsById(Long id);
	
	public ContactUs findContactUsByType(String type);
	
	public void deleteContactUs(ContactUs contactUs);
	
	public List<ContactUs> getContactUsList (int limit); 
}
