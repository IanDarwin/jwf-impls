<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/expresso" prefix="expresso" %>

 <expresso:useController id="controller" scope="session" 
     className="jwfdemo.controller.DemoController" 
     state="listAll" >
 </expresso:useController>

 <table width="100%" border="1" cellspacing="1" cellpadding="2" >
     <tr>
         <th> <b>FirstName</b> </th>
         <th> <b>LastName</b> </th>
         <th> <b>Email</b> </th>
 
     </tr>

 <expresso:block controller="controller" blockPath="StockList"
             id="blockStocks" >
     <beans:iterate name="blockStocks" property="nested" 
         loopId="block" counterId="counter"
         className="com.jcorporate.expresso.core.controller.Block" >
     <tr>
         <expresso:output outputPath="Detail" blockName="block" >
             <td> <expresso:outputAttribute property="FirstName" /> &nbsp; </td>
             <td> <expresso:outputAttribute property="LastName" /> &nbsp; </td>
 
     </expresso:output>
 		<!--
		form action="<%= contextPath %>/servlet/ControllerServlet?cmd=button" method="POST">
             td>
                 expresso:action actionName="Edit" blockName="block" />
             /td>
         /form>
		 -->
     </tr>
   </beans:iterate>
 </expresso:block>
 </table>
