<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,java.sql.*,javax.sql.*,javax.naming.*" %>

<!--
 *** JSP-only implementation for the JavaWebFramework project
 *** Copyright Ian F. Darwin
 *** $Id$
 */
<%!
	private static DataSource ds;

	private static PreparedStatement st;

	/** Static initializer to allocate DataSource and PreparedStatement */
	static {
		try {
			Context ctx = new InitialContext();

			String dsn = "java:comp/env/jdbc/javawebframeworks";
			System.out.println("Looking up " + dsn);
			Object o = ctx.lookup(dsn);
			ds = (javax.sql.DataSource)o;
			System.out.println("DataSource is " + ds);

			System.out.println("Getting connection ");
			Connection con = ds.getConnection();
			System.out.println("Got it!");

			st = con.prepareStatement(
				"insert into people (firstName, lastName, address1, address2," +
				"city, province, zipcode, country)" +
				"values(?,?,?,?,?,?,?,?)");

			// con.close();	// put back into connection pool
		} catch (NamingException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
%>

<!DOCTYPE html PUBLIC 
		"-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		>

<html>
<head><title>Servlet Output</title></head>
<body>

<%
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String postcode = request.getParameter("postcode");
		String country = request.getParameter("country");

		int ret = 0;

			int i = 1;
			st.setString(i++, firstName);
			st.setString(i++, lastName);
			st.setString(i++, email);
			st.setString(i++, address1);
			st.setString(i++, address2);
			st.setString(i++, city);
			st.setString(i++, province);
			st.setString(i++, postcode);
			st.setString(i++, country);

			ret = st.executeUpdate();

			// st.close();	// Do NOT close this PS!

		if (ret != 1) {
 %>
			<h2>Error</h2>
			Unable to insert into database, ret = <%= ret %>.
<%			return;
		}
 %>

<h1>Thank you!</h1>
Thank you for registering with us using the JSP-only implementation!
If this were a real service, you would now be
receiving a confirming email with more instructions.

</body>
</html>
