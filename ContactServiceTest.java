/* 
 * Leah Clemens
 * CS-320
 * 03.19.2023
 */
package contact_service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		Contact contact1 = new Contact("0987654321", "Will", "Byers", "8883558703", "666 Stranger Ln. Hawkins, IN");
		Contact contact2 = new Contact("3141592653", "Sherlock", "Holmes", "5897932384", "221B Baker St. London, UK");
	
		contactList.add(contact1); 
		contactList.add(contact2); 
	}
	
	@AfterEach
		void tearDown() throws Exception {
		contactList.clear();
	}
	
	@Test
	void checkForExistingID() {
		String inputID = "0987654321";
		String existingID = "";
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(inputID)) {
                existingID = contact.getContactID();
            }
        }
		assertEquals(inputID, existingID);
	}
	
	@Test
	void addContact() {
		int sizeBefore = contactList.size();
		Contact newContact = new Contact();
		
		newContact.setContactID("6666666666");
		newContact.setFirstName("Gomez");
		newContact.setLastName("Addams");
		newContact.setPhoneNum("3214531313");
		newContact.setContactAddress("0001 Cemetery Lane");	
		contactList.add(newContact);
		
		int sizeAfter = contactList.size();
		assertNotEquals(sizeBefore, sizeAfter);
	}
	
	@Test
	void deleteContactWithID() {
		int sizeBefore = contactList.size();
		String contactID = "0987654321";
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(contactID)) {
                contactList.remove(contact);
                break;
            }    
        }
		int sizeAfter = contactList.size();
		assertNotEquals(sizeBefore, sizeAfter);
	}
	
	@Test
	void updateContactFields() {
		Contact updateContact = new Contact();
		String contactID = "3141592653";
		
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(contactID)) {
                updateContact = contact;
                break;
            }    
        }
		updateContact.setFirstName("John");
		updateContact.setLastName("Watson");
		updateContact.setPhoneNum("5897932222");
		updateContact.setContactAddress("221B Baker St.");

		assertEquals(updateContact.toString(), "3141592653 | Watson, John | 5897932222 | 221B Baker St.");
	}
}
