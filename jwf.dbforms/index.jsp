<html xmlns:db="http://www.wap-force.com/dbforms">

<!-- Hide these from XML parser checking; JSP will still see them. -->
<!-- <%@page errorPage="/errors/oops.jsp"%> -->
<!-- <%@taglib uri="/WEB-INF/dbforms.tld" prefix="db" %> -->

<head>
	<title><db:message key="insert.title"/></title>
</head>

<body>

<h1>Signup With DBForms</h1>

<db:errors/>

<!-- START ORIGINAL HTML FRAGMENT basicform.html -->
<db:dbform tableName="people" maxRows='1' followUp="thanks.jsp">

	<input type="hidden" name="impl" value="dbform"/>
	<table border='1'>
	<db:header/>
	<db:body/>
	<%-- Main work in footer as we don't view, only insert, on this page --%>
	<db:footer>
	<tr>
		<td><db:textField fieldName="firstName" size="20"/>
		    <db:textField fieldName="lastName" size="20"/></td>
		</tr>
	<tr><td><db:textField fieldName="email"/></td></tr>
	<tr><td><db:textField fieldName="address1"/></td></tr>
	<tr><td><db:textField fieldName="address2"/></td></tr>
	<tr><td><db:textField fieldName="city"/></td></tr>
	<tr><td><db:textField fieldName="province"/></td></tr>
	<tr><td><db:textField fieldName="postCode"/></td></tr>
	<tr><td>Country:
		<!-- XXX Todo use db:select here -->
		<select name="addPersonDynaForm" property="country">
			<option value="--">--Choose your country--</option>
			<option value="ca">Canada</option>
			<option value="us">U.S.A.</option>
			<option value="uk">U.K.</option>
		</select></td></tr>
	<tr><td colspan="2" align="center">
		<db:insertButton caption="Sign Up!"/>
		</td></tr>
	</db:footer>
	</table>
</db:dbform>

<!-- END ORIGINAL HTML FRAGMENT basicform.html -->
</body>
<hr/>
View Source Code:
<a href="index.txt">index.jsp</a>
</html>
