package jwfdemo;

import com.darwinsys.jwf.model.Person;
import com.darwinsys.jwf.model.PersonDao;
import com.darwinsys.jwf.model.PersonDaoMemory;

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
	
	public String savePerson() {
		System.out.println("SaveHandler.savePerson()");
		//write it using PersonDao
		dao.insert(thePerson);
		return "saved";
	}

}
