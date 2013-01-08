package com.freedom.core.system.service;

import java.util.List;

import com.freedom.core.system.vo.user.SysUsers;
import com.freedom.extend.data.Pagination;

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
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<SysUsers> findAllSysUser();
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public SysUsers saveNewSysUser(SysUsers user);
	/**
	 * 查询所有用户并分页
	 * @return
	 */
	public void findAllSysUserPaging(Pagination pagination);
}
