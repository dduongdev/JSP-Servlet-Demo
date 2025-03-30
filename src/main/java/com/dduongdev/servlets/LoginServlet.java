package com.dduongdev.servlets;

import java.io.IOException;
import java.util.Optional;

import com.dduongdev.entities.User;
import com.dduongdev.services.AuthService;
import com.dduongdev.services.AuthServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuthService authService = new AuthServiceImpl();
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<User> userOpt = authService.login(username, password);

        if (userOpt.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userOpt.get());

            request.setAttribute("ResponseMessage", "Login Successfully!");
        } else {
            request.setAttribute("ResponseMessage", "Wrong username or password!");
            
        } 
        
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}
}
