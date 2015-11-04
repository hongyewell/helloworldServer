package com.hongyewell.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String  author = request.getParameter("author");
		/*String time = request.getParameter("time");*/
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH-mm");
		String time = simpleDateFormat.format(date);
		
		DataItem dataItem = new DataItem(title, content, author, time);
		NewsService newsService = new NewsService();
		int res = newsService.addNews(dataItem);
		if(res == 1) {	// 添加成功
			// 跳转到用户列表页面
			response.sendRedirect(request.getContextPath()+"/main.jsp");
			
		}else { // 添加失败
			request.setAttribute("message", "添加失败");
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		System.out.println("post请求执行了...我开始接收了");
		System.out.println("我接收到了：===="+title+content);
		
	}

}
