package com.hongyewell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hongyewell.pojo.DataItem;
import com.hongyewell.service.NewsService;


public class NewsDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		NewsService newsService = new NewsService();
		int  newsId = Integer.parseInt(request.getParameter("newsId"));
		DataItem dataItem = newsService.queryNewsDetail(newsId);
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String dataJson = gson.toJson(dataItem);
		PrintWriter out = response.getWriter();
		out.write(dataJson);
	}


}
