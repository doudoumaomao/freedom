package com.freedom.extend.data;

import java.util.List;
import java.util.Map;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 分页类
 * @ClassName: Pagination 
 * @Description: 获取分页数据使用
 * @author A18ccms a18ccms_gmail_com 
 * @date 2012-11-29 下午06:27:57 
 *
 */
@JsonIgnoreProperties(value = {"page","pagesize","startNumber","endNumber","parameter"})
public class Pagination 
{
    private int page = 1;        //当前页码，从1计起 
    private int pagesize = 1;    //每页记录数
    private int total = 0;     //总记录数 
    private int startNumber = 1; //起始数
    private int endNumber = 1;   //截至数
    private List<?> rows;        //数据结果集
    private Map<?,?> parameter;  //参数
    
    public Pagination(int page,int pagesize)
    { 
        this.page = page;
        this.pagesize = pagesize;
        //计算起始数
        this.startNumber = page * pagesize - (pagesize - 1);
        
        if(this.startNumber < 1)
        {
            this.startNumber = 1;
        }
        //计算截至数
        this.endNumber = page * pagesize;
    }
    
    public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getPage() {
        return page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

	public Map<?, ?> getParameter() {
        return parameter;
    }

    public void setParameter(Map<?, ?> parameter) {
        this.parameter = parameter;
    }

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
    
}
