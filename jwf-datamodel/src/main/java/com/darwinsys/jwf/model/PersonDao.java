package com.darwinsys.jwf.model;

import java.util.List;

/*
 * Data Accessor for "Person" in the JavaWebFraemwork.
 * @author Ian F. Darwin
 */
public interface PersonDao {


	/** insert - insert a Person object into the database. */
	boolean insert(Person person);

	/** Get the list of all Persons */
	List<Person> findAll();

}
