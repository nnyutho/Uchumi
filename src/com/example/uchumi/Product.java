package com.example.uchumi;

public class Product {
	String id, product, quantity, price;

	public Product(String id, String product, String quantity, String price) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getPrice() {
		return price;
	}

}
