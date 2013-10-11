<%@page isErrorPage="true"%>
<h1>Error Report</h1>
This database access failed.
The exception report is as follows:
<pre><%= exception %>.</pre>
<p>In more detail:
<pre>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>