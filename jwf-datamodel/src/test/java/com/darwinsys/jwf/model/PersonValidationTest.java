package com.darwinsys.jwf.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.darwinsys.jwf.model.Person;

public class PersonValidationTest {

	private static Validator validator;
	
	private Person p;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Before
	public void initAllValidly() {
		p = new Person();
		p.setFirstName("J");
		p.setLastName("Smith");
		p.setEmail("aa@bb.cc");
		p.setAddress1("123 Main St");
		p.setCity("Trawna");
		p.setProvince("Ontario");
		p.setPostCode("HOH 0HO");
		p.setCountry("ca");
	}
	
	@Test
	public void defaultIsValid() {
		Set<ConstraintViolation<Person>> constraintViolations = 
				validator.validate(p);

		assertEquals(0, constraintViolations.size());		
	}

	@Test
	public void emailIsNull() {
		
		p.setEmail(null);
		
		Set<ConstraintViolation<Person>> constraintViolations = 
			validator.validate(p);

		assertEquals(0, constraintViolations.size());
		assertEquals("may not be null", constraintViolations.iterator().next()
				.getMessage());
	}

	@Test
	public void emailIsValid() {
		
		p.setEmail("nobody@erewhon.inasnit");

		Set<ConstraintViolation<Person>> constraintViolations = 
				validator.validate(p);

		assertEquals(0, constraintViolations.size());
		assertEquals("Must be a valid email address", constraintViolations
				.iterator().next().getMessage());
	}
}