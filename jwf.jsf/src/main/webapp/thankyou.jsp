<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head>
	<title>Thank you</title>
</head>
 
<body bgcolor="white">

    <f:view>
    <h:form id="responseForm">
		<p>Thank you for signing up as
		<h:outputText id="result" value="#{PersonBean.firstName}"/></p>   
		<h:commandButton id="back" value="Back" action="success"/><p>
    </h:form>
    </f:view>
    
</body>
</html>
