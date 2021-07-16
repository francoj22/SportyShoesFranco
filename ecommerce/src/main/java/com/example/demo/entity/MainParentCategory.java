package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "main_parent_category")
public class MainParentCategory {
	
    @Id
    @Column(name = "main_parent_cat_id")
	private int mainParentCatId;
	
    @Column(name = "main_parent_cat_name")
	private String mainParentCatName;

    public MainParentCategory() {
    	
    }

	public MainParentCategory( String mainParentCatName) {
		super();
		this.mainParentCatName = mainParentCatName;
	}

	public int getMainParentCatId() {
		return mainParentCatId;
	}

	public void setMainParentCatId(int mainParentCatId) {
		this.mainParentCatId = mainParentCatId;
	}

	public String getMainParentCatName() {
		return mainParentCatName;
	}

	public void setMainParentCatName(String mainParentCatName) {
		this.mainParentCatName = mainParentCatName;
	}
	
	
    
    
	
	

}