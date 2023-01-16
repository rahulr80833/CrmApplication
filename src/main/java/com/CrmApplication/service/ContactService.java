package com.CrmApplication.service;

import java.util.List;

import com.CrmApplication.entities.Contact;

public interface ContactService {

	   public void saveContact(Contact contact);
	   public List<Contact> listContacts();
		public Contact getOneContact(long id);
}
