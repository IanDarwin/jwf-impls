<%@page isErrorPage="true" import="java.io.*" %>
<!-- 
  -- $Id$
  -->
<html>
<head>
	<title>Ummm...</title>
</head>
<body>
<h1>Oh dear!</h1>
<p>This came as a <b>complete surprise</b> to me at this point
in my programming.
Somehow, your interactions with 
this demonstration
have led to an error being reported.
</p>
<p>It would help us if you could 
<a href="mailto:<%= "webmaster@darwinsys.com" %>">
report what you were doing when this error occurred</a>.
</p>
<!--
  <p>The page that blew is
  <%= (String)request.getAttribute("sourcePage") %>
  </p>
  -->
<p>The exception is: <%= exception.toString() %>
<p>The underlying cause was: <%= exception.getCause() %>
<pre>
<% exception.printStackTrace(new PrintWriter(out)); %>
</pre>
</font>
</body>
</html>
