package com.darwinsys.springjsf;

import com.darwinsys.jwf.model.Person;

public class PersonHandler {
	
	private Person person;
	
	public String savePerson() {
		System.out.println("PersonHandler.savePerson()");
		
		// write code here to save "Person"
		
		return "saved";
	}
}
