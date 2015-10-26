package com.hongyewell.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hongyewell.pojo.User;
import com.hongyewell.util.DBUtil;

/**
* @className:UsersDao.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月25日 下午4:15:43
*/
public class UsersDao {
	
	public User queryByUserNameAndPassword(String username, String password){
		String sql = "select u.userName,u.userPassword from usersinfo u where u.userName =? and u.userPassword =?";
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			pstmt = DBUtil.getPStmt(conn, sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				User user = new User(userName, userPassword);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
