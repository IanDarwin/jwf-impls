package sofiademo;

//The Salmon Open Framework for Internet Applications (SOFIA)
//Copyright (C) 1999 - 2002, Salmon LLC
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License version 2
//as published by the Free Software Foundation; 
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
//
//For more information please visit http://www.salmonllc.com

import com.salmonllc.html.events.PageEvent;
import com.salmonllc.html.events.PageListener;
import com.salmonllc.html.events.SubmitEvent;
import com.salmonllc.html.events.SubmitListener;
import com.salmonllc.jsp.JspController;
import com.salmonllc.sql.DataStoreException;
import com.salmonllc.util.MessageLog;

/**
 * The controller for the detail portion of the Person List/Detail data entry example
 */
public class PersonDetailsController extends JspController implements SubmitListener, PageListener {

    //Visual Components
    public com.salmonllc.html.HtmlSubmitButton _cancel;
    public com.salmonllc.html.HtmlSubmitButton _delete;
    public com.salmonllc.html.HtmlSubmitButton _save;
    public com.salmonllc.html.HtmlValidatorText _errorMessage;
	public com.salmonllc.jsp.JspDisplayBox _displaybox1;

    //DataSources
    public PersonModel _jwf;

    public void initialize() {
        addPageListener(this);
        _delete.addSubmitListener(this);
        _save.addSubmitListener(this);
        _cancel.addSubmitListener(this);
        _jwf.setAutoValidate(false);

    }

    /**
     * Event is fired when one of the buttons is clicked
     */
    public boolean submitPerformed(SubmitEvent e) throws Exception {
         if (e.getSource() == _delete) {
            // This will generate a delete statment that will remove the row 
         	// from the database when the update method is called.
            if (_jwf.getPersonId() > -1) {
                _jwf.deleteRow();
                _jwf.update();
            }
			gotoSiteMapPage("index","?reload=true");
        }
        else if (e.getSource() == _save) {
            // This method will cause the database to reflect the changes made in the datastore.
            // All transaction operations are handled within the datastore.
            try {
                 _jwf.update();
				gotoSiteMapPage("index","?reload=true");
            }
            catch (DataStoreException ex) {
                _errorMessage.addErrorMessage("A database error occured saving your changes.");
                MessageLog.writeErrorMessage("submitPerformed",ex,this);
            }
        }
        else if (e.getSource() == _cancel) {
            //just return to the detail page and don't do anything
			gotoSiteMapPage("index");
        }

        return true;
    }

    /**
     * Event is fired each time the page is requested
     */
    public void pageRequested(PageEvent p) throws Exception {
        //check the contact_id parameter
        //if the parameter is not passed in, just put the page in "add mode"
        //else retrieve the row
        if (!isReferredByCurrentPage()) {
            String id = getParameter("id");
            if (id == null) {
                _jwf.reset();
                _jwf.insertRow();
            } else {
                _jwf.retrieve(PersonModel.PERSON_ID + "=" + id);
                if (_jwf.getRowCount() == 0) {
                    _jwf.reset();
                    _jwf.insertRow();
                }
                else
                    _jwf.gotoFirst();
            }
            
            //check the noedit parm. This allows the detail screen to be used as a zoom for a report
            if (getParameter("noedit") == null) {
				_cancel.setVisible(true);
				_delete.setVisible(true);
				_save.setVisible(true);
				_displaybox1.setEnabled(true);	
            }	
            else {
				_cancel.setVisible(false);
				_delete.setVisible(false);
				_save.setVisible(false);
				_displaybox1.setEnabled(false);	
            }	
        }
    }

    /**
     * This event is used to fill out the PageListener interface, but isn't used in this controller.
     */
    public void pageRequestEnd(PageEvent p) {
    }
    /**
     * This event is used to fill out the PageListener intrface, but isn't used in this controller.
     */

    public void pageSubmitEnd(PageEvent p) {}
    /**
     * This event is used to fill out the PageListener intrface, but isn't used in this controller.
     */
    public void pageSubmitted(PageEvent p) {}


}
