package com.freedom.core.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.freedom.common.util.StringUtil;
import com.freedom.exception.NullAbleException;
import com.freedom.extend.data.Pagination;

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

	@Override
	public void findListPaging(String sqlMap, Pagination pagination) 
	{
		if(StringUtil.isEmpty(sqlMap))
			throw new NullAbleException(sqlMap);
		if(pagination == null)
			throw new NullAbleException(Pagination.class);
		
		pagination.setTotal((int)sqlSession.selectOne(sqlMap + "Total"));
		pagination.setRows(sqlSession.selectList(sqlMap,null,new RowBounds(pagination.getStartNumber(), pagination.getEndNumber())));
	}
	
}
