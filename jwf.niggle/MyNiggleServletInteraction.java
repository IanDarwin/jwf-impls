import org.niggle.servlet.NiggleConfig;
import org.niggle.servlet.ServletInteraction;
import org.oreodata.OreoDataSource;
import org.oreodata.Record;
import javax.servlet.http.*;
import java.io.IOException;

/** The "action" class for the Person Entry implementation.
 */
public class MyNiggleServletInteraction extends ServletInteraction {
    /**
     * Construct a ServletInteraction; just delegate to super.
     */
    public MyNiggleServletInteraction(HttpServletRequest request, 
        HttpServletResponse response, NiggleConfig config)
		throws IOException {

        super(request, response, config);
    }

	/** The AddPerson handler, invoked for action="addperson" */
	public void execAddPerson() throws IOException {
		Record person = getNewRecord("person");
		if (person == null) {
			throw new IllegalArgumentException("can't get Record person");
		}
		fillInFields(person);
		OreoDataSource people = getDataSource("people");
		people.insert(person);
		page = getPage("thanks.nhtml");
		page.expose("inserted_ok", true);
		page.expose("person", person);
	}

    /** Default action handler, in case user invokes us w/ no "action" param. */
    public void execDefault() throws IOException {
        this.page = getPage("error.nhtml");
        page.expose("title", "Incorrect usage");
        page.expose("message", 
		"You invoked this servlet without specifying what action to perform!");
    }
}
