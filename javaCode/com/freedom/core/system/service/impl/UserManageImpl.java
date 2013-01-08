package com.freedom.core.system.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.freedom.core.system.service.UserManage;
import com.freedom.core.system.vo.user.SysUsers;
import com.freedom.core.system.vo.user.UserDao;
import com.freedom.extend.data.Pagination;
import com.sun.istack.internal.NotNull;

/**
 * 系统用户业务逻辑实现类
 * @author maomao
 *
 */
@Repository("userManage")
public class UserManageImpl implements UserManage
{
	@Resource
	private UserDao userDao;
	
	public SysUsers findByAccounts(String accounts) {
		List<SysUsers> userList = userDao.findByAccounts(accounts);
		if(!userList.isEmpty())
		{
			return userList.get(0);
		}
		return null;
	}

	public List<SysUsers> findAllSysUser() 
	{
		return userDao.findAllSysUser();
	}

	public SysUsers saveNewSysUser(SysUsers user) 
	{
		return userDao.saveNewSysUser(user);
	}

	@Override
	public void findAllSysUserPaging(Pagination pagination) {
		userDao.findAllSysUserPaging(pagination);
	}
}
