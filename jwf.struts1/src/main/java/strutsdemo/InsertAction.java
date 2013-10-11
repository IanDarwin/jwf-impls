package strutsdemo;

import com.darwinsys.jwf.model.Person;
import com.darwinsys.jwf.model.PersonDao;
import com.darwinsys.jwf.model.PersonDaoMemory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.util.List;
import javax.servlet.http.*;

/** The Struts "Action" to do the insert of a Person into the Database.
 * @author Ian F. Darwin
 * @version $Id$
 */
public class InsertAction extends Action {
	public ActionForward execute( 
		ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

		ActionErrors errors = new ActionErrors();

		// Get the ActionForm
		DynaActionForm f = (DynaActionForm)form;

		// Populate a Person bean
		Person person = new Person();
		person.setFirstName((String)f.get("firstName"));
		person.setLastName((String)f.get("lastName"));
		person.setEmail((String)f.get("email"));
		person.setAddress1((String)f.get("address1"));
		person.setAddress2((String)f.get("address2"));
		person.setCity((String)f.get("city"));
		person.setProvince((String)f.get("province"));
		person.setPostCode((String)f.get("postcode"));
		person.setCountry((String)f.get("country"));

		// Must be a better way to do validation!

		// If inputs not valid, process as error.
		// if (!person.isValid()) {
		//	List errs = person.getErrors();
		//	StringBuffer fields = new StringBuffer();
		//	for (int i = 0; i < errs.size(); i++) {
		//		if (i > 0)
		//			fields.append(", ");
		//		fields.append(errs.get(i));
		//	}
		//	errors.add(ActionErrors.GLOBAL_ERROR,
		//		new ActionError("error.fields.attention", fields));
		//	saveErrors(request, errors);
		//	return new ActionForward(mapping.getInput());
		//}

		// Data is OK, so try to store it in the database.
		try {
			new PersonDaoMemory().insert(person);
		} catch (Exception ex) {
			errors.add(ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.problem", ex.toString()));
			saveErrors(request, errors);
			return new ActionForward(mapping.getInput());
		}

		return mapping.findForward("success");
	}
}
