package com.hongyewell.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
* @className:DBUtil.java
* @classDescription:  mysql数据库连接工具类
* @author:yeye
* @createTime:2015年10月23日 下午4:43:13
*/
public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
			InputStream in = DBUtil.class.getResourceAsStream("/config/dbconfig.properties");
			Properties props = new Properties();
			try {
				props.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");

			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBUtil(){
		
	}
	
	//取得一个连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//关闭一个连接
	public static void closeConn(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static void closeStmt(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static PreparedStatement getPStmt(Connection conn,String sql){
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pStmt;
		
	}
	
	public static ResultSet executeQuery(Statement stmt,String sql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static void closeResultSet(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
