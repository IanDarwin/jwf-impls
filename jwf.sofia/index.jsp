<%@ page extends="com.salmonllc.jsp.JspServlet"%>
<%@ taglib uri="/taglib.tld" prefix="salmon"%>
<html>
	<head><title>Signups Listing</title></head>
<salmon:page/>
<salmon:body/>
<salmon:form name="pageForm">

  <!--Non Visual Part of the Page, Define the DataSource-->

  <salmon:datasource name="jwf" type="SQL" autoretrieve="Always">
    <salmon:datasourcedef>
      <salmon:field tablename="people" fieldname="firstName"/>
      <salmon:field tablename="people" fieldname="lastName"/>
    </salmon:datasourcedef>
    <salmon:order>
      <salmon:field fieldname="people.lastName" sortdir="ASC"/>
    </salmon:order>
  </salmon:datasource>

  <!--Visual Part of the page-->

  <salmon:text name="Title" text="Signups List" font="PageHeadingFont"/><br/>
  <salmon:box name="box1">
	<salmon:datatable clicksort="true" rowsperpage="10" pageselectortype="text" rowsperpageselector="false" name="people" width="100%" align="Left" datasource="jwf" cellpadding="5" cellspacing="0">
      <salmon:datatableheader>
      <salmon:tr><salmon:td><salmon:text name="text3" text="Person Info" font="TableHeadingFont"/></salmon:td></salmon:tr>
    </salmon:datatableheader>
    <salmon:datatablerows>
      <salmon:tr>
      <salmon:td><salmon:text name="name" text="Name Here" font="DefaultFont" datasource="jwf:people.firstName"/></salmon:td>
      <salmon:td><salmon:text name="url" text="Name Here" font="DefaultFont" datasource="jwf:people.lastName"/></salmon:td>
	</salmon:tr>
    </salmon:datatablerows>
    </salmon:datatable>
  </salmon:box>
</salmon:form>
<salmon:endbody/>
<salmon:endpage/>
</html>
