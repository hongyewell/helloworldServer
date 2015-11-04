package com.hongyewell.service;

import java.util.List;

import com.hongyewell.dao.NewsDao;
import com.hongyewell.pojo.DataItem;

/**
* @className:NewsService.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月23日 下午7:18:05
*/
public class NewsService {
	private NewsDao newsDao;
	
	public NewsService(){
		this.newsDao = new NewsDao();
	}
	
	/**
	 * 获取最新的信息
	 *
	 * @author: yeye
	 * @createTime: 2015年10月30日 上午10:12:13
	 * @history:
	 * @param id
	 * @return List<DataItem>
	 */
	public List<DataItem> getRefreshNews(int id){
		return newsDao.queryRefreshNews(id);
	}
	/**
	 * 获取一组信息
	 *
	 * @author: yeye
	 * @createTime: 2015年10月23日 下午7:21:47
	 * @history:
	 * @return List<DataItem>
	 */
	public List<DataItem> getAllNews(){
		return newsDao.queryAllNews();
		
	}
	
	/**
	 * 添加信息
	 *
	 * @author: yeye
	 * @createTime: 2015年10月23日 下午8:49:19
	 * @history:
	 * @param dataItem
	 * @return int
	 */
	public int addNews(DataItem dataItem){
		return newsDao.addNews(dataItem);
	}
	
	/**
	 * 根据id查找信息详情
	 *
	 * @author: yeye
	 * @createTime: 2015年10月26日 下午12:40:29
	 * @history:
	 * @param newsId
	 * @return DataItem
	 */
	public DataItem queryNewsDetail(int newsId){
		return newsDao.queryNewsDetail(newsId);
	}

}
