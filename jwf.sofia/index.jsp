<!-- Developed with SOFIA, see http://www.salmonllc.com -->

<%@ page extends="com.salmonllc.jsp.JspServlet" %>
<%@ taglib uri="/taglib.tld" prefix="salmon" %>

<salmon:page application="sofiademo" controller="sofiademo.PersonListController"/>

<salmon:body/>

<salmon:datasource name="jwf" type="MODEL" model="sofiademo.PersonModel"/>

<salmon:form name="pageForm">

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="2"><salmon:text name="title" text="Person Data Entry Example" font="PageHeadingFont"/><br/>
      </td>
    </tr>
    <tr>
      <td colspan="2"><salmon:text name="heading" 
      	text="This is a SOFIA-style add/list/search data entry screen." 
      	font="DefaultFont"/><br>
        <br/>
      </td>
    </tr>
	<!-- This tr is the add/search box -->
    <tr>
      <td><salmon:box name="box1" width="500">
          <salmon:displaybox name="displaybox1" caption="People List" width="100%">
	          <salmon:displayboxheader>
	            <salmon:input type="submit" name="add" value="Add"></salmon:input>
	            <salmon:input type="submit" name="search" value="Search"></salmon:input>
	          </salmon:displayboxheader>
	          <salmon:displayboxcontents>
	            <table border="0" cellspacing="5" cellpadding="0">
	              <tr>
	                <td colspan="2" width="300"><salmon:font type="DefaultFont">
					Please click &quot;Add&quot; to go to the Add page and
					add a new person.
					<hr/>
					Or enter some criteria and click &quot;Search&quot; 
					to search the people that have been signed up.
	                </salmon:font>
	                  <br/>
	                </td>
	              </tr>
	              <tr>
	                <td><salmon:text name="capFirstName" text="First Name" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="firstName" size="40" maxlength="255"></salmon:input></td>
	              </tr>
	              <tr>
	                <td><salmon:text name="capLastName" text="Last Name" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="lastName" size="40" maxlength="255"></salmon:input></td>
	              </tr>
	              <tr>
	                <td><salmon:text name="capEMail" text="EMail" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="eMail" size="40" maxlength="255"></salmon:input></td>
	              </tr>         
	              <tr>
	                <td><salmon:text name="capAddress1" text="Address" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="address1" size="40" maxlength="255"></salmon:input></td>
	              </tr>
	              <tr>
	                <td><salmon:text name="capAddress2" text="(continued)" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="address2" size="40" maxlength="255"></salmon:input></td>
	              </tr>
	               <tr>
	                <td><salmon:text name="capCity" text="City" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="city" size="40" maxlength="255"></salmon:input></td>
	              </tr>    
	              <tr>
	                <td><salmon:text name="capProvince" text="Prov/State" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="province" size="40" maxlength="255"></salmon:input></td>
	              </tr>        
	              <tr>
	                <td><salmon:text name="capCountry" text="Country" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="country" size="40" maxlength="255"></salmon:input></td>
	              </tr>        
	              <tr>
	                <td><salmon:text name="capPostCode" text="PostCode" font="ColumnCaptionFont"/></td>
	                <td><salmon:input type="text" name="postcode" size="40" maxlength="255"></salmon:input></td>
	              </tr>        	                      
	            </table>
	          </salmon:displayboxcontents>
          </salmon:displaybox>
          </salmon:box>
          </td>
    </tr>
	<!-- This tr is the Listing Box... -->
    <tr>
      <td><a name="scrollToMe"></a>
      <salmon:box name="box2" width="500">
	  <salmon:datatable name="people" datasource="jwf" clicksort="true" 
		rowsperpage="10" pageselectortype="text" rowsperpageselector="false" 
		width="100%" align="Left" cellpadding="5" cellspacing="0">
      <salmon:datatableheader>
            <salmon:tr><salmon:td valign="top"><salmon:font type="TableHeadingFont"> Name </salmon:font></salmon:td>
               <salmon:td valign="top"><salmon:font type="TableHeadingFont">
                          Address</salmon:font>
				</salmon:td>
			</salmon:tr>
      </salmon:datatableheader>
      <salmon:datatablerows>
            <salmon:tr><salmon:td valign="top"><salmon:a name="nameLink" href="details" datasource="jwf:'%details?id='+people.id">
            <salmon:text name="rowName" text="Name here" datasource="jwf:people.firstname+' '+people.lastname" font="LargeLinkFont"/></salmon:a></salmon:td>
            <salmon:td><salmon:text name="rowAddr" text="City Here" datasource="jwf:people.city"/></salmon:td>
			</salmon:tr>
      </salmon:datatablerows>
      </salmon:datatable>
      </salmon:box>
      </td>
    </tr>
  </table>
</salmon:form>
<salmon:endbody/>
<salmon:endpage/>
</html>
