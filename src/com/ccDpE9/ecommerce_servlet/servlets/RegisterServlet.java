package com.ccDpE9.ecommerce_servlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccDpE9.ecommerce_servlet.beans.User;
import com.ccDpE9.ecommerce_servlet.dao.ApplicationDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/html/register.jsp");
		dispatcher.forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(firstName, lastName, email, password);
		
		ApplicationDao dao = new ApplicationDao();
		int rows = dao.registerUser(user);
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
		if (rows == 0) {
			out.println("Error");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/html/index.html");
			dispatcher.forward(request, response);
		}
		
		//doGet(request, response);
	}

}
