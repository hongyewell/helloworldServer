package com.hongyewell.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongyewell.pojo.DataItem;
import com.hongyewell.service.NewsService;


public class PublishData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		DataItem dataItem = new DataItem(title, content);
		NewsService newsService = new NewsService();
		newsService.addNews(dataItem);
		System.out.println("post请求执行了...我开始接收了");
		System.out.println("我接收到了：===="+title+content);
		
	}

}
