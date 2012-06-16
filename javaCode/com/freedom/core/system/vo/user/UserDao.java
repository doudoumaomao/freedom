package com.freedom.core.system.vo.user;

import java.util.List;

import com.freedom.core.base.BaseDao;
/**
 * 系统用户数据访问接口
 * @author maomao
 *
 */
public interface UserDao extends BaseDao 
{
	/**
	 * 根据帐号查询用户
	 * @param accounts
	 * @return
	 */
	List<SysUsers> findByAccounts(String accounts);

}
