package niggle;

import org.oreodata.*;
import org.oreodata.metadata.StringField;

/** Field Class to check for valid-looking ISO country code (must be two
 * ASCII letters, lower case); does not look the code up in a table to 
 * ensure validity. Special handling for "-- Choose a Country --" at top
 * of choice list. For example:
 * <pre>
 * &lt;tr&gt;&lt;td&gt;Country:&lt;/td&gt;&lt;td&gt;
 *	&lt;select name="country"&gt;
 *		&lt;option selected="true" value="--"&gt;--Choose your country--
 *		&lt;option value="ca"&gt;Canada
 *		&lt;option value="us"&gt;U.S.A.
 *		&lt;option value="uk"&gt;U.K.
 *	&lt;/select&gt;
 * &lt;/td&gt;&lt;/tr&gt;
 * </pre>
 * @author Ian Darwin, http://www.darwinsys.com/
 * @version $Id$
 */
public class CountryCodeField extends StringField {
	public CountryCodeField() {
	}

	public void checkValidValue(Record rec, java.lang.Object value)
	throws DataException {
		super.checkValidValue(rec, value);
		String sValue = (String)value;
		if (value == null || sValue.startsWith("-")) {
			throw new MangledDataException(rec,
				"Please select a Country from the list");
        }
		if (sValue.length() != 2) {
			throw new MangledDataException(rec,
				"Country code " + sValue + 
				" not valid; please choose a country from the list");
		}
		for (int i = 0; i <= 1; i++) {
			char c = sValue.charAt(i);
			if (c < 'a' || c > 'z')
				throw new MangledDataException(rec,
					"Country code " + sValue + 
					" not valid; please choose a country from the list");
		}
	}
}
