package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Repository
@Entity
@Table(name = "cart")
public class Cart {
	
    @Id
    @Column(name = "cart_id ")
	private int cartId ;
	
    @Column(name = "user_id")
	private int userId;
    
    @Column(name = "product_id")
	private int productId;

    @Column(name = "qty")
	private int qty;

    @Column(name = "product_size")
	private String productSize;

    @Column(name = "product_color")
	private String productColor;

    public Cart() {
    	
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


	public String getProductSize() {
		return productSize;
	}


	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}


	public String getProductColor() {
		return productColor;
	}


	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}


	public Cart(int userId, int productId, int qty, String productSize, String productColor) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.qty = qty;
		this.productSize = productSize;
		this.productColor = productColor;
	}


	

}