<html>
<head>
	<title>Thank you</title>
</head>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <body bgcolor="white">
    <f:view>
    <h:form id="responseForm" formName="responseForm" >
		<p>Thank you for signing up as<h:output_text id="result" 
			valueRef="UserBean.firstname"/></h2>   
		<h:command_button id="back" label="Back" action="success" 
			commandName="back"/><p>
    </h:form>
    </f:view>
 </html>
