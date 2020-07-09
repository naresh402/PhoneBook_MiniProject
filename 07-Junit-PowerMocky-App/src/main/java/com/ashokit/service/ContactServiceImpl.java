package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import com.ashokit.dao.ContactDAO;
import com.ashokit.exception.NoDataFoundException;
import com.ashokit.model.Contact;
import com.ashokit.utils.EmailUtils;

public class ContactServiceImpl implements ContactService {
	
	private ContactDAO contactDao;
	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}
	private EmailUtils sendemail;
	public void setSendemail(EmailUtils sendemail) {
		this.sendemail = sendemail;
	}

	public Integer getIdByName(String name) {
		Integer contactName=contactDao.findIdByName(name);
		return contactName;
	}

	public List<Contact> getAll() {
		List<Contact> contact=contactDao.findAll();
		if(contact==null)
		throw new NoDataFoundException();
		return contact;
	}
    
	public List<Contact> getInActiveRecord() {
		List<Contact> contacts=contactDao.findInActiveRecord();
		if(contacts==null)
		{
			throw new NoDataFoundException();
		}
		return contacts;
	}

	public boolean getContact(Contact c) {
		boolean isSaved=contactDao.saveContact(c);
		boolean isSent=false;
		if(isSaved) {
			isSent=sendemail.sendEmail(c.getContactEmail());
	}
		return isSent;

	
	}
}
