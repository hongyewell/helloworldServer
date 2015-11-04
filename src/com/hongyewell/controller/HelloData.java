package com.hongyewell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hongyewell.pojo.DataItem;
import com.hongyewell.service.NewsService;

public class HelloData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/*request.setCharacterEncoding("utf-8");*/
		
		response.setContentType("text/html;charset=utf-8");
		
		List<DataItem> mList = new ArrayList<DataItem>();
		NewsService newsService = new NewsService();
		mList = newsService.getAllNews();
		/*response.setCharacterEncoding("utf-8");*/
		Gson gson = new Gson();
		String mListGson = gson.toJson(mList);
		PrintWriter out = response.getWriter();
		out.write(mListGson);
		System.out.println("get请求执行了....");
		
		
	}
}
