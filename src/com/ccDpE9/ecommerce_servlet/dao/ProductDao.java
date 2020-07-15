package com.ccDpE9.ecommerce_servlet.dao;

import java.util.List;

import com.ccDpE9.ecommerce_servlet.beans.Product;

public interface ProductDao {
	int save(Product product);
	List<Product> get();
}
