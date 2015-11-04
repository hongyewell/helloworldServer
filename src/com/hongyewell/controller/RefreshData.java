package com.hongyewell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hongyewell.pojo.DataItem;
import com.hongyewell.service.NewsService;


public class RefreshData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String idStr = request.getParameter("id");
		/*String idStr = "16";*/
		int id = Integer.parseInt(idStr);
		NewsService newsService = new NewsService();
		List<DataItem> dataItems = new ArrayList<DataItem>();
		dataItems =  newsService.getRefreshNews(id);
		
		Gson gson = new Gson();
		String dataJson = gson.toJson(dataItems);
		PrintWriter writer = response.getWriter();
		writer.write(dataJson);
	}

}
