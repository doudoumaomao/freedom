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
import com.freedom.core.common.util.StringUtil;
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
	public String SysUserManage(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		List<SysUsers> userList = userManage.findAllSysUser();
		
		request.setAttribute("userList", StringUtil.toJsonString(userList));
		return "system/user/userManage";
	}
}
