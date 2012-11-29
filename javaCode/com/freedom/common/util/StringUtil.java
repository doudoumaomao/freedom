package com.freedom.common.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 字符串工具
 * @author maomao
 *
 */
public class StringUtil 
{
	public static String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	public static boolean isEmpty(String value)
	{
	    return ((value == null) || (value.length() == 0));
	}
	
	public static boolean isNotEmpty(String value)
	{
	    return (!(isEmpty(value)));
	}
	
	public static boolean isEmpty(StringBuilder value)
	{
	    return ((value == null) || (value.length() == 0));
	}
	
    public static boolean isNotEmpty(StringBuilder value)
	{
	    return (!(isEmpty(value)));
	}
	
	public static boolean isEmptyTrim(String value)
	{
	    return ((value == null) ? true : isEmpty(value.trim()));
	}
	
	public static boolean isNotEmptyTrim(String value)
	{
	    return ((value == null) ? false : isNotEmpty(value.trim()));
	}
	/**
	 * 将java对象转为json字符串，日期输出为毫秒
	 * @param value
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJsonString(Object value) throws JsonGenerationException, JsonMappingException, IOException
    {
	    if (value == null)
	    {
	      return "";
	    }
	    ObjectMapper objectMapper = new ObjectMapper();
	
	    return objectMapper.writeValueAsString(value);
    }
	/**
	 * 将java对象转为json字符串，日期输出为指定日期格式
	 * @param value
	 * @param dataFormat
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJsonString(Object value, String dataFormat) throws JsonGenerationException, JsonMappingException, IOException
	{
	    if (value == null)
	    {
	      return "";
	    }
	    ObjectMapper objectMapper = new ObjectMapper();
	
	    DateFormat df = null;
	    if (isNotEmpty(dataFormat))
	    {
	      df = new SimpleDateFormat(dataFormat);
	    }
	    else
	    {
	      df = new SimpleDateFormat(dateFormat);
	    }
	    objectMapper.getSerializationConfig().setDateFormat(df);
	    objectMapper.getDeserializationConfig().setDateFormat(df);
	
	    return objectMapper.writeValueAsString(value);
	}
}
