package com.freedom.core.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DispatchAction基类
 * @author maomao
 *
 */
public class BaseAction 
{
	private static Log log = LogFactory.getLog(BaseAction.class);
	
	/**
	 * 输出响应
	 * 
	 * @param str
	 * @throws IOException
	 */
	protected void write(String str, HttpServletResponse response) throws IOException {
		response.getWriter().write(str);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
}
