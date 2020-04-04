package com.ccDpE9.ecommerce_servlet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.ccDpE9.servlets_ecommerce.beans.Product;
import com.github.ccDpE9.servlets_ecommerce.dao.DBConnection;

public class ApplicationDao {
	public List<Product> listProducts() {
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			Connection connection = DBConnection.get();
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
}
