package servletonly;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

/*
 * Servlet-only implementation for the JavaWebFramework project
 * THIS IS NOT INTENDED TO BE GOOD STYLE; I know it should be MVC
 * and all that; this is a "worst case" example for the Frameworks Catalog.
 * @author  Ian F. Darwin
 * @version $Id$
 */
public class ServletOnly extends HttpServlet
{
	private DataSource ds;

	private PreparedStatement st;

	/** Servlet initialization */
	public void init() throws ServletException {
		try {
			Context ctx = new InitialContext();

			String enc = "java:comp/env";
			System.out.println("Looking up " + enc);
			Context encContext = (Context)ctx.lookup(enc);
			
			String dsn = "jdbc/javawebframeworks";
			System.out.println("Looking up " + dsn);
			ds = (javax.sql.DataSource)encContext.lookup(dsn);
			System.out.println("DataSource is " + ds);

			System.out.println("Getting connection ");
			Connection con = ds.getConnection();
			System.out.println("Got it!");

			st = con.prepareStatement(
				"insert into people (firstName, lastName, email, address1, address2," +
				"city, province, postcode, country)" +
				"values(?,?,?,?,?,?,?,?,?)");

			// con.close();	// put back into connection pool
		} catch (NamingException ex) {
			ex.printStackTrace();
			return;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return;
		}
	}

	/** Called in response to a POST request (data unencoded on the socket) */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		ServletContext application = getServletContext();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 

		// BOILERPLATE beginning
		out.println("<!DOCTYPE html PUBLIC " +
			"\"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
			"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"\n" +
			">");

		out.println("<html>");
		out.println("<head><title>Servlet Output</title></head>");
		out.println("<body>");

		// Servlet logic code and main HTML goes here.

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String postcode = request.getParameter("postcode");
		String country = request.getParameter("country");

		if (st == null) {
			out.println("<h1>Error</h1>");
			out.println("Couldn't do that because, alas, this servlet's");
			out.println("initialization failed to load the 'DataSource' that we need.");
			out.println("Your valuable signup information was <b>not saved</b>.");
			return;
		}
		int ret = 0;
		try {

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

		} catch (SQLException ex) {
			out.println("<h1>Error</h1>");
			out.println("<pre>");
			ex.printStackTrace(out);
			out.println("</pre>");
			return;
		}

		if (ret != 1) {
			out.println("<h2>Error</h2>");
			out.println("Unable to insert into database, ret = " + ret);
			return;
		}

		out.println("<h1>Thank you!</h1>");
		out.println("Thank you for registering with us!");
		out.println("If this were a real service, you would now be");
		out.println("receiving a confirming email with more instructions.");

		out.println("<hr/>");
		out.println("<a href='http://localhost/javawebframeworks/list/'>List of People who've registered</a>");

		// BOILERPLATE ending
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}
