<%@page isErrorPage="true" import="beans.*" %>
<!-- 
  -- $Id$
  -->
<html>
<head>
	<title>Oops...</title>
</head>
<body>
<font size="+3"><h1>Oops...</h1></font>
Somehow, your interactions with this software have led to an error.
<p>It would be helpful if you could please
report via email what you were doing when this error occurred</a>.
<% String badPage = (String)request.getAttribute("sourcePage");
	if (badPage != null) {
 %>
  <p>The page that blew is
  <%= (String)request.getAttribute("sourcePage") %>
<% } %>
<p>The exception is:
<pre>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>
</body>
</html>
