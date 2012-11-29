package com.freedom.core.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.codehaus.jackson.map.ObjectMapper;

import com.freedom.core.mail.Email;
import com.freedom.core.mail.jmail.JMail;

public class Weather 
{

    /**
     * @param args
     * @author 刘珂
     * @creation 2012-7-5
     */
    public static void main(String[] args) 
    {
        try
        {
            
            URL url = new URL("http://www.weather.com.cn/data/cityinfo/101010100.html");
            InputStream inputstream = url.openStream();
            BufferedReader in = new BufferedReader(new  InputStreamReader(inputstream));
            String jsonStr = in.readLine();
            
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, Object> map = objectMapper.readValue(jsonStr,HashMap.class);
            
            for (Entry<String, Object> entry : map.entrySet()) {  
                System.out.println(entry.getKey() + " " + entry.getValue());  
            }
            
            HashMap<String, Object> map1 = (HashMap<String, Object>) map.get("weatherinfo");
            
            System.out.println(map1.get("city"));
            
            StringBuilder title = new StringBuilder(" " + map1.get("city") + 
                          "气温：" + map1.get("temp1") + " ~ " + map1.get("temp2") + 
                          " " + map1.get("weather"));
            System.out.println(title);
            
            JMail cn = new JMail();
            Email email = new Email();
            email.setHost("smtp.qq.com");
            email.setUser("Email");
            email.setPassword("password");
            email.setFromName("毛毛");
            
            String[] toEmailArr = {"Email","Email"};
            email.setToEmail(toEmailArr);
            
            email.setMessageTitle(title.toString());
            email.setMessageContent(jsonStr);

            System.out.println("进来了！");
            cn.sendEmail("smtp",email);

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
