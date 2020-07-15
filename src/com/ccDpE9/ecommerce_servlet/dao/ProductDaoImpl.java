package com.ccDpE9.ecommerce_servlet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ccDpE9.ecommerce_servlet.beans.Product;

public class ProductDaoImpl implements ProductDao {
	private Connection connection;
	
	public ProductDaoImpl() {
		super();
		this.connection = DBConnection.get();
	}

	@Override
	public int save(Product product) {
		int rowsAffected = 0;

		try {
			String query = "insert into products(name, description, price, quantity, imgPath) value(?, ?, ?, ?, ?);";

			
			java.sql.PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setDouble(3, product.getPrice());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getImg());

			rowsAffected = statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;

	}

	@Override
	public List<Product> get() {
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

}
