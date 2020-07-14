package com.ccDpE9.ecommerce_servlet.validators;

import java.util.ArrayList;
import java.util.List;

import com.ccDpE9.ecommerce_servlet.beans.Product;

public class ProductValidator {
	public List<String> validate(Product product) {
		List<String> errors = new ArrayList<String>();

		String name = product.getName();
		if (name == null || name.trim().isEmpty()) errors.add("Product must have a name.");
		
		String price = product.getPrice();
		if (price == null || price.trim().isEmpty()) {
			errors.add("Product must have a price.");
		}
		else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("Invalid price value.");
			}
		}
		
		return errors;
	}
}
