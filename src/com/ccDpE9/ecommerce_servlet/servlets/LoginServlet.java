package com.ccDpE9.ecommerce_servlet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccDpE9.ecommerce_servlet.beans.User;
import com.ccDpE9.ecommerce_servlet.dao.ApplicationDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/html/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");  
        String password = request.getParameter("password");  
        
        ApplicationDao dao = new ApplicationDao();
        User user = dao.findUser(email);
        
        if(password.equals(user.getPassword())){  
        	// @TODO: Sessions
        }  
        else request.getRequestDispatcher("login.html").include(request, response);

        doGet(request, response);
	}

}
