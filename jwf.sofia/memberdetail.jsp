<!-- This page build with SOFIA, see http://www.salmonllc.com-->

<%@ page extends="com.salmonllc.jsp.JspServlet"%>
<%@ taglib uri="/taglib.tld" prefix="salmon"%>
<html>
<salmon:page/> 
<salmon:body/>
<salmon:form name="pageForm">

  <!--Non Visual Part of the page, Define the DataSource-->

  <salmon:datasource name="datasource1" type="SQL" autoretrieve="OnChange">
    <salmon:datasourcedef> 
      <salmon:field tablename="news" fieldname="image"/>
      <salmon:field tablename="news" fieldname="story"/>
      <salmon:field tablename="news" fieldname="summary"/>
      <salmon:field tablename="news" fieldname="title"/>
    </salmon:datasourcedef>
    <salmon:selection> 
      <salmon:selectioncriteria fieldname="news.id" operator="EQUALS" value="%ID"/>
    </salmon:selection>
  </salmon:datasource>

  <!--Visual Part of the page-->

  <table width="600" border="0">
    <tr>
      <td rowspan="2" width="4%">
	  	<salmon:img name="img1" src="none" datasource="datasource1:news.image"/>
	  </td>
      <td width="96%" nowrap>
	    <salmon:text name="titleText" text="Title Goes Here" font="PageHeadingFont" datasource="datasource1:news.title"/>
	  </td>
    </tr>
    <tr> 
      <td width="96%">
	    <salmon:text name="summaryText" text="Summary Goes Here" font="SectionHeadingFont" datasource="datasource1:news.summary"/>
		<br>
  	  </td>
    </tr>
    <tr> 
      <td colspan="2">
	   <salmon:raw name="article" datasource="datasource1:news.story">Article Goes Here</salmon:raw>
	  </td>
    </tr>
  </table>
  <%@ include file="../return.jsp"%>
  <br><salmon:a name="viewSourceCode" href="%SourceCodeList?ID=1"><salmon:text name="sourceList" text="View Source Code" font="LinkFont"/></salmon:a>
</salmon:form>
<salmon:endbody/>
<salmon:endpage/> 
</html>
