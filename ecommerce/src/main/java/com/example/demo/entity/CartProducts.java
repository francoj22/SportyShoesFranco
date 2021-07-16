package com.example.demo.entity;

import java.util.Optional;

public class CartProducts {
	

	private int cartId ;
	
	private int userId;
    
	public CartProducts(int cartId, int userId, int productId, int qty, Product products) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.qty = qty;
		this.products = products;
	}


	public Product getProducts() {
		return products;
	}


	public void setProducts(Product product) {
		this.products = product;
	}


	private int productId;

	private int qty;

	private Product products;
	
    public CartProducts() {
    	
    }


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}





}