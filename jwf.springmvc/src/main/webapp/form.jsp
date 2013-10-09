<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org
<html>

	<body>

   		<head><title">Spring/JSF Demo</title>
			<ui:define name="pageHeader">#{springBean.getMessage()}</ui:define>
		</head>
		
		<body>
				<c:if test="${not empty message}"><div class="errors">${message}</div>
				</c:if>
				
				<form:form id="signupForm" modelAttribute="person">

					<label for="nameInput">First Name: </label>
      				<form:input path="firstName" id="firstName" />
      				<br/>
      				
      				<label for="nameInput">Last Name: </label>
      				<form:input path="lastName" id="lastName" />
      				<br/>
      				
      				<label for="nameInput">Email: </label>
      				<form:input path="email" id="email" />
      				<br/>
										
					<input type="submit" value="Save" />
					
				</form:form>
	</body>
</html>
