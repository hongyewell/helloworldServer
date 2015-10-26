package com.hongyewell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hongyewell.pojo.User;
import com.hongyewell.service.UserService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UserService userService = new UserService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String loginInfo = "fail" ;
		User user = userService.login(username,password);
		if (user !=null) {
			System.out.println(user.getUserName()+"登录成功");
			 loginInfo = "ok";
		}
		else{
			loginInfo = "fail";
		}
		Gson gson = new Gson();
		String stateGson = gson.toJson(loginInfo);
		PrintWriter out = response.getWriter();
		out.write(stateGson);
	}


}
