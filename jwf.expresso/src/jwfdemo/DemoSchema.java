package jwfdemo;

import com.jcorporate.expresso.core.db.DBException;
import com.jcorporate.expresso.core.dbobj.Schema;

public class DemoSchema extends Schema {
	private static String currentVersion = "0.1";
	public DemoSchema() throws DBException {
		super();
		try {
			addDBObject(jwfdemo.dbobj.PersonDB.class);
			addController(jwfdemo.controller.DemoController.class);
		} catch (Exception ex) {
			throw new DBException(ex.toString());
		}
	}

	/**
	 * Used to get the package name (== directory path) for the ResourceBundle
	 * to I18N the application.
	 */
	public String getMessageBundlePath() {
		return "jwfDemo";
	}
	
	/** Get the display name */
	public String getDefaultDescription() {
		return "JWFDemo Schema";
	}
	
	/** Return the component code (or "category") */
	public String getDefaultComponentCode() {
			return "jwfDemo";
	}

}
