package com.freedom.core.base;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * 该类用于实现基础Dao
 * @author maomao
 *
 */
public class BaseDaoImpl implements BaseDao 
{
	@Resource
    public SqlSessionTemplate sqlSession;

	public <T> List<T> findList(String sqlMap) 
	{
		return sqlSession.selectList(sqlMap);
	}
	
	public <T> List<T> findList(String sqlMap, Object parameter) 
	{
		return sqlSession.selectList(sqlMap, parameter);
	}
	
	public int update(String sqlMap) 
	{
		return sqlSession.update(sqlMap);
	}

	public int update(String sqlMap, Object parameter) 
	{
		return sqlSession.update(sqlMap,parameter);
	}
	
}
