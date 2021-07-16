package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "parent_category")
public class ParentCategory {
	
    @Id
    @Column(name = "parent_cat_id")
	private int parentCatId;
	
    @Column(name = "parent_cat_name")
	private String parentCatName;
    
    @Column(name = "main_parent_cat_id")
	private int mainParentCatId;


    public ParentCategory() {
    	
    }

	public int getMainParentCatId() {
		return mainParentCatId;
	}

	public ParentCategory(String parentCatName, int mainParentCatId) {
		super();
		this.parentCatName = parentCatName;
		this.mainParentCatId = mainParentCatId;
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

	public String getParentCatName() {
		return parentCatName;
	}

	public void setParentCatName(String parentCatName) {
		this.parentCatName = parentCatName;
	}

	
	
    
    
	
	

}