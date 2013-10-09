package jwfdemo;

import javax.naming.NamingException;

import beans.Person;
import beans.PersonDAO;

/**
 * JSFDemoActionHandler - copy the beans' data into the database
 * @version $Id$
 */
public class SaveHandler {

	private Person thePerson;
	
	private PersonDAO dao;
	
	public SaveHandler() {
		try {
			dao = new PersonDAO();
		} catch (NamingException e) {
			System.out.println("SaveHandler.SaveHandler(): caught " + e);
			throw new RuntimeException(e.toString());
		}
	}
	
	public void setPerson(Person p) {
		System.out.println("SaveHandler.setPerson()");;
		thePerson = p;
	}
	
	public String doSave() {
		System.out.println("SaveHandler.doSave()");
		//write it using PersonDAO
		dao.insert(thePerson);
		return "signup";
	}

}
