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

public class Test_EditProduct extends ProjectTests {

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
	}

	@Test
	public void test1_editProduct_Exist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/editProductToStore/s1/10?quantity=90&price=15"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("true", actual);
	}
	
	@Test
	public void test2_editProduct_notExist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/editProductToStore/s1/14?quantity=90&price=15"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
	}
	
	@Test
	public void test3_editProduct_notExistStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/editProductToStore/s11/10?quantity=90&price=15"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
	}
	
}