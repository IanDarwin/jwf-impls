package jwfdemo.controller;

import java.util.List;

import jwfdemo.dbobj.PersonDB;

import com.jcorporate.expresso.core.controller.Block;
import com.jcorporate.expresso.core.controller.ControllerException;
import com.jcorporate.expresso.core.controller.ControllerRequest;
import com.jcorporate.expresso.core.controller.ControllerResponse;
import com.jcorporate.expresso.core.controller.Output;
import com.jcorporate.expresso.core.controller.State;
import com.jcorporate.expresso.core.db.DBException;
import com.jcorporate.expresso.services.controller.Registration;

public class DemoController extends Registration {
	
	private String thisClass = getClass().getName() + ".";

	public DemoController() {
		super();

		addState(new State("enterNameAndAddress", "enterNameAndAddress"));
		addState(new State("listAll", "listAll"));
		setInitialState("enterNameAndAddress");
		
		setSchema("jwfdemo.controller.DemoController");
	}

	public String getTitle() {
		return "Demo Controller II";
	}

	private ControllerResponse runEnterNameAndAddress(
			ControllerRequest request, ControllerResponse response)
		throws ControllerException {
		System.out.println("enterNameAndAddress");
		return response;
		
	}

	private ControllerResponse runListAll(ControllerRequest request, ControllerResponse response) 
	throws ControllerException {
		System.out.println("listAll");

		try {

			response.addOutput(
				new Output("Heading", 
					"Here are the people that have signed up using one of the demos"));

			PersonDB person = new PersonDB();
			//stockInit.setDBName( this.getDBName() );
			List list = person.searchAndRetrieveList();
			int N = list.size();
			for (int k = 0; k < N; ++k) {
				PersonDB aPerson = (PersonDB) list.get(k);

				Block blockRow = new Block("Person" + k);
				response.add(blockRow);

				Output out1 = new Output();
				out1.setName("Person");
				out1.setAttribute("FirstName", aPerson.getField("firstName"));
				out1.setAttribute("LastName",  aPerson.getField("lastName"));
				blockRow.add(out1);
				// out1.setAttribute( "", stock.getField("ST_") );

			}
			return response;
		} catch (DBException ex) {
			throw new ControllerException(
				" database exception: " + ex.getMessage());
		}

	}
}
