<html>
<head>
	<title>JSF Implementation</title>
</head>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <body bgcolor="white">
	
	<h:form id="personForm" formName="personForm" >
		<h:input_number id="userNo" numberStyle="NUMBER"
			valueRef="UserNumberBean.userNumber">
			<f:validate_longrange minimum="0" maximum="10"/>
		</h:input_number> 
		<h:command_button id="submit" action="success" label="Submit" 
			commandName="submit"/>
		<p>
		<h:output_errors id="errors1" for="userNo"/>
	</h:form>
	</f:use_faces>
</html>
<!-- START HTML FRAGMENT basicform.html -->

<h1>Sign Up With Us</h1>
<p>
<hr />
<f:view>
<h:form id="personForm" formName="personForm"/>
	<h:input_hidden id="impl" value="jsf"/>
	<table>
	<tr><td>Name: *</td>
		<td><h:input_text id="firstName" size="10"/>
		<h:input_text id="lastName" size="18"/>
		</td></tr>
	<tr><td>Email: *</td><td><h:input_text name="email" size="30"></td></tr>
	<tr><td>Address:</td><td><h:input_text name="address1" size="30"></td></tr>
	<tr><td>Line 2:</td><td><h:input_text name="address2" size="30"></td></tr>
	<tr><td>City:</td><td><h:input_text name="city" size="30"></td></tr>
	<tr><td>Province:</td><td><h:input_text name="province" size="30"></td></tr>
	<tr><td>Post Code:</td><td><h:input_text name="postcode" size="30"></td></tr>
	<tr><td>Country: *</td><td><select name="country">
			<option selected="true">--Choose your country--</option>
			<option value="ca">Canada</option>
			<option value="us">U.S.A.</option>
			<option value="uk">U.K.</option>
		</select></td>
	<tr><td colspan="2" align="center">
		<h:command_button id="submit" action="signup" label="Register!">
		</td></tr>
	</table>
</form>

<!-- END HTML FRAGMENT basicform.html -->

<hr/>
View <a href="ServletOnly.java">Servlet Source Code</a>.
