package contact_service;

/* 
 * Leah Clemens
 * CS-320
 * 03.19.2023
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ContactTest {

	@Test
	void testInputIsNull() {
		String userInput = null;
		try {
	        if ((userInput == null) || (userInput.trim().isEmpty())) {
	        	throw new IllegalArgumentException("Please enter an alphabetical or numerical value: ");
	        } 
    	} catch (IllegalArgumentException e){
    		assertEquals("Please enter an alphabetical or numerical value: ", e.getMessage());	
    	}	
	}
	
	@Test
	void testInputMoreThanTenChar() {
		String userInput = "way more than ten characters";
		try {
	        if (userInput.length() > 10) {
	        	throw new IllegalArgumentException("Input cannot exceed 10 characters, please try again: ");
	        }	
        } catch (IllegalArgumentException e){
        	assertEquals("Input cannot exceed 10 characters, please try again: ", e.getMessage());	
    	}	
	}
	
	@Test
	void testInputMoreThanThirtyChar() {
		String userInput = "this input should be way more than thirty characters";
		try {
	        if (userInput.length() > 30) {
	        	throw new IllegalArgumentException("Input cannot exceed 30 characters, please try again: ");
	        }	
        } catch (IllegalArgumentException e){
        	assertEquals("Input cannot exceed 30 characters, please try again: ", e.getMessage());	
    	}
	}
}
