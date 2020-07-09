package com.ashokit.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.ashokit.dao.ContactDAO;
import com.ashokit.exception.NoDataFoundException;
import com.ashokit.model.Contact;

public class ContactServiceTest {
	
	@Test
	public void testContactByName_01() {
		ContactServiceImpl service=new ContactServiceImpl();
		ContactDAO dao =PowerMockito.mock(ContactDAO.class);
		 PowerMockito.when(dao.findIdByName("Ashok")).thenReturn(102);
		 service.setContactDao(dao);
		 Integer num=service.getIdByName("Ashok");
		 assertNotNull(num);
		 
		
	}
	@Test(expected=NoDataFoundException.class)
   public void testGetAllTest_02() {
		ContactServiceImpl service=new ContactServiceImpl();

		ContactDAO dao=PowerMockito.mock(ContactDAO.class);
		PowerMockito.when(dao.findAll()).thenReturn(null);
		service.setContactDao(dao);
		service.getAll();
   }
	@Ignore
	@Test(expected=NoDataFoundException.class)
	public void testInActivRecord() {
		ContactServiceImpl service=new ContactServiceImpl();
		ContactDAO dao=PowerMockito.mock(ContactDAO.class);
		PowerMockito.when(dao.findInActiveRecord()).thenReturn(null);
		service.setContactDao(dao);
		List<Contact> name=service.getInActiveRecord();
	assertNull(name);

}
	@Test()
	public void testInActivRecord_02() {
		ContactServiceImpl service=new ContactServiceImpl();
		ContactDAO dao=PowerMockito.mock(ContactDAO.class);
		PowerMockito.when(dao.findInActiveRecord()).thenThrow(new NullPointerException());
		service.setContactDao(dao);
		List<Contact> name=service.getInActiveRecord();
	assertNull(name);
}
	
	public void testSaveContact() {
		ContactServiceImpl service=new ContactServiceImpl();
		ContactDAO dao=PowerMockito.mock(ContactDAO.class);
		List<Contact> list=new ArrayList<Contact>();
		list.add(new Contact(101,"David",7013761893,""));
		list.add(new Contact(101,"Smith",7013761894,""));
		list.add(new Contact(101,"John",7013761895,""));

       PowerMockito.when(dao.findInActiveRecord()).thenReturn(list);

		service.setContactDao(dao);
	List<Contact> lists=	service.getInActiveRecord();
	assertNotNull(lists);
	}
}