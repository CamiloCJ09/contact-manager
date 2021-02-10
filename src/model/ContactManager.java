package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {


	private List<Contact> contacts;
	
	public ContactManager() {
		contacts = new ArrayList<Contact>();
	}
	
	public void addContact(String name, String email) {
		Contact contact1 = new Contact(name, email);
		contacts.add(contact1);

	}
	public List<Contact> getContacts(){
		return contacts;
	}
}
