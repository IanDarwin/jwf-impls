<%@page errorPage="/oops.jsp"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!-- START ORIGINAL HTML FRAGMENT basicform.html -->

<h1><bean:message key="label.title"/></h1>
<p>
<html:errors/>
<hr />
<html:form action="/process" focus="firstName">
	<table>
	<tr><td><bean:message key="insert.label.names"/>:*</td>
		<td><bean:message key="insert.label.firstName"/><html:text name="insertDynaForm" property="firstName" size="10"/>
		<bean:message key="insert.label.lastName"/><html:text name="insertDynaForm" property="lastName" size="18"/>
		</td></tr>
	<tr><td><bean:message key="insert.label.email"/>: *</td><td><html:text name="insertDynaForm" property="email" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.address1"/>:</td><td><html:text name="insertDynaForm" property="address1" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.address2"/>:</td><td><html:text name="insertDynaForm" property="address2" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.city"/>:</td><td><html:text name="insertDynaForm" property="city" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.province"/>:</td><td><html:text name="insertDynaForm" property="province" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.postcode"/>:</td><td><html:text name="insertDynaForm" property="postcode" size="30"/></td></tr>
	<tr><td><bean:message key="insert.label.country"/> *:</td>	
		<td><html:select name="insertDynaForm" property="country">
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