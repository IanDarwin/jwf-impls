<%@page import="beans.Person,beans.PersonDAO,java.io.*,java.util.*" %>

<!--
 *** List the contents of the database.
 *** Probably want some authentication on this, if it's used live.
 *** Copyright Ian F. Darwin
 *** $Id$
 -->

<!DOCTYPE html PUBLIC 
		"-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		>

<html>
<head><title>People</title></head>
<body>

<table border="1">
<tr><th>FirstName</th><th>Surname</th><th>Email</th>
	<th>Address</th><th>City</th><th>Country</th>
	</tr>

<%
	Iterator all = new PersonDAO().findAll().iterator();
	while (all.hasNext()) {
		Person p = (Person)all.next();
		out.print("<tr>");
		out.print("<td>" + p.getFirstName() + "</td>");
		out.print("<td>" + p.getLastName() + "</td>");
		out.print("<td>" + p.getEmail() + "</td>");
		out.print("<td>" + p.getAddress1() + "</td>");
		out.print("<td>" + p.getCity() + "</td>");
		out.print("<td>" + p.getCountry() + "</td>");
		out.print("</tr>");
	}
 %>
</table>

</body>
</html>
