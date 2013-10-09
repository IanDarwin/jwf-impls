package com.darwinsys.jwf.jdbc;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.ArrayList;

import com.darwinsys.jwf.model.Person;
import com.darwinsys.jwf.model.PersonDao;

/* Data Accessor for "Person" in the JavaWebFraemwork.
 * @author Ian F. Darwin
 * $Id: PersonDAO.java,v 1.3 2003/07/07 01:32:45 ian Exp $
 */

public class PersonDaoJdbc implements PersonDao {

	private DataSource ds;
	
	private static final String fields =
		"firstName, lastName, email, address1, address2," +
			"city, province, postcode, country";

	/** Constructor - just lookup DataSource */
	public PersonDaoJdbc() throws NamingException {
		Context ctx = new InitialContext();

		String dsn = "java:comp/env/jdbc/javawebframeworks";
		System.out.println("Looking up " + dsn);
		Object o = ctx.lookup(dsn);
		ds = (javax.sql.DataSource)o;
		System.out.println("DataSource is " + ds);
	}

	/** insert - insert a Person object into the database. */
	@Override
	public boolean insert(Person person) {
		try {
			Connection con = ds.getConnection();

			// Use a "throw-away" PreparedStatement - best practice - to
			// avoid SQL insertion attacks common when string-concat used.
			PreparedStatement st = con.prepareStatement(
				"insert into people (" + fields + ")" +
				"values(?,?,?,?,?,?,?,?,?)");


			int ret = 0, i = 1;

			st.setString(i++, person.getFirstName());
			st.setString(i++, person.getLastName());
			st.setString(i++, person.getEmail());
			st.setString(i++, person.getAddress1());
			st.setString(i++, person.getAddress2());
			st.setString(i++, person.getCity());
			st.setString(i++, person.getProvince());
			st.setString(i++, person.getPostCode());
			st.setString(i++, person.getCountry());

			ret = st.executeUpdate();

			st.close();
				
			con.close();	// put back into connection pool

			return (ret == 1);

		} catch (SQLException ex) {
			throw new IllegalStateException(ex.toString());
		}
	}

	@Override
	public List findAll() {
		List all = new ArrayList();
		try {
			Connection c = ds.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(
				"select " + fields + " from people");
			while (rs.next()) {
				all.add(getPerson(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return all;
	}

	private Person getPerson(ResultSet rs) throws SQLException {
		Person p = new Person();
		p.setFirstName(rs.getString("FirstName"));
		p.setLastName(rs.getString("LastName"));
		p.setEmail(rs.getString("email"));
		p.setAddress1(rs.getString("Address1"));
		p.setAddress2(rs.getString("Address2"));
		p.setCity(rs.getString("city"));
		p.setProvince(rs.getString("province"));
		p.setPostCode(rs.getString("postcode"));
		p.setCountry(rs.getString("Country"));
		return p;
	}
}
