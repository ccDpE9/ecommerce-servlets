package com.ccDpE9.ecommerce_servlet.beans;

public class Product {
	private String name;
	private int quantity;
	private String img;
	
	public Product() {
		super();
	}
	
	public Product(String name, int quantity, String img) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.img = img;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

}
