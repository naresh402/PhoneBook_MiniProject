package com.ashokit.dao;

import java.util.List;

import com.ashokit.model.Contact;

public interface ContactDAO {
	
	public Integer findIdByName(String name);
	
	public List<Contact> findAll();
	
	public List<Contact> findInActiveRecord();
	
	public boolean saveContact(Contact c);

}
