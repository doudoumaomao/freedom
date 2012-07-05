package com.freedom.core.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.mail.MessagingException;

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
            email.setUser("138383877@qq.com");
            email.setPassword("13327126259");
            email.setFromName("毛毛");
            /*
            String[] toEmailArr = {"18647975294@qq.com","815256819@qq.com","1171455@qq.com",
                                   "381027183@qq.com","170437211@qq.com","78400067@qq.com",
                                   "1132201810@qq.com","289864744@qq.com"};
            */
            String[] toEmailArr = {"18647975294@qq.com","289864744@qq.com"};
            email.setToEmail(toEmailArr);
            
            email.setMessageTitle(title.toString());
            email.setMessageContent(jsonStr);

            System.out.println("进来了！");
            cn.sendEmail("smtp",email);


            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
