package com.ashokit.service;

import java.util.List;

import com.ashokit.model.Contact;

public interface ContactService {
	
	public Integer getIdByName(String name);
		
	public List<Contact> getAll();
	
	public List<Contact> getInActiveRecord();
	
	public boolean getContact(Contact c);
	}

    