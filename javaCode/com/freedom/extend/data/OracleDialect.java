package com.freedom.extend.data;

public class OracleDialect extends DataDialect{

    @Override
    public String getLimitString(String sql, int offset, int limit) 
    {
        sql = sql.trim();  
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);  
        
        pagingSelect.append("select * from (select row_.*,rownum rn_ from ( ");  
          
        pagingSelect.append(sql);  
          
        pagingSelect.append(" ) row_ where rownum <= ").append(limit).append(" )  where rn_ >= ").append(offset);  
          
        return pagingSelect.toString();  
    }
}
