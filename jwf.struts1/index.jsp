<%@page errorPage="/errors/oops.jsp"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
	<font color="red">
    <h1>ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.</h1>
  </font>
</logic:notPresent>

<html:html locale="true">
<head>
	<title><bean:message key="insert.title"/></title>
</head>

<body>

<img src="/images/struts-power.gif" alt="<bean:message key="image.struts-power"/>" 
	align="right" width="95" height="37"/>

<h1><bean:message key="insert.title"/></h1>
<p>
<html:errors/>

<p><bean.message key="struts.i18n"/></p>

<html:javascript formName="addPersonDynaForm"/>

<!-- START ORIGINAL HTML FRAGMENT basicform.html -->
<html:form action="/jwf.struts/process" 
	focus="firstName" onsubmit="return validateAddPersonDynaForm(this)">

	<input type="hidden" name="impl" value="struts">
	<table>
	<tr><td><bean:message key="insert.label.names"/>:*</td>
		<td><bean:message key="insert.label.firstName"/><html:text name="addPersonDynaForm" property="firstName" size="10"/>
		<bean:message key="insert.label.lastName"/><html:text name="addPersonDynaForm" property="lastName" size="18"/>
		</td></tr>
	<tr><td><bean:message key="insert.label.email"/>: *</td><td><html:text name="addPersonDynaForm" property="email" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.address1"/>:</td><td><html:text name="addPersonDynaForm" property="address1" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.address2"/>:</td><td><html:text name="addPersonDynaForm" property="address2" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.city"/>:</td><td><html:text name="addPersonDynaForm" property="city" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.province"/>:</td><td><html:text name="addPersonDynaForm" property="province" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.postcode"/>:</td><td><html:text name="addPersonDynaForm" property="postcode" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.country"/> *:</td>	
		<td><html:select name="addPersonDynaForm" property="country">
			<html:option value="--">--Choose your country--</html:option>
			<html:option value="ca">Canada</html:option>
			<html:option value="us">U.S.A.</html:option>
			<html:option value="uk">U.K.</html:option>
		</html:select></td>
	<tr><td colspan="2" align="center"><html:submit property="Action">
			<bean:message key="insert.label.signup"/></html:submit>
		</td></tr>
	</table>
</html:form>

<!-- END ORIGINAL HTML FRAGMENT basicform.html -->
</body>
<hr/>
View Source Code:
<a href="index.txt">index.jsp</a>;
<a href="InsertAction.java">Struts "Action" for Database Insertion</a>;
</html:html>
