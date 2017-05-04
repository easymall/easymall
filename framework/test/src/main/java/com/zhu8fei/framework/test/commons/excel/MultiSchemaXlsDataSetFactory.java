package com.zhu8fei.framework.test.commons.excel;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

public class MultiSchemaXlsDataSetFactory
  implements DataSetFactory
{
  protected String defaultSchemaName;
  
  public void init(Properties configuration, String defaultSchemaName)
  {
    this.defaultSchemaName = defaultSchemaName;
  }
  
  public MultiSchemaDataSet createDataSet(File... dataSetFiles)
  {
    try
    {
      MultiSchemaXlsDataSetReader multiSchemaXlsDataSetReader = new MultiSchemaXlsDataSetReader(this.defaultSchemaName);
      return multiSchemaXlsDataSetReader.readDataSetXls(dataSetFiles);
    }
    catch (Exception e)
    {
      throw new UnitilsException("Unable to create DbUnit dataset for data set files: " + Arrays.toString(dataSetFiles), e);
    }
  }
  
  public String getDataSetFileExtension()
  {
    return "xls";
  }
}
