package com.freedom.core.mail.jmail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.freedom.core.common.util.StringUtil;
import com.freedom.core.exception.AppException;

public class JMail 
{
    public final static String DEFAULT_SMTP_PROT = "25";//smtp默认端口
    public final static String DEFAULT_POP3_PROT = "110";//pop3默认端口
    
    public final static String SMTP = "smtp";
    public final static String POP3 = "pop3";
    
    private Session session;
    private Transport transport;
    private Store store;
    private Properties properties;//属性参数
    private String treaty;//所用协议
    private MimeMessage message;//消息
    
    
    public void sendEmail(String treaty,String host, String user, String password) throws MessagingException
    {
        
        boolean chekcFlag = checkingConnect( treaty, host,  user,  password);
        if(!chekcFlag)
        {
            throw new AppException("无法连接邮件服务器！");
        }
        message = new MimeMessage(session);
        
        // 加载发件人地址
        message.setFrom(new InternetAddress(from,"11111","gb2312"));
        // 加载收件人地址
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    }
    
    /**
     * 验证Smtp协议是否可用
     * @param smtpHost
     * @param user
     * @param password
     * @return
     * @author 刘珂
     * @throws MessagingException 
     * @creation 2012-7-4
     */
    private boolean checkingConnect(String treaty,String host, String user, String password) throws MessagingException 
    {
        properties = new java.util.Properties();
        setTreaty(treaty);
        if(SMTP.equals(treaty))
        {
            if(StringUtil.isEmptyTrim(host))
            {
                host = DEFAULT_SMTP_PROT;
            }
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", host);
            session = Session.getInstance(properties);
            transport = session.getTransport(SMTP);
            transport.connect(user, password);
            transport.connect();
            //transport.close();
        }
        else if(POP3.equals(treaty))
        {
            if(StringUtil.isEmptyTrim(host))
            {
                host = DEFAULT_POP3_PROT;
            }
            session = Session.getDefaultInstance(properties, null);
            store = session.getStore(POP3);
            store.connect(host, user, password);
            //store.close();
        }
        else
        {
            return false;
        }
        return true;
    }
    
    public String getTreaty() {
        return treaty;
    }

    public void setTreaty(String treaty) {
        this.treaty = treaty;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
