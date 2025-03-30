package com.dduongdev.servlets;

import java.io.IOException;

import com.dduongdev.services.AuthService;
import com.dduongdev.services.AuthServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService authService = new AuthServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
	        request.setAttribute("ResponseMessage", "Username and password cannot be empty!");
	        request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	        return;
	    }

	    try {
	        authService.signUp(username, password);
	        request.setAttribute("ResponseMessage", "Signup successful!");
	    } catch (IllegalArgumentException ex) {
	        request.setAttribute("ResponseMessage", ex.getMessage());
	    } catch (Exception ex) {
	        request.setAttribute("ResponseMessage", "Internal error!");
	    } finally {
	    	request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	    }
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	}
}
