package com.SWE.Testing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.SWE.Controllers.AddProduct;
import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ActionRepo;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreActionsRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_AddProduct extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreProductRepo spRepo;
	@Autowired
	public StoreActionsRepo saRepository;
	@Autowired
	public ActionRepo actionRepository;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//		Product product = new Product();
//		product.setName("product4");
//		product.setPrice(20);
//		product.setBrand("b2");
//		product.setQuantity(50);
//		product.setType("camera");
//		productRepository.save(product);
	}

	@Test
	public void test1_addProduct_NotExist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addProductToStore/s1/product4/20/13"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		System.out.println("ddddddddd" + actual);
		Assert.assertEquals("true", actual);
//		Store s = storeRepository.findByName("s1");
//		
//		boolean actual = false;
//		for(StoreProduct sp: s.getStoreProducts()) {
//			if(sp.getProduct().getName().equals("product3")) {
//				actual = true;
//				break;
//			}
//		}
//		
	}
	
	@Test
	public void test2_addProduct_ExistingProduct() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addProductToStore/s1/product3/10/13"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		for(StoreProduct sp: spRepo.findAll()) {
			if(sp.getStore().getId() == 1 && sp.getProduct().getId() == 10) {
//				Assert.assertEquals(Integer.valueOf(100), sp.getQuantity());
			}
		}
		Assert.assertEquals("true", actual);
	}
	
	@Test
	public void test3_addProduct_unExistProduct() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addProductToStore/s1/product11/20/13"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
	}
	
}