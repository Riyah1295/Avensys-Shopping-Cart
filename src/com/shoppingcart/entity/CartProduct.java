package com.shoppingcart.entity;

public class CartProduct {
	
	Cart cart;
	Product product;
	
	public CartProduct(Cart cart, Product product) {
		super();
		this.cart = cart;
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
