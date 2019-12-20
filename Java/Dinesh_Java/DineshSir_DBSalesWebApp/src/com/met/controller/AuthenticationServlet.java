package com.met.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.met.model.LoginBean;

//@WebServlet("/login")
@WebServlet({"/login", "/logout"})
public class AuthenticationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//getServletConfig().getInitParameter("");
		//getServletContext().getInitParameter("companyEmailId");
		
		HttpSession session = req.getSession(false);
		
		if(session != null){
			LoginBean loginBean = (LoginBean) session.getAttribute("login");
			
			String userName = loginBean.getUserName();
			
			Cookie cookie = new Cookie("userName", userName);
			cookie.setMaxAge(5*24*60*60);
			
			resp.addCookie(cookie);
			
			session.invalidate();
		}
		
		//resp.sendRedirect("index.jsp");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(req, resp);
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		LoginBean loginBean = new LoginBean();
		boolean authenticate = loginBean.authenticate(userName, password);
		
		if(authenticate){
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("login", loginBean);
			
			resp.sendRedirect("secure/orders.jsp");
			
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}
	
}
