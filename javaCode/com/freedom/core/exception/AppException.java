package com.freedom.core.exception;

import com.freedom.core.common.Constants;
/**
 * 自定义应用异常
 * @author maomao
 *
 */
public class AppException extends RuntimeException {
	
	public AppException(){
		super();
	}
	public AppException(String msg){
		super(Constants.Exception_Head + msg);
	}
}
