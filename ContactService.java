/* 
 * Leah Clemens
 * CS-320
 * 03.19.2023
 */
package contact_service;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactService {
	
	private static ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userChoice = "";
		initializeContacts();
		
		//matches user input to menu options and calls corresponding functions
		do {
			
	    	userChoice = displayMenu();			//method call to store user input based on menu options
	    	
	    	switch (userChoice) {
	    		case "1": 
	        		intakeNewContact(scnr);		//method call to create new contact
	        		break;
	    		case "2":
	    			deleteContact(scnr);		//method call to delete contact
	    			break;	
	    		case "3":
	    			updateContact(scnr);		//method call to update contact fields 
	    			break;	
	    		case "4":
	    			printContacts();			//method call to print contacts
	    			break;
	    		case "q":
	    			break;
	    		default:
	        		System.out.println("Invalid entry - enter a number 1-4 or q to exit.");
	    	}
	    } while (!userChoice.equalsIgnoreCase("q"));
	}
	
	//method displays menu options and returns user input
	public static String displayMenu() {
		Scanner scnr = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("\t\t\t\tContact Service Menu");
        System.out.println("[1] Input new contact");
        System.out.println("[2] Delete contact");
        System.out.println("[3] Update contact");
        System.out.println("[4] Print contacts");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection: ");
        String userChoice = scnr.nextLine();
        return userChoice;
	}
	
	//populates list with default contact values 
	public static void initializeContacts() {
		Contact contact1 = new Contact("0987654321", "Will", "Byers", "8883558703", "666 Stranger Ln. Hawkins, IN");
		Contact contact2 = new Contact("3141592653", "Sherlock", "Holmes", "5897932384", "221B Baker St. London, UK");
		Contact contact3 = new Contact("6666666666", "Gomez", "Addams", "3214531313", "0001 Cemetery Lane");
	
		contactList.add(contact1); 
		contactList.add(contact2); 
		contactList.add(contact3); 

	}
	
	//method validates user input for ID, first name, last name, and phone number
	public static String validateInput() {
		Scanner scnr = new Scanner(System.in);
    	String userInput = "";
        boolean needInput = true;
        
        //loop ensures user input fits specifications before returning value
        do {
			try {
		        userInput = scnr.nextLine();
		        if ((userInput == null) || (userInput.trim().isEmpty())) {
		        	throw new IllegalArgumentException("Please enter an alphabetical or numerical value: ");
		        } 
		        if (userInput.length() > 10) {
		        	throw new IllegalArgumentException("Input cannot exceed 10 characters, please try again: ");
		        } else {
		        	needInput = false;
		        }	
	    	} catch (IllegalArgumentException e){
	    		System.out.println(e.getMessage());	
	    	}
        } while (needInput);	
        
		return userInput;
	}
	
	//method validates user input for address 
	public static String validateAddress() {
		Scanner scnr = new Scanner(System.in);
    	String userInput = "";
        boolean needInput = true;
        
        //loop ensures user input fits specifications before returning value 
        do {
			try {
		        userInput = scnr.nextLine();
		        if ((userInput == null) || (userInput.trim().isEmpty())) {
		        	throw new IllegalArgumentException("Please enter an alphabetical or numerical value: ");
		        } else if (userInput.length() > 30) {
		        	throw new IllegalArgumentException("Input cannot exceed 30 characters, please try again: ");
		        } else {
		        	needInput = false;
		        }	
	    	} catch (IllegalArgumentException e){
	    		System.out.println(e.getMessage());	
	    	}
        } while (needInput);	
        
		return userInput;
	}
	
	//method creates new contact from user input
	public static void intakeNewContact(Scanner scnr) {
		Contact newContact = new Contact();
		
		System.out.println("Enter a contact ID\n"
				+ "(Cannot be longer than 10 characters):  ");
		String contactID = validateInput();							//checks input fits specifications
		
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(contactID)) {
                System.out.println("\nThis contact ID is already in our system\n");
                return; //returns to menu
            }
        }
		
		//create contact with user values and validate before storing
		newContact.setContactID(contactID);
		System.out.println("Enter first name: ");
		newContact.setFirstName(validateInput());
		System.out.println("Enter last name: ");
		newContact.setLastName(validateInput());
		System.out.println("Enter phone number (spaces excluded): ");
		newContact.setPhoneNum(validateInput());
		System.out.println("Enter address: ");
		newContact.setContactAddress(validateAddress());
		
		contactList.add(newContact);
		
		return;
	}
	
	//method deletes contact that fits user input ID
	public static void deleteContact(Scanner scnr) {
		System.out.println("Enter the ID of the contact you wish to delete: ");
		String contactID = scnr.nextLine();
		
		//checks list for existing ID and removes that contact
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(contactID)) {
                contactList.remove(contact);
                System.out.println("\nContact removed\n");
                return; //returns to menu
            } else {
            	System.out.println("\nThis contact ID is not in our system\n");
            	return;
            }
        }
		
	}
	
	//method displays menu for updating a contact and returns user input
	public static String updateContactMenu(Contact updContact) {
		Scanner scnr = new Scanner(System.in);
		System.out.println(updContact);
		System.out.println("\n***What field do you wish to update***\n");
		System.out.println("1. First Name");
		System.out.println("2. Last Name");
		System.out.println("3. Phone Number");
		System.out.println("4. Address");
		System.out.println("To exit press q");
		System.out.println();
		
		String userChoice = scnr.nextLine();
        return userChoice;
	}
	
	//method updates contact fields with user decision and input
	public static void updateContact(Scanner scnr) {
		String userChoice = "";
		System.out.println("Enter the ID of the contact you wish to update: ");
		String contactID = scnr.nextLine();
		Contact updateContact = new Contact();
		
		//checks list for contact which matches user input ID
		for(Contact contact: contactList) {
            if(contact.getContactID().equals(contactID)) {
                updateContact = contact;
                break;
            } else {
            	System.out.println("\nThis contact ID is not in our system\n");
            	return;
            }
        }
		
		//user modifies contact fields based on menu options 
		do {
			userChoice = updateContactMenu(updateContact);				//displays menu and stores user choice 
	    	switch (userChoice) {
	    		case "1": 
	        		System.out.println("Enter new first name: ");
	        		updateContact.setFirstName(validateInput());		//method call to update first name and validate input
	        		break;
	    		case "2":
	    			System.out.println("Enter new last name: ");
	        		updateContact.setLastName(validateInput());			//method call to update last name and validate input
	        		break;	
	    		case "3":
	    			System.out.println("Enter new phone number: ");
	        		updateContact.setPhoneNum(validateInput());			//method call to update phone number and validate input
	    			break;	
	    		case "4":
	    			System.out.println("Enter new first address: ");
	        		updateContact.setContactAddress(validateAddress());	//method call to update address and validate input
	        		break;
	    		case "q":
	    			break;
	    		default:
	        		System.out.println("Invalid entry - enter a number 1-4.");
	    	}
	    } while (!userChoice.equalsIgnoreCase("q"));
	}
	
	//method displays all contacts using toString format
	public static void printContacts() {
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}
}
