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
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
//
//For more information please visit http://www.salmonllc.com

import com.salmonllc.html.HtmlPage;
import com.salmonllc.html.HtmlValidatorText;

/**
 * A Validator component that validates the contact form
 */
public class PersonValidator extends HtmlValidatorText {

	public PersonValidator(String name, String font, HtmlPage p) {
		super(name, font, p);
	}

	public void initialize() {
		// load up the rules from the datastore model.
		// We could also declare the rules in here instead of importing them.
		importRules(getDataStore());
	}

}
