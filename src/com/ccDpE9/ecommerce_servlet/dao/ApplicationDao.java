package com.ccDpE9.ecommerce_servlet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ccDpE9.ecommerce_servlet.beans.Product;
import com.ccDpE9.ecommerce_servlet.beans.User;

public class ApplicationDao {
	private Connection connection;
	
	public ApplicationDao() {
		super();
		this.connection = DBConnection.get();
	}
	
	public int storeProduct(Product product) {
		int rowsAffected = 0;
		
		try {
			String query = "INSERT INTO products(name, quantity, imgPath) VALUES ('"+product.getName()+"','"+product.getQuantity()+"','"+product.getImg()+"')";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(query);
			
			rowsAffected = statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rowsAffected;

	}
	
	public List<Product> listProducts() {
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			String sql = "select * from products";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
		
			while(set.next()) { 
				product = new Product();
				product.setName(set.getString("name"));
				product.setQuantity(set.getInt("quantity"));
				product.setImg(set.getString("img"));
				
				products.add(product);
			}
		}
		catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return products;
	}
	
	public int registerUser(User user) {
		int rowsAffected = 0;
		
		try {
			String query = "INSERT INTO users(name, email, password) VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(query);
			
			rowsAffected = statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rowsAffected;
	}
	
	public User findUser(String email) {
		User user = null;
		
		try {
			String query = String.format("select name, email, password from users where email=\"%s\"", email);
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query);
			
			if (set.next()) {
				user = new User(set.getString("firstName"), set.getString("lastName"), set.getString("email"), set.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
