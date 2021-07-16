package com.example.demo.entity;

import java.util.List;

public class Category {
	
	private int mainParentCatId;
	
	private String mainParentCatName;
	
	private List<ParentCategory> parentCategory;
	
	private Object childCategory;

	public Category() {
    	
    }

	public Category( String mainParentCatName) {
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

	public List<ParentCategory> getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(List<ParentCategory> parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Object getChildCategory() {
		return childCategory;
	}

	public void setChildCategory(Object object) {
		this.childCategory = object;
	}

	public Category(int mainParentCatId, String mainParentCatName, List<ParentCategory> parentCategory,
			List<ChildCategory> childCategory) {
		super();
		this.mainParentCatId = mainParentCatId;
		this.mainParentCatName = mainParentCatName;
		this.parentCategory = parentCategory;
		this.childCategory = childCategory;
	}

	
}