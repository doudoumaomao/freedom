package com.freedom.core.common.util;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.freedom.core.system.vo.user.SysUsers;

/**
 * session监听器
 * @author maomao
 *
 */
public class SessionListener implements HttpSessionListener 
{
	private static Log log = LogFactory.getLog(SessionListener.class);
	//保存用户集合
	private static HashMap<String,SysUsers> usersMap = new HashMap<String,SysUsers>();
	
	/**
	 * session创建
	 */
	public void sessionCreated(HttpSessionEvent event) 
	{
		
	}
	/**
	 * session销毁
	 */
	public void sessionDestroyed(HttpSessionEvent event) 
	{
		usersMap.remove(event.getSession().getId());
		log.info("销毁了一个Session连接:" + event.getSession().getId());
	}
	/**
	 * 增加session用户
	 * @param session
	 * @param user
	 */
	public static void addSessionUser(HttpSession session, SysUsers user)
	{
		usersMap.put(session.getId(), user);
	}
	/**
	 * 获取session用户数量
	 * @return
	 */
	public static int getSessionUserNumber()
	{
		return usersMap.size();
	}
	/**
	 * 获取所有session中的用户数组
	 * @return
	 */
	public static SysUsers[] getAllSessionUser()
	{
		return usersMap.entrySet().toArray(new SysUsers[usersMap.size()]);
	}
}
