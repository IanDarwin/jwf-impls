package sofiademo;

import com.salmonllc.sql.*;
import com.salmonllc.util.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A hand-coded Model Containing all the columns in the Person table.
 */
public class PersonModel extends DataStore implements Remotable {

    //constants for columns
    public static final String PERSON_ID = "people.id";
    public static final String PERSON_FIRSTNAME = "people.firstname";
    public static final String PERSON_LASTNAME = "people.lastname";
    public static final String PERSON_EMAIL = "people.email";
    public static final String PERSON_ADDRESS1 = "people.address1";
    public static final String PERSON_ADDRESS2 = "people.address2";
    public static final String PERSON_CITY = "people.city";
    public static final String PERSON_PROVINCE = "people.province";
    public static final String PERSON_POSTCODE = "people.postcode";
    public static final String PERSON_COUNTRY = "people.country";

    private int _nextID = -1;

    public PersonModel(String appName) {
		super(appName);

		// add columns
		addColumn(
			computeTableName("people"),
			"id",
			DataStore.DATATYPE_INT,
			true,
			true,
			PERSON_ID);
		addColumn(
			computeTableName("people"),
			"firstname",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_FIRSTNAME);
		addColumn(
			computeTableName("people"),
			"lastname",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_LASTNAME);
		addColumn(
			computeTableName("people"),
			"address1",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_ADDRESS1);
		addColumn(
			computeTableName("people"),
			"address2",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_ADDRESS2);
		addColumn(
			computeTableName("people"),
			"city",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_CITY);
		addColumn(
			computeTableName("people"),
			"province",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_PROVINCE);
		addColumn(
			computeTableName("people"),
			"postcode",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_POSTCODE);
		addColumn(
			computeTableName("people"),
			"email",
			DataStore.DATATYPE_STRING,
			false,
			true,
			PERSON_EMAIL);

		// set ordering
		setOrderBy(
			computeTableAndFieldName(PERSON_LASTNAME) + " ASC," +
			computeTableAndFieldName(PERSON_FIRSTNAME) + " ASC");

		// blend in validation rules
		try {
			addRequiredRule(PERSON_FIRSTNAME, "Must give your first name.");
			addRequiredRule(PERSON_LASTNAME, "Must give your last name.");
			addRequiredRule(PERSON_EMAIL, "Must give your email address.");
			addExpressionRule(
				PERSON_EMAIL,
				new EMailValidation(PERSON_EMAIL),
				"Invalid email address entered.",
				false);
			setAutoValidate(true);
		} catch (Exception ex) {
		}
	}

    /**
     * Override the update method so that the person id is generated for all new rows and every modified row is validated.
     */
    public void update(DBConnection conn, boolean handleTrans) throws DataStoreException, SQLException {
        _nextID = -1;
        for (int i = 0; i < getRowCount(); i++) {
            if (getRowStatus(i) == STATUS_NEW_MODIFIED)
                generatePersonID(conn, i);
        }
        super.update(conn, handleTrans);
    }

    /**
     * This method generates the next person id using the max function in sql.
     * The "getMax" technique generally should not be used in a real world application due to concurrency considerations
     * but is used here for the sake of simplicity.
     */
    private void generatePersonID(DBConnection conn, int row) throws DataStoreException {
        if (getPersonId() > 0)
            return;

        if (_nextID != -1) {
            setPersonId(row, _nextID++);
            return;
        }


        int nextID = 1;
        try {
            String selectID = "select max(id) from people";

            Statement st = conn.createStatement();

            ResultSet r = st.executeQuery(selectID);
            if (r.next())
                nextID = r.getInt(1) + 1;

            r.close();
            st.close();
        } catch (Exception e) {
            MessageLog.writeErrorMessage("generatePersonID", e, this);
        }
        setPersonId(row, nextID);
        _nextID = nextID + 1;
    }


    public int getPersonId() throws DataStoreException {
        return getInt(PERSON_ID);
    }

    public int getPersonId(int row) throws DataStoreException {
        return getInt(row, PERSON_ID);
    }

    public void setPersonId(int newValue) throws DataStoreException {
        setInt(PERSON_ID, newValue);
    }

    public void setPersonId(int row, int newValue) throws DataStoreException {
        setInt(row, PERSON_ID, newValue);
    }

    public String getPersonFirstName() throws DataStoreException {
        return getString(PERSON_FIRSTNAME);
    }

    public String getPersonFirstName(int row) throws DataStoreException {
        return getString(row, PERSON_FIRSTNAME);
    }

    public void setPersonFirstName(String newValue) throws DataStoreException {
        setString(PERSON_FIRSTNAME, newValue);
    }

    public void setPersonFirstName(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_FIRSTNAME, newValue);
    }

    public String getPersonLastName() throws DataStoreException {
        return getString(PERSON_LASTNAME);
    }

    public String getPersonLastName(int row) throws DataStoreException {
        return getString(row, PERSON_LASTNAME);
    }

    public void setPersonLastName(String newValue) throws DataStoreException {
        setString(PERSON_LASTNAME, newValue);
    }

    public void setPersonLastName(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_LASTNAME, newValue);
    }

    public String getPersonEmail() throws DataStoreException {
        return getString(PERSON_EMAIL);
    }

    public String getPersonEmail(int row) throws DataStoreException {
        return getString(row, PERSON_EMAIL);
    }

    public void setPersonEmail(String newValue) throws DataStoreException {
        setString(PERSON_EMAIL, newValue);
    }

    public void setPersonEmail(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_EMAIL, newValue);
    }

    public String getPersonAddress1() throws DataStoreException {
        return getString(PERSON_ADDRESS1);
    }

    public String getPersonAddress1(int row) throws DataStoreException {
        return getString(row, PERSON_ADDRESS1);
    }

    public void setPersonAddress1(String newValue) throws DataStoreException {
        setString(PERSON_ADDRESS1, newValue);
    }

    public void setPersonAddress1(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_ADDRESS1, newValue);
    }

    public String getPersonAddress2() throws DataStoreException {
        return getString(PERSON_ADDRESS2);
    }

    public String getPersonAddress2(int row) throws DataStoreException {
        return getString(row, PERSON_ADDRESS2);
    }

    public void setPersonAddress2(String newValue) throws DataStoreException {
        setString(PERSON_ADDRESS2, newValue);
    }

    public void setPersonAddress2(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_ADDRESS2, newValue);
    }

    public String getPersonCity() throws DataStoreException {
        return getString(PERSON_CITY);
    }

    public String getPersonCity(int row) throws DataStoreException {
        return getString(row, PERSON_CITY);
    }

    public void setPersonCity(String newValue) throws DataStoreException {
        setString(PERSON_CITY, newValue);
    }

    public void setPersonCity(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_CITY, newValue);
    }

    public String getPersonProvince() throws DataStoreException {
        return getString(PERSON_PROVINCE);
    }

    public String getPersonProvince(int row) throws DataStoreException {
        return getString(row, PERSON_PROVINCE);
    }

    public void setPersonProvince(String newValue) throws DataStoreException {
        setString(PERSON_PROVINCE, newValue);
    }

    public void setPersonProvince(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_PROVINCE, newValue);
    }

    public String getPersonPostCode() throws DataStoreException {
        return getString(PERSON_POSTCODE);
    }

    public String getPersonPostCode(int row) throws DataStoreException {
        return getString(row, PERSON_POSTCODE);
    }

    public void setPersonPostCode(String newValue) throws DataStoreException {
        setString(PERSON_POSTCODE, newValue);
    }

    public void setPersonPostCode(int row, String newValue) throws DataStoreException {
        setString(row, PERSON_POSTCODE, newValue);
    }

    /**
    * This method is called before each remote request to the DataStore 
	* (including creation methods) to grant or deny permission on the operation.
    * @return true to grant the request, false to deny it.
    */
   public boolean request(String reqType, HttpServletRequest req, boolean sessionValid, String userID, String password, String criteria) throws DataStoreException {
       // what is not forbidden must be allowed!
       return true;
   }

}
