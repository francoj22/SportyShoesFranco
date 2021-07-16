package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "child_category")
public class ChildCategory {
	
    @Id
    @Column(name = "child_cat_id")
	private int childCatId;
	
    @Column(name = "child_cat_name")
	private String childCatName;
    
    @Column(name = "parent_cat_id")
	private int parentCatId;


    public ChildCategory() {
    	
    }

	public ChildCategory(String childCatName, int parentCatId) {
		super();
		this.childCatName = childCatName;
		this.parentCatId = parentCatId;
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

	public String getChildCatName() {
		return childCatName;
	}

	public void setChildCatName(String childCatName) {
		this.childCatName = childCatName;
	}

	
	
    
    
	
	

}