<?xml version="1.0" encoding="UTF-8"?>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">

	<body>

   		<ui:composition template="/templates/standard.xhtml">

			<ui:define name="pageTitle">Spring/JSF Demo</ui:define>
  
			<ui:define name="pageHeader">#{springBean.getMessage()}</ui:define>

			<ui:define name="body">
				<h:messages globalOnly='true' showSummary="true" showDetail="false" style="color: red; font-weight: bold;"/>
				<h:form id="signupForm">
					<h:panelGrid columns='3'>

					<h:outputText value="First Name"/>
					<h:inputText required="true" id="firstName" value="#{person.firstName}" />
					<h:message for="firstName" errorStyle="color:red"/>
					
					<h:outputText value="Email"/>
					<h:inputText required="true" id="email" value="#{person.email}" />
					<h:message for="email" errorStyle="color:red"/>

					<h:outputText value="Last Name"/>
					<h:inputText required="true" id="lastName" value="#{person.lastName}" />
					<h:message for="lastName"  errorStyle="color:red"/>

					<h:outputText value="Address"/>
					<h:inputText required="true" id="address" value="#{person.address}" />
					<h:message for="address"  errorStyle="color:red"/>

					<h:outputText value="City"/>
					<h:inputText required="true" id="city" value="#{person.city}" />
					<h:message for="city"  errorStyle="color:red"/>
					
					<h:outputText value=""/>
					<h:commandButton id="submit"
						action="#{personHandler.savePerson}" 
						value="Save" />
					</h:panelGrid>
				</h:form>
				
			</ui:define>
		</ui:composition>
	</body>
</html>
