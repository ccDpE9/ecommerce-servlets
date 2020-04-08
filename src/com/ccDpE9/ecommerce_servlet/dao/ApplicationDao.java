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
	
	public List<Product> listProducts() {
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			String sql = "select * from products";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
		
			while(set.next()) { 
				product = new Product();
				product.setId(set.getInt("id"));
				product.setName(set.getString("name"));
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
			String query = "INSERT INTO users(name, email, password) VALUES ('"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
			
			java.sql.PreparedStatement statement = connection.prepareStatement(query);
			
			rowsAffected = statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rowsAffected;
	}
}
