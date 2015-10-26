package com.hongyewell.pojo;
/**
* @className:User.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月25日 下午4:11:40
*/
public class User {
	private int userId;
	private String userName;
	private String userPassword;
	
	public User(){
		
	}
	
	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	

	

}
