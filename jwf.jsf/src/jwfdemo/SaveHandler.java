package jwfdemo;

import beans.Person;

/**
 * JSFDemoActionHandler - copy the beans' data into the database
 * @version $Id$
 */
public class SaveHandler {

	private Person theBean;
	
	public void setPerson(Person p) {
		theBean = p;
	}
	
	public void doSave() {

		//write it using PersonDAO

	}

}
