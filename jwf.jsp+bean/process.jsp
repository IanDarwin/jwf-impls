<%@page import="beans.Person,java.io.*,javax.servlet.*,javax.servlet.http.*,java.util.List" %>

<!--
 *** JSP + JavaBean implementation for the JavaWebFramework project
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

<jsp:useBean id="person" class="beans.Person" scope="request"/>
<jsp:setProperty name="person" property="*"/>

<%
		if (person.isValid()) {
			new PersonDAO.insert(person);
 %>

<h1>Thank you!</h1>
Thank you, <%= person.getFirstName() %> <%= person.getLastName() %>,
for registering with us using the JSP+JavaBean implementation!
If this were a real service, you would now be
receiving a confirming email at <%= person.getEmail() %> with more instructions.
<%
		} else {
 %>
		<h1>Errors in input</h1>
		These fields in the input need attention: <font color="red">
 <%
		List list = person.getErrors();
		for (int i = 0; i < list.size(); i++) {
			if (i > 0)
				out.print(", ");
			out.print(list.get(i));
		}
 %>
		</font>
		<p>Please hit the <em>Back button</em> and try the form again.
<%
	}
 %>

</body>
</html>
