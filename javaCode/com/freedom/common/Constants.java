package com.freedom.common;

public interface Constants 
{
    /**
     * 异常信息统一头信息<br>
     * 非常遗憾的通知您,程序发生了异常
     */
    public static final String Exception_Head = "\n非常遗憾的通知您,程序发生了异常.\n" + "异常信息如下:\n";
    /**
     * 格式化<br>
     * FORMAT_DateTime: 日期时间
     */
    public static final String FORMAT_DateTime = "yyyy-MM-dd hh:mm:ss";

    /**
     * 格式化<br>
     * FORMAT_DateTime: 日期
     */
    public static final String FORMAT_Date = "yyyy-MM-dd";

    /**
     * 格式化<br>
     * FORMAT_DateTime: 时间
     */
    public static final String FORMAT_Time = "hh:mm:ss";
    
    /**
     * session请求用户
     */
    public static final String SESSION_LOGIN_USER = "session_login_user";
}
