package com.zhu8fei.framework.test.commons.excel;

import org.apache.commons.lang.StringUtils;
import org.dbunit.dataset.AbstractTable;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.DefaultTableMetaData;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ITableMetaData;
import org.unitils.core.UnitilsException;

public class XlsTableWrapper
  extends AbstractTable
{
  private String tableName;
  private ITable delegate;
  
  public XlsTableWrapper(String tableName, ITable delegate)
  {
    this.tableName = tableName;
    this.delegate = delegate;
  }
  
  public ITableMetaData getTableMetaData()
  {
    ITableMetaData meta = this.delegate.getTableMetaData();
    try
    {
      return new DefaultTableMetaData(this.tableName, meta.getColumns(), meta.getPrimaryKeys());
    }
    catch (DataSetException e)
    {
      throw new UnitilsException("Don't get the meta info from  " + meta, e);
    }
  }
  
  public int getRowCount()
  {
    return this.delegate.getRowCount();
  }
  
  public Object getValue(int row, String column)
    throws DataSetException
  {
    Object delta = this.delegate.getValue(row, column);
    if (((delta instanceof String)) && 
      (StringUtils.isEmpty((String)delta))) {
      return null;
    }
    return delta;
  }
}
