<%@page import="beans.Person"%>
<!--
 *** JSP for ServletDispatcher implementation for the JavaWebFramework project
 *** Copyright Ian F. Darwin
 *** $Id$
 -->
<!DOCTYPE html PUBLIC 
		"-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		>

<html>
<head><title>Servlet Output</title></head>
<body>
<%
	// Get the Person object from the request, put in PageContext
	// so that jsp:getProperty will find it.
	Person p = (Person)request.getAttribute("NEWLY_REGISTERED_PERSON");
	pageContext.setAttribute("person", p);
 %>
<h1>Thank you!</h1>
Thank you,
<jsp:getProperty name="person" property="firstName"/>
<jsp:getProperty name="person" property="lastName"/>,
for registering with us using the JSP+JavaBean implementation!
If this were a real service, you would now be
receiving a confirming email at 
<jsp:getProperty name="person" property="email"/>
with more instructions.
</body>
</html>
