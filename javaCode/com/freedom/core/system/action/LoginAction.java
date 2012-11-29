package com.freedom.core.system.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freedom.core.base.BaseAction;
import com.freedom.common.Constants;
import com.freedom.common.util.SessionListener;
import com.freedom.core.system.service.UserManage;
import com.freedom.core.system.vo.user.SysUsers;


/**
 * 登录Action用于处理用户登录
 * @author maomao
 *
 */
@Controller
public class LoginAction extends BaseAction 
{
	private static Log log = LogFactory.getLog(LoginAction.class);
	
	@Resource
	private UserManage userManage;
	
	/**
	 * 从登录页登录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login_Login.action")
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		String accounts = request.getParameter("accounts");
		String password = request.getParameter("password");
		
		log.info("帐户[" + accounts + "]正尝试登陆系统...");
		
		SysUsers user = userManage.findByAccounts(accounts);
		
		String returnText = "登陆成功！";
		
		if(user == null)
		{
			returnText = "帐号输入错误,请重新输入!";
			log.warn("帐户[" + accounts + "]登陆失败.(失败原因：不存在此帐户)");
			write(returnText, response);
			return "system/login";
		}
		if(!password.equals(user.getPassword()))
		{
			returnText = "帐号输入错误,请重新输入!";
			log.warn(user.getUserName() + "[" + user.getAccounts() + "]" + "登录系统失败(失败原因：密码输入错误)");
			write(returnText, response);
			return "system/login";
		}
		
		log.info(user.getUserName() + "[" + user.getAccounts() + "]" + "成功登录系统!创建了一个有效Session连接,会话ID:["
				+ request.getSession().getId() + "]");
		
		//将当前用户放到session以便其他地方获取用户对象
		request.getSession().setAttribute(Constants.SESSION_LOGIN_USER, user);
		//将当前用户放到session监控器中
		SessionListener.addSessionUser(request.getSession(), user);
		
		request.setAttribute("message", returnText);
		return "success";
	}
}
