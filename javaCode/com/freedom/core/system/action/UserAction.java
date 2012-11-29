package com.freedom.core.system.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freedom.core.base.BaseAction;
import com.freedom.common.Constants;
import com.freedom.common.util.StringUtil;
import com.freedom.core.system.service.UserManage;
import com.freedom.core.system.vo.user.SysUsers;
/**
 * 用户Action处理所有系统用户
 * @author maomao
 *
 */
@Controller
public class UserAction extends BaseAction
{
	private static Log log = LogFactory.getLog(LoginAction.class);
	
	@Resource
	private UserManage userManage;
	
	/**
	 * 用户管理
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userManage_User.action")
	public String sysUserManage(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		return "system/user/userManage";
	}
	/**
	 * 增加用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSysUser_User.action")
	public String addSysUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		if(StringUtil.isNotEmpty(request.getParameter("flag")) && "true".equals(request.getParameter("flag")))
		{
			SysUsers user = new SysUsers();
			user.setUserName(request.getParameter("userName"));
			user.setAccounts(request.getParameter("account"));
			user.setPassword(request.getParameter("password"));
			user.setState(request.getParameter("state"));
			
			userManage.saveNewSysUser(user);
		}
		
		return "system/user/addUser";
	}
	
	@RequestMapping("/ajaxGetUserList_User.action")
    public String ajaxGetUserList(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
	    System.out.println(request.getParameter("page"));
	    System.out.println(request.getParameter("pagesize"));
	    
        List<SysUsers> userList = userManage.findAllSysUser();
        System.out.println("+++++++++" + userList.size());
        request.setAttribute("str",StringUtil.toJsonString(userList, Constants.FORMAT_DateTime));
        return "common/ajax";
    }
}
