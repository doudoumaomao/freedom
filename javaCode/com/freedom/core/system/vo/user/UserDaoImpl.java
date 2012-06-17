package com.freedom.core.system.vo.user;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.freedom.core.base.BaseDaoImpl;

/**
 * 系统用户数据访问实现类
 * @author maomao
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao 
{
	
	public List<SysUsers> findByAccounts(String accounts) 
	{
		return super.findList("User.findByAccounts",accounts);
	}

	public List<SysUsers> findAllSysUser() 
	{
		return super.findList("User.allUser");
	}
}
