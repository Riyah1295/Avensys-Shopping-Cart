package com.shoppingcart.entity;

public class Product {
	private int product_id;
	private String product_name;
	private String product_description;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param product_id
	 * @param product_name
	 * @param product_description
	 */
	public Product(int product_id, String product_name, String product_description) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
	}

	/**
	 * for creating new product
	 * @param product_name
	 * @param product_description
	 */
	public Product(String product_name, String product_description) {
		super();
		this.product_name = product_name;
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + "]";
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	
	
}
