package servletdispatcher;

import beans.Person;
import beans.PersonDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

/*
 * Servlet Dispatcher Implementation for the JavaWebFramework project
 * @author  Ian F. Darwin
 * @version $Id$
 */
public class ServletDispatcher extends HttpServlet
{
	PersonDAO dao;

	/** Constructor, to catch DAO constructor errors */
	public ServletDispatcher() throws ServletException {
		try {
			dao = new PersonDAO();
		} catch (NamingException ex) {
			throw new ServletException("ServletDispatcher: " + ex.toString());
		}
	}

	/** Called in response to a POST request (data unencoded on the socket) */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		ServletContext application = getServletContext();

		Person person = new Person();

		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		person.setEmail(request.getParameter("email"));
		person.setAddress1(request.getParameter("address1"));
		person.setAddress2(request.getParameter("address2"));
		person.setCity(request.getParameter("city"));
		person.setProvince(request.getParameter("province"));
		person.setPostcode(request.getParameter("postcode"));
		person.setCountry(request.getParameter("country"));

		RequestDispatcher rd;

		if (!person.isValid()) {
			request.setAttribute("errors", person.getErrors());
			rd = application.getRequestDispatcher(
				"/servletdispatcher/badinput.jsp");
		} else {

			dao.insert(person);

			request.setAttribute("NEWLY_REGISTERED_PERSON", person);
			rd = application.getRequestDispatcher(
				"/servletdispatcher/thankyou.jsp");
		}

		// Forward either to the thanks page or to the erro page.
		rd.forward(request, response);
	}
}
