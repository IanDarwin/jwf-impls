package jwfdemo.dbobj;

import com.jcorporate.expresso.core.db.DBConnection;
import com.jcorporate.expresso.core.db.DBException;
import com.jcorporate.expresso.core.dbobj.DBObject;
import com.jcorporate.expresso.core.dbobj.SecuredDBObject;

public class PersonDB extends SecuredDBObject {

	/**
	 * Construct a PersonDB with no connection yet allocated.
	 * @throws DBException
	 *             If the new object cannot be * created
	 */
	public PersonDB() throws DBException {
		super();
	}

	/**
	 * Construct a PersonDB with an existing Database connection.
	 * @param theConnection
	 *            Database connection to communicate with the database
	 * @throws DBException
	 *             If the construction is messed.
	 */
	public PersonDB(DBConnection theConnection) throws DBException {
		super(theConnection);
	}

	/**
	 * Construct a PersonDB with a DBConnecction and a username for validation.
	 * @param theConnection
	 *            DBConnection to be used to communicate with the database
	 * @param theUser
	 *            User name attempting to access the object
	 * @throws DBException
	 *             If the user cannot access this object or the object cannot
	 *             be initialized
	 */
	public PersonDB(DBConnection theConnection, String theUser)
		throws DBException {
		super(theConnection, theUser);
	}

	/**
	 * Initialize the DBMS fields matching Person entries
	 * 
	 * @throws DBException
	 *             if anything goes wrong
	 */
	protected synchronized void setupFields() throws DBException {
		setTargetTable("people");
		setDescription("Name and Address Form");
		// Excerpt from the actual SQL creation script:
		// CREATE TABLE PEOPLE(ID INTEGER NOT NULL IDENTITY PRIMARY KEY,
		//  FIRSTNAME VARCHAR(40),LASTNAME VARCHAR(40),EMAIL VARCHAR(40),
		//  ADDRESS1 VARCHAR(40),ADDRESS2 VARCHAR(40),CITY VARCHAR(40),
		//  PROVINCE VARCHAR(40),POSTCODE VARCHAR(20),COUNTRY VARCHAR(40));
		addField("ID",        "int",      0, false, "ID");
		addField("firstName", "varchar", 40, false, "First Name");
		addField("lastName", "varchar", 40, false, "Last Name");
		addField("email"   , "varchar", 40, false, "Email Address");
		addField("address1", "varchar", 40, false, "Address");
		addField("address2", "varchar", 40, false, "Address Continuation");
		addField("city",     "varchar", 40, false, "City");
		addField("province", "varchar", 40, false, "Province/State");
		addField("postcode", "varchar", 40, false, "Post/Zip Code");
		addField("country",  "varchar", 40, false, "Country");
		addKey("ID");
	}

	/**
	 * Get a PersonDB
	 * 
	 * @return DBObject A newly created instance of this object
	 * @throws DBException
	 *             If the new object cannot be created
	 */
	public DBObject getThisDBObj() throws DBException {

		return new PersonDB();
	}
}
