package com.hongyewell.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hongyewell.pojo.DataItem;
import com.hongyewell.util.DBUtil;

/**
* @className:NewsDao.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月23日 下午5:22:50
*/
public class NewsDao {
	
	/**
	 * 获取一组新闻信息
	 *
	 * @author: yeye
	 * @createTime: 2015年10月23日 下午7:17:19
	 * @history:
	 * @return List<DataItem>
	 */
	public List<DataItem> queryAllNews(){
		List<DataItem> newsList = new ArrayList<DataItem>();
		String sql = "select * from newsitem";
		Connection conn = DBUtil.getConn();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = DBUtil.getPStmt(conn, sql);
			rs = pStmt.executeQuery();
			while(rs.next()){
				String newsTitle = rs.getString("newsTitle");
				String newsContent = rs.getString("newsContent");
				DataItem dataItem = new DataItem(newsTitle, newsContent);
				newsList.add(dataItem);
			}
			return newsList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn);
			DBUtil.closeResultSet(rs);
		}
		return null;
		
	}
	
	
	public int addNews(DataItem dataItem){
		String sql = "insert into newsitem values (null,?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		pstmt = DBUtil.getPStmt(conn, sql);
		try {
			int res = 0;
			pstmt.setString(1, dataItem.getMyTitle());
			pstmt.setString(2, dataItem.getMyContent());
			res = pstmt.executeUpdate();
			return res;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn);
			DBUtil.closeStmt(pstmt);
		}
		
		return 0;
		
	}

}
