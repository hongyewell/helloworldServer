package com.hongyewell.service;

import com.hongyewell.dao.UsersDao;
import com.hongyewell.pojo.User;



/**
* @className:UserService.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月25日 下午4:29:53
*/
public class UserService {
	private UsersDao usersDao;
	
	public UserService(){
		this.usersDao = new UsersDao();
	}
	
	public User login(String username,String password){
		
		return usersDao.queryByUserNameAndPassword(username,password);
		
	}
	

}
