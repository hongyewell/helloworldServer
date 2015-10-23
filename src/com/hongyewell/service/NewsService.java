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

}
