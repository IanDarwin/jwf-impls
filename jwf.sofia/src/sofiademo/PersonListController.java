package sofiademo;

import com.salmonllc.html.HtmlTextEdit;
import com.salmonllc.html.events.PageEvent;
import com.salmonllc.html.events.PageListener;
import com.salmonllc.html.events.SubmitEvent;
import com.salmonllc.html.events.SubmitListener;
import com.salmonllc.jsp.JspController;
import com.salmonllc.util.MessageLog;

/**
 * This class is the SOFIA controller for the People list page.
 */
/**
 * name - purpose
 * @version $Id$
 */
public class PersonListController extends JspController implements SubmitListener, PageListener {

    //Visual Components
    public com.salmonllc.html.HtmlSubmitButton _add;
    public com.salmonllc.html.HtmlSubmitButton _search;
    public com.salmonllc.html.HtmlTextEdit _eMail;
    public com.salmonllc.html.HtmlTextEdit _firstName;
    public com.salmonllc.html.HtmlTextEdit _lastName;
	public com.salmonllc.html.HtmlTextEdit _address1;
	public com.salmonllc.html.HtmlTextEdit _address2;
	public com.salmonllc.html.HtmlTextEdit _city;
	public com.salmonllc.html.HtmlTextEdit _province;
	public com.salmonllc.html.HtmlTextEdit _postcode;
	public com.salmonllc.html.HtmlTextEdit _country;

    //DataSources
    public PersonModel _jwf;

    public void initialize() {
        addPageListener(this);
        _add.addSubmitListener(this);
        _search.addSubmitListener(this);

        //initially load all the contacts
        search();
    }

    /**
     * This method gets fired when the user clicks a button
     */
    public boolean submitPerformed(SubmitEvent e) throws Exception {
        if (e.getSource() == _search) {
            search();
            scrollToItem("scrollToMe");
        }
        else if (e.getSource() == _add)
            gotoSiteMapPage("details");
        return true;
    }


    /**
     * This method seaches the database with whatever criteria were specified.
     * If no criteria are specified it will try to retrieve all the entries.
     */
    private void search() {
        StringBuffer criteria = new StringBuffer();
        try {
        		addSearchCriteria(criteria, _firstName, PersonModel.PERSON_FIRSTNAME);
			addSearchCriteria(criteria, _lastName, PersonModel.PERSON_LASTNAME);
			addSearchCriteria(criteria, _eMail, PersonModel.PERSON_EMAIL);
			addSearchCriteria(criteria, _address1, PersonModel.PERSON_ADDRESS1);
			addSearchCriteria(criteria, _address2, PersonModel.PERSON_ADDRESS2);
			addSearchCriteria(criteria, _city, PersonModel.PERSON_CITY);
			addSearchCriteria(criteria, _province, PersonModel.PERSON_PROVINCE);
			addSearchCriteria(criteria, _postcode, PersonModel.PERSON_POSTCODE);
			addSearchCriteria(criteria, _country, PersonModel.PERSON_COUNTRY);
 
			// If nothing has been entered, pass null criteria, else "retrieve" 
			// will generate incorrect SQL like
			// "SELECT bleah  FROM people  WHERE  ORDER BY people.lastname ASC"
			System.out.println("Criteria = " + criteria);
            _jwf.retrieve(criteria.length() != 0 ? criteria.toString() : null);
            
        } catch (Exception e) {
            MessageLog.writeErrorMessage("search", e, this);
        }
    }

    /** Convenience routine for building up "criteria"
     * @param criteria A constructed but possibly empty StringBuffer
     * @param field  The HTML Text Field whose value is to be looked for.
     * @param fieldName The class field for the corresponding db table.column.
     */
    void addSearchCriteria(StringBuffer criteria, 
			   HtmlTextEdit field,
			   String fieldName) {
    	
    		// This is a fatal error
    		assert criteria != null : "BaseController.addSearchCriteria(): null StringBuffer";

    		// This is a warning, since the search may not all be right, but can continue...
    		if (field == null) {
	    		System.err.println(
	    			"BaseController.addSearchCriteria(): warning: null HtmlTextEdit for " +
					fieldName);
	    		return;
	    	}
    		
    		// OK, get the user value.
    		// XXX Do we need to sanitize this input, or does SOFIA use a PreparedStatment?
		String test = field.getValue();
		if (test != null && test.trim().length() != 0) {
		    test = test.trim().toLowerCase();
			if (criteria.length() != 0)
				 criteria.append(" or ");
		    criteria.append("lower(").append(fieldName).append(") like '%" + test + "%'");
		}
		return;
	}

	/**
     * This event will get fired each time a page is requested by the browser before any HTML is generated.
     */
    public void pageRequested(PageEvent p) throws Exception {
        // check for a parameter, reload. If it is there, we want to reload all the rows in the list,
        // but only if the request didn't come from this page.
        if (!isReferredByCurrentPage()) {
            if (getParameter("reload") != null)
                search();
        }
    }

    /**
     * This method is required by the PageListener interface, but isn't used in this controller.
     */
    public void pageRequestEnd(PageEvent p) throws Exception {}

    /**
     * This method is required by the PageListener interface, but isn't used in this controller.
     */
    public void pageSubmitEnd(PageEvent p) {}

    /**
     * This method is required by the PageListener interface, but isn't used in this controller.
     */
    public void pageSubmitted(PageEvent p) {}
}
