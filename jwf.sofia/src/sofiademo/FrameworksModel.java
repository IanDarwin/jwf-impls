package sofiademo;

import com.salmonllc.sql.*;

/**
 * FrameworksModel: A SOFIA generated model
 */
public class FrameworksModel extends DataStore {

     //constants for columns
     public static final String FRAMEWORKS_ID="frameworks.id";
     public static final String FRAMEWORKS_NAME="frameworks.name";
     public static final String FRAMEWORKS_URL="frameworks.url";
     public static final String FRAMEWORKS_YEAR="frameworks.year";
     public static final String FRAMEWORKS_SPONSOR="frameworks.sponsor";
     public static final String FRAMEWORKS_SHORTDESC="frameworks.shortdesc";
     public static final String FRAMEWORKS_LONGDESC="frameworks.longdesc";
     public static final String FRAMEWORKS_IMPLSUBDIR="frameworks.implsubdir";
     public static final String FRAMEWORKS_LICENCETYPE="frameworks.licencetype";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new FrameworksModel object.
      * @param appName The SOFIA application name
      */
     public FrameworksModel (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new FrameworksModel object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public FrameworksModel (String appName, String profile) { 
          super(appName, profile);

          //add columns
          addColumn(computeTableName("frameworks"),"id",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_ID);
          addColumn(computeTableName("frameworks"),"name",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_NAME);
          addColumn(computeTableName("frameworks"),"url",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_URL);
          addColumn(computeTableName("frameworks"),"year",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_YEAR);
          addColumn(computeTableName("frameworks"),"sponsor",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_SPONSOR);
          addColumn(computeTableName("frameworks"),"shortdesc",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_SHORTDESC);
          addColumn(computeTableName("frameworks"),"longdesc",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_LONGDESC);
          addColumn(computeTableName("frameworks"),"implsubdir",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_IMPLSUBDIR);
          addColumn(computeTableName("frameworks"),"licencetype",DataStore.DATATYPE_STRING,false,true,FRAMEWORKS_LICENCETYPE);
     }

     /**
      * Retrieve the value of the frameworks.id column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksId() throws DataStoreException {
          return  getString(FRAMEWORKS_ID);
     }

     /**
      * Retrieve the value of the frameworks.id column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksId(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_ID);
     }

     /**
      * Set the value of the frameworks.id column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksId(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_ID, newValue);
     }

     /**
      * Set the value of the frameworks.id column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksId(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_ID, newValue);
     }

     /**
      * Retrieve the value of the frameworks.name column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksName() throws DataStoreException {
          return  getString(FRAMEWORKS_NAME);
     }

     /**
      * Retrieve the value of the frameworks.name column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksName(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_NAME);
     }

     /**
      * Set the value of the frameworks.name column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksName(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_NAME, newValue);
     }

     /**
      * Set the value of the frameworks.name column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksName(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_NAME, newValue);
     }

     /**
      * Retrieve the value of the frameworks.url column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksUrl() throws DataStoreException {
          return  getString(FRAMEWORKS_URL);
     }

     /**
      * Retrieve the value of the frameworks.url column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksUrl(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_URL);
     }

     /**
      * Set the value of the frameworks.url column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksUrl(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_URL, newValue);
     }

     /**
      * Set the value of the frameworks.url column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksUrl(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_URL, newValue);
     }

     /**
      * Retrieve the value of the frameworks.year column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksYear() throws DataStoreException {
          return  getString(FRAMEWORKS_YEAR);
     }

     /**
      * Retrieve the value of the frameworks.year column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksYear(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_YEAR);
     }

     /**
      * Set the value of the frameworks.year column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksYear(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_YEAR, newValue);
     }

     /**
      * Set the value of the frameworks.year column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksYear(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_YEAR, newValue);
     }

     /**
      * Retrieve the value of the frameworks.sponsor column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksSponsor() throws DataStoreException {
          return  getString(FRAMEWORKS_SPONSOR);
     }

     /**
      * Retrieve the value of the frameworks.sponsor column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksSponsor(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_SPONSOR);
     }

     /**
      * Set the value of the frameworks.sponsor column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksSponsor(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_SPONSOR, newValue);
     }

     /**
      * Set the value of the frameworks.sponsor column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksSponsor(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_SPONSOR, newValue);
     }

     /**
      * Retrieve the value of the frameworks.shortdesc column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksShortdesc() throws DataStoreException {
          return  getString(FRAMEWORKS_SHORTDESC);
     }

     /**
      * Retrieve the value of the frameworks.shortdesc column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksShortdesc(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_SHORTDESC);
     }

     /**
      * Set the value of the frameworks.shortdesc column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksShortdesc(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_SHORTDESC, newValue);
     }

     /**
      * Set the value of the frameworks.shortdesc column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksShortdesc(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_SHORTDESC, newValue);
     }

     /**
      * Retrieve the value of the frameworks.longdesc column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksLongdesc() throws DataStoreException {
          return  getString(FRAMEWORKS_LONGDESC);
     }

     /**
      * Retrieve the value of the frameworks.longdesc column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksLongdesc(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_LONGDESC);
     }

     /**
      * Set the value of the frameworks.longdesc column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksLongdesc(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_LONGDESC, newValue);
     }

     /**
      * Set the value of the frameworks.longdesc column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksLongdesc(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_LONGDESC, newValue);
     }

     /**
      * Retrieve the value of the frameworks.implsubdir column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksImplsubdir() throws DataStoreException {
          return  getString(FRAMEWORKS_IMPLSUBDIR);
     }

     /**
      * Retrieve the value of the frameworks.implsubdir column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksImplsubdir(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_IMPLSUBDIR);
     }

     /**
      * Set the value of the frameworks.implsubdir column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksImplsubdir(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_IMPLSUBDIR, newValue);
     }

     /**
      * Set the value of the frameworks.implsubdir column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksImplsubdir(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_IMPLSUBDIR, newValue);
     }

     /**
      * Retrieve the value of the frameworks.licencetype column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksLicencetype() throws DataStoreException {
          return  getString(FRAMEWORKS_LICENCETYPE);
     }

     /**
      * Retrieve the value of the frameworks.licencetype column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getFrameworksLicencetype(int row) throws DataStoreException {
          return  getString(row,FRAMEWORKS_LICENCETYPE);
     }

     /**
      * Set the value of the frameworks.licencetype column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksLicencetype(String newValue) throws DataStoreException {
          setString(FRAMEWORKS_LICENCETYPE, newValue);
     }

     /**
      * Set the value of the frameworks.licencetype column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setFrameworksLicencetype(int row,String newValue) throws DataStoreException {
          setString(row,FRAMEWORKS_LICENCETYPE, newValue);
     }
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
