package com.weshopify.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weshopify.ecomm.beans.Category;
import com.weshopify.ecomm.beans.ProductBean;

@Component
public class ProductService {

	private static List<ProductBean> productsList = new ArrayList<ProductBean>();
	
	@Autowired
	private CategoryService categoryService;
	

	/*
	 * public ProductService(CategoryService categoryService) { this.categoryService
	 * = categoryService }
	 */
	
	public ProductBean addProductToWareHouse(ProductBean productBean) {
		Category category = categoryService.fetchCategoryByName(productBean.getCategory());
		/*
		 * if(category != null) { int productId = new Random().nextInt();
		 * productBean.setId(productId); productsList.add(productBean); }
		 */
		int productId = new Random().nextInt();
		productBean.setId(productId);
		productsList.add(productBean);
		return productBean;
	}
}
