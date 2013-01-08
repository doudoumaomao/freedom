package com.freedom.extend.data;

public class MysqlDialect extends DataDialect{

	@Override
	public String getLimitString(String sql, int skipResults, int maxResults) 
	{
		  skipResults--;
		  sql = sql.trim();  
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);  
        pagingSelect.append(sql);  
        pagingSelect.append(" limit " + skipResults + "," + maxResults);  
        return pagingSelect.toString(); 
	}

}
