package com.ashokit.model;

public class Contact {
	
	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactEmail;
	
	public Contact() {
	}

	public Contact(Integer contactId, String contactName, Long contactNum, String contactEmail) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNum = contactNum;
		this.contactEmail = contactEmail;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	

}
