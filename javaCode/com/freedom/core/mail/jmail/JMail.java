package com.freedom.core.mail.jmail;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.freedom.core.common.util.StringUtil;
import com.freedom.core.exception.AppException;
import com.freedom.core.mail.Email;
import com.freedom.core.system.action.LoginAction;

public class JMail 
{
    private static Log log = LogFactory.getLog(JMail.class);
    
    public final static String DEFAULT_SMTP_PROT = "25";//smtp默认端口
    public final static String DEFAULT_POP3_PROT = "110";//pop3默认端口
    public final static int DEFAULT_TIMEOUT = 20 * 1000;//默认超时时间
    
    public final static String SMTP = "smtp";
    public final static String POP3 = "pop3";
    
    private Session session;
    private Transport transport;
    private Store store;
    private Properties properties;//属性参数
    private String treaty;//所用协议
    private MimeMessage message;//消息
    
    public static void main(String[] args) 
    {
        JMail cn = new JMail();
        Email email = new Email();
        email.setHost("smtp.qq.com");
        email.setUser("*******@qq.com");
        email.setPassword("**********");
        email.setFromName("张三");
        
        String[] toEmailArr = {"********@qq.com","*******@163.com"};
        
        email.setToEmail(toEmailArr);
        
        email.setMessageTitle("标题1");
        email.setMessageContent("内容1");
        try
        {
            System.out.println("进来了！");
            cn.sendEmail(SMTP,email);
        } 
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 发送Email
     * @param treaty    协议现只可是smtp
     * @param email     
     * @throws MessagingException
     * @author 刘珂
     * @creation 2012-7-5
     */
    public void sendEmail(String treaty,Email email) throws MessagingException
    {
        if(!SMTP.equals(treaty))
        {
            throw new AppException("必须使用SMTP协议！");
        }
        boolean chekcFlag = checkingConnect( treaty, email);
        if(!chekcFlag)
        {
            throw new AppException("无法连接邮件服务器！");
        }
        if(StringUtil.isEmptyTrim(email.getFromEmail()))
        {
            email.setFromEmail(email.getUser());
        }
        message = new MimeMessage(session);
        try
        {
            if(StringUtil.isEmptyTrim(email.getFromName()))
            {
                email.setFromName(email.getFromEmail());
            }
            // 加载发件人地址
            message.setFrom(new InternetAddress(email.getFromEmail(),email.getFromName(),"gb2312"));
            
            // 加载收件人地址
            InternetAddress[] addressArray = new InternetAddress[email.getToEmail().length];
            for(int i = 0;i < email.getToEmail().length;i++)
            {
                addressArray[i] = new InternetAddress(email.getToEmail()[i]);
            }
            message.addRecipients(Message.RecipientType.TO, addressArray);
            // 加载标题
            message.setSubject(email.getMessageTitle());
            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(email.getMessageContent());
            multipart.addBodyPart(contentPart);

            // 添加附件
            // BodyPart messageBodyPart = new MimeBodyPart();
            // DataSource source = new FileDataSource(affix);
            // 添加附件的内容
            // messageBodyPart.setDataHandler(new DataHandler(source));
            // 添加附件的标题
            // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
            // misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            // messageBodyPart.setFileName("=?GBK?B?"+
            // enc.encode(affixName.getBytes()) + "?=");
            // multipart.addBodyPart(messageBodyPart);

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
        }
        catch (UnsupportedEncodingException e) 
        {
            log.error(e.getMessage());
            throw new AppException("编码异常！");
        }
        finally
        {
            transport.close();
        }
    }
    
    /**
     * 验证连接是否可用
     * @param smtpHost
     * @param user
     * @param password
     * @return
     * @author 刘珂
     * @throws MessagingException 
     * @creation 2012-7-4
     */
    private boolean checkingConnect(String treaty,Email email) throws MessagingException 
    {
        properties = new java.util.Properties();
        setTreaty(treaty);
        try
        {
            if(SMTP.equals(treaty))
            {
                if(StringUtil.isEmptyTrim(email.getProt()))
                {
                    email.setProt(DEFAULT_SMTP_PROT);
                }
                properties.put("mail.smtp.host", email.getHost());
                properties.put("mail.smtp.auth", "true");
                //properties.put("mail.smtp.auth", email.getIsAuth());
                properties.put("mail.smtp.port", email.getProt());
                properties.put("mail.smtp.connectiontimeout", DEFAULT_TIMEOUT);
                properties.put("mail.smtp.timeout", DEFAULT_TIMEOUT);
                
                session = Session.getInstance(properties);
                transport = session.getTransport(SMTP);
                transport.connect(email.getUser(), email.getPassword());
            }
            else if(POP3.equals(treaty))
            {
                if(StringUtil.isEmptyTrim(email.getProt()))
                {
                    email.setProt(DEFAULT_POP3_PROT);
                }
                properties.put("mail.pop3.host", email.getHost());
                properties.put("mail.pop3.port", email.getProt());
                properties.put("mail.pop3.timeout", DEFAULT_TIMEOUT);
                
                session = Session.getDefaultInstance(properties, null);
                store = session.getStore(POP3);
                store.connect(email.getUser(), email.getPassword());
            }
            else
            {
                return false;
            }
        }
        catch (Exception e) 
        {
            
            throw new AppException("系统连接失败！");
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
