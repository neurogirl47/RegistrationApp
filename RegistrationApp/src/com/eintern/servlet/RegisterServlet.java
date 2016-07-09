package com.eintern.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.eintern.orm.dao.UserDAO;
import com.eintern.orm.dao.impl.UserDAOImpl;
import com.eintrn.orm.entity.User;


public class RegisterServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRun(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRun(request, response);
	}
	
	protected void doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("usernm");
		String password= request.getParameter("passwd");
		String passconf= request.getParameter("passconf");
		String email= request.getParameter("email");
		String dob= request.getParameter("dob");
		String gender= request.getParameter("gender");
		
		UserDAO userOpers = new UserDAOImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPassconf(passconf);
		user.setEmail(email);
		user.setDob(dob);
		user.setGender(gender);
		
		if(userOpers.passCompare(user.getPassword(), user.getPassconf())){
					
			if(userOpers.saveUser(user)){
				
				request.getRequestDispatcher("/registered.html").forward(request, response);
				//System.out.println("Registration page");
			}
			

		else if (!userOpers.passCompare (user.getPassword(), user.getPassconf())){
			response.sendRedirect("/passauthfail.html");
			//System.out.println("Password authentication failure page");
		}

}
}
}