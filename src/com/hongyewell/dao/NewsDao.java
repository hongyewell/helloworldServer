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
	
	public List<DataItem> queryRefreshNews(int id){
		List<DataItem> newsList = new ArrayList<DataItem>();
		String sql = "select * from newsitem where newsId > ? order by newsTime Desc";
		Connection conn = DBUtil.getConn();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = DBUtil.getPStmt(conn, sql);
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			while(rs.next()){
				int newsId = rs.getInt("newsId");
				String newsTitle = rs.getString("newsTitle");
				String newsContent = rs.getString("newsContent");
				String newsAuthor = rs.getString("newsAuthor");
				String newsTime = rs.getString("newsTime");
				DataItem dataItem = new DataItem(newsId,newsTitle, newsContent, newsAuthor, newsTime);
				newsList.add(dataItem);
			}
			return newsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn);;
			DBUtil.closeResultSet(rs);
		}
		return null;
		
	}
	
	/**
	 * 获取一组新闻信息，按时间降序排列
	 *
	 * @author: yeye
	 * @createTime: 2015年10月23日 下午7:17:19
	 * @history:
	 * @return List<DataItem>
	 */
	public List<DataItem> queryAllNews(){
		List<DataItem> newsList = new ArrayList<DataItem>();
		String sql = "select * from newsitem order by newsTime Desc";
		Connection conn = DBUtil.getConn();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = DBUtil.getPStmt(conn, sql);
			rs = pStmt.executeQuery();
			while(rs.next()){
				int newsId = rs.getInt("newsId");
				String newsTitle = rs.getString("newsTitle");
				String newsContent = rs.getString("newsContent");
				String newsAuthor = rs.getString("newsAuthor");
				String newsTime = rs.getString("newsTime");
				DataItem dataItem = new DataItem(newsId,newsTitle, newsContent, newsAuthor, newsTime);
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
	
	
	/**
	 * 添加一条信息
	 *
	 * @author: yeye
	 * @createTime: 2015年10月26日 上午10:55:50
	 * @history:
	 * @param dataItem
	 * @return int
	 */
	public int addNews(DataItem dataItem){
		String sql = "insert into newsitem values (null,?,?,?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		pstmt = DBUtil.getPStmt(conn, sql);
		try {
			int res = 0;
			pstmt.setString(1, dataItem.getMyTitle());
			pstmt.setString(2, dataItem.getMyContent());
			pstmt.setString(3, dataItem.getMyAuthor());
			pstmt.setString(4, dataItem.getMyTime());
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
	
	/**
	 * 根据id获取信息详情
	 *
	 * @author: yeye
	 * @createTime: 2015年11月3日 下午3:34:11
	 * @history:
	 * @param newsId
	 * @return DataItem
	 */
	public DataItem queryNewsDetail(int newsId){
		DataItem dataItem = new DataItem();
		String sql = "select * from newsitem where newsId = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = DBUtil.getPStmt(conn, sql);
		
		try {
			pstmt.setInt(1, newsId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dataItem.setMyId(rs.getInt("newsId"));
				dataItem.setMyTitle(rs.getString("newsTitle"));
				dataItem.setMyContent(rs.getString("newsContent"));
				dataItem.setMyAuthor(rs.getString("newsAuthor"));
				dataItem.setMyTime(rs.getString("newsTime"));
				return dataItem;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
