package com.eintern.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.orm.dao.UserDAO;
import com.eintern.orm.dao.impl.UserDAOImpl;


public class LoginServlet extends HttpServlet {
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRun(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRun(request, response);
	}
	
	protected void doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("usernm");
		String password= request.getParameter("passwd");
		
		UserDAO userOpers = new UserDAOImpl();
		
		PrintWriter out = response.getWriter();
		
		if(userOpers.authenticateUser(username,password)){
			
			request.getRequestDispatcher("/loggedIn.html").forward(request, response);
			//response.sendRedirect("success.html");
			
		}
		else
		{
			//response.sendRedirect("/loginfail.html");
			out.print("you have failed to authenticate!");
		}
	}

}
