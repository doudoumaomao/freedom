package com.freedom.core.system.vo.user;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.freedom.core.base.BaseDaoImpl;
import com.freedom.extend.data.Pagination;

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

	public SysUsers saveNewSysUser(SysUsers user) 
	{
		super.update("addSysUser",user);
		return user;
	}

	@Override
	public void findAllSysUserPaging(Pagination pagination) {
		super.findListPaging("User.allUser", pagination);
	}
}
