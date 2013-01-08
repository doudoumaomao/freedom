package com.freedom.extend.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;  
import org.apache.ibatis.plugin.Interceptor;  
import org.apache.ibatis.plugin.Intercepts;  
import org.apache.ibatis.plugin.Invocation;  
import org.apache.ibatis.plugin.Plugin;  
import org.apache.ibatis.plugin.Signature;  
import org.apache.ibatis.reflection.MetaObject;  
import org.apache.ibatis.session.Configuration;  
import org.apache.ibatis.session.RowBounds;

import com.freedom.extend.data.DataDialect;
import com.freedom.extend.data.MysqlDialect;
import com.freedom.extend.data.OracleDialect;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PaginationInterceptor implements Interceptor 
{
    private static Log log = LogFactory.getLog(PaginationInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable 
     {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();  
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);  
        
        RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");  
        if(rowBounds == null || rowBounds == RowBounds.DEFAULT)
           {  
            return invocation.proceed();  
           }  
        String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");  
        
        Configuration configuration = (Configuration)metaStatementHandler.getValue("delegate.configuration");  

        DataDialect.Type databaseType  = null;  
        try
           {  
            databaseType = DataDialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());  
           } 
        catch(Exception e)
           {  
        	log.error(e);
           }  
        if(databaseType == null)
           {  
            throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + configuration.getVariables().getProperty("dialect"));  
           }  
        DataDialect dialect = null;  
        switch(databaseType)
           {  
            case ORACLE:  
                dialect = new OracleDialect();
                break;  
            case MYSQL:
            	 dialect = new MysqlDialect();
                break;
           }  
        System.out.println("SQL:" + dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
        metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()) );  
        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );  
        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );  
        
        return invocation.proceed();  
    }

 
   @Override
   public Object plugin(Object target) {
        // TODO Auto-generated method stub
        return Plugin.wrap(target, this);
    }

   @Override
   public void setProperties(Properties arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
