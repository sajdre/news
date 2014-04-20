package com.pvt;

import java.io.Serializable;
import java.util.List;


public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

    private List<News> newsByCategory;
	private String category;
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<News> getNewsByCategory() {
		return newsByCategory;
	}
	public void setNewsByCategory(List<News> newsByCategory) {
		this.newsByCategory = newsByCategory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Category){
			Category category = (Category)obj;
			if(id.equals(category.id)){
				return true;
			}
			return false;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\n" + category;
	}
}
