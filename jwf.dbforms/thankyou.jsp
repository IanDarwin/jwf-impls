<%@page errorPage="/oops.jsp" import="beans.Person"%>
<%@taglib uri="/WEB-INF/dbforms.tld" prefix="db" %>
<!--
 *** "Thank you" JSP for dbforms implementation for the JavaWebFramework project
 *** Copyright Ian F. Darwin
 *** $Id$
 -->
<!DOCTYPE html PUBLIC 
		"-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		>

<html>
<head>
	<title>Thank you</title>
</head>

<body>
<h1>Thank you</h1>
<p><bean:message key="success.text.thankyou"/>
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="firstName"/ -->
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="lastName"/ -->
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="email"/ -->
</p>
<p><a href="../list/">View the list</a></p>
</body>
</html>
