<!-- Developed with SOFIA, see http://www.salmonllc.com -->

<%@ page extends="com.salmonllc.jsp.JspServlet" %>
<%@ taglib uri="/taglib.tld" prefix="salmon" %>

<salmon:page application="sofiademo" controller="sofiademo.PersonDetailsController"/>

<salmon:body/>

<salmon:datasource name="jwf" type="MODEL" model="sofiademo.PersonModel" autoretrieve="never"/>

<salmon:form name="pageForm">

<salmon:text name="txtHead" text="Person Details" font="PageHeadingFont"/><br><br>
<salmon:validator name="errorMessage" visible="false" breaksafter="2" 
	allowmultipleerrors="true" focuslinks="true" rulejs="true" 
	validatorclass="sofiademo.PersonValidator" datasource="jwf" 
	submitcomponents="save"/> 
 <salmon:box name="box1"><salmon:displaybox name="displaybox1" caption="Details"><salmon:displayboxheader>
        <salmon:input type="submit" name="delete" value="Delete"></salmon:input>
        <salmon:input type="submit" name="save" value="Save"></salmon:input>
        <salmon:input type="submit" name="cancel" value="Cancel"></salmon:input>
    </salmon:displayboxheader><salmon:displayboxcontents>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><salmon:text name="capFirstName" text="First Name" font="ColumnCaptionFont"/></td>
          <td> <salmon:input type="text" name="firstname" size="16" maxlength="255" datasource="jwf:people.firstname"></salmon:input></td>
          <td> <salmon:text name="capLastName" text="Last Name" font="ColumnCaptionFont"/></td>
          <td> <salmon:input type="text" name="lastname" size="16" maxlength="255" datasource="jwf:people.lastname"></salmon:input></td>
        </tr>
        <tr>
          <td><salmon:text name="capEmail" text="EMail" font="ColumnCaptionFont"/></td>
          <td colspan="3"> <salmon:input type="text" name="email" size="64" maxlength="255" datasource="jwf:people.email"></salmon:input></td>
        </tr>
        <tr>
          <td><salmon:text name="capAddress1" text="Address" font="ColumnCaptionFont"/></td>
          <td colspan="3"> <salmon:input type="text" name="address1" size="64" maxlength="255" datasource="jwf:people.address1"></salmon:input></td>
        </tr>
       <tr>
          <td><salmon:text name="capAddress2" text="(continued)" font="ColumnCaptionFont"/></td>
          <td colspan="3"> <salmon:input type="text" name="address2" size="64" maxlength="255" datasource="jwf:people.address2"></salmon:input></td>
        </tr>        
        <tr>
          <td><salmon:text name="capCity" text="City" font="ColumnCaptionFont"/></td>
          <td><salmon:input type="text" name="city" size="16" maxlength="255" datasource="jwf:people.city"></salmon:input></td>
          <td><salmon:text name="capState" text="Province/State" font="ColumnCaptionFont"/></td>
          <td><salmon:input type="state" name="province" datasource="jwf:people.province"></salmon:input></td>
        </tr>
        <tr>
          <td><salmon:text name="capZip" text="PostCode" font="ColumnCaptionFont"/></td>
          <td><salmon:input type="zip" name="postcode" datasource="jwf:people.postcode"></salmon:input></td>
           <td><salmon:text name="capCountry" text="Country" font="ColumnCaptionFont"/></td>
          <td><salmon:input type="text" name="country" datasource="jwf:people.country"></salmon:input></td>
         </tr>
      </table>
    </salmon:displayboxcontents></salmon:displaybox></salmon:box>
  <%--The hidden field is part of the table that isn't displayed.
  It is there because it will cause the browser to pass the value of the field back
  to the server and help to recover from a session timeout error.--%>
  <salmon:input type="hidden" name="id" value="-1" datasource="jwf:people.id"></salmon:input>
</salmon:form>

<br>
<salmon:a name="viewSourceCode" href="%SourceCodeList.jsp?ID=8"><salmon:text name="sourceList" text="View Source Code" font="LinkFont"/></salmon:a>
<salmon:endbody/>
<salmon:endpage/>
