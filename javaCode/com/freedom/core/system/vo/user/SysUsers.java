package com.freedom.core.system.vo.user;

import java.util.Date;

/**
 * 系统用户实体
 * @author maomao
 *
 */
public class SysUsers 
{
	private Integer userid;
	private String accounts;
	private String password;
	private String encryptionPassword;
	private String userName;
	private String state;
	private String locked;
	private String foundIP;
	private Date  foundTime;
	private String foundPerson;
	private Date amendTime;
	private String amendPerson;
	
	public SysUsers(){}
	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptionPassword() {
		return encryptionPassword;
	}
	public void setEncryptionPassword(String encryptionPassword) {
		this.encryptionPassword = encryptionPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getFoundIP() {
		return foundIP;
	}
	public void setFoundIP(String foundIP) {
		this.foundIP = foundIP;
	}
	public Date getFoundTime() {
		return foundTime;
	}
	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}
	public String getFoundPerson() {
		return foundPerson;
	}
	public void setFoundPerson(String foundPerson) {
		this.foundPerson = foundPerson;
	}
	public Date getAmendTime() {
		return amendTime;
	}
	public void setAmendTime(Date amendTime) {
		this.amendTime = amendTime;
	}
	public String getAmendPerson() {
		return amendPerson;
	}
	public void setAmendPerson(String amendPerson) {
		this.amendPerson = amendPerson;
	}
	
	
}
