<%@page import="beans.Person, java.util.List" %>
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
<head><title>Invalid Input</title></head>
<body>
<h1>Errors in input</h1>
These fields in the input need attention: <font color="red">
<%
	List errs = (List)request.getAttribute("errors");
	if (errs == null) {
 %>
		<h1>Logic error!</h1>
		<p>badinput.jsp invoked with no error attribute!</p>
		</body></html>
<%
		return;
	}
	for (int i = 0; i < errs.size(); i++) {
		if (i > 0)
			out.print(", ");
		out.print(errs.get(i));
	}
 %>
</font></p>
<p>Please go Back and try again.</p>
</body>
</html>
