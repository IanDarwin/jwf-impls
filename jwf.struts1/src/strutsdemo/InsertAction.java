package struts;

import beans.Person;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import javax.servlet.http.*;

public class InsertAction extends Action {
	public ActionForward execute( 
		ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

		// Get the ActionForm
		DynaActionForm f = (DynaActionForm)form;

		// Extract the values

		// Populate a Person bean
		Person person = new Person();
		// person.setFirstName(...);
		// ...

		// Store it
		// new PersonDAO().insert(person);

		return mapping.findForward("success");
	}
}
