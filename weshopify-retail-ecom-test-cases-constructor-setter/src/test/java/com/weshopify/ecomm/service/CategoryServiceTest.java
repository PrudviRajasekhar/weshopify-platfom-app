package com.weshopify.ecomm.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weshopify.ecomm.beans.Category;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class CategoryServiceTest extends ProductServiceTest{

	@Autowired
	private CategoryService categoryService;

	@Test
	public void testAddCategory() {
		Category category = new Category();
		category.setCatId(100);
		category.setName("Cloths");
		category = categoryService.addCategory(category);
		assertNotNull(category);
		assertNotNull(categoryService.fetchAllCategories());
	}

}
