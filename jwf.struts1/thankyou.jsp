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
<head>
	<title><bean:message key="success.title"/></title>
</head>

<body>
<h1><bean:message key="success.title"/></h1>
<p><bean:message key="success.text.thankyou"/>
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="firstName"/ -->
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="lastName"/ -->
<!-- jsp:getProperty name="NEWLY_REGISTERED_PERSON" property="email"/ -->
</p>
<p><a href="../list/"><bean:message key="success.text.next"/></a></p>
</body>
</html>
