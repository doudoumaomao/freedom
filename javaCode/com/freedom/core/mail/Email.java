package com.freedom.core.mail;

public class Email 
{
    private String host;//主机地址
    private String prot;//连接端口
    private String user;//连接用户名
    private String password;//连接密码
    private String fromEmail;//发件人Email
    private String fromName;//发件人姓名
    private String[] toEmail;//收信人Email
    private String messageTitle;//信息标题
    private String messageContent;//信息内容
    private String isAuth = "true";//是否认证默认认证
    
    public String getIsAuth() {
        return isAuth;
    }
    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getProt() {
        return prot;
    }
    public void setProt(String prot) {
        this.prot = prot;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFromEmail() {
        return fromEmail;
    }
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }
    public String getFromName() {
        return fromName;
    }
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
    public String[] getToEmail() {
        return toEmail;
    }
    public void setToEmail(String[] toEmail) {
        this.toEmail = toEmail;
    }
    public String getMessageTitle() {
        return messageTitle;
    }
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    public String getMessageContent() {
        return messageContent;
    }
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
