<%@page errorPage="/oops.jsp" import="beans.Person"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!--
 *** "Thank you" JSP for Struts implementation for the JavaWebFramework project
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
<h1><bean:message key="label.title"/></h1>
<p>Thank you,
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="firstName"/ -->
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="lastName"/ -->,
for registering with us using the ServletDispatcher implementation!
If this were a real service, you would now be
receiving a confirming email at 
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="email"/ -->
with more instructions.
</p>
<p>See the <a href="../list/">list of people</a>.</p>
</body>
</html>
