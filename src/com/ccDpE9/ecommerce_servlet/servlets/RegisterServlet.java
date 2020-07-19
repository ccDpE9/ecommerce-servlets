package com.ccDpE9.ecommerce_servlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccDpE9.ecommerce_servlet.beans.Role;
import com.ccDpE9.ecommerce_servlet.beans.User;
import com.ccDpE9.ecommerce_servlet.dao.UserDaoImpl;
import com.ccDpE9.ecommerce_servlet.dao.RoleDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/html/register.jsp");
		dispatcher.forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Role role = new RoleDaoImpl().get("user");
		User user = new User(name, email, password, role);
		
		int rows = new UserDaoImpl().register(user);
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
		if (rows == 0) {
			out.println("Error");
		}
		else {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) oldSession.invalidate();

			HttpSession newSession = request.getSession(true);
			newSession.setAttribute("user", user.getEmail());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/html/index.html");
			dispatcher.forward(request, response);
		}
	}
}
