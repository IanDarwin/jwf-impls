package servletdispatcher;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;
import beans.PersonDAO;

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

		// Forward either to the thanks page or to the error page.
		rd.forward(request, response);
	}
}
