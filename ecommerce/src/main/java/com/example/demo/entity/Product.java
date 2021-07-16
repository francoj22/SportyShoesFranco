package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "products")
public class Product {
	
    @Id
    @Column(name = "product_id")
	private int productId;
	
    @Column(name = "product_code")
	private String productCode;
    
    public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getProductSize() {
		return productSize;
	}


	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}


	public String getProductColorName() {
		return productColorName;
	}


	public void setProductColorName(String productColorName) {
		this.productColorName = productColorName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getMainParentCatId() {
		return mainParentCatId;
	}


	public void setMainParentCatId(int mainParentCatId) {
		this.mainParentCatId = mainParentCatId;
	}


	public int getParentCatId() {
		return parentCatId;
	}


	public void setParentCatId(int parentCatId) {
		this.parentCatId = parentCatId;
	}


	public int getChildCatId() {
		return childCatId;
	}


	public void setChildCatId(int childCatId) {
		this.childCatId = childCatId;
	}


	public String getProductImages() {
		return productImages;
	}


	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}


	public Product(String productCode, String productName, int productPrice, int sellingPrice, int productQuantity,
			String productSize, String productColorName, String productDescription, int mainParentCatId,
			int parentCatId, int childCatId, String productImages) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellingPrice = sellingPrice;
		this.productQuantity = productQuantity;
		this.productSize = productSize;
		this.productColorName = productColorName;
		this.productDescription = productDescription;
		this.mainParentCatId = mainParentCatId;
		this.parentCatId = parentCatId;
		this.childCatId = childCatId;
		this.productImages = productImages;
	}


	@Column(name = "product_name")
	private String productName;

    @Column(name = "product_price")
	private int   productPrice;
    
    @Column(name = "selling_price")
	private int sellingPrice;

    
    @Column(name = "product_quantity")
	private int productQuantity;

    
    @Column(name = "product_size")
	private String productSize;

    
    @Column(name = "product_color_name")
	private String productColorName;

    
    @Column(name = "product_description")
	private String 	productDescription;

    
    @Column(name = "main_parent_cat_id")
	private int mainParentCatId;

    
    @Column(name = "parent_cat_id")
	private int parentCatId;

    
    @Column(name = "child_cat_id")
	private int childCatId;
    
    @Column(name = "product_images")
	private String productImages;


    public Product() {
    	
    }

	
}