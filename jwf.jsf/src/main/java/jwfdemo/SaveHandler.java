package jwfdemo;

import javax.naming.NamingException;

import com.darwinsys.jwf.model.*;

/**
 * JSFDemoActionHandler - copy the beans' data into the database
 */
public class SaveHandler {

	private Person thePerson;
	
	private PersonDao dao;
	
	public SaveHandler() {
		dao = new PersonDaoMemory();
	}
	
	public void setPerson(Person p) {
		System.out.println("SaveHandler.setPerson()");;
		thePerson = p;
	}
	
	public String doSave() {
		System.out.println("SaveHandler.doSave()");
		//write it using PersonDao
		dao.insert(thePerson);
		return "signup";
	}

}
