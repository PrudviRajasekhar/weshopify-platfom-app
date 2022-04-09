package com.weshopify.ecomm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.weshopify.ecomm.beans.Category;

@Component
public class CategoryService {

	private static List<Category> categoryList = new ArrayList<Category>();
	
	public Category addCategory(Category category) {
		categoryList.add(category);
		return category;
	}
	
	public List<Category> fetchAllCategories(){
		return categoryList;
	}
	
	public Category fetchCategoryByName(String name) {
		Category categoryUnique = null;
		for(Category category: categoryList) {
			if(category.getName().equals(name)) {
				categoryUnique = category;
			}
		}
		if(categoryUnique != null) {
			return categoryUnique;
		}else {
			//throw new RuntimeException("No Category Found with the name "+name);
		}
		return categoryUnique;
	}
}
