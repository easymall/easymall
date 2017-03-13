package com.zhu8fei.mybatis.plugins;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitor;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SubSelect;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.slf4j.Logger;

@Intercepts({@org.apache.ibatis.plugin.Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class})})
public class UpdateInterceptor
  extends AbstractInterceptor
{
  static int MAPPED_STATEMENT_INDEX = 0;
  static int PARAMETER_INDEX = 1;
  static String COMPANY_ID = "company_id";
  
  public Object intercept(Invocation invocation)
    throws Throwable
  {
    if (!this.enabled) {
      return invocation.proceed();
    }
    Executor executor = (Executor)invocation.getTarget();
    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement)args[MAPPED_STATEMENT_INDEX];
    Object parameter = args[PARAMETER_INDEX];
    if ((this.ignoreSet != null) && (this.ignoreSet.contains(ms.getId()))) {
      return invocation.proceed();
    }
    BoundSql boundSql = ms.getBoundSql(parameter);
    String sql = boundSql.getSql();
    Statement statement = CCJSqlParserUtil.parse(sql);
    String tableName = null;
    boolean isInsert = false;
    if ((statement instanceof Insert))
    {
      tableName = ((Insert)statement).getTable().getFullyQualifiedName();
      isInsert = true;
    }
    if (parameter != null) {
      if ((parameter instanceof BasePO))
      {
        _setCommonProps(isInsert, tableName, parameter);
      }
      else if ((parameter instanceof Map))
      {
        Map map = (Map)parameter;
        visitMap(isInsert, tableName, map);
      }
    }
    return invocation.proceed();
  }
  
  private void visitMap(boolean isInsert, String tableName, Map map)
  {
    Collection values = map.values();
    for (Object value : values)
    {
      if ((value instanceof BasePO)) {
        ((BasePO)value).setCompanyId(SystemContext.getCompanyId());
      }
      int dataType = DataType.getDataType(value);
      if (dataType == 30)
      {
        Object[] objects = (Object[])value;
        for (Object object : objects) {
          _setCommonProps(isInsert, tableName, object);
        }
      }
      else if (dataType == 31)
      {
        List list = (List)value;
        for (Object object : list) {
          _setCommonProps(isInsert, tableName, object);
        }
      }
    }
  }
  
  private void _setCommonProps(boolean isInsert, String tableName, Object object)
  {
    try
    {
      if (!(object instanceof BasePO)) {
        return;
      }
      BasePO basePO = (BasePO)object;
      basePO.setCompanyId(SystemContext.getCompanyId());
      if (isInsert)
      {
        Long id = basePO.getId();
        if (id == null) {
          try
          {
            long uuid = SEQUtil.getUUID(tableName);
            basePO.setId(Long.valueOf(uuid));
          }
          catch (Exception e)
          {
            throw new RuntimeException(e.getMessage(), e);
          }
        }
        if (basePO.getCreateUserid() == null) {
          basePO.setCreateUserid(SystemContext.getUserId());
        }
        if (basePO.getCreateUsername() == null) {
          basePO.setCreateUsername(SystemContext.getUserName());
        }
        if (basePO.getServerIp() == null)
        {
          String localHostAddress = NetUtils.getLocalAddress().getHostAddress();
          basePO.setServerIp(localHostAddress);
        }
      }
      else if ((object instanceof BaseBizPO))
      {
        BaseBizPO baseBizPO = (BaseBizPO)object;
        if (baseBizPO.getUpdateUserid() == null) {
          baseBizPO.setUpdateUserid(SystemContext.getUserId());
        } else if (baseBizPO.getUpdateUsername() == null) {
          baseBizPO.setUpdateUsername(SystemContext.getUserName());
        }
      }
    }
    catch (Exception e)
    {
      this.logger.error(e.getMessage(), e);
    }
  }
  
  private void _scanCompanyId(Invocation invocation)
    throws Exception
  {
    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement)args[MAPPED_STATEMENT_INDEX];
    Object parameter = args[PARAMETER_INDEX];
    BoundSql boundSql = ms.getBoundSql(parameter);
    String sql = boundSql.getSql();
    Statement statement = CCJSqlParserUtil.parse(sql);
    if ((statement instanceof Insert))
    {
      List<Column> columns = ((Insert)statement).getColumns();
      boolean hasCompanyId = false;
      if ((columns != null) && (columns.size() > 0))
      {
        for (Column column : columns)
        {
          String columnName = column.getColumnName();
          if (columnName.equals(COMPANY_ID)) {
            hasCompanyId = true;
          }
        }
        if (!hasCompanyId)
        {
          columns.add(new Column(COMPANY_ID));
          ItemsList itemsList = ((Insert)statement).getItemsList();
          itemsList.accept(new ItemsListVisitor()
          {
            public void visit(SubSelect subSelect) {}
            
            public void visit(ExpressionList expressionList)
            {
              expressionList.getExpressions().add(new LongValue(SystemContext.getCompanyId().longValue()));
            }
            
            public void visit(MultiExpressionList multiExpressionList)
            {
              List<ExpressionList> exprList = multiExpressionList.getExprList();
              if (exprList != null) {
                for (ExpressionList expressionList : exprList) {
                  expressionList.getExpressions().add(new LongValue(SystemContext.getCompanyId().longValue()));
                }
              }
            }
          });
          args[MAPPED_STATEMENT_INDEX] = MybatisStatementUtils.copyFromNewSql(ms, boundSql, statement.toString(), boundSql.getParameterMappings(), boundSql.getParameterObject());
          args[PARAMETER_INDEX] = parameter;
        }
      }
    }
  }
}
