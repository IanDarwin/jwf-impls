<%@page isErrorPage="true" %>
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
<p>
The error is <%= exception %>. More precisely:
</p>
<p>
<pre>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>
</p>
</body>
</html>
