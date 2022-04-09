package com.weshopify.ecomm.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.weshopify.ecomm.beans.ProductBean;
import com.weshopify.ecomm.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	//@Autowired
	private OrderService orderService;
	
	@Test
	public void testAddProduct() {
		ProductBean productBean = new ProductBean();
		//productBean.setId(101);
		productBean.setName("US-POLLO-T-shirt");
		productBean.setCategory("Cloths");
		
		productService.addProductToWareHouse(productBean);
		assertNotNull(productBean);
		assertNotNull(productBean.getId());
		System.out.println(orderService.getOrderName());
	}
}
