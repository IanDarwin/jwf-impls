package com.darwinsys.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.darwinsys.jwf.model.Person;

@Controller
@RequestMapping(value="/person")
public class PersonHandler {
	
	private Person person;
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm() {
		return "form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String savePerson() {
		System.out.println("PersonHandler.savePerson()");
		
		// write code here to save "Person"
		
		return "saved";
	}
}
