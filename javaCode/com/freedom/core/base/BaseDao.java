package com.freedom.core.base;

import java.util.List;

import com.freedom.extend.data.Pagination;

/**
 * 基本Dao，该接口用于封装Dao公共方法
 * @author maomao
 *
 */
public interface BaseDao 
{
	/**
	 * 查询指定SQLMap
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findList(String sqlMap);
	/**
	 * 查询带参数的SqlMap
	 * @param <T>
	 * @param sqlMap
	 * @param parameter
	 * @return
	 */
	public <T> List<T> findList(String sqlMap,Object parameter);
	/**
	 * 执行数据库操作
	 * @param sqlMap
	 * @return
	 */
	public int update(String sqlMap);
	/**
	 * 执行数据库带参数的SqlMap
	 * @param <T>
	 * @param sqlMap
	 * @param parameter
	 * @return
	 */
	public int update(String sqlMap,Object parameter);
	/**
	 * 按分页查询指定SqlMap
	 * @param sqlMap
	 * @param parameter
	 * @param paging
	 * @return
	 */
	public void findListPaging(String sqlMap,Pagination pagination);
}
