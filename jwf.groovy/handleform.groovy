import java.util.Date
import beans.Person
import beans.PersonDAO

bean = new Person();

# bean.setFirstName(${firstName})

out.println(<<<EOS
<html>
<head>
	<title>Thanks for Signing Up Via the Groovy Servlet</title>
</head>
<body>
The Groovy Servlet thanks you, 
${firstName} at ${request.remoteHost}, 
for signing up with us at ${new Date()}.
<hr/>
</body>
</html>
EOS)
out.println("Bean = " + bean);
new PersonDAO().insert(bean);
out.println("<hr>");
out.println("(database updated)");
