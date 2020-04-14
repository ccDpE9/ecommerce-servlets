package com.ccDpE9.ecommerce_servlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccDpE9.ecommerce_servlet.beans.Product;
import com.ccDpE9.ecommerce_servlet.beans.User;
import com.ccDpE9.ecommerce_servlet.dao.ApplicationDao;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/html/createProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String imgPath = request.getParameter("image");
				
		Product product = new Product(name, quantity, imgPath);
		
		ApplicationDao dao = new ApplicationDao();
		int rows = dao.storeProduct(product);
		
		if (rows == 0) {
			// @TODO: Send a response that can be rendered on the page
			System.out.println("Error");
		}
		else {
			// @TODO: Redirect to Admin Dashboard
			RequestDispatcher dispatcher = request.getRequestDispatcher("/html/index.html");
			dispatcher.forward(request, response);
		}

		
		doGet(request, response);
	}

}
