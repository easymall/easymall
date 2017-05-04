package com.zhu8fei.framework.test.commons.mysql;

import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.unitils.dbunit.DbUnitModule;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

public class MySqlDbUnitModule
  extends DbUnitModule
{
  public DbUnitDatabaseConnection getDbUnitDatabaseConnection(String schemaName)
  {
    DbUnitDatabaseConnection dbConn = super.getDbUnitDatabaseConnection(schemaName);
    dbConn.getConfig().setProperty("http://www.dbunit.org/features/caseSensitiveTableNames", Boolean.valueOf(true));
    dbConn.getConfig().setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
    dbConn.getConfig().setProperty("http://www.dbunit.org/properties/metadataHandler", new MySqlMetadataHandler());
    return dbConn;
  }
}
