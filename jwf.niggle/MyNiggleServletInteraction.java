package niggle;

import org.niggle.servlet.NiggleConfig;
import org.niggle.servlet.ServletInteraction;
import org.oreodata.OreoDataSource;
import org.oreodata.Record;

import javax.servlet.http.*;
import java.io.IOException;

/** The "action" class for the Person Entry implementation.
 */
public class MyNiggleServletInteraction extends ServletInteraction {
    /** Construct a ServletInteraction; just delegate to super. */
    public MyNiggleServletInteraction(HttpServletRequest request, 
        HttpServletResponse response, NiggleConfig config)
		throws IOException {

        super(request, response, config);
    }

	/** The AddPerson handler, invoked for action="addperson" */
	public void execAddPerson() throws IOException {
		// Get a database connection.
		OreoDataSource people = getDataSource("peopledb");
		if (people == null) {
			throw new IllegalArgumentException("can't get DataSource peopledb");
		}
		// Create an empty Record of type "people"
		Record person = getNewRecord("people");
		if (person == null) {
			throw new IllegalArgumentException("can't get Record people");
		}

		// Fill in its fields from the HTML form
		fillInFields(person);

		// Plonk it into the database
		people.insert(person);

		// Acknowledge addition to DB back to the user.
		page = getPage("niggle/thanks.nhtml");
		page.expose("title", "Thank you for registering");
		page.expose("firstname", person.get("firstname"));
		page.expose("lastname", person.get("lastname"));
		page.expose("email", person.get("email"));
	}

    /** Default action handler, in case user invokes us w/ no "action" param. */
    public void execDefault() throws IOException {
        this.page = getPage("niggle/error.nhtml");
        page.expose("title", "Incorrect usage");
        page.expose("message", 
		"You invoked this servlet without specifying what action to perform!");
    }
}
