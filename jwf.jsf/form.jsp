<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head>
	<title>JSF Implementation</title>
</head>

<body bgcolor="white">
	
<!-- START HTML FRAGMENT basicform.html -->

<h1>Sign Up With Us - Via JSF</h1>
<p>
<hr />
<f:view>
<h:form id="personForm">
	<h:inputHidden id="impl" value="NOTUSED{PersonBean.impl}">jsf</h:inputHidden>
	<table>
	<tr><td>Name: *</td>
		<td><h:inputText id="firstName" value="#{PersonBean.firstName}" size="10"/>
		<h:inputText id="lastName" value="#{PersonBean.lastName}" size="18"/>
		</td></tr>
	<tr><td>Email: *</td><td><h:inputText id="email" value="#{PersonBean.email}" size="30"/></td></tr>
	<tr><td>Address:</td><td><h:inputText id="address1" value="#{PersonBean.address1}" size="30"/></td></tr>
	<tr><td>Line 2:</td><td><h:inputText id="address2" value="#{PersonBean.address2}" size="30"/></td></tr>
	<tr><td>City:</td><td><h:inputText id="city" value="#{PersonBean.city}" size="30"/></td></tr>
	<tr><td>Province:</td><td><h:inputText id="province" value="#{PersonBean.province}" size="30"/></td></tr>
	<tr><td>Post Code:</td><td><h:inputText id="postcode" value="#{PersonBean.postcode}" size="30"/></td></tr>
	<tr><td>Country: *</td><td><select name="country">
			<option selected="true">--Choose your country--</option>
			<option value="ca">Canada</option>
			<option value="us">U.S.A.</option>
			<option value="uk">U.K.</option>
		</select></td>
	<tr><td colspan="2" align="center">
		<h:commandButton id="submit" action="signup" value="Register!"/>
		</td></tr>
	</table>
</h:form>
</f:view>

<!-- END HTML FRAGMENT basicform.html -->

<hr/>
