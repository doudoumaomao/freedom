package com.freedom.extend.data;

public abstract class DataDialect 
{
    public static enum Type
    {  
        MYSQL,  
        ORACLE  
    }
    public abstract String getLimitString(String sql, int skipResults, int maxResults); 
}
