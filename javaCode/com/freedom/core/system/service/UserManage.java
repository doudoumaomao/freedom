package com.freedom.core.system.service;

import com.freedom.core.system.vo.user.SysUsers;

/**
 * 系统用户逻辑业务接口
 * @author maomao
 *
 */
public interface UserManage 
{

	/**
	 * 根据帐号查询用户对象
	 * @param accounts
	 * @return
	 */
	public SysUsers findByAccounts(String accounts);
}
